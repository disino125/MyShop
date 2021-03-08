package cn.disino125.service;

import cn.disino125.dao.BaseDao;
import cn.disino125.entity.Item_Category;
import cn.disino125.entity.Shop_Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProDao {

    public static int totalCount(){
        int count = 0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT COUNT(*) FROM Shop_Product";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return count;
    }

    public static Shop_Product selectById(int id){
        Shop_Product p = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Product where PRODUCT_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                p = new Shop_Product(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_SID"),
                        rs.getString("PRODUCT_IMG_NAME")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return p;
    }

    public static ArrayList<Shop_Product> selectBySId(int sid){
        ArrayList<Shop_Product> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Product where PRODUCT_SID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sid);
            rs = ps.executeQuery();
            while (rs.next()){
                Shop_Product p = new Shop_Product(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_SID"),
                        rs.getString("PRODUCT_IMG_NAME")
                );
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<Shop_Product> selectAllSameSId(int sid,int id){
        ArrayList<Shop_Product> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Product where PRODUCT_SID=? and PRODUCT_ID!=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sid);
            ps.setInt(2,id);
            rs = ps.executeQuery();
            while (rs.next()){
                Shop_Product p = new Shop_Product(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_SID"),
                        rs.getString("PRODUCT_IMG_NAME")
                );
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<Shop_Product> selectAllRecently(ArrayList<Integer> ids){
        ArrayList<Shop_Product> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Product where PRODUCT_ID=?";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <ids.size() ; i++) {
                ps.setInt(1, ids.get(i));
                rs = ps.executeQuery();
                while (rs.next()){
                    Shop_Product p = new Shop_Product(
                            rs.getInt("PRODUCT_ID"),
                            rs.getString("PRODUCT_NAME"),
                            rs.getString("PRODUCT_DESCRIPTION"),
                            rs.getInt("PRODUCT_PRICE"),
                            rs.getInt("PRODUCT_STOCK"),
                            rs.getInt("PRODUCT_FID"),
                            rs.getInt("PRODUCT_SID"),
                            rs.getString("PRODUCT_IMG_NAME")
                    );
                    list.add(p);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<Shop_Product> selectByFId(int fid){
        ArrayList<Shop_Product> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Shop_Product where PRODUCT_FID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,fid);
            rs = ps.executeQuery();
            while (rs.next()){
                Shop_Product p = new Shop_Product(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_SID"),
                        rs.getString("PRODUCT_IMG_NAME")
                );
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<Shop_Product> selectAll(int cp, int rows, String keyword){
        ArrayList<Shop_Product> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            if(keyword!=null){
                sql = "SELECT * FROM Shop_Product where PRODUCT_NAME like ? limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
                ps.setInt(2,(cp-1)*rows);
                ps.setInt(3,rows);
            }else {
                sql = "SELECT * FROM Shop_Product limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,(cp-1)*rows);
                ps.setInt(2,rows);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                Shop_Product p = new Shop_Product(
                        rs.getInt("PRODUCT_ID"),
                        rs.getString("PRODUCT_NAME"),
                        rs.getString("PRODUCT_DESCRIPTION"),
                        rs.getInt("PRODUCT_PRICE"),
                        rs.getInt("PRODUCT_STOCK"),
                        rs.getInt("PRODUCT_FID"),
                        rs.getInt("PRODUCT_SID"),
                        rs.getString("PRODUCT_IMG_NAME")
                );
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
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
                sql = "select count(*) from Shop_Product where PRODUCT_NAME like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
            }else {
                sql = "select count(*) from Shop_Product";
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

    public static int insert(Shop_Product product){
        String sql="insert into Shop_Product values(null,?,?,?,?,?,?,?)";
        Object[] params = {
                product.getPRODUCT_NAME(),
                product.getPRODUCT_DESCRIPTION(),
                product.getPRODUCT_PRICE(),
                product.getPRODUCT_STOCK(),
                product.getPRODUCT_FID(),
                product.getPRODUCT_SID(),
                product.getPRODUCT_IMG_NAME()
        };
        return BaseDao.executionIDU(sql,params);
    }

    public static int update(Shop_Product product){
        String sql="Update Shop_Product set " +
                "PRODUCT_NAME = ?," +
                "PRODUCT_DESCRIPTION = ?," +
                "PRODUCT_PRICE = ?," +
                "PRODUCT_STOCK = ?," +
                "PRODUCT_FID = ?," +
                "PRODUCT_SID = ?," +
                "PRODUCT_IMG_NAME = ? " +
                "where PRODUCT_ID = ?";
        Object[] params = {
                product.getPRODUCT_NAME(),
                product.getPRODUCT_DESCRIPTION(),
                product.getPRODUCT_PRICE(),
                product.getPRODUCT_STOCK(),
                product.getPRODUCT_FID(),
                product.getPRODUCT_SID(),
                product.getPRODUCT_IMG_NAME(),
                product.getPRODUCT_ID()
        };
        return BaseDao.executionIDU(sql,params);
    }

    public static int deleteById(int pid) {
        String sql = "delete FROM Shop_Product WHERE PRODUCT_ID=?";
        Object[] param = {pid};
        return BaseDao.executionIDU(sql,param);
    }

}
