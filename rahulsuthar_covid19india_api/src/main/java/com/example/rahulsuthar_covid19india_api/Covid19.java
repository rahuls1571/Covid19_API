package com.example.rahulsuthar_covid19india_api;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Covid19 {

    // STATE VARIABLE
    String STATE_NAME;
    String STATE_ACTIVE_CASES;
    String STATE_RECOVERED_CASES;
    String STATE_CONFIRMED;
    String STATE_DEATHS_CASES;

   // COUNTRIES VARIABLE
    String COUNTRIES_FLAG;
    String COUNTRIES_NAME;
    String COUNTRIES_CASES;
    String COUNTRIES_TODAY_CASES;
    String COUNTRIES_DEATHS_CASES;
    String COUNTRIES_TODAY_DEATHS_CASES;
    String COUNTRIES_RECOVERED_CASES;

    // URL COVID
    String URL_COVID19_INDIA  = "https://api.covid19india.org/data.json";
    String URL_CORONA_LMAO    = "https://corona.lmao.ninja/v2/countries/";

    // MODULE
    Countries COUNTRIES; // Covid19 countries module!
    State STATE; // Covid19 state module!

    Context CONTEXT;
    Covid19_Interface COVID_INTERFACE; // Covid Interface!

    //ARRAY LIST
    ArrayList<Countries> COUNTRIES_LIST = new ArrayList<>();
    ArrayList<State>     STATE_LIST     = new ArrayList<>();


    public Covid19(Context CONTEXT, Covid19_Interface COVID_INTERFACE){
        this.CONTEXT = CONTEXT;
        this.COVID_INTERFACE = COVID_INTERFACE;
        STATE_DATA();
        COUNTRIES_DATA();
     }

    public void STATE_DATA(){
        //String url = "https://api.covid19india.org/data.json";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL_COVID19_INDIA, null, response -> {
            try {
                JSONArray jsonArray = (response.getJSONArray("statewise"));
                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    STATE_NAME            = jsonObject.getString("state");
                    STATE_ACTIVE_CASES    = jsonObject.getString("active");
                    STATE_RECOVERED_CASES = jsonObject.getString("recovered");
                    STATE_CONFIRMED       = jsonObject.getString("confirmed");
                    STATE_DEATHS_CASES    = jsonObject.getString("deaths");
                    // STATE MODULE
                    STATE = new  State( STATE_NAME , STATE_ACTIVE_CASES, STATE_RECOVERED_CASES, STATE_CONFIRMED, STATE_DEATHS_CASES);
                    // STATE ARRAY LIST
                    STATE_LIST.add(STATE);
                }
                // COVID INTERFACE
                COVID_INTERFACE.OnStateDataReceived(STATE_LIST);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> COVID_INTERFACE.OnFailed(error.getMessage()));

        RequestQueue requestQueue = Volley.newRequestQueue(CONTEXT);
        requestQueue.add(request);
    }


    public void COUNTRIES_DATA() {
        // using Volley Library
        //String url = "https://corona.lmao.ninja/v2/countries/";
        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                URL_CORONA_LMAO,
                response -> {    // Handle the JSON object and
                    // handle it inside try and catch
                    try {
                        // Creating object of JSONObject
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            JSONObject Object = jsonObject.getJSONObject("countryInfo");
                            COUNTRIES_FLAG               = Object.getString("flag");
                            COUNTRIES_NAME               = jsonObject.getString("country");
                            COUNTRIES_CASES              = jsonObject.getString("cases");;
                            COUNTRIES_TODAY_CASES        = jsonObject.getString("todayCases");
                            COUNTRIES_DEATHS_CASES       = jsonObject.getString("deaths");
                            COUNTRIES_TODAY_DEATHS_CASES = jsonObject.getString("todayDeaths");
                            COUNTRIES_RECOVERED_CASES    = jsonObject.getString("recovered");

                            // COVID 19 COUNTRIES MODULE!
                            COUNTRIES = new Countries(COUNTRIES_FLAG, COUNTRIES_NAME, COUNTRIES_CASES, COUNTRIES_TODAY_CASES, COUNTRIES_DEATHS_CASES, COUNTRIES_TODAY_DEATHS_CASES, COUNTRIES_RECOVERED_CASES);
                            // COUNTRIES ARRAY LIST!
                            COUNTRIES_LIST.add(COUNTRIES);
                        }
                        // COVID INTERFACE!
                        COVID_INTERFACE.OnCountriesDataReceived(COUNTRIES_LIST);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> COVID_INTERFACE.OnFailed(error.getMessage().toString()));
        RequestQueue requestQueue = Volley.newRequestQueue(CONTEXT);
        requestQueue.add(request);
    }


}
