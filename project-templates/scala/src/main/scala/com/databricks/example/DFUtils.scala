package com.databricks.example

import org.apache.log4j.Logger

object DFUtils extends Serializable {

  @transient
  lazy val logger: Logger = Logger.getLogger(getClass.getName)

  def pointlessUDF(raw: String): String = {
    raw
  }

}
