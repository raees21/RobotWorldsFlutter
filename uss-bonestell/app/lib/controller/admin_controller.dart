import 'package:app/data/model/obstacle_models.dart';
import 'package:app/data/model/robot.dart';
import 'package:app/data/repository/admin_repository.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter_bloc/flutter_bloc.dart';


class AdminController extends Bloc<AdminEvent, AdminState> {
  final AdminRepository repository;

  AdminController(initialState, {required this.repository}) : super(initialState) {
    on<LoadRobotsEvent>((event, emit) async {
      state.robots = await repository.fetchRobots();
      emit(state);
    });

    on<LoadObstaclesEvent>((event, emit) async {
      state.obstacles = await repository.fetchObstacles();
      emit(state);
    });

    on<PurgeEvent>((event, emit) async {
      await repository.purgeRobot(event.name);
      state.robots = await repository.fetchRobots();
      emit(state);
    });

    on<SaveWorldEvent>((event, emit) async {
      await repository.purgeRobot(event.name);
      var robots = await repository.fetchRobots();
      emit(WorldSaved(state.obstacles, robots));
    });
  }
}

class AdminState {
  List<Obstacle> obstacles;
  List<Robot> robots;

  AdminState({required this.robots, required this.obstacles});
}

class WorldSaved extends AdminState{
  WorldSaved(List<Obstacle> obstacles, List<Robot> robots) : super(robots: robots, obstacles: obstacles);
}

abstract class AdminEvent {
  String name;
  AdminEvent({required this.name});
}

class PurgeEvent extends AdminEvent {
  PurgeEvent(name): super(name: name);
}

class LoadRobotsEvent extends AdminEvent {
  LoadRobotsEvent(): super(name: "name");
}

class LoadObstaclesEvent extends AdminEvent {
  LoadObstaclesEvent(): super(name: "name");
}

class SaveWorldEvent extends AdminEvent {
  SaveWorldEvent(): super(name: "name");
}