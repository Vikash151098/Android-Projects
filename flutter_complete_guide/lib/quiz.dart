import 'package:flutter/material.dart';
import './question.dart';
import './answer.dart';
class Quiz extends StatelessWidget {
  final List<Map<String,Object>> questions;
  final questionIndex;
  final Function answerQuestion;
  Quiz({@required this.questions,@required this.questionIndex,@required this.answerQuestion});
  @override
  Widget build(BuildContext context) {
    return Column(
                children: [
                  Question(
                    questions[questionIndex]['questionText'],
                  ),
                  ...(questions[questionIndex]['answer'] as List<String>)
                      .map((answer) {
                    return Answer(answerQuestion, answer);
                  }).toList()
                ],
              );
  }
}