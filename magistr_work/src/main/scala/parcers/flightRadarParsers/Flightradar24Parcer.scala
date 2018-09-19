package parcers.flightRadarParsers

import entity.{RawHistoricalFlightData, FlightRadarRecord}

object Flightradar24Parcer {

  def parsePlainData(row: String): FlightRadarRecord = {
    val regex = ",\"(\\w*)\":\\[\"(\\w*)\",([-.\\d]*),([-.\\d]*),(\\d*),(\\d*),(\\d*),\"(\\d*)\",\"([\\w-]*)\",\"(\\w*)\",\"([\\w-]*)\".(\\d*),\"(\\w*)\",\"(\\w*)\",\"(\\w*)\",(\\d*),([-\\d]*),\"(\\w*)\",(\\d*),\"(\\w*)\"]".r
    row match {
      case regex(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20) => FlightRadarRecord(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20)
      case _ =>
        println("failed data " + row); null
    }
  }

  def parseRawHistoricalFlightData(data: String): RawHistoricalFlightData = {
    val regex = ".*identification\":(.*),\"status\":(.*),\"level\":\"(.*)\",\"aircraft\":(.*),\"airline\":(.*),\"owner\":(.*),\"airspace\":(.*),\"airport\":(.*),\"flightHistory\":(.*),\"ems\":(.*),\"availability\":(.*),\"time\":(.*),\"trail\":(.*),\"firstTimestamp\":(.*),\"s\":(.*)".r
    data match {
      case regex(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15) => RawHistoricalFlightData(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14.toInt, _15)
      case _ =>
        println("failed data " + data); null
    }
  }
}
