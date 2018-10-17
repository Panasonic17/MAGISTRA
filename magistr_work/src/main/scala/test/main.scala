package test

import http.HttpClient
import parcers.flightRadarParsers.Flightradar24Parcer
import scalaj.http.{Http, HttpResponse}

object main {
  def main(args: Array[String]): Unit = {
    //    def get(url: String) = scala.io.Source.fromURL(url).mkString
    //
    val url = "https://data-live.flightradar24.com/zones/fcgi/feed.js?bounds=69.65,-55.06,-101.88,81.82&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=14400&gliders=1&stats=1"
    //    //   val url_1=/
    val data: HttpResponse[String] = Http(url).asString
    //
    print(data)
    val arr = data.body.split("\n")
    val filtered_arr = arr.filter(str => str.startsWith(",") && str.endsWith("]"))
    //    //    filtered_arr.foreach(println)
    //    //    println(Flightradar24DataRowParcer.parse(filtered_arr(10)))
    //
    //    //    println(filtered_arr(0))
   val data23= filtered_arr.map(Flightradar24Parcer.parsePlainData)
      .map(fl => fl.flightGlobalID)
      .map(id => "https://data-live.flightradar24.com/clickhandler/?version=1.5&flight=" + id)

      data23.map(url => {Flightradar24Parcer.parseRawHistoricalFlightData(HttpClient.getBody(url))})
      .length
    //
    //    //    println(filtered_arr.map(Flightradar24DataRowParcer.parse).filter(flightRecord => flightRecord._13 != "" && flightRecord._12 != "").size)
    //    val data1 = filtered_arr.map(Flightradar24Parcer.parsePlainData).map(data => data.timestamp.toInt)
    //    println(data1.max)
    //    println(data1.min)
    //    val testUrl = "https://data-live.flightradar24.com/clickhandler/?version=1.5&flight=1de18404"
    //    Flightradar24Parcer.parseRawHistoricalFlightData(HttpClient.getBody(testUrl))
  }
}
