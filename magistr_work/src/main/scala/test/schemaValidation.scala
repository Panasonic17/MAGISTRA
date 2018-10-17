package test

import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Dataset, Encoders, SparkSession}

final class Shcema2(a: String, b: String, c: String) extends Serializable {

}

object schemaValidation {
  case class Test(a: String, b: Double,  d: Int, e: Long,daet:Array[String],boll:Boolean,f:Float)
  case class Shema(a: Int, b: String, c: String)

  case class Shema2(a: String, b: String, c: String, d: String,double: Double)

  def validate(dataset: Dataset[String], shema: StructType): Dataset[(Boolean, String)] = {

    dataset.map(row => (true, "2"))(Encoders.tuple(Encoders.scalaBoolean, Encoders.STRING))
  }

  //  def validateString(str:String, shema: StructType)

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .master("local[*]")
      .appName("StructuredNetworkWordCount")
      .getOrCreate()
    //
    //    spark.sparkContext.setLogLevel("ERROR")

    //
    //    val texst = spark.read.text("spark_test").as[String]
    //    texst.show()
    //    val shema = ScalaReflection.schemaFor[Shema].dataType.asInstanceOf[StructType]
    //    val as: StructField = shema.fields(0)
    //    println(shema.fields.size)
    //        println(as.dataType)
    //        println(as.metadata)
    //    val dt: DataType = as.dataType
    //    dt.typeName
    //    println(dt.toString)
    //    println(as.nullable)

    val shema1 = ScalaReflection.schemaFor[Test].dataType.asInstanceOf[StructType]
    shema1.fields.foreach(println)

//    println(LongType.simpleString)
    //    shema.foreach(strField=>println(strField))
    //    val raw = texst.sparkSession.read.schema(shema).csv(texst)
    //    raw.show()
    //    println(raw.schema)

    //    val raw = spark.read.csv("spark_test")
    //
    //
    //
    //    val validated = validate(raw, shema)
    //split
    //    raw.map()

    //    raw.show()

    //    raw.map(data=> {println(data.getClass);data}).count()


    //    val schema = ScalaReflection.schemaFor[Shema].dataType.asInstanceOf[StructType]
    //
    //    print(schema)
    //    raw.show()
    //
    //    test(raw).show
  }
}
