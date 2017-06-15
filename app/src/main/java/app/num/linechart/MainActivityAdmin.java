package app.num.linechart;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivityAdmin extends AppCompatActivity {

    public static String json_data = "";
    public static List<Map<String, String>> LIST_DATA = new LinkedList<>();

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

        String url = getDirectionsUrl();

        DownloadTask downloadTask = new DownloadTask();

        // Start downloading json data from Google Directions API
        downloadTask.execute(url);

        ParsingData parsingData = new ParsingData();
        LIST_DATA = parsingData.retrieve();
        if (!LIST_DATA.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data downloaded", Toast.LENGTH_LONG).show();
        }


        btnGoutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityAdmin.this, ConsoWaterActivity.class);
                startActivity(i);
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
                Intent i = new Intent(MainActivityAdmin.this, LedActivity.class);
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
        String url = "http://31.33.137.249:4567/api/data";


        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
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

            json_data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return json_data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            try {
                // Fetching the data from web service
                json_data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return json_data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

        }
    }
}
