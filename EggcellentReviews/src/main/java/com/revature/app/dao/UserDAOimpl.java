package com.revature.app.dao;

import com.revature.app.models.User;
import com.revature.app.util.ConnectionUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDAOimpl implements UserDAO {
    @Override
    public User getByUsername(String username) {


        try( Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE username = ?";
            //? goes where info goes
            PreparedStatement stat = conn.prepareStatement(sql);
            //set individual values for ? makes
            stat.setString(1, username);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                int usId = rs.getInt("user_id");
                String frst = rs.getString("first");
                String lst = rs.getString("last");
                String usrname = rs.getString("username");
                String passwrd = rs.getString("password");
                Boolean managr = rs.getBoolean("manager");
                User user = new User(usId,frst,lst,usrname,passwrd,managr);

//                System.out.println(user.toString());

                return user;
            }

        } catch(SQLException e){
            e.printStackTrace();
        }



        return null;
    }

    @Override
    public User createUser(String first, String last, String username, String password, Boolean manager) {


        try( Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE username = ?";
            //? goes where info goes
            PreparedStatement stat = conn.prepareStatement(sql);
            //set individual values for ? makes
            stat.setString(1, username);
            ResultSet rs = stat.executeQuery();
            if(!rs.next()){
                String sql2 = "INSERT INTO users (\"first\", \"last\", username, \"password\", manager)" +
                        "VALUES (?,?,?,?,?)";
                PreparedStatement stat2 = conn.prepareStatement(sql2);
                stat2.setString(1,first);
                stat2.setString(2,last);
                stat2.setString(3,username);
                stat2.setString(4,password);
                stat2.setBoolean(5,manager);
                int rs2 = stat2.executeUpdate();
                System.out.println(rs2);
                if(rs2 == 1){
                    String sql3 = "SELECT * FROM users WHERE username = ?";
                    PreparedStatement stat3 = conn.prepareStatement(sql3);
                    stat3.setString(1, username);
                    ResultSet rs3 = stat3.executeQuery();
                    rs3.next();

                    int usId = rs3.getInt("user_id");
                    String frst = rs3.getString("first");
                    String lst = rs3.getString("last");
                    String usrname = rs3.getString("username");
                    String passwrd = rs3.getString("password");
                    Boolean managr = rs3.getBoolean("manager");
                    User user = new User(usId,frst,lst,usrname,passwrd,managr);

                    return user;

                }




            }

        } catch(SQLException e){
            e.printStackTrace();
        }


        return null;
    }
}
