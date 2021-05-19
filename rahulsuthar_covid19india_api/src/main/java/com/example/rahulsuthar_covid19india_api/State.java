package com.example.rahulsuthar_covid19india_api;

public class State {

    private String STATE_NAME;
    private String ACTIVE_CASES;
    private String RECOVERED_CASES;
    private String CONFIRMED;
    private String DEATHS_CASES;

    public State() {
        this.STATE_NAME      = "";
        this.ACTIVE_CASES    = "";
        this.RECOVERED_CASES = "";
        this.CONFIRMED       = "";
        this.DEATHS_CASES    = "";
    }

    public State(String STATE_NAME ,String ACTIVE_CASES, String RECOVERED_CASES,  String CONFIRMED ,String DEATHS_CASES ) {

        this.STATE_NAME = STATE_NAME;
        this.ACTIVE_CASES = ACTIVE_CASES;
        this.RECOVERED_CASES = RECOVERED_CASES;
        this.CONFIRMED = CONFIRMED;
        this.DEATHS_CASES = DEATHS_CASES;
    }


    public String getSTATE_NAME() {
        return STATE_NAME;
    }

    public String getDEATHS_CASES() {
        return DEATHS_CASES;
    }

    public String getRECOVERED_CASES() {
        return RECOVERED_CASES;
    }

    public String getACTIVE_CASES() {
        return ACTIVE_CASES;
    }

    public String getCONFIRMED() {
        return CONFIRMED;
    }

}
