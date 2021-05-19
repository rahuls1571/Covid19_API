package com.example.rahulsuthar_covid19india_api;

import java.util.ArrayList;

public interface Covid19_Interface
{
    void OnStateDataReceived(ArrayList<State> states);
    void OnCountriesDataReceived(ArrayList<Countries> countries);
    void OnFailed(String error);
}
