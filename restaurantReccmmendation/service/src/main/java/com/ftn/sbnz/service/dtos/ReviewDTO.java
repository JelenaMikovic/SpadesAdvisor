package com.ftn.sbnz.service.dtos;

public class ReviewDTO {

    private Long restaurantId;
    private String comment;
    private int rating;
    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public ReviewDTO() {
    }
    public ReviewDTO(Long restaurantId, String comment, int rating) {
        this.restaurantId = restaurantId;
        this.comment = comment;
        this.rating = rating;
    }


}
