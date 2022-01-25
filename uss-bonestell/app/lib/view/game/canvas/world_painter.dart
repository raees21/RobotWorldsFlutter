import 'package:app/data/model/obstacle_models.dart';
import 'package:app/data/model/robot.dart';
import 'package:flutter/material.dart';
import 'package:flutter/painting.dart';

class WorldPainter {

  void paintObstacle(Canvas canvas, Size size, Obstacle o) {

    var paint = Paint()
      ..color = Colors.red;

      double h = size.height;
      double w = size.width;
      canvas.drawRect(Rect.fromLTWH((o.x) + w/2, o.y + h/2, 10, 10), paint);
  }

  void paintRobot(Canvas canvas, Size size, Robot r) {
    var paint = Paint()
      ..color = Colors.blue;

    double h = size.height;
    double w = size.width;
    final icon = Icons.smart_toy;
    TextPainter textPainter = TextPainter(textDirection: TextDirection.rtl);
    textPainter.text = TextSpan(text: String.fromCharCode(icon.codePoint),
        style: TextStyle(fontSize: 25.0,fontFamily: icon.fontFamily));
    textPainter.layout();
    textPainter.paint(canvas, Offset((r.x) + w/2,r.y + h/2));
  }
}