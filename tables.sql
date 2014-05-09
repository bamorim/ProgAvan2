CREATE TABLE articles (
  id SERIAL PRIMARY KEY,
  titulo varchar(100),
  autor varchar(100),
  veiculo varchar(100),
  filename varchar(100),
  data date
);

CREATE TABLE keywords (
  id SERIAL PRIMARY KEY,
  keyword varchar(50) UNIQUE
);

CREATE TABLE article_keywords (
  article_id integer references articles(id),
  keyword_id integer references keywords(id),
  PRIMARY KEY(article_id, keyword_id)
);
