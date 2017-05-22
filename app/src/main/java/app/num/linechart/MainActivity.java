package app.num.linechart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoutte,btnRobinet,btnAlerte,btnChasse,btnLed,btnReglage;

        btnGoutte = (Button)findViewById(R.id.btnGoutte);
        btnRobinet = (Button)findViewById(R.id.btnRobinet);
        btnAlerte = (Button)findViewById(R.id.btnAlerte);
        btnChasse = (Button)findViewById(R.id.btnChasse);
        btnLed = (Button)findViewById(R.id.btnLed);
        btnReglage = (Button)findViewById(R.id.btnReglage);


        btnGoutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ConsoWaterActivity.class);
                startActivity(i);
            }
        });

        btnRobinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TapActivity.class);
                startActivity(i);
            }
        });

        btnAlerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WarningActivity.class);
                startActivity(i);
            }
        });

        btnChasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FlushActivity.class);
                startActivity(i);
            }
        });

        btnLed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LedActivity.class);
                startActivity(i);
            }
        });

        btnReglage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });


    }
}
