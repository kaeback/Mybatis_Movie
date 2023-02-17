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

    // 영화 목록 출력
    public List<Movie> findAllMovies() {
        return movieDao.findAllMovies();
    }

    // 리뷰 등록
    public void saveReview(Review review) {
        movieDao.saveReview(review);
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
