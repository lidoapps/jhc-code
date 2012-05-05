package cn.jhc.util;

import java.util.*;
import java.sql.*;
import javax.servlet.jsp.jstl.sql.*;

/*
 * 通用的JDBC数据库访问类
 * Y2JavaEE的ch06的工具类
 */
public class SQLCommandBean {
    private Connection conn;
    private String sqlValue;
    private List values;

    /**
     * 设定连接类
     */
    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    /**
     * 设定SQL语句.
     */
    public void setSqlValue(String sqlValue) {
        this.sqlValue = sqlValue;
    }

    /**
     * 设定SQL语句的参数
     */
    public void setValues(List values) {
        this.values = values;
    }

    /**
     * 执行查询
     *
     * @return a javax.servlet.jsp.jstl.sql.Result object
     * @exception SQLException
     */
    public Result executeQuery() throws SQLException {
        Result result = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        try {
            if (values != null && values.size() > 0) {
                // Use a PreparedStatement and set all values
                pstmt = conn.prepareStatement(sqlValue);
                setValues(pstmt, values);
                rs = pstmt.executeQuery();
            }
            else {
                // Use a regular Statement
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlValue);
            }
            result = ResultSupport.toResult(rs);
        }finally {
            if (rs != null) {
                try {rs.close();} catch (SQLException e) {}
            }
            if (stmt != null) {
                try {stmt.close();} catch (SQLException e) {}
            }
            if (pstmt != null) {
                try {pstmt.close();} catch (SQLException e) {}
            }
        }
        return result;
    }

    /**
     * 执行Update语句
     *
     * @return the number of rows affected
     * @exception SQLException
     */
    public int executeUpdate() throws SQLException {
        int noOfRows = 0;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        try {
            if (values != null && values.size() > 0) {
                // Use a PreparedStatement and set all values
                pstmt = conn.prepareStatement(sqlValue);
                setValues(pstmt, values);
                noOfRows = pstmt.executeUpdate();
            }
            else {
                // Use a regular Statement
                stmt = conn.createStatement();
                noOfRows = stmt.executeUpdate(sqlValue);
            }
        }
        finally {
            if (rs != null) {
                try {rs.close();} catch (SQLException e) {}
            }
            if (stmt != null) {
                try {stmt.close();} catch (SQLException e) {}
            }
            if (pstmt != null) {
                try {pstmt.close();} catch (SQLException e) {}
            }
        }
        return noOfRows;
    }

    /**
     * 设定语句的参数.
     *
     * @param pstmt the PreparedStatement
     * @param values a List with objects
     * @exception SQLException
     */
    private void setValues(PreparedStatement pstmt, List values)
        throws SQLException {
        for (int i = 0; i < values.size(); i++) {
            Object v = values.get(i);
            // Set the value using the method corresponding to the type.
            // Note! Set methods are indexed from 1, so we add 1 to i
            pstmt.setObject(i + 1, v);
        }
    }
}
