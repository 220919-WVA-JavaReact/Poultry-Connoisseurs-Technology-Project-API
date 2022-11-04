package com.revature.controllers;

import com.revature.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    private ReviewService rs;

    @Autowired
    public ReviewController(ReviewService rs){
        System.out.println("ReviewController was instantiated");
        this.rs = rs;
    }
}
