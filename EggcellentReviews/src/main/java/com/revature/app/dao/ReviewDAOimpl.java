package com.revature.app.dao;

import com.revature.app.models.Review;
import com.revature.app.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOimpl implements ReviewDAO {
    @Override
    public Review createReview(Integer userId, String title, String description) {
        //Should return review  to use in a statement after to confirm.
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO reviews (user_id, title, description) VALUES (?,?,?) RETURNING *";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,userId);
            stmt.setString(2,title);
            stmt.setString(3,description);

            ResultSet rs;

            if((rs = stmt.executeQuery())!=null){
                //need to call rs.next() somehow.
                rs.next();
                int id = rs.getInt("review_id");
                int usId = rs.getInt("user_id");
                String titl = rs.getString("title");
                String descrip = rs.getString("description");
                Review review = new Review(id,usId,titl,descrip);
                return review;
            }
        }   catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Review> getAllReviews() {
        //SELECT * FROM reviews
        //First get a connection to database
        Connection conn = ConnectionUtil.getConnection();
        //create statement
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM reviews";
            ResultSet rs = stat.executeQuery(sql);

            // to store all reviews, create an empty list and store info inside.
            List<Review> reviews = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("review_id");
                int usId = rs.getInt("user_id");
                String title = rs.getString("title");
                String descrip = rs.getString("description");
                Review review = new Review(id,usId,title,descrip);
                reviews.add(review);
            }
            return reviews;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Review> getReviewsByUserId(int id) {
        //using prepared statement
        List<Review> reviews = new ArrayList<>();
        try( Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM reviews WHERE user_id = ?";
            //? goes where info goes
            PreparedStatement stat = conn.prepareStatement(sql);
            //set individual values for ? makes
            stat.setInt(1, id);
            ResultSet rs;
            if((rs = stat.executeQuery()) != null){

                while(rs.next()){
                    int rId = rs.getInt("review_id");
                    int usId = rs.getInt("user_id");
                    String title = rs.getString("title");
                    String descrip = rs.getString("description");
                    Review review = new Review(rId,usId,title,descrip);
                    reviews.add(review);
                }
                return reviews;
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return reviews;
    }

    @Override
    public boolean updateReview(Review review) {
        return false;
    }
}
