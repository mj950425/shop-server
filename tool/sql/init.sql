-- 카테고리
insert into categories (code, created_at, updated_at, deleted_at)
values ('상의', now(), now(), null);

insert into categories (code, created_at, updated_at, deleted_at)
values ('아우터', now(), now(), null);

insert into categories (code, created_at, updated_at, deleted_at)
values ('바지', now(), now(), null);

insert into categories (code, created_at, updated_at, deleted_at)
values ('스니커즈', now(), now(), null);

insert into categories (code, created_at, updated_at, deleted_at)
values ('가방', now(), now(), null);

insert into categories (code, created_at, updated_at, deleted_at)
values ('모자', now(), now(), null);

insert into categories (code, created_at, updated_at, deleted_at)
values ('양말', now(), now(), null);

insert into categories (code, created_at, updated_at, deleted_at)
values ('액세서리', now(), now(), null);

-- 파트너
insert into partners (brand_name, created_at, updated_at, deleted_at)
values ('A', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values ('B', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values ('C', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values ('D', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values ('E', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values ('F', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values ('G', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values (8, 'H', now(), now(), null);

insert into partners (brand_name, created_at, updated_at, deleted_at)
values (1, 'I', now(), now(), null);

-- 상품
-- 상의
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (11200, '상의', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (10500, '상의', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (10000, '상의', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (10100, '상의', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (10700, '상의', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (11200, '상의', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (10500, '상의', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (10800, '상의', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (11400, '상의', 'I', NOW(), NOW(), NULL);

-- 아우터
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (5500, '아우터', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (5900, '아우터', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (6200, '아우터', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (5100, '아우터', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (5000, '아우터', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (7200, '아우터', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (5800, '아우터', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (6300, '아우터', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (6700, '아우터', 'I', NOW(), NOW(), NULL);

-- 바지
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (4200, '바지', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (3800, '바지', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (3300, '바지', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (3000, '바지', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (3800, '바지', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (4000, '바지', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (3900, '바지', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (3100, '바지', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (3200, '바지', 'I', NOW(), NOW(), NULL);

-- 스니커즈
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9000, '스니커즈', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9100, '스니커즈', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9200, '스니커즈', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9500, '스니커즈', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9900, '스니커즈', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9300, '스니커즈', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9200, '스니커즈', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9700, '스니커즈', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (9500, '스니커즈', 'I', NOW(), NOW(), NULL);

-- 가방
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2000, '가방', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2100, '가방', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2200, '가방', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2500, '가방', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2300, '가방', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2100, '가방', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2200, '가방', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2100, '가방', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2400, '가방', 'I', NOW(), NOW(), NULL);

-- 모자
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1700, '모자', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2000, '모자', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1900, '모자', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1500, '모자', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1800, '모자', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1600, '모자', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1700, '모자', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1600, '모자', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1700, '모자', 'I', NOW(), NOW(), NULL);

-- 양말
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1800, '양말', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2000, '양말', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2200, '양말', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2400, '양말', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2100, '양말', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2300, '양말', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2000, '양말', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2000, '양말', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1700, '양말', 'I', NOW(), NOW(), NULL);

-- 액세서리
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2300, '액세서리', 'A', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2200, '액세서리', 'B', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2100, '액세서리', 'C', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2000, '액세서리', 'D', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2100, '액세서리', 'E', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (1900, '액세서리', 'F', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2100, '액세서리', 'G', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2000, '액세서리', 'H', NOW(), NOW(), NULL);
INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (2400, '액세서리', 'I', NOW(), NOW(), NULL);
