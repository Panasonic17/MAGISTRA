import scalaj.http.{Http, HttpResponse}

object main {
  def main(args: Array[String]): Unit = {
    def get(url: String) = scala.io.Source.fromURL(url).mkString

    val url = "https://data-live.flightradar24.com/zones/fcgi/feed.js?bounds=69.65,-55.06,-101.88,81.82&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=14400&gliders=1&stats=1"
    //   val url_1=/
    val data: HttpResponse[String] = Http(url).asString

    val arr = data.body.split("\n")
    val filtered_arr = arr.filter(str => str.startsWith(",") && str.endsWith("]"))
    //    filtered_arr.foreach(println)
//    println(Flightradar24DataRowParcer.parse(filtered_arr(10)))

    filtered_arr.foreach(Flightradar24DataRowParcer.parse)

  }
}
