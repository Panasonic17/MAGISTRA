package recivers

import entity.FlightRadarRecord
import http.HttpClient
import parcers.flightRadarParsers.Flightradar24Parcer

class SimpleFlightRadarLiveDataReciver extends Reciver[FlightRadarRecord] {

  override def getData(): FlightRadarRecord = ???

  override def getDataList(): List[FlightRadarRecord] = {

    val url = "https://data-live.flightradar24.com/zones/fcgi/feed.js?bounds=69.65,-55.06,-101.88,81.82&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=14400&gliders=1&stats=1"
    val body = HttpClient.getBody(url).split("\n").filter(str => str.startsWith(",") && str.endsWith("]")).map(Flightradar24Parcer.parsePlainData)
    ???

  }
}
