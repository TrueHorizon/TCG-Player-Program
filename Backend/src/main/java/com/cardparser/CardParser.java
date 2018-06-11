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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import com.cardparser.MagicCard;

public class CardParser {
  // URL location for the AllCards.json file from MTGJson.
  private static String url = "https://mtgjson.com/json/AllCards.json";

  public CardParser() {
      getAllCardsJsonFile(url);
  }

  /*
  * This method connects to the MTGJson site, downloads
  * AllCards.json, and parses the file with Jackson. It
  * then adds the cards to an ArrayList.
  */
  public static void getAllCardsJsonFile(String url) {
    JsonFactory factory = new JsonFactory();
    ObjectMapper mapper = new ObjectMapper(factory);
    ObjectMapper cardMapper = new ObjectMapper();
    MagicCard currentCard = null;
    List<MagicCard> cardList = new ArrayList<MagicCard>();

    try {
      JsonNode rootNode = mapper.readTree(new URL(url));

      Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
      while (fieldsIterator.hasNext()) {
        Map.Entry<String,JsonNode> field = fieldsIterator.next();
        currentCard = cardMapper.readValue(field.getValue().toString(), MagicCard.class);
        cardList.add(currentCard);
      }
    } catch (IOException ie) {
      System.out.println(ie.toString());
    }

    for (MagicCard card : cardList) {
      System.out.println(card.getName());
    }
  }
}
