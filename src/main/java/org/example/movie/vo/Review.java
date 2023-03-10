package org.example.movie.vo;

public class Review {
    private Long review_id;
    private String contents;
    private Long movie_id;
    private String member_id;
    private String created_date;

    public Review() {}

    public Review(String contents, Long movie_id, String member_id) {
        this.contents = contents;
        this.movie_id = movie_id;
        this.member_id = member_id;
    }

    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", contents='" + contents + '\'' +
                ", movie_id=" + movie_id +
                ", member_id='" + member_id + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
