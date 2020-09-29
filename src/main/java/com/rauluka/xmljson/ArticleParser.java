package com.rauluka.xmljson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.text.SimpleDateFormat;

public class ArticleParser {

  private static final ObjectMapper XML_MAPPER = new XmlMapper();
  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

  static {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
    XML_MAPPER.setDateFormat(simpleDateFormat);
    JSON_MAPPER.setDateFormat(simpleDateFormat);
  }

  public static String serialize(Article article, Format format) {
    return format.equals(Format.JSON) ? serialize(article, JSON_MAPPER) : serialize(article, XML_MAPPER);
  }

  private static String serialize(Article article, ObjectMapper objectMapper) {
    try {
      return objectMapper.writeValueAsString(article);
    } catch (IOException e) {
      throw new UncheckedIOException("Oh no!", e);
    }
  }

  public static Article deserialize(String article, Format format) {
    return format.equals(Format.JSON) ? deserialize(article, JSON_MAPPER) : deserialize(article, XML_MAPPER);
  }

  private static Article deserialize(String article, ObjectMapper objectMapper) {
    try {
      return objectMapper.readValue(article, Article.class);
    } catch (JsonProcessingException e) {
      throw new UncheckedIOException("Bad!", e);
    }
  }

}
