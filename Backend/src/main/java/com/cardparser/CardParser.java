package com.cardparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import com.cardparser.MagicCard;

public class CardParser {
  private static String url = "https://mtgjson.com/json/AllCards.json";

  public CardParser() {
      getAllCardsJsonFile(url);
  }

  public static void getAllCardsJsonFile(String url) {
    JsonFactory factory = new JsonFactory();
    ObjectMapper mapper = new ObjectMapper(factory);
    ObjectMapper cardMapper = new ObjectMapper();
    MagicCard obj = null;

    try {
      JsonNode rootNode = mapper.readTree(new URL(url));

      Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
      while (fieldsIterator.hasNext()) {
        Map.Entry<String,JsonNode> field = fieldsIterator.next();
        obj = cardMapper.readValue(field.getValue().toString(), MagicCard.class);
        System.out.println(obj.getName());
      }
    } catch (IOException ie) {
      System.out.println(ie.toString());
    }
  }
}
