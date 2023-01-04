 create or replace view search
   as
   select a.rseq, a.rname, a.hash, a.rimage, a.kind,
      b.fname, b.fimage
   from restaurant a, foodmenu b
   where a.rseq=b.rseq;
   
   select restaurant from where rname '아빠분식';
   
select rname,rseq,rimage,kind,hash from search where fname like '%피자%' or hash like '%피자%'  or  rname like '%피자%'  group by rname,rseq,rimage,kind,hash;

select rname, rseq, rimage, kind, hash from search  where fname like '%치킨%' group

select*from admin;
select*from review;
select*from order_view;

insert into review(review_seq,id,rseq,star,content,oseq)
values(review_seq_seq.nextVal,'bsc1234',23,3,'그냥 저냥 먹을만 합니다',2);

insert into review(review_seq,id,rseq,star,content,oseq)
values(review_seq_seq.nextVal,'abc1234',48,5,'왈왈왈왈!!',1);

