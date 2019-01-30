name := "sparkScala_application"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.3.0"


resolvers += Resolver.url("ClouderaRepo", url("https://repository.cloudera.com/content/repositories/releases"))

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "mysql" % "mysql-connector-java" % "5.1.6"
)
