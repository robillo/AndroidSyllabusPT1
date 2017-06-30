package com.appbusters.robinkamboj.udacitysyllabuspart1.model;

public class Data {

    private String heading;
    private String description;

    public Data(String heading, String description) {
        this.heading = heading;
        this.description = description;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String testFunctionResults(String str1, String str2){

        String temp = str1;
        str1 = str2;
        str2 = temp;

        return str1.concat(str2);
    }
}
