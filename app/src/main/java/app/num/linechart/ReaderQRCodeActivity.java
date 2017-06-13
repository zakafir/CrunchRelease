package app.num.linechart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ReaderQRCodeActivity extends AppCompatActivity {

    ImageButton buttonLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader_qrcode);
        ImageButton scan_btn;

        buttonLaunch = (ImageButton) findViewById(R.id.buttonGoToApp);

        final Activity activity = this;
        scan_btn = (ImageButton) findViewById(R.id.buttonScann);
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(activity);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intentIntegrator.setPrompt("Scan");
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.setBarcodeImageEnabled(false);
                intentIntegrator.initiateScan();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Vous avez quittez le scan", Toast.LENGTH_LONG).show();
            } else {
                String status = result.getContents();
                Toast.makeText(this, "Vous êtes: "+status, Toast.LENGTH_LONG).show();
                buttonLaunch.setVisibility(View.VISIBLE);

                if ("admin".equals(status)) {

                    buttonLaunch.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(ReaderQRCodeActivity.this, MainActivityAdmin.class);
                            startActivity(i);
                        }
                    });

                } else if ("user".equals(status)) {

                    buttonLaunch.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(ReaderQRCodeActivity.this, MainActivityUser.class);
                            startActivity(i);
                        }
                    });
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
