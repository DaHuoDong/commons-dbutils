package org.apache.commons.dbutils.impl.topicdata

import java.sql.Connection

import javax.sql.DataSource
import org.apache.commons.dbcp2.BasicDataSource

import scala.util.Try

object DBPoll {
  def initDS(connectURI: String, username: String, password: String, driverClass: String, initialSize: Int, maxActive: Int, maxIdle: Int, maxWait: Int) = {
    val ds = new BasicDataSource()
    ds.setDriverClassName(driverClass)
    ds.setUsername(username)
    ds.setPassword(password)
    ds.setUrl(connectURI)
    ds.setInitialSize(initialSize)
    ds.setMaxIdle(maxIdle)
    ds
  }


  def getHiveConnection(host: String, port: Int, userName: String, password: String): Try[Connection] = {
    val driverName: String = s"org.apache.hive.jdbc.HiveDriver"
    val url: String = s"jdbc:hive2://$host:$port"
    Try {
      initDS(url, userName, password, driverName, 10, 20, 0, 60000).getConnection()
    }
  }

  def getHiveDs(host: String, port: Int, userName: String, password: String): DataSource = {
    val driverName: String = s"org.apache.hive.jdbc.HiveDriver"
    val url: String = s"jdbc:hive2://$host:$port/default"
    val ds = initDS(url, userName, password, driverName, 10, 20, 0, 60000)
    //ds.
    ds
  }
}
