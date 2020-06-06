import 'package:flutter/material.dart';
import './quiz.dart';
import './result.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  static const _questions = [
    {
      'questionText': 'what\'s your favorites colors?',
      'answer': ['Red', 'Yellow', 'Blue', 'White']
    },
    {
      'questionText': 'what\'s your favorites animals?',
      'answer': ['Rabbit', 'Elephant', 'Snake', 'Lion']
    },
    {
      'questionText': 'who\'s your favorites instructor',
      'answer': ['Vikash', 'Mangal', 'Ganesh', 'Amrit']
    },
  ];
  var _questionIndex = 0;
  void _answerQuestion() {
    setState(() {
      _questionIndex++;
    });

    print(_questionIndex);
    if (_questionIndex < _questions.length) {
      print('we have more questions');
    } else {
      print('No more questions');
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('My first App'),
        ),
        body: _questionIndex < _questions.length
            ? Quiz(
                questions: _questions,
                answerQuestion: _answerQuestion,
                questionIndex: _questionIndex,
              )
            : Result()
      ),
    );
  }
}
