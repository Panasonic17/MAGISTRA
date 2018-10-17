package test

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window

object JumpIntoWindow {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .master("local[*]")
      .appName("StructuredNetworkWordCount")
      .getOrCreate()
    import org.apache.spark.sql.functions._
    import spark.implicits._
    val timename="time"
    val data = spark.read.option("header", "true").option("inferSchema", "true").option("delimiter", "~").csv("C:\\WORK_DIR\\NORTHORM\\tmp\\sparktest\\input\\test.csv")
    val window = Window.partitionBy("key").orderBy(desc("time"))
    data.withColumn("rowNum", row_number().over(window)).where(col("rowNum") === 1)
      .drop("rowNum").show()
  }
}
