package people

import org.apache.spark.{SparkConf, SparkContext}
import config.Config

object myObj extends App {

  val pfac = PersonFactory

  val conf = new SparkConf(true)
    .set("spark.cassandra.connection.host", "127.0.0.1")
    .set("spark.cores.max", "10")
    .setAppName("Executor")
  val sc = new SparkContext(Config.sparkContext, "test", conf)
  val file = sc.textFile("myObj.scala")
  file.count()
}
