package org.example.movie.vo;

public class Review {
    private Long review_id;
    private String contents;
    private int score;
    private String member_id;
    private String created_date;

    public Review(String contents, int score, String member_id) {
        this.contents = contents;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
                ", score=" + score +
                ", member_id='" + member_id + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
