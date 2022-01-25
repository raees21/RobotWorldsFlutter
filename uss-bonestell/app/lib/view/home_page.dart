import 'package:app/controller/admin_controller.dart';
import 'package:app/controller/game_state_controller.dart';
import 'package:app/data/repository/admin_repository.dart';
import 'package:app/data/repository/world_repository.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';

import 'launch_page.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    // return Container(
    //       padding: const EdgeInsets.all(8.0),
    //   child: Center(
    //     child: ElevatedButton(
    //       child: const Text(
    //         "Go to launch",
    //         ),
    //           onPressed: (){
    //             Navigator.of(context).pushNamed('/launch');
    //           },),
    //         )
    // );
    return LaunchPage(title: 'Robot worlds',);
  }
}
