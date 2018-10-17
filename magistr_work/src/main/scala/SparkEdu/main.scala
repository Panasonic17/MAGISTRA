package SparkEdu

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql._

object main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .master("local[*]")
      .appName("StructuredNetworkWordCount")
      .getOrCreate()
    val df= spark.range(100).toDF()
    df.filter("id==5").show



    while (true){
      Thread.sleep(10000)
    }

  }
}
