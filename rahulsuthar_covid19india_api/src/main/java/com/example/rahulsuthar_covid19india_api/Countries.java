package com.example.rahulsuthar_covid19india_api;

public class Countries {

    private String FLAG;
    private String COUNTRIES_NAME;
    private String CASES;
    private String TODAY_CASES;
    private String DEATHS_CASES;
    private String TODAY_DEATHS_CASES;
    private String RECOVERED_CASES;

    public Countries(){
        this.FLAG               = "";
        this.COUNTRIES_NAME     = "";
        this.CASES              = "";
        this.TODAY_CASES        = "";
        this.DEATHS_CASES       = "";
        this.TODAY_DEATHS_CASES = "";
        this.RECOVERED_CASES    = "";
    }


    public Countries(String FLAG, String COUNTRIES_NAME , String CASES, String TODAY_CASES, String DEATHS_CASES, String TODAY_DEATHS_CASES, String RECOVERED_CASES) {
        this.FLAG               = FLAG;
        this.COUNTRIES_NAME     = COUNTRIES_NAME;
        this.CASES              = CASES;
        this.TODAY_CASES        = TODAY_CASES;
        this.DEATHS_CASES       = DEATHS_CASES;
        this.TODAY_DEATHS_CASES = TODAY_DEATHS_CASES;
        this.RECOVERED_CASES    = RECOVERED_CASES;
    }

    public String getFLAG() {
        return FLAG;
    }

    public String getCOUNTRIES_NAME() {
        return COUNTRIES_NAME;
    }

    public String getCASES() {
        return CASES;
    }

    public String getTODAY_CASES() {
        return TODAY_CASES;
    }

    public String getDEATHS_CASES() {
        return DEATHS_CASES;
    }

    public String getTODAY_DEATHS_CASES() {
        return TODAY_DEATHS_CASES;
    }

    public String getRECOVERED_CASES() {
        return RECOVERED_CASES;
    }

}
