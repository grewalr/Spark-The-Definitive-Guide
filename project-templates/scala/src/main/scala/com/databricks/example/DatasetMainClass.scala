package com.databricks.example

import org.apache.spark.sql.SparkSession

object DatasetMainClass extends Serializable {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Datasets Spark Example")
      .config("spark.sql.warehouse.dir", "/user/hive/warehouse")
      .getOrCreate()
    // allows the .toDF method
    import spark.implicits._

    val authors = Seq("bill,databricks", "matei,databricks")
    val authorsDS = spark
      .sparkContext
      .parallelize(authors)
      .map(DatasetUtils.createPersonFromString)
      .toDF()
      .as[Person]

    authorsDS.show()
  }
}
