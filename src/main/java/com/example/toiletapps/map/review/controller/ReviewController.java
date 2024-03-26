package com.example.toiletapps.map.review.controller;


import com.example.toiletapps.map.review.model.Review;
import com.example.toiletapps.map.review.model.req.ReviewRequest;
import com.example.toiletapps.map.review.model.resp.ReviewResponse;
import com.example.toiletapps.map.review.usecase.ReviewUseCase;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewUseCase reviewUseCase;

    @PostMapping("/addReview")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@RequestBody ReviewRequest request){
        reviewUseCase.addReview(request);
    }

    @GetMapping("/findAllReview")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Review> findAll(){
        return reviewUseCase.findAll();
    }

    @GetMapping("/findByReviewId/{marker_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReviewResponse findById(@PathVariable("marker_id") Integer marker_id){
        return reviewUseCase.findAllReviewByMarkerId(marker_id);
    }
    @DeleteMapping("/deleteReview/{review_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReview(@PathVariable("review_id") Integer review_id){
        reviewUseCase.deleteReview(review_id);
    }
}
