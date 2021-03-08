package cn.disino125.dao;

import cn.disino125.entity.SHOP_USER;

import java.sql.*;
import java.util.ArrayList;

public class BaseDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<SHOP_USER> selectAll(int cp, int rows,String keyword){
        ArrayList<SHOP_USER> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            if(keyword!=null){
                sql = "select * from SHOP_USER where USER_NAME like ? limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
                ps.setInt(2,(cp-1)*rows);
                ps.setInt(3,rows);
            }else {
                sql = "select * from SHOP_USER limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,(cp-1)*rows);
                ps.setInt(2,rows);
            }

            rs = ps.executeQuery();
            while (rs.next()){
               SHOP_USER user = new SHOP_USER(
                       rs.getString("USER_ID"),
                       rs.getString("USER_NAME"),
                       rs.getString("USER_PASSWORD"),
                       rs.getString("USER_GENDER"),
                       rs.getString("USER_BIRTHDAY"),
                       rs.getString("USER_IDENTITY_CODE"),
                       rs.getString("USER_EMAIL"),
                       rs.getString("USER_MOBIL"),
                       rs.getString("USER_ADDRESS"),
                       rs.getInt("USER_STATUS")
               );
               list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static int executionIDU(String sql, Object[] params){
        int count = 0;
        Connection conn = BaseDao.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i<params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(null,ps,conn);
        }
        return count;
    }
    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyShop?useSSL=false&serverTimezone=UTC",
                    "root","root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void closeConn(ResultSet rs,PreparedStatement ps,Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
