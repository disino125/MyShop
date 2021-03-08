package cn.disino125.service;

import cn.disino125.dao.BaseDao;
import cn.disino125.entity.Item_Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CatDao {

    public static int insert(Item_Category cate){
        String sql="insert into Item_Category values(null,?,?)";
        Object[] params = {
                cate.getCATE_NAME(),
                cate.getCATE_PARENT_ID()

        };
        return BaseDao.executionIDU(sql,params);
    }

    public static ArrayList<Item_Category> selectAll(){
        ArrayList<Item_Category> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            sql = "SELECT * FROM Item_Category";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Item_Category cat = new Item_Category(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(cat);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static ArrayList<Item_Category> selectCate(String flag){
        ArrayList<Item_Category> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "";
        try {
            conn = BaseDao.getConn();
            if(flag.equals("father")){
                sql = "SELECT * FROM Item_Category where CATE_PARENT_ID=0";
            }else {
                sql = "SELECT * FROM Item_Category where CATE_PARENT_ID!=0";
            }
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Item_Category cat = new Item_Category(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(cat);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return list;
    }

    public static Item_Category selectById(int catId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Item_Category cate = null;
        try {
            conn = BaseDao.getConn();
            String sql = "SELECT * FROM Item_Category WHERE CATE_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,catId);
            rs = ps.executeQuery();
            while (rs.next()){
                cate = new Item_Category(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeConn(rs,ps,conn);
        }
        return cate;
    }

    public static int update(Item_Category cate) {
        String sql="update Item_Category set " +
                "CATE_NAME=?," +
                "CATE_PARENT_ID=? " +
                "where CATE_ID=?";
        Object[] params = {
                cate.getCATE_NAME(),
                cate.getCATE_PARENT_ID(),
                cate.getCATE_ID()
        };
        return BaseDao.executionIDU(sql,params);
    }

    public static int deleteAllByParentId(int parentId){
        String sql = "delete FROM Item_Category WHERE CATE_PARENT_ID=?";
        Object[] param = {parentId};
        return BaseDao.executionIDU(sql,param);
    }

    public static int deleteById(int Id){
        String sql = "delete FROM Item_Category WHERE CATE_ID=?";
        Object[] param = {Id};
        return BaseDao.executionIDU(sql,param);
    }
}
