import 'package:flutter/material.dart';

class Menu extends StatelessWidget {
  const Menu({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Drawer(
      elevation: 20,
      child: Material(
        color: Colors.blueGrey,
        child: ListView(
            children: const [
              DrawHeader(),
              MenuOption(text: "Settings", route: "/settings",),
              MenuOption(text: "Log in", route: "/login",),
            ],
        ),
      ),
    );
  }
}

class DrawHeader extends StatelessWidget {
  const DrawHeader({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          colors: [Colors.lightBlue, Colors.blueGrey],
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
        )
      ),
      child: const DrawerHeader(
        child: Text("hello"),
        curve: Curves.bounceIn,
      ),
    );
  }
}

class MenuOption extends StatelessWidget {
  const MenuOption({required this.text, Key? key, required this.route}) : super(key: key);

  final String route;
  final String text;
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {Navigator.of(context).pushNamed(route);},
      child: Container(
        padding: const EdgeInsets.all(20),
        child: Center(
          child: Text(text),
        ),
      ),
    );
  }
}
