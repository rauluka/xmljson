package com.rauluka.xmljson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;
import java.util.List;

@JacksonXmlRootElement(localName = "article")
public class Article {

  @JsonProperty
  private String title;

  @JsonProperty
  private Date publicationDate;

  @JsonProperty
  @JacksonXmlElementWrapper(localName = "authors")
  @JacksonXmlProperty(localName = "author")
  private List<Author> authors;

  @JsonProperty
  @JsonSerialize(using = CustomSerializer.class)
  private String content;

  @JsonDeserialize(using = CustomDeserializer.class)
  private String metadata;


  @Override
  public String toString() {
    return "com.rauluka.xmljson.Article{" +
        "title='" + title + '\'' +
        ", publicationDate=" + publicationDate +
        ", authors=" + authors +
        ", content='" + content + '\'' +
        ", metadata='" + metadata + '\'' +
        '}';
  }

  public static final class ArticleBuilder {
    private String title;
    private Date publicationDate;
    private List<Author> authors;
    private String content;
    private String metadata;

    private ArticleBuilder() {
    }

    public static ArticleBuilder anArticle() {
      return new ArticleBuilder();
    }

    public ArticleBuilder withTitle(String title) {
      this.title = title;
      return this;
    }

    public ArticleBuilder withPublicationDate(Date publicationDate) {
      this.publicationDate = publicationDate;
      return this;
    }

    public ArticleBuilder withAuthors(List<Author> authors) {
      this.authors = authors;
      return this;
    }

    public ArticleBuilder withContent(String content) {
      this.content = content;
      return this;
    }

    public ArticleBuilder withMetadata(String metadata) {
      this.metadata = metadata;
      return this;
    }

    public Article build() {
      Article article = new Article();
      article.content = this.content;
      article.metadata = this.metadata;
      article.title = this.title;
      article.authors = this.authors;
      article.publicationDate = this.publicationDate;
      return article;
    }
  }
}
