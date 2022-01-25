import 'dart:io';

import 'package:app/controller/client_controller.dart';
import 'package:app/controller/robot_types.dart';
import 'package:app/data/repository/admin_repository.dart';
import 'package:app/view/home_page.dart';
import 'package:app/view/route_generator.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';

import 'controller/admin_controller.dart';
import 'controller/game_state_controller.dart';
import 'data/model/robot.dart';
import 'data/repository/world_repository.dart';

void main() async {
  final gs = GameStateController(GameState.initState(), repository: WorldRepository());
  final client = ClientController(ClientSate(), gs: gs,);

  runApp(ChangeNotifierProvider(
    create: (BuildContext context) => RobotTypeList(),
    child: MultiBlocProvider(
      providers: [
        BlocProvider(create: (context) => AdminController(AdminState(robots: [], obstacles: []),repository: AdminRepository())),
        BlocProvider(create: (context) => gs),
        BlocProvider(create: (context) => client,),
      ],
      child: MaterialApp(
            debugShowCheckedModeBanner: false,
            title: 'Robot Worlds',
            theme: ThemeData(
              primarySwatch: Colors.blueGrey,
            ),
            home: const HomePage(title: 'Robot Worlds'),
            onGenerateRoute: (settings) => RouteGenerator.generateRoute(settings),
          ),
    ),
  ),
  );
}

