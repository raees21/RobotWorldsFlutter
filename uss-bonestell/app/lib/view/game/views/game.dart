import 'package:app/controller/game_state_controller.dart';
import 'package:app/view/game/canvas/game_painter.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';

class Game extends StatefulWidget {
  const Game({Key? key}) : super(key: key);

  @override
  _GameState createState() => _GameState();
}

class _GameState extends State<Game> {
  @override
  Widget build(BuildContext context) {
    return BlocConsumer<GameStateController, GameState>(
      listener: (ctx, state) {},
      builder: (ctx, state) => LayoutBuilder(builder: (_, constraints) => Container(
          height: constraints.maxHeight,
          width: constraints.maxWidth,
          color: Colors.greenAccent,
          child: CustomPaint(painter: GamePainter(gameState: state,),),
        )
      ),
    );
  }
}
