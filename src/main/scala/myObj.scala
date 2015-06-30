package people
import spray.json._

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import com.datastax.spark.connector._

object myObj extends App {

  val pfac = PersonFactory

  val conf = new SparkConf(true)
  .set("spark.cassandra.connection.host", "127.0.0.1")
  val sc = new SparkContext("http://localhost:8080", "test", conf)

  val rdd = sc.cassandraTable("test", "kv")
  println(rdd.count)
  println(rdd.first)
  println(rdd.map(_.getInt("value")).sum)

}
