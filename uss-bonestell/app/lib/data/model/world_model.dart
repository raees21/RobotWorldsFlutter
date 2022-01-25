import 'package:app/data/model/robot.dart';

import 'package:app/data/model/obstacle_models.dart';

class WorldModel {
  final int id;
  List<dynamic> obstacles;
  List<dynamic> mines;
  List<dynamic> robots;

  WorldModel({required this.obstacles,
              required this.mines,
              required this.robots,
              required this.id});

  factory WorldModel.initState() {
    return WorldModel(obstacles: [], mines: [],
        robots: [], id: 0);
  }

  factory WorldModel.fromJson(Map<String, dynamic> jsonData) {
    return WorldModel(
        obstacles: jsonData['obstacles'].map((data) => Obstacle.fromJson(data)).toList(),
        mines: jsonData['mines'].map((data) => Mine.fromJson(data)).toList(),
        robots: jsonData['robots'].map((data) => Robot.fromJson(data)).toList(),
        id: jsonData["worldID"]
    );
  }
}