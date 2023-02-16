create table movie (
                       movie_id number primary key,
                       title varchar2(200) not null
);

create table member (
                        member_id varchar2(20) primary key ,
                        password varchar2(30) not null ,
                        name varchar2(50) not null
);

create table review (
                        review_id number primary key ,
                        contents varchar2(2000) ,
                        score number,
                        member_id references member(member_id),
                        created_date date default sysdate
);

create movie_seq;