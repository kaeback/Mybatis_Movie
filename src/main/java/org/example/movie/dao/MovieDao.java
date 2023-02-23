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
            session.commit();
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

    // 전체 영화 목록
    public List<Movie> findAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            movies = mapper.findAllMovies();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    // 영화 정보
    public Movie findMovieById(Long movie_id) {
        Movie movie = null;
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            movie = mapper.findMovieById(movie_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
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
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 리뷰 검색
    public Review findReview(Review searchReview) {
        Review review = null;
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            review = mapper.findReview(searchReview);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return review;
    }

    // 리뷰 수정
    public void updateReview(Review updateReview) {
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.updateReview(updateReview);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 리뷰 삭제
    public void removeReview(Long review_id) {
        try (SqlSession session = factory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.removeReview(review_id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
