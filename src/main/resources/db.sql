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
                        movie_id references movie(movie_id),
                        member_id references member(member_id),
                        created_date date default sysdate
);

drop table review;

insert into movie values (movie_seq.nextval, '앤트맨과 와스프: 퀀텀매니아');
insert into movie values (movie_seq.nextval, '더 퍼스트 슬램덩크');
insert into movie values (movie_seq.nextval, '어메이징 모리스');
insert into movie values (movie_seq.nextval, '두다다쿵: 후후섬의 비밀');
insert into movie values (movie_seq.nextval, '아바타: 물의 길');
insert into movie values (movie_seq.nextval, '영웅');
insert into movie values (movie_seq.nextval, '타이타닉');
insert into movie values (movie_seq.nextval, '상견니');

select * from member;
select * from movie;
select * from review;

insert into review values (movie_seq.nextval, '좋아요', 9, 1, 'hong', sysdate);
insert into review values (movie_seq.nextval, '좋아요', 8, 1, 'hong', sysdate);

select m.movie_id, nvl(avg(r.score), 0) score from movie m left join review r on (m.movie_id = r.movie_id) group by m.movie_id order by m.movie_id;

create sequence movie_seq;