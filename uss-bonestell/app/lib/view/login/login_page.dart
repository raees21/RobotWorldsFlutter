import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {

  TextEditingController username = TextEditingController();
  TextEditingController password = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Log In"),
      ),
      body: Column(
        children: [
          TextField(
            controller: username,
          ),
          TextField(
            controller: password,
          ),
          Row(
            children: [
              TextButton(onPressed: () {}, child: const Text("CANCEL")),
              TextButton(onPressed: () {}, child: const Text("LOG IN")),
            ],
          ),
        ],
      ),
    );
  }
}

