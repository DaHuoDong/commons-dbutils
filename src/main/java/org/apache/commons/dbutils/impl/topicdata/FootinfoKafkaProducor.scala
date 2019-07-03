package org.apache.commons.dbutils.impl.topicdata

import java.sql.{ResultSet,SQLException}

import org.apache.commons.dbutils.{QueryRunner, ResultSetHandler}

import scala.util.{Failure, Success}

object FootinfoKafkaProducor {
  def main(args: Array[String]): Unit = {

    val ds = DBPoll.getHiveDs("172.17.70.93", 10000, "hive", "hive123")
    //val sql = "show tables"
    val sql = "select * from test;"

    new QueryRunner(ds).query(sql,new ResultSetHandler[Object]() {


      @throws[SQLException]
      def handle(rs: ResultSet) = {
        /*if (!rs.next) logger.debug("null")
        val meta = rs.getMetaData
        val cols = meta.getColumnCount
        val result = new Array[AnyRef](cols)
        var i = 0
        while ( {
          i < cols
        }) {
          result(i) = rs.getObject(i + 1)

          {
            i += 1;
            i - 1
          }
        }
        result*/
        rs
      }
    },"test")
  }
}



