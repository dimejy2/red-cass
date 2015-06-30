package people

import org.apache.spark.{SparkConf, SparkContext}

object myObj extends App {

  val pfac = PersonFactory

  val conf = new SparkConf(true)
    .set("spark.cassandra.connection.host", "127.0.0.1")
  val sc = new SparkContext("http://127.0.0.1:8080", "test", conf)
  val file = sc.textFile("README.md")

  print(file.count())

  // val rdd = sc.cassandraTable("test", "kv")
  // println(rdd.count)
  // println(rdd.first)
  // println(rdd.map(_.getInt("value")).sum)
}
