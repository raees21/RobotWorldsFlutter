import 'package:app/view/admincommands/pages/obstacle_list.dart';
import 'package:app/view/admincommands/pages/purge.dart';
import 'package:app/view/game/game_page.dart';
import 'package:app/view/login/login_page.dart';
import 'package:app/view/admincommands/pages/robot_list.dart';
import 'package:flutter/material.dart';
import 'package:app/view/home_page.dart';
import 'package:app/view/admincommands/admin_commands.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import 'launch_page.dart';

class RouteGenerator {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    final args = settings.arguments;
    switch (settings.name) {
      case '/':
        return MaterialPageRoute(builder: (_) => const HomePage(title: 'robot worlds',));
      case '/login':
        return MaterialPageRoute(builder: (_) => const LoginPage());
      case '/game':
        return MaterialPageRoute(builder: (_) => const GamePage());
      case '/admin':
        return MaterialPageRoute(builder: (_) => const AdminCommands());
      case '/robotlist':
        return MaterialPageRoute(builder: (_) => const RobotList());
      case '/obstacles':
        return MaterialPageRoute(builder: (_) => const ObstacleList());
      case '/purge':
        return MaterialPageRoute(builder: (_) => const purge());
      case '/launch':
        return MaterialPageRoute(builder: (_) => LaunchPage(title: "Robot Worlds",));
    }
    return MaterialPageRoute(builder: (_) => const Error());
  }
}

class Error extends StatelessWidget {
  const Error({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Something went wrong"),
      ),
    );
  }
}