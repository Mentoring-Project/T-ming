CREATE DATABASE `tmingDB`;

DROP TABLE IF EXISTS tb_file;
DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_user_auth;
DROP TABLE IF EXISTS tb_study;
DROP TABLE IF EXISTS tb_study_member;
DROP TABLE IF EXISTS tb_study_applicant;
DROP TABLE IF EXISTS tb_study_category;
DROP TABLE IF EXISTS tb_portfolio;
DROP TABLE IF EXISTS tb_chat_list;
DROP TABLE IF EXISTS tb_chat_msg;

CREATE TABLE `tb_file` (
       `file_seq` int(11) NOT NULL AUTO_INCREMENT,
       `file_name` varchar(100) DEFAULT NULL,
       `file_url` varchar(100) DEFAULT NULL,
       `file_path` varchar(100) DEFAULT NULL,
       `create_date` timestamp NULL DEFAULT current_timestamp(),
       PRIMARY KEY (`file_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

CREATE TABLE `tb_user` (
       `user_seq` int(11) NOT NULL AUTO_INCREMENT,
       `name` varchar(50) DEFAULT NULL,
       `id` varchar(50) NOT NULL,
       `password` varchar(50) NOT NULL,
       `email` varchar(100) DEFAULT NULL,
       `gender` varchar(2) DEFAULT NULL,
       `age` int(11) DEFAULT NULL,
       `phone` varchar(50) DEFAULT NULL,
       `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
       `update_date` timestamp NULL DEFAULT NULL,
       PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;





CREATE TABLE `tb_user_auth` (
            `auth_seq`	int(11)	NOT NULL auto_increment,
            `user_seq`	int(11)	NOT NULL,
            `token`	varchar(100) DEFAULT NULL,
            PRIMARY KEY (`auth_seq`)
);

CREATE TABLE `tb_study` (
        `study_seq`	int(11)	NOT NULL auto_increment,
        `user_seq`	int(11)	NOT NULL,
        `category_seq`	int(11)	NOT NULL,
        `title`	varchar(50)	NULL,
        `sub_title`	varchar(200)	NULL,
        `contents`	varchar(200)	NULL,
        `recruit_int` int(11)	NULL,
        `type`	varchar(20)	NULL,
        `hope_area`	varchar(100),
        `start_date`	timestamp,
        `end_date`	timestamp,
        `status`	varchar(10)	NULL,
        `create_date`	timestamp,
        `creator`	varchar(15),
        `update_date`	timestamp,
        `updator`	varchar(15),
        `portfolio_yn`	varchar(2)	NULL,
        PRIMARY KEY (`study_seq`)
);

CREATE TABLE `tb_study_member` (
               `member_seq`	int(11)	NOT NULL auto_increment,
               `study_seq`	int(11)	NOT NULL,
               `user_seq`	int(11)	NOT NULL,
               `category_seq`	int(11)	NOT NULL,
               PRIMARY KEY (`member_seq`)
);

CREATE TABLE `tb_study_applicant` (
                  `apply_seq`	int(11)	NOT NULL auto_increment,
                  `study_seq`	int(11)	NOT NULL,
                  `user_seq`	int(11)	NOT NULL,
                  `status`	varchar(10)	NULL	COMMENT '승인 여부(요청,승인,거절)',
                  `req_date`	timestamp	NOT NULL	DEFAULT current_timestamp()	COMMENT '신청일',
                  `res_date`	timestamp	NULL	COMMENT '승인일',
                  PRIMARY KEY (`apply_seq`)
);

CREATE TABLE `tb_study_category` (
                 `category_seq`	int(11)	NOT NULL auto_increment,
                 `category_type`	varchar(10)	NULL	COMMENT '카테고리 타입',
                 `category_add`	varchar(50)	NULL	DEFAULT null	COMMENT '카테고리 직접추가',
                 PRIMARY KEY (`category_seq`)
);

CREATE TABLE `tb_portfolio` (
            `port_seq`	int(11)	NOT NULL auto_increment,
            `file_seq`	int(11)	NOT NULL,
            `study_seq`	int(11)	NOT NULL,
            `category_seq`	int(11)	NOT NULL,
            `title`	varchar(50)	NULL	COMMENT '제목',
            `sub_title`	varchar(200)	NULL	COMMENT '소개글',
            `status`	enum('Y', 'N')	NULL	COMMENT '상태(공개, 비공개)',
            `create_date`	timestamp	NULL,
            `creator`	varchar(50)	NULL,
            `update_date`	timestamp	NULL,
            `updator`	varchar(50)	NULL,
            PRIMARY KEY (`port_seq`)
);

CREATE TABLE `tb_chat_list` (
            `chat_list_seq`	int(11)	NOT NULL auto_increment,
            `user_seq`	int(11)	NOT NULL,
            `from_id`	varchar(50)	NULL	COMMENT '최초에 보낸 사람',
            `to_id`	varchar(50)	NULL	COMMENT '최초에 받는 사람',
            `subject`	varchar(500)	NULL	COMMENT '마지막에 보낸 메세지 내용',
            `status`	varchar(50)	NULL	COMMENT '누가 마지막에 보냈는지 상태',
            `send_time`	timestamp	NULL	COMMENT '마지막에 보낸 시간',
            PRIMARY KEY (`chat_list_seq`)
);

CREATE TABLE `tb_chat_msg` (
           `chat_msg_seq`	int(11)	NOT NULL auto_increment,
           `chat_list_seq`	int(11)	NOT NULL,
           `user_seq`	int(11)	NOT NULL,
           `from_sender`	varchar(50)	NULL	COMMENT '보낸 사람',
           `contents`	varchar(500)	NULL	COMMENT '메세지 내용',
           `read_status`	varchar(2)	NULL	COMMENT '읽었는지 여부',
           `send_time`	timestamp	NULL	COMMENT '보낸 시간',
           PRIMARY KEY (`chat_msg_seq`)
);

# ALTER TABLE `tb_user` ADD CONSTRAINT `PK_TB_USER` PRIMARY KEY (
#     `user_seq`
# );
#
# ALTER TABLE `tb_user_auth` ADD CONSTRAINT `PK_TB_USER_AUTH` PRIMARY KEY (
#     `auth_seq`,
#     `user_seq`
# );
#
# ALTER TABLE `tb_study` ADD CONSTRAINT `PK_TB_STUDY` PRIMARY KEY (
#     `study_seq`,
#     `user_seq`,
#     `category_seq`
# );
#
# ALTER TABLE `tb_study_member` ADD CONSTRAINT `PK_TB_STUDY_MEMBER` PRIMARY KEY (
#     `member_seq`,
#     `study_seq`,
#     `user_seq`,
#     `category_seq`
# );
#
# ALTER TABLE `tb_study_applicant` ADD CONSTRAINT `PK_TB_STUDY_APPLICANT` PRIMARY KEY (
#     `apply_seq`,
#     `study_seq`,
#     `user_seq`
# );
#
# ALTER TABLE `tb_study_category` ADD CONSTRAINT `PK_TB_STUDY_CATEGORY` PRIMARY KEY (
#     `category_seq`
# );
#
# ALTER TABLE `tb_file` ADD CONSTRAINT `PK_TB_FILE` PRIMARY KEY (
#     `file_seq`
# );
#
# ALTER TABLE `tb_portfolio` ADD CONSTRAINT `PK_TB_PORTFOLIO` PRIMARY KEY (
#     `port_seq`,
#     `file_seq`,
#     `study_seq`,
#     `category_seq`
# );
#
# ALTER TABLE `tb_chat_list` ADD CONSTRAINT `PK_TB_CHAT_LIST` PRIMARY KEY (
#     `chat_list_seq`,
#     `user_seq`
# );
#
# ALTER TABLE `tb_chat_msg` ADD CONSTRAINT `PK_TB_CHAT_MSG` PRIMARY KEY (
#     `chat_msg_seq`,
#     `chat_list_seq`,
#     `user_seq`
# );
#
# ALTER TABLE `tb_user_auth` ADD CONSTRAINT `FK_tb_user_TO_tb_user_auth_1` FOREIGN KEY (
#     `user_seq`
# )
# REFERENCES `tb_user` (
#     `user_seq`
# );
#
# ALTER TABLE `tb_study` ADD CONSTRAINT `FK_tb_user_TO_tb_study_1` FOREIGN KEY (
#     `user_seq`
# )
# REFERENCES `tb_user` (
#     `user_seq`
# );
#
# ALTER TABLE `tb_study` ADD CONSTRAINT `FK_tb_study_category_TO_tb_study_1` FOREIGN KEY (
#     `category_seq`
# )
# REFERENCES `tb_study_category` (
#     `category_seq`
# );
#
# ALTER TABLE `tb_study_member` ADD CONSTRAINT `FK_tb_study_TO_tb_study_member_1` FOREIGN KEY (
#     `study_seq`
# )
# REFERENCES `tb_study` (
#     `study_seq`
# );
#
# ALTER TABLE `tb_study_member` ADD CONSTRAINT `FK_tb_study_TO_tb_study_member_2` FOREIGN KEY (
#     `user_seq`
# )
# REFERENCES `tb_study` (
#     `user_seq`
# );
#
# ALTER TABLE `tb_study_member` ADD CONSTRAINT `FK_tb_study_TO_tb_study_member_3` FOREIGN KEY (
#     `category_seq`
# )
# REFERENCES `tb_study` (
#     `category_seq`
# );
#
# ALTER TABLE `tb_study_applicant` ADD CONSTRAINT `FK_tb_study_TO_tb_study_applicant_1` FOREIGN KEY (
#     `study_seq`
# )
# REFERENCES `tb_study` (
#     `study_seq`
# );
#
# ALTER TABLE `tb_study_applicant` ADD CONSTRAINT `FK_tb_study_TO_tb_study_applicant_2` FOREIGN KEY (
#     `user_seq`
# )
# REFERENCES `tb_study` (
#     `user_seq`
# );
#
# ALTER TABLE `tb_portfolio` ADD CONSTRAINT `FK_tb_file_TO_tb_portfolio_1` FOREIGN KEY (
#     `file_seq`
# )
# REFERENCES `tb_file` (
#     `file_seq`
# );
#
# ALTER TABLE `tb_portfolio` ADD CONSTRAINT `FK_tb_study_TO_tb_portfolio_1` FOREIGN KEY (
#     `study_seq`
# )
# REFERENCES `tb_study` (
#     `study_seq`
# );
#
# ALTER TABLE `tb_portfolio` ADD CONSTRAINT `FK_tb_study_TO_tb_portfolio_2` FOREIGN KEY (
#     `category_seq`
# )
# REFERENCES `tb_study` (
#     `category_seq`
# );
#
# ALTER TABLE `tb_chat_list` ADD CONSTRAINT `FK_tb_user_TO_tb_chat_list_1` FOREIGN KEY (
#     `user_seq`
# )
# REFERENCES `tb_user` (
#     `user_seq`
# );
#
# ALTER TABLE `tb_chat_msg` ADD CONSTRAINT `FK_tb_chat_list_TO_tb_chat_msg_1` FOREIGN KEY (
#     `chat_list_seq`
# )
# REFERENCES `tb_chat_list` (
#     `chat_list_seq`
# );
#
# ALTER TABLE `tb_chat_msg` ADD CONSTRAINT `FK_tb_chat_list_TO_tb_chat_msg_2` FOREIGN KEY (
#     `user_seq`
# )
# REFERENCES `tb_chat_list` (
#     `user_seq`
# );