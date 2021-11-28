package edu.xcdq.dao.impl;
import edu.xcdq.bean.User;
import edu.xcdq.dao.BaseDao;
import edu.xcdq.dao.UserDao;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    //增
    public boolean add(User news) {
        boolean flag = false;
        try {
            String sql = "insert into smbms_user(id,userCode, userName, userPassword,gender,birthday,phone,address,userRole,createdBy,creationDate,modifyBy,modifyDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {news.getId(), news.getUserCode(), news.getUserName(), news.getUserPassword(), news.getGender(), news.getBirthday(), news.getPhone(), news.getAddress(), news.getUserRole(), news.getCreatedBy(), news.getCreationDate(), news.getModifyBy(), news.getModifyDate()};
            int i = this.executeUpdate(sql, params);
            // 4 处理执行结果
            if (i > 0) {
                System.out.println("插入成功！");
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        System.out.println(news);
        return flag;
    }
    @Override
    //删
    public boolean delete(User news) {
        boolean flag = false;
        try {
            String sql = "delete from smbms_user where id=?";
            Object[] params ={news.getId()};
            int i = this.executeUpdate(sql,params);
            if (i > 0) {
                System.out.println("删除成功！");
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    @Override
    //改
    public void update(User news) {
        try {
            String sql = "update smbms_user set userName=? where id=?";
            Object[] params = {news.getPhone(), news.getId()};
            int i = this.executeUpdate(sql, params);
            if (i > 0) {
                System.out.println("修改成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
    }
    @Override
    //查
    public List<User> getNewsList() {
        User news = null;
        List<User> list = new ArrayList<User>();
        try {
            // 3 获取Statement对象，执行sql语句
            String sql = "select * from smbms_user";
            Object[] params = {};
            rs = this.executeSQL(sql, params);
            // 4 处理执行结果集ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String userCode = rs.getString("userCode");
                String userName = rs.getString("userName");
                String userPassword= rs.getString("userPassword");
                int gender = rs.getInt("gender");
                Timestamp birthday = rs.getTimestamp("birthday");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int userRole = rs.getInt("userRole");
                int createdBy = rs.getInt("createdBy");
                Timestamp creationDate = rs.getTimestamp("creationDate");
                int modifyBy = rs.getInt("modifyBy");
                Timestamp modifyDate = rs.getTimestamp("modifyDate");

                 news = new User();
                news.setId(id);
                news.setUserCode(userCode);
                news.setUserName(userName);
                news.setUserPassword(userPassword);
                news.setGender(gender);
                news.setBirthday(birthday);
                news.setPhone(phone);
                news.setAddress(address);
                news.setUserRole(userRole);
                news.setCreatedBy(createdBy);
                news.setCreationDate(creationDate);
                news.setModifyBy(modifyBy);
                news.setModifyDate(modifyDate);

                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        System.out.println(list);
        return list;
    }
    @Override
    public User getNewsById(int id) {
        User news = null;
        try {
            String sql = "select * from  smbms_user where id=?";
            Object[] params = {id};
            ResultSet rs = this.executeSQL(sql, params);
            if (rs.next()) {
                int id1 = rs.getInt("id");
                String userCode = rs.getString("userCode");
                String userPassword = rs.getString("userPassword");
                int gender = rs.getInt("gender");
                Timestamp birthday = rs.getTimestamp("birthday");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int userRole = rs.getInt("userRole");
                int createdBy = rs.getInt("createdBy");
                Timestamp creationDate = rs.getTimestamp("creationDate");
                int modifyBy = rs.getInt("modifyBy");
                Timestamp modifyDate = rs.getTimestamp("modifyDate");
                news = new User();
                news.setId(id1);
                news.setUserCode(userCode);
                news.setUserPassword(userPassword);
                news.setGender(gender);
                news.setBirthday(birthday);
                news.setPhone(phone);
                news.setAddress(address);
                news.setUserRole(userRole);
                news.setCreatedBy(createdBy);
                news.setCreationDate(creationDate);
                news.setModifyBy(modifyBy);
                news.setModifyDate(modifyDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        System.out.println(news);
        return news;
    }
    @Test
    public void test(){
        UserDao userDao =  new UserDaoImpl();
        User user = new User();
        user.setId(16);
        userDao.delete(user);
    }
    @Test
    public void test01(){
        User user = new User();
        user.setId(16);
        user.setUserCode("dazhuzi");
        user.setUserName("大柱子");

        UserDao userDao = new UserDaoImpl();
        userDao.add(user);
    }
@Test
    public void test02() {
        UserDao userDao = new UserDaoImpl();
        userDao.getNewsById(1);
    }
    @Test
    public void test03(){
        UserDao userDao = new UserDaoImpl();

        userDao.getNewsList();
    }
}