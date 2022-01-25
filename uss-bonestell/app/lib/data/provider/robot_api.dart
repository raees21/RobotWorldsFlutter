
import 'package:app/constants/api_endpoints.dart';
import 'package:http/http.dart' as http;
import 'package:http/http.dart';

class RobotAPI {

  Future<Response> getWorld() async {
    final response = http.get(worldUri);
    return response;
  }

  Future<Response> command(String command, String name, List<String> args) async {
    final response = await http.post(robotUri,
        body: '{"command": "$command","robot": "$name","arguments": $args}');
    return response;
  }
}