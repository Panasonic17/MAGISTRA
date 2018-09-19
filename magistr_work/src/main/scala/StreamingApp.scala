import org.apache.spark.sql.SparkSession

object StreamingApp {
  def main(args: Array[String]): Unit = {

    // simple scala therad populate data to kafka
    // structured stream read from kafra
    // transform
    // save to  elk and mongo

    val spark = SparkSession
      .builder
      .master("local[*]")
      .appName("StructuredNetworkWordCount")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._


    // load

    //transform

    //save

  }
}
