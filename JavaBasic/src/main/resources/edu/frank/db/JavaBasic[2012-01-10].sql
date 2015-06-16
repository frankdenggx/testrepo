-- ------------------------------------------------------------------------------------------
-- Date: 2011-01-10 
-- Author: Frank Deng <FrankDengGX@gmail.com>
-- Version: 1.0
-- Desc:
-- 			JavaBasic project database script
--
--
-- History:
-- <Modifier>						<Time>										<Content>
-- Frank							2012-01-10 00:00:01							Created
--
-- ------------------------------------------------------------------------------------------
-- 人员表
drop table JB_PERSION
/
create table JB_PERSION(
 P_ID varchar(44) not null,
 P_NAME nvarchar2(100) not null,
 P_PHONE varchar(100),
 P_MOBILE varchar(100),
 P_TEL varchar(100),
 P_ADDR varchar(255)
);
alter table JB_PERSION add constraint pk_person primary key (P_ID)
/
alter table JB_PERSION add constraint un_persion unique (P_NAME)
/
insert into JB_PERSION values ('qwertyuiop+=', 'John', '(020)87447899', '15847896558', '020-87996851', 'Tianhe road')
/
insert into JB_PERSION values ('asdfghjklm+=', 'King', '(020)87447890', '15847896569', '020-87996852', 'Zhujiang road')
/
insert into JB_PERSION values ('zxcvbnmlkh+=', 'Feng', '(020)87447891', '15847896522', '020-87996853', 'Linhedong road')
/
insert into JB_PERSION values ('gfdsajklmn+=', 'Xing', '(020)87447897', '15847896512', '020-87996854', 'Penggeteng road')
/
-- 学院表
drop table JB_COLLEGE
/
create table JB_COLLEGE(
 C_ID varchar(44) not null,
 C_NAME nvarchar2(100) not null,
 C_MANAGER varchar(44) not null,
 C_PHONE varchar(100),
 C_EMAIL varchar(100),
 C_ADDR nvarchar2(255)
);
alter table JB_COLLEGE add constraint pk_college primary key (C_ID)
/
alter table JB_COLLEGE add constraint un_college unique (C_NAME)
/
alter table JB_COLLEGE add constraint fk_college foreign key (C_MANAGER)
 references JB_PERSION (P_ID)
/
drop sequence seq_college
/
create sequence seq_college increment by 1 start with 1 minvalue 1 nocycle cache 20 noorder
/
insert into JB_COLLEGE values ('poiuytrewq+=', 'Computer School', 'qwertyuiop+=', '(0758)8192148', 'kelly@scnu.com', 'Zhongshan road')
/
-- 学生表
drop table JB_STUDENT
/ 
create table JB_STUDENT(
 S_ID varchar(44) not null,
 S_NAME nvarchar2(100) not null,
 S_PERSION varchar(44) not null,
 S_COLLEGE varchar(44) not null,
 S_C_NAME varchar(100) not null,
 S_PHONE varchar(100),
 S_MOBILE varchar(100),
 S_TEL varchar(100),
 S_EMAIL varchar(100),
 S_ADDR varchar(255),
 S_SCORE number(10,2)
);
alter table JB_STUDENT add constraint pk_student primary key (S_ID)
/
alter table JB_STUDENT add constraint un_student unique (S_NAME)
/
alter table JB_STUDENT add constraint fk_student_persion foreign key (S_PERSION)
 references JB_PERSION (P_ID)
/
alter table JB_STUDENT add constraint fk_student_college foreign key (S_COLLEGE)
 references JB_COLLEGE (C_ID)
/
-- create index index_stucent_college on JB_STUDENT (S_PERSION) /
-- create unique index index_student_c_name on JB_STUDENT (S_C_NAME) /
insert into JB_STUDENT values ('wertuyjklh+=', 'King', 'asdfghjklm+=', 'poiuytrewq+=', 'Computer School', '(0745)38714568', '15789651234', '0758-68795412', 'louis@scnu.com', 'Heitong road', 1789.36)
/
commit
/