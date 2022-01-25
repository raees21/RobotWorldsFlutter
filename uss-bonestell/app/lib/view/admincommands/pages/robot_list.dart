import 'package:app/controller/admin_controller.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class RobotList extends StatefulWidget {
  const RobotList({Key? key}) : super(key: key);

  @override
  _RobotListState createState() => _RobotListState();
}

class _RobotListState extends State<RobotList> {

  // var _isInit = true;
  //
  // @override
  // void didChangeDependencies() {
  //   if (_isInit) {
  //     Provider.of<AdminController>(context).fetchRobots();
  //   }
  //   _isInit = false;
  //   super.didChangeDependencies();
  // }

  @override
  Widget build(BuildContext context) {
    return BlocConsumer<AdminController, AdminState>(
      listener: (BuildContext context, state) {  },
      builder: (ctx, state) => Scaffold(
          appBar: AppBar(
          title: const Text("Robot List"),
      ),
      body: Column(children: [
        Expanded(
          child: ListView.builder(
            shrinkWrap: true,
            itemCount: state.robots.length,
            itemBuilder: (ctx,i){
              String name = state.robots[i].name;
              String status = state.robots[i].status;
              int reload = state.robots[i].reload;
              int repair = state.robots[i].repair;
              int mine = state.robots[i].mine;
              int shields = state.robots[i].shields;
              int shots = state.robots[i].shots;
              String currentDirection = state.robots[i].currentDirection;
              int x = state.robots[i].x;
              int y = state.robots[i].y;
              String robotStatus = state.robots[i].robotStatus;
              return Card(
                color: Colors.transparent,
                child: ListTile(
                    title: Text("Robot Name: " + name, style: TextStyle(color: Colors.white),),
                    subtitle: Text("Robot Status: " + status + "\nReload: " + reload.toString()
                        + "\nRepair: " + repair.toString() + "\nMine: " + mine.toString() +
                        "\nShields: " + shields.toString() + "\nShots: " + shots.toString() +
                        "\nCurrent Direction: " + currentDirection + "\nX: " + x.toString() +
                        "\nY: " + y.toString() + "\nRobot Status: " + robotStatus ,style: TextStyle(color: Colors.white)
                    )
                ),
              );
            },
          ),
        ),

      ]),
      ),
    );
  }
}
