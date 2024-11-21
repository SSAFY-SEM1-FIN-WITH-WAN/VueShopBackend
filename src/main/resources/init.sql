-- 기존 데이터베이스 삭제 (있다면)
DROP DATABASE IF EXISTS whats_you_db;

-- 새로운 데이터베이스 생성
CREATE DATABASE whats_you_db;
USE whats_you_db;

-- User 테이블 생성
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) DEFAULT 'normal' NOT NULL,
    account_id VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(100) UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    zodiac_sign VARCHAR(50) DEFAULT 'unknown' NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- Board 테이블 생성
CREATE TABLE Board (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
	user_name VARCHAR(100) NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    view_cnt INT DEFAULT 0 NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

-- Comment 테이블 생성
CREATE TABLE Comment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    board_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (board_id) REFERENCES Board(id) ON DELETE CASCADE
);

-- ClothImage 테이블 생성
CREATE TABLE ClothImage (
    id INT AUTO_INCREMENT PRIMARY KEY,
    file_name VARCHAR(255) NOT NULL,
    file_path TEXT NOT NULL
);

-- ProfileImage 테이블 생성
CREATE TABLE ProfileImage (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    file_path TEXT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

-- BoardImage 테이블 생성
CREATE TABLE BoardImage (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    board_id INT NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    file_path TEXT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (board_id) REFERENCES Board(id) ON DELETE CASCADE
);

-- Zodiac 테이블 생성
CREATE TABLE Zodiac (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    start_date VARCHAR(5) NOT NULL,
    end_date VARCHAR(5) NOT NULL
);

-- Fortune 테이블 생성
CREATE TABLE Fortune (
    id INT AUTO_INCREMENT PRIMARY KEY,
    zodiac_sign VARCHAR(50) NOT NULL,
    content TEXT NOT NULL
);

SELECT * FROM User;
SELECT * FROM Board;
SELECT * FROM Comment;
SELECT * FROM ClothImage;
SELECT * FROM ProfileImage;
SELECT * FROM BoardImage;
SELECT * FROM Zodiac;
SELECT * FROM Fortune;