import 'package:app/controller/admin_controller.dart';
import 'package:app/data/model/obstacle_models.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class ObstacleList extends StatefulWidget {
  const ObstacleList({Key? key}) : super(key: key);

  @override
  _ObstacleListState createState() => _ObstacleListState();
}

class _ObstacleListState extends State<ObstacleList> {
  @override
  Widget build(BuildContext context) {
    return BlocConsumer<AdminController, AdminState>(
      listener: (BuildContext context, state) {  },
      builder: (ctx, state) => Scaffold(
          appBar: AppBar(
          title: const Text("Robot List"),
      ),
      body: Column(children: [
      Expanded(child: ListView.builder(
      shrinkWrap: true,
        itemCount: state.obstacles.length,
        itemBuilder: (ctx,i){
          int x = state.obstacles[i].x;
          int y = state.obstacles[i].y;
          int size = state.obstacles[i].size as int;
          return Card(
            color: Colors.transparent,
            child: ListTile(
                title: const Text("Is Pit: False" , style: TextStyle(color: Colors.white),),
                subtitle: Text("X-Coordinate: " + x.toString() + "\nY-Coordinate: " + y.toString() + "\nSize: " + size.toString()
                )
                )
            );
        },
      ),
      )
      ])
      ),
    );
  }
}
