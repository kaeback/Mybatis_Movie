package org.example.movie.dao;

import org.example.movie.vo.Member;
import org.example.movie.vo.Movie;
import org.example.movie.vo.Review;

import java.util.List;
import java.util.Map;

public interface MovieMapper {
    // 회원가입
    void joinMember(Member member);

    // 회원정보 검색(로그인)
    Member findMemberById(String member_id);

    // 전체 영화 목록
    List<Movie> findAllMovies();

    // 개별 영화 평점
    double findMovieReviewScore(Long movie_id);

    // 영화별 리뷰 전체 목록
    List<Review> findAllReviews(Long movie_id);

    // 리뷰 등록
    void saveReview(Review review);

    // 리뷰 수정
    void updateReview(Review updateReview);

    // 리뷰 삭제
    void removeReview(Long review_id);
}
