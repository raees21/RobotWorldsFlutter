import 'package:app/controller/client_controller.dart';
import 'package:app/controller/game_state_controller.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class CommandPanel extends StatefulWidget {
  const CommandPanel({Key? key}) : super(key: key);

  @override
  _CommandPanelState createState() => _CommandPanelState();
}

class _CommandPanelState extends State<CommandPanel> {

  @override
  Widget build(BuildContext context) {
    return BlocConsumer<GameStateController, GameState>(
      listener: (ctx,state) {},
      builder: (ctx, state) => Container(
        alignment: Alignment.center,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Expanded(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Expanded(child: ZButton(color: Colors.blue, text: "forward",
                    cl: CommandEvent('back', state.player.name, ["10"]),
                  )),
                  Expanded(child: ZButton(color: Colors.blueGrey, text: "back",
                    cl: CommandEvent('forward', state.player.name, ["10"]),
                  )),
                ],
              ),
            ),
            Expanded(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Expanded(child: ZButton(color: Colors.green, text: "left",
                    cl: CommandEvent('turn', state.player.name, ["right"]),
                  )),
                  Expanded(child: ZButton(color: Colors.red, text: "right",
                    cl: CommandEvent('turn', state.player.name, ["left"]),
                  )),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class ZButton extends StatelessWidget {
  const ZButton({Key? key, required this.color, required this.text, required this.cl}) : super(key: key);

  final Color color;
  final String text;
  final CommandEvent cl;

  @override
  Widget build(BuildContext context) {
    var gsc = BlocProvider.of<ClientController>(context);
    return GestureDetector(
      onTap: () {
        gsc.add(cl);
      },
      child: Container(
        color: color,
        child: Text(text),
      ),
    );
  }
}



