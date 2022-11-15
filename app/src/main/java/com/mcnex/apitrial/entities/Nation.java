package com.mcnex.apitrial.entities;

public class Nation {
    private int nation_code;
    private String nation_english;
    private String nation_native;

    public Nation() {
    }

    public Nation(int nation_code, String nation_english, String nation_native) {
        this.nation_code = nation_code;
        this.nation_english = nation_english;
        this.nation_native = nation_native;
    }

    public int getNation_code() {
        return nation_code;
    }

    public void setNation_code(int nation_code) {
        this.nation_code = nation_code;
    }

    public String getNation_english() {
        return nation_english;
    }

    public void setNation_english(String nation_english) {
        this.nation_english = nation_english;
    }

    public String getNation_native() {
        return nation_native;
    }

    public void setNation_native(String nation_native) {
        this.nation_native = nation_native;
    }
}
