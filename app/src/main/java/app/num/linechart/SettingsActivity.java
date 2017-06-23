package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static app.num.linechart.MainActivityAdmin.LIST_DATA;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Switch switching = (Switch)findViewById(R.id.remiseAZero);

        switching.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //clearing all data
                LIST_DATA.clear();
                Toast.makeText(getApplicationContext(), "Data deleted", Toast.LENGTH_LONG).show();

            }
        });
    }
}
