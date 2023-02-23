package org.example.movie.manager;

import org.example.movie.dao.MovieDao;
import org.example.movie.exception.DuplicateMemberIdException;
import org.example.movie.exception.LoginFaildException;
import org.example.movie.vo.*;

import java.util.List;
import java.util.Map;

public class MovieManager {

    private MovieDao movieDao = new MovieDao();

    // 회원가입
    public void joinMember(Member member) throws DuplicateMemberIdException {
        Member findMember = movieDao.findMemberById(member.getMember_id());
        if (findMember != null) {
            throw new DuplicateMemberIdException("동일한 아이디를 사용중인 회원이 있습니다.");
        }

        movieDao.joinMember(member);
    }

    // 로그인
    public Member login(String member_id, String password) throws LoginFaildException {
        Member findMember = movieDao.findMemberById(member_id);
        if (findMember != null && findMember.getPassword().equals(password)) {
            return findMember;
        }
        throw new LoginFaildException("아이디 또는 패스워드가 틀렸습니다.");
    }

    // 모든 영화 목록
    public List<Movie> findAllMovies() {
        return movieDao.findAllMovies();
    }

    // 영화 정보 검색
    public Movie findMovieById(Long movie_id) {
        return movieDao.findMovieById(movie_id);
    }

    // 영화별 등록된 리뷰 목록 검색
    public List<Review> findAllReviews(Long movie_id) {
        return movieDao.findAllReviews(movie_id);
    }

    // 리뷰 등록
    public void saveReview(Review review) {
        movieDao.saveReview(review);
    }

    // 리뷰 검색
    public Review findReview(Long movie_id, String member_id) {
    	Review searchReview = new Review();
    	searchReview.setMovie_id(movie_id);
    	searchReview.setMember_id(member_id);
        return movieDao.findReview(searchReview);
    }

    // 리뷰 수정
    public void updateReview(Review updateReview) {
        movieDao.updateReview(updateReview);
    }

    // 리뷰 삭제
    public void removeReview(Long review_id) {
        movieDao.removeReview(review_id);
    }

}
