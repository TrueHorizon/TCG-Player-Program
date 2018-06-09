package com.cardparser;

public class MagicCard {

  private String layout;
  private String name;
  private String[] names;
  private String manaCost;
  private int cmc;
  private String[] colors;
  private String type;
  private String[] supertypes;
  private String[] types;
  private String[] subtypes;
  private String text;
  private String power;
  private String toughness;
  private int loyalty;
  private String imageName;
  private boolean starter;
  private int hand;
  private int life;
  private String[] colorIdentity;

  // getters and setters
  private String getLayout() {
    return this.layout;
  }

  private void setLayout(String layout) {
    this.layout = layout;
  }

  public String getName() {
    return this.name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public String[] getNames() {
    return this.names;
  }

  private void setNames(String[] names) {
    this.names = names;
  }

  private String getManaCost() {
    return this.manaCost;
  }

  private void setManaCost(String manaCost) {
    this.manaCost = manaCost;
  }

  private int getCmc() {
    return this.cmc;
  }

  private void setCmc(int cmc) {
    this.cmc = cmc;
  }

  private String[] getColors() {
    return this.colors;
  }

  private void setColors(String[] colors) {
    this.colors = colors;
  }

  private String getType() {
    return this.type;
  }

  private void setType(String type) {
    this.type = type;
  }

  private String[] getSupertypes() {
    return supertypes;
  }

  private void setSupertypes(String[] supertypes) {
    this.supertypes = supertypes;
  }

  private String[] getTypes() {
    return types;
  }

  private void setTypes(String[] types) {
    this.types = types;
  }

  private String[] getSubtypes() {
    return this.subtypes;
  }

  private void setSubtypes(String[] subtypes) {
    this.subtypes = subtypes;
  }

  private String getText() {
    return this.text;
  }

  private void setText(String text) {
    this.text = text;
  }

  private String getPower() {
    return this.power;
  }

  private void setPower(String power) {
    this.power = power;
  }

  private String getToughness() {
    return this.toughness;
  }

  private void setToughness(String toughness) {
    this.toughness = toughness;
  }

  private int getLoyalty() {
    return this.loyalty;
  }

  private void setLoyalty(int loyalty) {
    this.loyalty = loyalty;
  }

  private String getImageName() {
    return this.imageName;
  }

  private void setImageName(String imageName) {
    this.imageName = imageName;
  }

  private boolean getStarter() {
    return this.starter;
  }

  private void setStarter(boolean starter) {
    this.starter = starter;
  }

  private int getHand() {
    return this.hand;
  }

  private void setHand(int hand) {
    this.hand = hand;
  }

  private int getLife() {
    return this.life;
  }

  private void setLife(int life) {
    this.life = life;
  }

  private String[] getColorIdentity() {
    return this.colorIdentity;
  }

  private void setColorIdentity(String[] colorIdentity) {
    this.colorIdentity = colorIdentity;
  }
}
