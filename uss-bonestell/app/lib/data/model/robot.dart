import 'package:app/data/model/response.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Robot {
  String name;
  String status;
  int reload;
  int repair;
  int mine;
  int shields;
  int shots;
  String currentDirection;
  int x;
  int y;
  String robotStatus;
  int size = 10;

  Robot({required this.shots, required this.robotStatus,
    required this.currentDirection, required this.name,
    required this.status, required this.reload, required this.repair,
    required this.mine, required this.shields, required this.x, required this.y});

  factory Robot.initState() {
    return Robot(shots: 0, robotStatus: "robotStatus",
        currentDirection: "NORTH", name: "name",
        status: "status", reload: 0, repair: 0,
        mine: 0, shields: 5, x: 0, y: 0);
  }
  
  factory Robot.fromState(PlayerState playerState, String name) {
    return Robot(shots: playerState.shots,
        robotStatus: playerState.status,
        currentDirection: playerState.direction,
        name: name, status: playerState.status,
        reload: 0, repair: 0,
        mine: 0, shields: playerState.shields,
        x: playerState.position[0], y: playerState.position[1]);
  }

  factory Robot.fromJson(Map<String, dynamic> json) {
    return Robot(
      name: json['name'],
      status: json['status'],
      reload: json['reload'],
      repair: json['repair'],
      mine: json['mine'],
      shields: json['shields'],
      shots: json['shots'],
      currentDirection: json['currentDirection'],
      x: json['x'],
      y: json['y'],
      robotStatus: json['robotStatus'],
    );
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['name'] = name;
    data['status'] = status;
    data['reload'] = reload;
    data['repair'] = repair;
    data['mine'] = mine;
    data['shields'] = shields;
    data['shots'] = shots;
    data['currentDirection'] = currentDirection;
    data['x'] = x;
    data['y'] = y;
    data['robotStatus'] = robotStatus;
    return data;
  }

  void draw(Canvas canvas, Size screenSize) {
    final paint = Paint();
    paint.color = Colors.yellowAccent;
    canvas.drawRect(Rect.fromLTWH(x + screenSize.width/2,
        y + screenSize.height/2, (size/200)*screenSize.width,
        (size/200)*screenSize.height), paint);
  }

}