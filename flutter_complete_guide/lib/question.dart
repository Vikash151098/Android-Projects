import 'package:flutter/material.dart';

class Question extends StatelessWidget {
  final String questionaText;
  Question(this.questionaText);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      margin: EdgeInsets.all(10),
      child: Text(
        questionaText,
        style: TextStyle(fontSize: 28),
        textAlign: TextAlign.center,
      ),
    );
  }
}
