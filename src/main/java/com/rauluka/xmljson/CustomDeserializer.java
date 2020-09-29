package com.rauluka.xmljson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.logging.Logger;

public class CustomDeserializer extends JsonDeserializer<String> {
  private static final Logger LOG = Logger.getLogger(CustomDeserializer.class.getName());

  @Override
  public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    JsonNode jsonNode = ctxt.readTree(p);
    LOG.info(jsonNode.toString());
    return jsonNode.toString();
  }
}
