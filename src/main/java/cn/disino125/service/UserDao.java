package cn.disino125.service;

import cn.disino125.dao.BaseDao;
import cn.disino125.entity.SHOP_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    public static int selectByIdAndPsw(String id, String password){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = BaseDao.getConn();
            String sql = "SELECT count(*) FROM shop_user u WHERE USER_ID=? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeConn(rs,ps,conn);
        }

        return count;
    }

    public static int deleteById(String id){
        String sql = "delete FROM shop_user WHERE USER_ID=? and USER_STATUS!=2";
        Object[] param = {id};
        return BaseDao.executionIDU(sql,param);
    }

    public static int update(SHOP_USER user){
        String sql="update SHOP_USER set " +
                "USER_NAME=?," +
                "USER_PASSWORD=?," +
                "USER_GENDER=?," +
                "USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d')," +
                "USER_IDENTITY_CODE=?," +
                "USER_EMAIL=?," +
                "USER_MOBIL=?," +
                "USER_ADDRESS=?," +
                "USER_STATUS=? where USER_ID=?";
        Object[] params = {
                user.getUSER_NAME(),
                user.getUSER_PASSWORD(),
                user.getUSER_GENDER(),
                user.getUSER_BIRTHDAY(),
                user.getUSER_IDENTITY_CODE(),
                user.getUSER_EMAIL(),
                user.getUSER_MOBIL(),
                user.getUSER_ADDRESS(),
                user.getUSER_STATUS(),
                user.getUSER_ID()
        };
        return BaseDao.executionIDU(sql,params);
    }

    public static SHOP_USER selectById(String id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SHOP_USER user = null;
        try {
            conn = BaseDao.getConn();
            String sql = "SELECT u.*, DATE_FORMAT(u.`USER_BIRTHDAY`,'%Y-%m-%d') birthday FROM shop_user u WHERE USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                user = new SHOP_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_GENDER"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENTITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBIL"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return user;
    }

    public static int checkById(String id){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = BaseDao.getConn();
            String sql = "SELECT count(*) FROM shop_user u WHERE USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return count;
    }

    public static int[] CountForSelect(int rows,String keyword){
        int arr[] = {0,1};
        String sql = "";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = BaseDao.getConn();
            if(keyword!=null){
                sql = "select count(*) from shop_user where USER_NAME like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
            }else {
                sql = "select count(*) from shop_user";
                ps = conn.prepareStatement(sql);
            }

            rs = ps.executeQuery();
            while (rs.next()){
                arr[0] = rs.getInt(1);
                arr[1] = arr[0]%rows==0?arr[0]/rows:arr[0]/rows+1;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return arr;
    }
    public static int insert(SHOP_USER user){
        String sql="insert into shop_user values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
        Object[] params = {
                user.getUSER_ID(),
                user.getUSER_NAME(),
                user.getUSER_PASSWORD(),
                user.getUSER_GENDER(),
                user.getUSER_BIRTHDAY(),
                user.getUSER_IDENTITY_CODE(),
                user.getUSER_EMAIL(),
                user.getUSER_MOBIL(),
                user.getUSER_ADDRESS(),
                user.getUSER_STATUS()
        };
        return BaseDao.executionIDU(sql,params);
    }

    public static ArrayList<SHOP_USER> selectAll(int cp, int rows, String keyword){
        return BaseDao.selectAll(cp,rows,keyword);

    }
}
