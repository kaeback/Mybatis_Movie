package org.example.movie.ui;

import org.example.movie.exception.DuplicateMemberIdException;
import org.example.movie.exception.LoginFaildException;
import org.example.movie.manager.MovieManager;
import org.example.movie.vo.Member;
import org.example.movie.vo.Movie;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieUI {
    private MovieManager manager = new MovieManager();
    private Scanner scanner = new Scanner(System.in);
    private Member loginMember;

    public MovieUI() {
        // 로그인을 하지 않았으면
        while (true) {
            if (loginMember == null) {
                beforeLoginMenu();
                String input = scanner.nextLine();
                switch (input) {
                    case "1": joinMember(); break;
                    case "2": login(); break;
                    default: System.out.println("다시 선택 해주세요");
                }
            } else {
                mainMenu();
                String input = scanner.nextLine();
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

    public static void main(String[] args) {
        new MovieUI();
    }

}
