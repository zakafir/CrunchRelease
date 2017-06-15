package app.num.linechart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivityUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        ImageButton btnGoutte,btnRobinet,btnChasse,btnLed;

        btnGoutte = (ImageButton)findViewById(R.id.btnGoutteUser);
        btnRobinet = (ImageButton)findViewById(R.id.btnRobinetUser);
        btnChasse = (ImageButton)findViewById(R.id.btnChasseUser);
        btnLed = (ImageButton)findViewById(R.id.btnLedUser);


        btnGoutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityUser.this, ConsoWaterActivity.class);
                startActivity(i);
            }
        });

        btnRobinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityUser.this, TapActivity.class);
                startActivity(i);
            }
        });


        btnChasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityUser.this, FlushActivity.class);
                startActivity(i);
            }
        });

        btnLed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityUser.this, LedActivity.class);
                startActivity(i);
            }
        });


    }
}
