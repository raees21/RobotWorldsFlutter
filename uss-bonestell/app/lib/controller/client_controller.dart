import 'dart:convert';
import 'dart:io';

import 'package:app/constants/api_endpoints.dart';
import 'package:app/controller/game_state_controller.dart';
import 'package:app/data/model/response.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class ClientController extends Bloc<ClientEvent, ClientSate> {
  GameStateController gs;
  Future<Socket> s = Socket.connect(serverIp, serverPort);
  ClientController(initialState, {required this.gs}) : super(initialState) {
    () async {
      var socket = await s;
      socket.listen((event) {
        gs.add(UpdateWorldEvent(String.fromCharCodes(event),));
      });
    }();

    on<CommandEvent>((event, emit) async {
      await sendCommand(event);
    });
    on<ServerResponseEvent>((event, emit) async {

    });
    on<ConnectEvent>((event, emit) async {
      await connect();
    });
    on<LaunchRobotEvent>((event, emit) async {
      await sendCommand(event);
    });
  }

  Future<void> connect() async {

  }

  Future<void> sendCommand(CommandEvent event) async {
    var socket = await s;

    String b = jsonEncode({
      "robot": event.robot,
      "command":event.command,
      "arguments":event.arguments,
    });

    List<int> bytes = b.codeUnits + "\n".codeUnits;
    socket.add(bytes);
  }
}

class ClientEvent {
  String command;
  String robot;
  List<String> arguments;

  ClientEvent({required this.arguments, required this.command, required this.robot});
}

class CommandEvent extends ClientEvent {
  CommandEvent(String command, String robot, List<String> arguments) : super(arguments: arguments, command: command, robot: robot);
}

class LaunchRobotEvent extends CommandEvent {
  LaunchRobotEvent(String robot, List<String> arguments) : super("launch", robot, arguments);
}

class ServerResponseEvent extends ClientEvent {
  String response;
  ServerResponseEvent({required this.response}) : super(arguments: [], command: "", robot: "");
}

class ConnectEvent extends ClientEvent {
  ConnectEvent() : super(arguments: [], command: "", robot: "");
}


class ClientSate {
  APIResponse? response;
  ClientSate({this.response});
}