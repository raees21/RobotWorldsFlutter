import 'package:flutter/cupertino.dart';

class APIResponse {
  String result;
  PlayerState state;

  APIResponse({required this.result, required this.state,});
  factory APIResponse.fromJson(Map<String, dynamic> jsonData) {
    debugPrint(jsonData.toString());
    return APIResponse(result: jsonData['result'],
        state: PlayerState.fromJson(jsonData['state']));
  }


  @override
  String toString() {
    return '{"result":"$result","data":"","state":"${state.toString()}"}';
  }
}

class PlayerState {
  List<dynamic> position;
  String direction;
  int shields;
  int shots;
  String status;

  PlayerState({required this.status,required this.position,required this.direction,required this.shields,required this.shots,});

  factory PlayerState.fromJson(Map<String, dynamic> jsonData) {
    return PlayerState(
        status: jsonData['status'],
        position: jsonData['position'],
        direction: jsonData['direction'],
        shields: jsonData['shields'],
        shots: jsonData['shots'],
    );
  }
}