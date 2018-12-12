package com.databricks.example

import org.apache.log4j.Logger

case class Person(Name: String, Company: String)

object DatasetUtils extends Serializable {

  @transient
  lazy val logger: Logger = Logger.getLogger(getClass.getName)

  def createPersonFromString(rawString: String): Person = {
    logger.info("people from string")
    val split = rawString.split(",")

    if (split.length < 2) {
      logger.warn("not enough fields in this string")
      Person(null, null)
    } else if (split.length == 2) {
      Person(split(0), split(1))
    } else {
      logger.warn("Too many fields in this string")
      Person(null, null)
    }
  }
}