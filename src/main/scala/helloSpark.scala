
import java.io.File

import org.apache.commons.io.FileUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark._

object SparkWordCount {
  def main(args: Array[String]) {

    val sqlContext = org.apache.spark.sql.SparkSession.builder
      .master("local")
      .appName("Spark CSV Reader")
      .getOrCreate;

//    val df = spark.read
//      .format("csv")
//      .option("header", "true") //reading the headers
//      .option("mode", "DROPMALFORMED")
//      .load("hdfs:///user/sreddy/db/csv/cities.csv")

//    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    val df = sqlContext.read.parquet("/user/sreddy/db/tmp/parquet_files/userdata1.parquet")
    df.printSchema()
    df.registerTempTable("people")
    sqlContext.sql("select * from people").collect().foreach(println)

    System.out.println("OK");
  }
}
