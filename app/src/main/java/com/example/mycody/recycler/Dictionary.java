package com.example.mycody.recycler;

public class Dictionary {
    private String topImagePath;
    private String topName;

    public Dictionary(String topImagePath, String topName) {
        this.topImagePath = topImagePath;
        this.topName = topName;
    }

    public String getTopImagePath() {
        return topImagePath;
    }

    public void setTopImagePath(String topImagePath) {
        this.topImagePath = topImagePath;
    }

    public String getTopName() {
        return topName;
    }

    public void setTopName(String topName) {
        this.topName = topName;
    }
}
