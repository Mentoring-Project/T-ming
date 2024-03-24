INSERT INTO tb_study_category (category_type)
values ('수학');
INSERT INTO tb_study_category (category_type)
values ('영어 회화');

INSERT INTO tb_study (study_seq, user_seq, category_seq, title, sub_title, contents, recruit_int, type, hope_area, start_date, end_date, status, create_date, portfolio_yn, creator)
values (1, 1, 1, '수학 스터디', '수학 스터디 모집 합니다.', 'test', 10, 'test', '서울', DATE_FORMAT('2024-01-01 00:00:00', '%Y%m%d'), DATE_FORMAT('2024-09-01 00:00:00', '%Y%m%d'), '모집중', DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%m%d'), 'Y', 'ay');
