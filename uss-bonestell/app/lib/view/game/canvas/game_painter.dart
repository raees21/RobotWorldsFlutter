import 'package:app/controller/game_state_controller.dart';
import 'package:app/data/model/obstacle_models.dart';
import 'package:app/data/model/robot.dart';
import 'package:app/view/game/canvas/world_painter.dart';
import 'package:flutter/cupertino.dart';

class GamePainter extends CustomPainter {
  GameState gameState;
  WorldPainter wp = WorldPainter();
  GamePainter({required this.gameState});

  @override
  void paint(Canvas canvas, Size size) {
    for (Obstacle o in gameState.obstacles) {
      wp.paintObstacle(canvas, size, o);
    }

    for (Robot r in gameState.robots) {
      wp.paintRobot(canvas, size, r);
    }
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return true;
  }
  
}