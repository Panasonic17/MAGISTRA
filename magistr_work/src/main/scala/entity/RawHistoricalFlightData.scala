package entity

case class RawHistoricalFlightData(identification: String,
                                   status: String,
                                   level: String,
                                   aircraft: String,
                                   airline: String,
                                   owner: String,
                                   airspace: String,
                                   airport: String,
                                   flightHistory: String,
                                   ems: String,
                                   availability: String,
                                   time: String,
                                   trail: String,
                                   firstTimestamp: Long,
                                   s: String)
