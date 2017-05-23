package app.num.linechart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnGoutte,btnRobinet,btnAlerte,btnChasse,btnLed,btnReglage;

        btnGoutte = (ImageButton)findViewById(R.id.btnGoutte);
        btnRobinet = (ImageButton)findViewById(R.id.btnRobinet);
        btnAlerte = (ImageButton)findViewById(R.id.btnAlerte);
        btnChasse = (ImageButton)findViewById(R.id.btnChasse);
        btnLed = (ImageButton)findViewById(R.id.btnLed);
        btnReglage = (ImageButton)findViewById(R.id.btnReglage);


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
                Intent i = new Intent(MainActivity.this, SampleActivity2.class);
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
