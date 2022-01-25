import 'package:app/controller/game_state_controller.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class InfoBar extends StatefulWidget {
  const InfoBar({Key? key}) : super(key: key);

  @override
  _InfoBarState createState() => _InfoBarState();
}

class _InfoBarState extends State<InfoBar> {
  @override
  Widget build(BuildContext context) {
    return BlocConsumer<GameStateController, GameState>(
      listener: (ctx, state) {},
      builder: (ctx, state) => Container(
        color: Colors.cyanAccent,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Attribute(name: "shots", value: state.player.shots.toString(),),
                Attribute(name: "shields", value: state.player.shields.toString(),),
                Attribute(name: "robotStatus", value: state.player.robotStatus,),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Attribute(name: "mine", value: state.player.mine.toString(),),
                Attribute(name: "reload", value: state.player.reload.toString(),),
                Attribute(name: "status", value: state.player.status,),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

class Attribute extends StatefulWidget {
  Attribute({Key? key, required this.value, required this.name}) : super(key: key);

  String value;
  String name;

  @override
  _AttributeState createState() => _AttributeState();
}

class _AttributeState extends State<Attribute> {

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Container(
          padding: const EdgeInsets.all(10),
            child: Text(widget.name)
        ),
        Container(
            padding: const EdgeInsets.all(10),
            child: Text(widget.value.toString())
        )
      ],
    );
  }
}
