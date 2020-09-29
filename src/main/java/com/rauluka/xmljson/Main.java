package com.rauluka.xmljson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Main {
  private static final Logger LOG = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) throws IOException {
    Article article = Article.ArticleBuilder.anArticle()
        .withTitle("The art of parsing.")
        .withPublicationDate(new Date())
        .withAuthors(List.of(new Author("John", "Smith"), new Author("Betty", "Kowalski")))
        .withContent("Interesting story.")
        .build();

    String xmlArticle = ArticleParser.serialize(article, Format.XML);
    String jsonArticle = ArticleParser.serialize(article, Format.JSON);

    LOG.info(xmlArticle);
    LOG.info(jsonArticle);

    String jsonStringArticle = Files.readString(Paths.get("src/main/resources/article.json"));
    Article deserializedJsonArticle = ArticleParser.deserialize(jsonStringArticle, Format.JSON);
    LOG.info(deserializedJsonArticle.toString());

    String xmlStringArticle = Files.readString(Paths.get("src/main/resources/article.xml"));
    Article deserializedXmlArticle = ArticleParser.deserialize(xmlStringArticle, Format.XML);
    LOG.info(deserializedXmlArticle.toString());
  }
}
