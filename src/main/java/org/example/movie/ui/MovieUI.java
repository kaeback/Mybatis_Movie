package org.example.movie.ui;

import org.example.movie.exception.DuplicateMemberIdException;
import org.example.movie.exception.LoginFaildException;
import org.example.movie.manager.MovieManager;
import org.example.movie.vo.Member;
import org.example.movie.vo.Movie;
import org.example.movie.vo.Review;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieUI {
    private MovieManager manager = new MovieManager();
    private Scanner scanner = new Scanner(System.in);
    private Member loginMember;

    public MovieUI() {
        while (true) {
        	// 로그인 전이면 회원가입 및 로그인 메뉴를 출력
            if (loginMember == null) {
                beforeLoginMenu();
                String input = scanner.nextLine();
                switch (input) {
                    case "1": joinMember(); break;
                    case "2": login(); break;
                    default: System.out.println("다시 선택 해주세요");
                }
            // 로그인을 했으면 영화 목록을 출력
            } else {
                mainMenu();
                System.out.print("리뷰를 작성하거나 확인할 영화의 No를 선택하세요: ");
                String input = scanner.nextLine();
                reviewMenu(input);
            }

        }
    }

    // 회원가입 및 로그인 메뉴
    public void beforeLoginMenu() {
        System.out.println("==========================");
        System.out.println("영화 리뷰 게시판");
        System.out.println("==========================");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.print("선택> ");
    }

    // 회원가입
    public void joinMember() {
        System.out.println("==========================");
        System.out.println("회원가입");
        System.out.println("==========================");
        System.out.print("아이디: ");
        String member_id = scanner.nextLine();
        System.out.print("패스워드 ");
        String password = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        Member member = new Member(member_id, password, name);
        try {
            manager.joinMember(member);
            System.out.println("회원 가입에 성공했습니다. 로그인 해주세요");
        } catch (DuplicateMemberIdException e) {
            System.out.println(e.getMessage());
        }
    }

    // 로그인
    public void login() {
        System.out.println("==========================");
        System.out.println("로그인");
        System.out.println("==========================");
        System.out.print("아이디: ");
        String member_id = scanner.nextLine();
        System.out.print("패스워드: ");
        String password = scanner.nextLine();
        try {
            loginMember = manager.login(member_id, password);
        } catch (LoginFaildException e) {
            System.out.println(e.getMessage());
        }
    }

    // 메인 메뉴
    public void mainMenu() {
        System.out.println("==========================");
        System.out.println("ABC 영화 리뷰");
        System.out.println("==========================");
        System.out.println("** 현재 상영중인 영화 **");
        System.out.println("No\t제목");
        List<Movie> movies = manager.findAllMovies();
        for (Movie movie : movies) {
            System.out.print(movie.getMovie_id() + "\t");
            System.out.println(movie.getTitle());
        }
    }

    // 리뷰확인
    public void reviewMenu(String no) {
        while (true) {
            Long movie_id = Long.valueOf(no);
            // 영화 제목 가져오기
            Movie movie = manager.findMovieById(movie_id);
            System.out.println("제목: " + movie.getTitle());
            // 내가 작성한 리뷰 가져오기
            Review myReview = manager.findReviewByMemberId(loginMember.getMember_id());
            System.out.println("==========================");
            System.out.print("작성한 리뷰: ");
            if (myReview != null) {
                System.out.println(myReview.getContents() + "\t작성시간: " + myReview.getCreated_date());
                System.out.println("1. 리뷰 수정하기");
                System.out.println("2. 리뷰 삭제하기");
                System.out.println("3. 전체 리뷰 보기");
                System.out.println("4. 이전 메뉴로");
                System.out.print("선택: ");

                String input = scanner.nextLine();
                switch (input) {
                    case "1": updateReview(myReview); break;
                    case "2": manager.removeReview(myReview.getReview_id());
                    case "3": showAllReviews(movie_id); break;
                    case "4": return;
                    default: System.out.println("잘못 선택 했습니다.");
                }
            } else {
                System.out.println("작성한 리뷰가 없습니다.");
                System.out.println("1. 리뷰 작성하기");
                System.out.println("2. 전체 리뷰 보기");
                System.out.println("3. 이전 메뉴로");
                System.out.print("선택: ");

                String input = scanner.nextLine();
                switch (input) {
                    case "1": writeReview(movie_id); break;
                    case "2": showAllReviews(movie_id); break;
                    case "3": return;
                    default: System.out.println("잘못 선택 했습니다.");
                }
            }
        }
    }

    // 리뷰 작성하기
    public void writeReview(Long movie_id) {
        System.out.print("리뷰내용: ");
        String contents = scanner.nextLine();
        Review review = new Review(contents, movie_id, loginMember.getMember_id());
        manager.saveReview(review);
    }

    // 리뷰 수정하기
    public void updateReview(Review myReview) {
        System.out.print("수정할 내용: ");
        String contents = scanner.nextLine();
        myReview.setContents(contents);
        manager.updateReview(myReview);
    }

    // 모든 리뷰 보기
    public void showAllReviews(Long movie_id) {
        List<Review> reviews = manager.findAllReviews(movie_id);
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    public static void main(String[] args) {
        new MovieUI();
    }

}
