import 'package:app/constants/api_endpoints.dart';
import 'package:http/http.dart' as http;
import 'package:http/http.dart';

class AdminAPI {
  Future<Response> fetchRobots() async {
    final response = await http.get(adminRobotUri);
    return response;
  }

  Future<Response>  fetchObstacles() async {
    final response = await http.get(adminObstaclesUri);
    return response;
  }

  Future<Response> purgeRobot(String name) async {
    final response = await http.delete(adminPurgeRobotUri, body: '{"command":"purge","arguments":"$name"}');
    return response;
  }

  Future<Response> saveWorld() async {
    final response = await http.post(adminSaveWorldUri);
    return response;
  }
}