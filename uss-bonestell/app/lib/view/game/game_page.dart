import 'dart:ui';
import 'package:app/view/game/views/command_panel.dart';
import 'package:app/view/game/views/info_bar.dart';
import 'package:flutter/material.dart';
import 'package:app/view/game/views/game.dart';
import 'package:provider/provider.dart';

class GamePage extends StatefulWidget {
  const GamePage({Key? key}) : super(key: key);

  @override
  _GamePageState createState() => _GamePageState();
}

class _GamePageState extends State<GamePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Robot Worlds"),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: const [
          Expanded(
              flex: 6,
              child: Game(),
          ),
          Expanded(
              flex: 2,
              child: InfoBar()),
          Expanded(
              flex: 2,
              child: CommandPanel()),
        ],
      ),
    );
  }
}
