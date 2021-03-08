package cn.disino125.service;

import cn.disino125.dao.BaseDao;
import cn.disino125.entity.Shop_Cart;
import cn.disino125.entity.Shop_Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDao {

    public static int insert(Shop_Cart cart){
        String sql="insert into Shop_Cart values(null,?,?,?,?,?,?,?,1)";
        Object[] params = {
                cart.getCART_P_IMG(),
                cart.getCART_P_NAME(),
                cart.getCART_P_PRICE(),
                cart.getCART_P_QUANTITY(),
                cart.getCART_P_STOCK(),
                cart.getCART_P_ID(),
                cart.getCART_U_ID()
        };
        return BaseDao.executionIDU(sql,params);
    }

    public static ArrayList<Shop_Cart> selectAllCartsByUID(String uid) {
        ArrayList<Shop_Cart> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Cart where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uid);
            rs = ps.executeQuery();
            while (rs.next()){
                Shop_Cart c = new Shop_Cart(
                        rs.getInt("CART_ID"),
                        rs.getString("CART_P_IMG"),
                        rs.getString("CART_P_NAME"),
                        rs.getInt("CART_P_PRICE"),
                        rs.getInt("CART_P_QUANTITY"),
                        rs.getInt("CART_P_STOCK"),
                        rs.getInt("CART_P_ID"),
                        rs.getString("CART_U_ID"),
                        rs.getInt("CART_VALID")
                );
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static Shop_Cart selectCartByUidUndPid(int pid, String uid) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        Shop_Cart c = null;
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Cart where CART_U_ID=? and CART_P_ID=? and CART_VALID=1";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uid);
            ps.setInt(2,pid);
            rs = ps.executeQuery();
            while (rs.next()){
                c = new Shop_Cart(
                        rs.getInt("CART_ID"),
                        rs.getString("CART_P_IMG"),
                        rs.getString("CART_P_NAME"),
                        rs.getInt("CART_P_PRICE"),
                        rs.getInt("CART_P_QUANTITY"),
                        rs.getInt("CART_P_STOCK"),
                        rs.getInt("CART_P_ID"),
                        rs.getString("CART_U_ID"),
                        rs.getInt("CART_VALID")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return c;
    }

    public static int UpdateCartQuantity(int newCount,int cid) {
        String sql = "update Shop_Cart set CART_P_QUANTITY=? where CART_ID=?";
        Object[] params = {newCount,cid};
        return BaseDao.executionIDU(sql,params);
    }

    public static int deleteById(int cid) {
        String sql = "Delete from Shop_Cart where CART_ID=?";
        Object[] params = {cid};
        return BaseDao.executionIDU(sql,params);
    }

    public static Shop_Cart selectById(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        Shop_Cart c = null;
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Cart where CART_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                c = new Shop_Cart(
                        rs.getInt("CART_ID"),
                        rs.getString("CART_P_IMG"),
                        rs.getString("CART_P_NAME"),
                        rs.getInt("CART_P_PRICE"),
                        rs.getInt("CART_P_QUANTITY"),
                        rs.getInt("CART_P_STOCK"),
                        rs.getInt("CART_P_ID"),
                        rs.getString("CART_U_ID"),
                        rs.getInt("CART_VALID")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return c;
    }
}
