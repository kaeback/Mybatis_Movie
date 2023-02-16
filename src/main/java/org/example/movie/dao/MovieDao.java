package org.example.movie.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.movie.config.MybatisConfig;
import org.example.movie.vo.*;

import java.util.*;

public class MovieDao {
    private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

    // 회원가입
    public void joinMember(Member member) {
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.joinMember(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원정보 검색(로그인)
    public Member findMemberById(String member_id) {
        Member findMember = null;
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            findMember = mapper.findMemberById(member_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findMember;
    }

    // 전체 영화 평점
    public Map<Long, Double> findAllMovieReviewScore() {
        Map<Long, Double> scores = new HashMap<>();
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            scores = mapper.findAllMovieReviewScore();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scores;
    }

    // 개별 영화 평점
    public double findMovieReviewScore(Long movie_id) {
        double score = 0.0;
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            score = mapper.findMovieReviewScore(movie_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return score;
    }

    // 영화별 리뷰 전체 목록
    public List<Review> findAllReviews(Long movie_id) {
        List<Review> reviews = null;
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            reviews = mapper.findAllReviews(movie_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    // 리뷰 등록
    public void saveReview(Review review) {
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.saveReview(review);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 리뷰 수정
    public void updateReview(Review updateReview) {
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.updateReview(updateReview);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 리뷰 삭제
    public void removeReview(Long review_id) {
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.removeReview(review_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
