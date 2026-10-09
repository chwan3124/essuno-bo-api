-- 1뎁스 카테고리
INSERT INTO category (name, type, parent_id)
VALUES
    ('상의', 'TOP', NULL),
    ('하의', 'BOTTOM', NULL),
    ('아우터', 'OUTER', NULL),
    ('원피스', 'DRESS', NULL),
    ('신발', 'SHOES', NULL),
    ('액세서리', 'ACCESSORY', NULL);

-- 2뎁스 카테고리
-- 상의
INSERT INTO category (name, type, parent_id)
SELECT '반팔 티셔츠', 'SHORT_SLEEVE', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '긴팔 티셔츠', 'LONG_SLEEVE', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '맨투맨', 'SWEATSHIRT', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '후드티', 'HOODIE', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '셔츠', 'SHIRT', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '니트', 'KNITWEAR', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '가디건', 'CARDIGAN', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '조끼', 'VEST', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '민소매', 'SLEEVELESS', id FROM category WHERE name = '상의';

INSERT INTO category (name, type, parent_id)
SELECT '블라우스', 'BLOUSE', id FROM category WHERE name = '상의';

-- 하의
INSERT INTO category (name, type, parent_id)
SELECT '데님 팬츠', 'DENIM', id FROM category WHERE name = '하의';

INSERT INTO category (name, type, parent_id)
SELECT '슬랙스', 'SLACKS', id FROM category WHERE name = '하의';

INSERT INTO category (name, type, parent_id)
SELECT '트레이닝 팬츠', 'TRAINING_PANTS', id FROM category WHERE name = '하의';

INSERT INTO category (name, type, parent_id)
SELECT '반바지', 'SHORTS', id FROM category WHERE name = '하의';

INSERT INTO category (name, type, parent_id)
SELECT '스커트', 'SKIRT', id FROM category WHERE name = '하의';

-- 아우터
INSERT INTO category (name, type, parent_id)
SELECT '코트', 'COAT', id FROM category WHERE name = '아우터';

INSERT INTO category (name, type, parent_id)
SELECT '패딩', 'PADDING', id FROM category WHERE name = '아우터';

INSERT INTO category (name, type, parent_id)
SELECT '재킷', 'JACKET', id FROM category WHERE name = '아우터';

INSERT INTO category (name, type, parent_id)
SELECT '블레이저', 'BLAZER', id FROM category WHERE name = '아우터';

INSERT INTO category (name, type, parent_id)
SELECT '바람막이', 'WINDBREAKER', id FROM category WHERE name = '아우터';

-- 원피스
INSERT INTO category (name, type, parent_id)
SELECT '미니 원피스', 'MINI_DRESS', id
FROM category WHERE name = '원피스';

INSERT INTO category (name, type, parent_id)
SELECT '미디 원피스', 'MIDI_DRESS', id
FROM category WHERE name = '원피스';

INSERT INTO category (name, type, parent_id)
SELECT '맥시 원피스', 'MAXI_DRESS', id
FROM category WHERE name = '원피스';

-- 신발
INSERT INTO category (name, type, parent_id)
SELECT '스니커즈', 'SNEAKERS', id
FROM category WHERE name = '신발';

INSERT INTO category (name, type, parent_id)
SELECT '로퍼', 'LOAFERS', id
FROM category WHERE name = '신발';

INSERT INTO category (name, type, parent_id)
SELECT '구두', 'DRESS_SHOES', id
FROM category WHERE name = '신발';

INSERT INTO category (name, type, parent_id)
SELECT '샌들', 'SANDALS', id
FROM category WHERE name = '신발';

INSERT INTO category (name, type, parent_id)
SELECT '부츠', 'BOOTS', id
FROM category WHERE name = '신발';

-- 액세서리
INSERT INTO category (name, type, parent_id)
SELECT '모자', 'HAT', id
FROM category WHERE name = '액세서리';

INSERT INTO category (name, type, parent_id)
SELECT '가방', 'BAG', id
FROM category WHERE name = '액세서리';

INSERT INTO category (name, type, parent_id)
SELECT '벨트', 'BELT', id
FROM category WHERE name = '액세서리';

INSERT INTO category (name, type, parent_id)
SELECT '양말', 'SOCKS', id
FROM category WHERE name = '액세서리';

INSERT INTO category (name, type, parent_id)
SELECT '주얼리', 'JEWELRY', id
FROM category WHERE name = '액세서리';

INSERT INTO category (name, type, parent_id)
SELECT '머플러', 'MUFFLER', id
FROM category WHERE name = '액세서리';