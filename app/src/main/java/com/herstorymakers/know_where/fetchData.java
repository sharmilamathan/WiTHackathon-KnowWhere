package com.herstorymakers.know_where;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void>
{
    String data ="";
    String singleParsed = "";
    String dataParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://know-where.eu-gb.mybluemix.net/API/employees");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null)
            {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i =0;i<JA.length();i++)
            {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name: " + JO.get("name") + "\n" +
                                "Information: " + JO.get("information") + "\n" +
                                "Employee id: " + JO.get("eid") + "\n" +
                                "Work location: " + JO.get("workloc") + "\n" +
                                "Locality: " + JO.get("locality") + "\n" +
                                "Contact no: " + JO.get("contactnum") + "\n" ;

                dataParsed = dataParsed + singleParsed + "\n";

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        EmpDetailsActivity.data.setText(this.dataParsed);
    }
}
