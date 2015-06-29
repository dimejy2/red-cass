name := "DataAnalysis"

version := "1.0"

libraryDependencies ++= Seq(
    "net.debasishg" %% "redisclient" % "3.0"
)


libraryDependencies += "io.spray" %%  "spray-json" % "1.3.2"

resolvers += "spray repo" at "http://repo.spray.io"


libraryDependencies ++= Seq(
    "net.debasishg" %% "redisclient" % "3.0"
)

libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "1.4.0-M1"


libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.0"


libraryDependencies ++= Seq(
  "org.apache.cassandra" % "cassandra-thrift" % "2.1.2" ,

  "org.apache.cassandra" % "cassandra-clientutil" % "2.1.2",

  "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.3")
