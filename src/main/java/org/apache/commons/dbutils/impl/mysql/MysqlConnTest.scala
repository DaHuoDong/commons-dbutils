package org.apache.commons.dbutils.impl.mysql

import java.io.PrintWriter
import java.sql.{Connection, DriverManager, ResultSet, SQLException}
import java.util.logging.Logger

import javax.sql.DataSource
import org.apache.commons.dbutils.{DbUtils, QueryRunner, ResultSetHandler}

object MysqlConnTest {
  def main(args: Array[String]): Unit = {

    val h = new ResultSetHandler[List[Object]](){
      /**
        * Turn the <code>ResultSet</code> into an Object.
        *
        * @param rs The <code>ResultSet</code> to handle.  It has not been touched
        *           before being passed to this method.
        * @return An Object initialized with <code>ResultSet</code> data. It is
        *         legal for implementations to return <code>null</code> if the
        *         <code>ResultSet</code> contained 0 rows.
        * @throws SQLException if a database access error occurs
        */
      override def handle(rs: ResultSet): List[Object] = {
        if (!rs.next()){
          Nil
        }

        val meta = rs.getMetaData

        val cols = meta.getColumnCount


      }
    }
    //DbUtils.loadDriver("")
    val databaseHost: String = "tp540new"
    val mysqlPort: Int = 3306
    val mysqlUser: String = "hive"
    val password: String = "hive123"
    val databaseName = "rt_data"

    //DatabaseConfig.mysql = MysqlDatabaseInfo(databaseHost, mysqlPort, databaseName, mysqlUser, password)

    DbUtils.loadDriver("com.mysql.cj.jdbc.Driver")
    val conn = DriverManager.getConnection(s"jdbc:mysql://$databaseHost:$mysqlPort/$databaseName?useSSL=true&useServerPrepStmts=true", mysqlUser, password)

    val qr = new QueryRunner()
    qr.query(conn,"show databases")
  }
}
