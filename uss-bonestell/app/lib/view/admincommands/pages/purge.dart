import 'package:app/controller/admin_controller.dart';
import 'package:app/data/model/robot.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';

class purge extends StatefulWidget {
  const purge({Key? key}) : super(key: key);

  @override
  _purgeState createState() => _purgeState();
}

class _purgeState extends State<purge> {
  String robotName = "";

  @override
  Widget build(BuildContext context) {
    return BlocConsumer<AdminController, AdminState>(
      listener: (ctx, state) {},
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
              String robotStatus = state.robots[i].robotStatus;
              return Card(
                color: Colors.transparent,
                child: ListTile(
                    onTap: () {
                      BlocProvider.of<AdminController>(ctx).add(PurgeEvent(name));
                      },
                    title: Text("Robot Name: " + name, style: const TextStyle(color: Colors.white),),
                    subtitle: Text("Robot Status; "+ robotStatus,style: const TextStyle(color: Colors.white) )),
              );
            },
          ),
        ),
        ]
      ),
      ),
    );}
}
