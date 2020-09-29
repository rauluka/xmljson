package com.rauluka.xmljson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
  @JsonProperty
  private String firstName;

  @JsonProperty
  private String secondName;

  public Author() {
  }

  public Author(String firstName, String secondName) {
    this.firstName = firstName;
    this.secondName = secondName;
  }

  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", secondName='" + secondName + '\'' +
        '}';
  }
}
