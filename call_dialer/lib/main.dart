import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

void main() =>runApp(MyApp());
class MyApp extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: 'Call Dialer',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Call Dialer'),
      ),
      body: Center(
      child: RaisedButton(
    onPressed: _launchURL,
    child: Text('Show Flutter homepage'),
    ),
    ),
    ));
}


_launchURL() async {
  const url = 'https://flutter.dev';
  if (await canLaunch(url)) {
    await launch(url);
  } else {
    throw 'Could not launch $url';
  }
}
}