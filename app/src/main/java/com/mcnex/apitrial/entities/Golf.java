package com.mcnex.apitrial.entities;

public class Golf {
  private int golf_code;
  private String golf_english;
  private String golf_native;
  private int update_time;

  public Golf() {
  }

  public Golf(int golf_code, String golf_english, String golf_native, int update_time) {
    this.golf_code = golf_code;
    this.golf_english = golf_english;
    this.golf_native = golf_native;
    this.update_time = update_time;
  }

  public int getGolf_code() {
    return golf_code;
  }

  public void setGolf_code(int golf_code) {
    this.golf_code = golf_code;
  }

  public String getGolf_english() {
    return golf_english;
  }

  public void setGolf_english(String golf_english) {
    this.golf_english = golf_english;
  }

  public String getGolf_native() {
    return golf_native;
  }

  public void setGolf_native(String golf_native) {
    this.golf_native = golf_native;
  }

  public int getUpdate_time() {
    return update_time;
  }

  public void setUpdate_time(int update_time) {
    this.update_time = update_time;
  }
}
