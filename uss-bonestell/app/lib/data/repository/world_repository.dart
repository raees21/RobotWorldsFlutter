
import 'dart:convert';

import 'package:app/data/model/response.dart';
import 'package:app/data/model/robot.dart';
import 'package:app/data/model/world_model.dart';
import 'package:app/data/provider/robot_api.dart';

class WorldRepository {
  RobotAPI api = RobotAPI();

  Future<APIResponse> sendCommand(String command, String name, List<String> args) async {
    var jsonRawData = await api.command(command, name, args);
    var jsonData = jsonDecode(jsonRawData.body);

    return APIResponse.fromJson(jsonData);
  }

  Future<WorldModel> getWorld() async {
    var jsonRawData = await api.getWorld();
    var jsonData = jsonDecode(jsonRawData.body);

    return WorldModel.fromJson(jsonData);
  }

  Future<Robot> launchRobot(String name, List<String> args) async {

    var jsonRawData = await api.command("launch", name, args);
    var jsonData = jsonDecode(jsonRawData.body);

    var r = APIResponse.fromJson(jsonData);

    return Robot(shots: r.state.shots,
        robotStatus: r.state.status,
        currentDirection: r.state.direction,
        name: name,
        status: r.state.status,
        reload: 3,
        repair: 3,
        mine: 3,
        shields: r.state.shields,
        x: r.state.position[0],
        y: r.state.position[1]);
  }
}