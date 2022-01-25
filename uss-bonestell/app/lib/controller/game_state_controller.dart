import 'dart:async';
import 'dart:convert';

import 'package:app/data/model/response.dart';
import 'package:app/data/model/robot.dart';
import 'package:app/data/model/world_model.dart';
import 'package:app/data/repository/world_repository.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import 'client_controller.dart';

class GameStateController extends Bloc<GameEvent, GameState> {
  final WorldRepository repository;

  GameStateController(initialState, {required this.repository}) : super(initialState) {
    on<UpdateWorldEvent>((event, emit) async {
      var f = await repository.getWorld();

      var jsonData = jsonDecode(event.response);
      var responseObject = APIResponse.fromJson(jsonData);
      var r = Robot.fromState(responseObject.state, state.player.name);
      var gs = GameState(player: r, world: f);
      emit(gs);
    });
  }

  @override
  Future<void> close() async {
    super.close();
  }
}

class GameState {
    Robot player;
    WorldModel world;
    GameState({required this.player,
              required this.world,
    });

    factory GameState.initState() {
      return GameState(player: Robot.initState(),
          world: WorldModel.initState());
    }

    get obstacles => world.obstacles;
    get mines => world.mines;
    get robots => world.robots;
}

abstract class GameEvent {
  String response;
  GameEvent({required this.response});
}
class UpdateWorldEvent extends GameEvent {
  UpdateWorldEvent(String response) : super(response: response);
}