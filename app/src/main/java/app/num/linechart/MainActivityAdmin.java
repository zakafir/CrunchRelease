package app.num.linechart;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivityAdmin extends AppCompatActivity {

    public static String JSON_DATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        ImageButton btnGoutte, btnRobinet, btnAlerte, btnChasse, btnLed, btnReglage;

        btnGoutte = (ImageButton) findViewById(R.id.btnGoutte);
        btnRobinet = (ImageButton) findViewById(R.id.btnRobinet);
        btnAlerte = (ImageButton) findViewById(R.id.btnAlerte);
        btnChasse = (ImageButton) findViewById(R.id.btnChasse);
        btnLed = (ImageButton) findViewById(R.id.btnLed);
        btnReglage = (ImageButton) findViewById(R.id.btnReglage);


        btnGoutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, ConsoWaterActivity.class);
                startActivity(i);
                String url = getDirectionsUrl();

                DownloadTask downloadTask = new DownloadTask();

                // Start downloading json data from Google Directions API
                downloadTask.execute(url);
            }
        });

        btnRobinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, TapActivity.class);
                startActivity(i);
            }
        });

        btnAlerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, WarningActivity.class);
                startActivity(i);
            }
        });

        btnChasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, FlushActivity.class);
                startActivity(i);
            }
        });

        btnLed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, SampleActivity2.class);
                startActivity(i);
            }
        });

        btnReglage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, SettingsActivity.class);
                startActivity(i);
            }
        });


    }

    private String getDirectionsUrl() {

        // Building the url to the web service
        String url = "https://jsonplaceholder.typicode.com/posts/1";


        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                JSON_DATA = data;
                Log.d("Here", JSON_DATA);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

        }
    }
}
