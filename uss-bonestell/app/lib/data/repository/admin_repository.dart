import 'dart:convert';

import 'package:app/data/model/obstacle_models.dart';
import 'package:app/data/model/robot.dart';
import 'package:app/data/provider/admin_api.dart';

class AdminRepository {
  AdminAPI api = AdminAPI();

   Future<List<Robot>> fetchRobots() async {
     var rawRobotData = await api.fetchRobots();
     var jsonData = jsonDecode(rawRobotData.body);

     List<dynamic> r = jsonData.map((data) => Robot.fromJson(data)).toList();

     return r.cast<Robot>();
   }

  Future<List<Obstacle>>  fetchObstacles() async {
    var rawObstacleData = await api.fetchObstacles();
    var jsonData = jsonDecode(rawObstacleData.body);

    List<dynamic> o = jsonData.map((data) => Obstacle.fromJson(data)).toList();
    return o.cast<Obstacle>();
  }

  Future<void> purgeRobot(String name) async {
    var rawPurgeRobotData = await api.purgeRobot(name);
  }

  Future<void> saveWorld() async {
    var rawSaveWorldData = await api.saveWorld();
  }
}