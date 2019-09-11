import 'dart:async';
import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:location/location.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Google Maps Demo',
      home: MapSample(),
    );
  }
}

class MapSample extends StatefulWidget {
  @override
  State<MapSample> createState() => MapSampleState();
}

class MapSampleState extends State<MapSample> {
  Completer<GoogleMapController> _controller = Completer();

  static final CameraPosition _kGooglePlex = CameraPosition(
    target: LatLng(37.42796133580664, -122.085749655962),
    zoom: 14.4746,
  );

  static final CameraPosition _kLake = CameraPosition(
      //bearing: 192.8334901395799,
      target: LatLng(currentLocation.latitude,currentLocation.longitude),
      //tilt: 59.440717697143555,
      zoom: 19.151926040649414);
 static LocationData currentLocation;

  var location = new Location();

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: GoogleMap(
        mapType: MapType.hybrid,
        initialCameraPosition: _kGooglePlex,
        onMapCreated: (GoogleMapController controller) {
          _controller.complete(controller);
        },
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: _goToTheLake,
        label:Text(""),
        icon: Icon(Icons.my_location),
      ),
    );
  }

  Future<LocationData> _getLocation() async {


// Platform messages may fail, so we use a try/catch PlatformException.
    try {
      var userLocation=await location.getLocation();
      currentLocation = LocationData(latitude: userLocation.latitude,longitude: userLocation.longitude);
    } on Exception catch (e) {
      if (e.toString() == 'PERMISSION_DENIED') {
        print('Permission denied');
      }
      currentLocation = null;
    }
    return currentLocation;
}

  Future<void> _goToTheLake() async {

    _getLocation();
    _showLocation();

  }
  Future<void> _showLocation() async{
    var location = new Location();
    final GoogleMapController controller = await _controller.future;

    location.onLocationChanged().listen((LocationData) {
      //print(currentLocation.latitude);
      //print(currentLocation.longitude);
      controller.animateCamera(CameraUpdate.newCameraPosition(_kLake));

    });
  }
}

class LocationData
{
  final double latitude;
  final double longitude;
  LocationData({this.latitude,this.longitude});
}

