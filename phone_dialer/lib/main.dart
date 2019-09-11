import 'package:flutter/material.dart';
import 'package:phone_dialer/services/calls_and_messages_service.dart';
import 'package:phone_dialer/services/service_locator.dart';

void main() {
  setupLocator();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {

  @override
  _MyHomePageState createState() => _MyHomePageState();
}



class _MyHomePageState extends State<MyHomePage> {
  final CallsAndMessagesService _service = locator<CallsAndMessagesService>();

  final String number = "123456789";
  final String email = "dancamdev@example.com";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Phone Dialer'),
      ),
      body: Container(
        width: double.infinity,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          mainAxisSize: MainAxisSize.max,
          children: <Widget>[
            RaisedButton(
              child: Text(
                "call $number",
              ),
              onPressed: () => _service.call(number),
            ),
            SizedBox(height: 20),
            RaisedButton(
              child: Text(
                "message $number",
              ),
              onPressed: () => _service.sendSms(number),
            ),
            SizedBox(height: 20),
            RaisedButton(
              child: Text(
                "email $email",
              ),
              onPressed: () => _service.sendEmail(email),
            ),
          ],
        ),
      ),
    );
  }
}
