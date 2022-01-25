import 'package:app/controller/admin_controller.dart';
import 'package:app/view/route_generator.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';


class AdminCommands extends StatefulWidget {
  const AdminCommands({Key? key}) : super(key: key);

  @override
  _AdminCommandsState createState() => _AdminCommandsState();
}

class _AdminCommandsState extends State<AdminCommands> {

  // var _isInit = true;
  //
  // @override
  // void didChangeDependencies() {
  //   if (_isInit) {
  //     Provider.of<AdminController>(context).fetchRobots();
  //     //Provider.of<InsertProviders>(context).fetchAuthors();
  //   }
  //   _isInit = false;
  //   super.didChangeDependencies();
  // }

  @override
  Widget build(BuildContext context) {
    var adminController = BlocProvider.of<AdminController>(context);
    return BlocConsumer<AdminController, AdminState>(
      builder: (ctx, state) => Scaffold(
        appBar: AppBar(
          title: const Text("Admin Commands"),
        ),
        body: Column(children: [
        Container(
        padding: const EdgeInsets.all(8.0),
          child: Center(
            child: Column(
              children: [
                FractionallySizedBox(
                  widthFactor: 0.5,
                  child: ElevatedButton(
                    child: const Text(
                  "Robots",
                ),
                onPressed: (){
                  adminController.add(LoadRobotsEvent());
                  Navigator.of(context).pushNamed("/robotlist");
                },),
                ),
                FractionallySizedBox(
                  widthFactor: 0.5,
                  child: ElevatedButton(
                    child: const Text(
                    "Dump",
                  ),
                  onPressed: (){
                    Navigator.of(context).pushNamed("/game");
                  },
                ),
                ),
                FractionallySizedBox(
                  widthFactor: 0.5,
                  child: ElevatedButton(
                    child: const Text(
                    "Obstacles",
                  ),
                  onPressed: (){
                    adminController.add(LoadObstaclesEvent());
                    Navigator.of(context).pushNamed("/obstacles");
                  },
                ),
                ),
                FractionallySizedBox(
                  widthFactor: 0.5,
                  child: ElevatedButton(
                    child: const Text(
                    "Purge",
                  ),
                  onPressed: (){
                    adminController.add(LoadRobotsEvent());
                    Navigator.of(context).pushNamed("/purge");
                  },
                ),
                ),
                FractionallySizedBox(
                  widthFactor: 0.5,
                  child: ElevatedButton(
                    child: const Text(
                      "Save World",
                    ),
                    onPressed: (){
                      adminController.add(SaveWorldEvent());
                    },
                  ),
                )
          ])
        )
        )
        ]
      )
      ), listener: (context, state) {
        if (state is WorldSaved) {ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        duration: Duration(seconds: 2),
          content: Text("World Saved")
      )
    );}}
    );
  }
}