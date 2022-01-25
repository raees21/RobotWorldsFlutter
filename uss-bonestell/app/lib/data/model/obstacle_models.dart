import 'dart:ui';
import 'package:flutter/material.dart';

class Obstacle {
  int x;
  int y;
  double size = 5;

  void draw(Canvas canvas, Size screenSize) {
    final paint = Paint()
    ..color = Colors.red;
    canvas.drawRect(Rect.fromLTWH(x + screenSize.width/2,
        y + screenSize.height/2, (size/200)*screenSize.width,
        (size/200)*screenSize.height), paint);
  }

  Obstacle({required this.x, required this.y});

  factory Obstacle.fromJson(Map<String, dynamic> jsonData) {
    return Obstacle(
      x: jsonData['x'],
      y: jsonData['y'],
    );
  }

  @override
  String toString() {
    return "obstacle{x: $y,y: $x,}";
  }
}


class Pit extends Obstacle {
  Pit({x, y}) : super(x: x, y: y);

  @override
  void draw(Canvas canvas, Size screenSize) {
    final paint = Paint();
    paint.color = Colors.black;
    canvas.drawRect(Rect.fromLTWH(x + screenSize.width/2,
        y + screenSize.height/2, (size/200)*screenSize.width,
        (size/200)*screenSize.height), paint);
  }

  factory Pit.fromJson(Map<String, dynamic> jsonData) {
    return Pit(
      x: jsonData['x'],
      y: jsonData['y'],
    );
  }
}

class Mine extends Obstacle {
  Mine({x, y}) : super(x: x, y: y);

  @override
  void draw(Canvas canvas, Size screenSize) {
    final paint = Paint();
    paint.color = Colors.yellow;
    canvas.drawRect(Rect.fromLTWH(x + screenSize.width/2,
        y + screenSize.height/2, (size/200)*screenSize.width,
        (size/200)*screenSize.height), paint);
  }

  factory Mine.fromJson(Map<String, dynamic> jsonData) {
    return Mine(
      x: jsonData['x'],
      y: jsonData['y'],
    );
  }
}