DROP TABLE  IF EXISTS test.user;
create table test.user(
  id bigint primary key auto_increment,
  name varchar(30) COMMENT '姓名',
  age int(3) COMMENT '年龄',
  create_time TIMESTAMP default CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP default current_timestamp on update CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户表';

ALTER TABLE test.user ADD COLUMN username VARCHAR(20) NOT NULL COMMENT '用户名' AFTER id;
ALTER TABLE test.user ADD COLUMN password VARCHAR(100) NOT NULL COMMENT '用户密码' AFTER username;

