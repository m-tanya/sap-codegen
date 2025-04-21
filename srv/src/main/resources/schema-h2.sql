
DROP VIEW IF EXISTS localized_CatalogService_Books;
DROP VIEW IF EXISTS localized_my_bookshop_Books;
DROP VIEW IF EXISTS CatalogService_Books_texts;
DROP VIEW IF EXISTS CatalogService_Books;
DROP TABLE IF EXISTS my_bookshop_Books_texts;
DROP TABLE IF EXISTS my_bookshop_Books;

CREATE TABLE my_bookshop_Books (
  ID INTEGER NOT NULL,
  title NVARCHAR(255),
  stock INTEGER,
  PRIMARY KEY(ID)
);


CREATE TABLE my_bookshop_Books_texts (
  locale NVARCHAR(14) NOT NULL,
  ID INTEGER NOT NULL,
  title NVARCHAR(255),
  PRIMARY KEY(locale, ID)
);


CREATE VIEW CatalogService_Books AS SELECT
  Books_0.ID,
  Books_0.title,
  Books_0.stock
FROM my_bookshop_Books AS Books_0;


CREATE VIEW CatalogService_Books_texts AS SELECT
  texts_0.locale,
  texts_0.ID,
  texts_0.title
FROM my_bookshop_Books_texts AS texts_0;


CREATE VIEW localized_my_bookshop_Books AS SELECT
  L_0.ID,
  coalesce(localized_1.title, L_0.title) AS title,
  L_0.stock
FROM (my_bookshop_Books AS L_0 LEFT JOIN my_bookshop_Books_texts AS localized_1 ON localized_1.ID = L_0.ID AND localized_1.locale = @locale);


CREATE VIEW localized_CatalogService_Books AS SELECT
  Books_0.ID,
  Books_0.title,
  Books_0.stock
FROM localized_my_bookshop_Books AS Books_0;

