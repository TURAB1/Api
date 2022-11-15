package com.mcnex.apitrial.entities;

public class Region {
    private int region_code;
    private String region_english;
    private String region_native;

    public Region() {
    }

    public Region(int region_code, String region_english, String region_native) {
        this.region_code = region_code;
        this.region_english = region_english;
        this.region_native = region_native;
    }

    public int getRegion_code() {
        return region_code;
    }

    public void setRegion_code(int region_code) {
        this.region_code = region_code;
    }

    public String getRegion_english() {
        return region_english;
    }

    public void setRegion_english(String region_english) {
        this.region_english = region_english;
    }

    public String getRegion_native() {
        return region_native;
    }

    public void setRegion_native(String region_native) {
        this.region_native = region_native;
    }
}
