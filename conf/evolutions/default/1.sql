# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table benefit (
  id                        bigint auto_increment not null,
  description               varchar(255),
  additional_info           varchar(255),
  type_key                  integer,
  type_value                varchar(255),
  creditcard_id             bigint,
  constraint pk_benefit primary key (id))
;

create table credit_card (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_credit_card primary key (id))
;

create table criteria (
  id                        bigint auto_increment not null,
  minimum                   integer,
  maximum                   integer,
  description               varchar(255),
  additional_info           varchar(255),
  type_key                  integer,
  type_value                varchar(255),
  creditcard_id             bigint,
  constraint pk_criteria primary key (id))
;

create table fee (
  id                        bigint auto_increment not null,
  amount                    decimal(38) not null,
  description               varchar(1000),
  additional_info           varchar(1000),
  type_key                  integer,
  type_value                varchar(255),
  creditcard_id             bigint,
  constraint pk_fee primary key (id))
;

create table generalinfo (
  id                        bigint auto_increment not null,
  description               varchar(255),
  type_value                varchar(255),
  condition                 varchar(255),
  title                     varchar(255),
  creditcard_id             bigint,
  constraint pk_generalinfo primary key (id))
;

create table promotion (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  description               varchar(1000),
  condition                 varchar(1000),
  type_value                varchar(255),
  creditcard_id             bigint,
  constraint pk_promotion primary key (id))
;

create table reward (
  id                        bigint auto_increment not null,
  value                     decimal(38) not null,
  description               varchar(1000),
  type_value                varchar(255),
  additional_info           varchar(1000),
  creditcard_id             bigint,
  constraint pk_reward primary key (id))
;

alter table benefit add constraint fk_benefit_creditcard_1 foreign key (creditcard_id) references credit_card (id) on delete restrict on update restrict;
create index ix_benefit_creditcard_1 on benefit (creditcard_id);
alter table criteria add constraint fk_criteria_creditcard_2 foreign key (creditcard_id) references credit_card (id) on delete restrict on update restrict;
create index ix_criteria_creditcard_2 on criteria (creditcard_id);
alter table fee add constraint fk_fee_creditcard_3 foreign key (creditcard_id) references credit_card (id) on delete restrict on update restrict;
create index ix_fee_creditcard_3 on fee (creditcard_id);
alter table generalinfo add constraint fk_generalinfo_creditcard_4 foreign key (creditcard_id) references credit_card (id) on delete restrict on update restrict;
create index ix_generalinfo_creditcard_4 on generalinfo (creditcard_id);
alter table promotion add constraint fk_promotion_creditcard_5 foreign key (creditcard_id) references credit_card (id) on delete restrict on update restrict;
create index ix_promotion_creditcard_5 on promotion (creditcard_id);
alter table reward add constraint fk_reward_creditcard_6 foreign key (creditcard_id) references credit_card (id) on delete restrict on update restrict;
create index ix_reward_creditcard_6 on reward (creditcard_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table benefit;

drop table credit_card;

drop table criteria;

drop table fee;

drop table generalinfo;

drop table promotion;

drop table reward;

SET FOREIGN_KEY_CHECKS=1;

