-- day8 todo sample insert --
-- INSERT INTO todo (title, content, done, created_date, updated_date)
-- VALUES ("자바공부하기", "chapter4 마스터", false, NOW(), NOW()),
--        ("스프링 부트 실습", "REST API CRUD 구현하기", false, NOW(), NOW()),
--        ("알고리즘 풀기", "백준 실버 2문제 풀기", true, NOW(), NOW()),
--        ("운동하기", "헬스장 1시간 유산소+근력", false, NOW(), NOW()),
--        ("노션 일지 작성", "오늘 배운 JPA 내용 정리", true, NOW(), NOW()),
--        ("팀 회의 준비", "NOOS 프로젝트 진행상황 정리", false, NOW(), NOW()),
--        ("MySQL 복습", "JOIN, 서브쿼리 개념 다시 보기", false, NOW(), NOW()),
--        ("깃허브 커밋", "오늘 실습 코드 정리해서 push", true, NOW(), NOW()),
--        ("포트폴리오 업데이트", "Tap Card 프로젝트 설명 추가", false, NOW(), NOW()),
--        ("책 읽기", "클린코드 2장 읽고 요약", false, NOW(), NOW());

INSERT INTO article (title, content, created_at, updated_at) values ('제목 1', '내용 1', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) values ('제목 2', '내용 2', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) values ('제목 3', '내용 3', NOW(), NOW());
