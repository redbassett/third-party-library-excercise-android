package io.intrepid.thirdpartylibraryexcercise;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class GetRandomCatUrlTask extends AsyncTask<String, Void, String> {

    private Callback callback;

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = read.readLine()) != null) {
                    builder.append(line);
                }
                read.close();
                connection.disconnect();
                JSONObject object = new JSONObject(builder.toString());
                return object.getString("file");
            }
        } catch (IOException e) {
            Log.e(this.getClass().getSimpleName(), e.toString());
        } catch (JSONException e) {
            Log.e(this.getClass().getSimpleName(), "Unable to parse JSON");
        }
        return null;
    }

    @Override
    protected void onPostExecute(String randomCatUrl) {
        super.onPostExecute(randomCatUrl);

        if (callback != null) {
            callback.onUrlResult(randomCatUrl);
        }
    }

    void setCallback(Callback callback) {
        this.callback = callback;
    }

    interface Callback {
        void onUrlResult(String randomCatUrl);
    }
}
