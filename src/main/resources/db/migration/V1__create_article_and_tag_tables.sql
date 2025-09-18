CREATE TABLE article (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT
);

CREATE TABLE tag (
    article_id BIGINT NOT NULL,
    tag VARCHAR(100) NOT NULL,
    PRIMARY KEY (article_id, tag)
    FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE
);