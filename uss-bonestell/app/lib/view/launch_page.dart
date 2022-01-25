import 'package:app/controller/client_controller.dart';
import 'package:app/controller/robot_types.dart';
import 'package:flutter/material.dart';
import 'package:app/view/menu.dart';
import 'package:app/view/route_generator.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';

class LaunchPage extends StatefulWidget {

  final List<RobotType> robotList = [
    RobotType(type: "Sniper", description: "",),
    RobotType(type: "Shooter", description: "",),
    RobotType(type: "Miner", description: "",),
    RobotType(type: "cool dude", description: "",),
  ];

  LaunchPage({Key? key, required this.title}) : super(key: key);
  final String title;
  static String routeName = '/home';

  @override
  _MyLaunchPageState createState() => _MyLaunchPageState();

}

class _MyLaunchPageState extends State<LaunchPage> {
  TextEditingController nameController = TextEditingController();
  String robotType = '';
  final _isInit = true;

  @override
  void initState() {
    super.initState();
  }

  @override
  void dispose() {
    nameController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    var client = BlocProvider.of<ClientController>(context);
    return Scaffold(
      backgroundColor: Colors.grey,
      drawer: const Menu(),
      appBar: AppBar(
        title: Text(widget.title),
      ),
    body: Container(
      constraints:  const BoxConstraints.expand(),
      decoration: const BoxDecoration(
        image: DecorationImage(
            image: AssetImage("Destroyer_Mech.gif"),
            fit: BoxFit.cover
        ),
      ),
    child: Column(children: [
      Container(
        padding: const EdgeInsets.all(8.0),
        child: Center(
          child: ElevatedButton(
            child: const Text(
              "I'm a Bloody ADMIN",
            ),
            onPressed: (){
              Navigator.of(context).pushNamed("/admin");
            },),
        ),
      ),
      TextFormField(
        maxLength: 20,
        controller: nameController,
        style: const TextStyle(color: Colors.white
        ),
        decoration: InputDecoration(
          focusedBorder: OutlineInputBorder(
            borderRadius: BorderRadius.circular(0),
            borderSide: const BorderSide(
              width: 5.0,
                color: Colors.white
            ),
          ),
          enabledBorder: const OutlineInputBorder(
            borderSide: BorderSide(
              color: Colors.grey,
              width: 5.0
            )
          ),
          labelText: 'Robot Name',
          labelStyle: const TextStyle(
              color:Colors.white
          ),
          ),
        ),
      const Text(
        'Robot Type',
        style: TextStyle(fontSize: 18, color: Colors.white),
      ),
      Expanded(
        child: ListView.builder(
          shrinkWrap: true,
          itemCount: 4,
          itemBuilder: (ctx,i){
            String type = widget.robotList[i].type;
            String des = widget.robotList[i].description;
            return Card(
              color: Colors.transparent,
              child: ListTile(
                onTap: () {robotType = type;},
                  title: Text(type, style: const TextStyle(color: Colors.white),),
                  subtitle: Text(des,style: const TextStyle(color: Colors.white) )),
            );
          },
        ),
      ),

      Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Container(
              padding: const EdgeInsets.all(8.0),
              child: Center(
                child: ElevatedButton(
                  child: const Text(
                      "Go to game",
                  ),
                  onPressed: (){
                    client.add(ConnectEvent());
                    Navigator.of(context).pushNamed("/game");
                  },),
              ),
            ),
          Container(
            padding: const EdgeInsets.all(8.0),
            child: Center(
              child: ElevatedButton(
                child: const Text(
                  "Launch Robot",
                ),
                onPressed: (){
                  client.add(ConnectEvent());
                  client.add(CommandEvent("launch", nameController.value.text, [robotType]));
                },),
            ),
          ),
        ],
      ),
      ]),
    )
    );
  }
}