DROP TABLE cart CASCADE CONSTRAINTS;
 CREATE TABLE cart
(
	cseq number(5) NOT NULL,
	quantity number(5) NOT NULL,
	indate date DEFAULT sysdate,
	id varchar2(20) NOT NULL,
	fseq number(5) NOT NULL,
	sideyn1 varchar2(50) ,
	sideyn2 varchar2(50) ,
	sideyn3 varchar2(50) ,
	cprice number(10),
	cfname varchar2(50),
	rseq number(5) not null,
	PRIMARY KEY (cseq)
);

ALTER TABLE cart
	ADD FOREIGN KEY (fseq)
	REFERENCES foodmenu (fseq)
;


ALTER TABLE cart
	ADD FOREIGN KEY (id)
	REFERENCES Member (id)
;

alter table cart
	add foreign key (rseq)
	references restaurant (rseq)
;

-- cart 변경 
select*from cart;






DROP TABLE order_detail CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;

CREATE TABLE orders
(
	oseq number(5) NOT NULL,
	indate date DEFAULT sysdate,
	id varchar2(20) NOT NULL,
	rideryn number(2) DEFAULT 0 NOT NULL,
	plasticyn number(2) DEFAULT 0 NOT NULL,
	payment number(2) DEFAULT 0 NOT NULL,
	result number(2) DEFAULT 0,
	address1 varchar2(100),
	address2 varchar2(100),
	totalprice number(7),
	phone varchar2(20),
	PRIMARY KEY (oseq)
);

CREATE TABLE order_detail
(
	odseq number(7) NOT NULL,
	quantity number(5) NOT NULL,
	oseq number(5) NOT NULL,
	fseq number(5) NOT NULL,
	sideyn1 number(2) DEFAULT 0,
	sideyn2 number(2) DEFAULT 0,
	sideyn3 number(2) DEFAULT 0,
	PRIMARY KEY (odseq)
);

drop sequence orders_seq;
create sequence orders_seq start with 1;

drop sequence order_detail_seq;
create sequence order_detail_seq start with 1;


ALTER TABLE order_detail
	ADD FOREIGN KEY (oseq)
	REFERENCES orders (oseq)
;

create or replace view order_view
as
select a.oseq, a.result, a.indate, a.id, a.rideryn, a.plasticyn, a.payment, a.address1 as oadd1, a.address2 as oadd2, a.phone as ophone, a.totalprice,
      b.odseq, b.quantity, b.fseq, b.sideyn1, b.sideyn2, b.sideyn3,
      c.nick, c.address1 as madd1, c.address2 as madd2, c.phone as mphone,
      d.fname, d.fprice, d.fside1, d.fside2, d.fside3, d.fsideprice1, d.fsideprice2, d.fsideprice3, d.fimage, d.fcontent,
      e.rname, e.rseq, e.rimage, e.rtip, e.ryn,
      f.review_seq, f.id as reviewer, f.indate as review_indate, f.star, f.image as review_image, f.content as review_content, f.reply as review_reply, f.replyyn as review_replyyn
from orders a, order_detail b, member c, foodmenu d, restaurant e, review f
where a.oseq=b.oseq and a.id = c.id and b.fseq=d.fseq and d.rseq=e.rseq and a.oseq=f.oseq;



-- 오더스1 rideyn 0 배달 1 포장 , plasticyn 0 필요 없어요 1 주세요 payment 0 카드 1 현금 result 0 배달중, 1 배달완료	 (기본값0)
insert into orders(oseq,id,rideryn,plasticyn,payment,result,address1,address2,totalprice,phone)
values(orders_seq.nextVal,'abc1234',1,0,1,1,'서울특별시 서대문구','신촌 이젠아카데미 2층 404호', 11000,'010-1234-4321');
insert into order_detail(odseq,oseq,fseq,quantity,sideyn1,sideyn2,sideyn3)
values(order_detail_seq.nextVal,1,242,2,0,0,0);

-- 오더스 2
insert into orders(oseq,id,rideryn,plasticyn,payment,result,address1,address2,totalprice,phone)
values(orders_seq.nextVal,'bsc1234',1,1,1,2,'서울특별시 서대문구','신촌 이젠아카데미 2층 404호', 71000, '010-1234-1234' );
insert into order_detail(odseq,oseq,fseq,quantity,sideyn1,sideyn2,sideyn3)
values(order_detail_seq.nextVal,2,118,1,1,1,0);
insert into order_detail(odseq,oseq,fseq,quantity,sideyn1,sideyn2,sideyn3)
values(order_detail_seq.nextVal,2,119,2,1,0,1);