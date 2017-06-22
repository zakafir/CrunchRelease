package app.num.linechart;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class FlushActivity extends AppCompatActivity {

    ArrayList<String> labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flush);


        LineChart lineChartChasse = (LineChart) findViewById(R.id.chartFlush);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(0f, 1));
        entries.add(new Entry(4f, 2));
        entries.add(new Entry(0f, 3));
        entries.add(new Entry(4f, 4));
        entries.add(new Entry(8f, 5));
        entries.add(new Entry(0f, 6));
        entries.add(new Entry(4f, 7));
        entries.add(new Entry(0f, 8));
        entries.add(new Entry(0.4f, 9));
        entries.add(new Entry(0.5f, 10));
        entries.add(new Entry(0.3f, 11));

        LineDataSet dataset = new LineDataSet(entries, "Consommation d'eau par mois");

        labels = new ArrayList<String>();
        labels.add("08h");
        labels.add("08h30");
        labels.add("09h");
        labels.add("09h30");
        labels.add("10h");
        labels.add("10h30");
        labels.add("11h");
        labels.add("11h30");
        labels.add("12h");
        labels.add("12h30");
        labels.add("13h");
        labels.add("13h30");
        labels.add("14h");

        LineData data = new LineData(labels, dataset);
        dataset.setDrawCubic(false);
        dataset.setDrawFilled(true);

        lineChartChasse.setData(data);
        lineChartChasse.animateY(3000);


        //Bar chart

        BarChart barChart = (BarChart) findViewById(R.id.barChartFlush);
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(4f, 0));
        barEntries.add(new BarEntry(8f, 1));
        barEntries.add(new BarEntry(6f, 2));
        barEntries.add(new BarEntry(12f, 3));
        barEntries.add(new BarEntry(18f, 4));
        barEntries.add(new BarEntry(19f, 5));
        barEntries.add(new BarEntry(10f, 6));
        barEntries.add(new BarEntry(4f, 7));
        barEntries.add(new BarEntry(2f, 8));
        barEntries.add(new BarEntry(9f, 9));

        barEntries.add(new BarEntry(1f, 0));
        barEntries.add(new BarEntry(6f, 1));
        barEntries.add(new BarEntry(2f, 2));
        barEntries.add(new BarEntry(9f, 3));
        barEntries.add(new BarEntry(5f, 4));
        barEntries.add(new BarEntry(4f, 5));
        barEntries.add(new BarEntry(10f, 6));
        barEntries.add(new BarEntry(4f, 7));
        barEntries.add(new BarEntry(2f, 8));
        barEntries.add(new BarEntry(9f, 9));

        barEntries.add(new BarEntry(5f, 0));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(3f, 2));
        barEntries.add(new BarEntry(6f, 3));
        barEntries.add(new BarEntry(7f, 4));
        barEntries.add(new BarEntry(2f, 5));
        barEntries.add(new BarEntry(10f, 6));
        barEntries.add(new BarEntry(4f, 7));
        barEntries.add(new BarEntry(2f, 8));
        barEntries.add(new BarEntry(9f, 9));


        BarDataSet barDataSet = new BarDataSet(barEntries, "Consommation globale de la chasse + Fuites");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        // creating barLabels
        ArrayList<String> barLabels = new ArrayList();

        barLabels.add("January");
        barLabels.add("February");
        barLabels.add("March");
        barLabels.add("April");
        barLabels.add("May");
        barLabels.add("June");
        barLabels.add("July");
        barLabels.add("August");
        barLabels.add("September");
        barLabels.add("October");

        barLabels.add("January");
        barLabels.add("February");
        barLabels.add("March");
        barLabels.add("April");
        barLabels.add("May");
        barLabels.add("June");
        barLabels.add("July");
        barLabels.add("August");
        barLabels.add("September");
        barLabels.add("October");

        barLabels.add("January");
        barLabels.add("February");
        barLabels.add("March");
        barLabels.add("April");
        barLabels.add("May");
        barLabels.add("June");
        barLabels.add("July");
        barLabels.add("August");
        barLabels.add("September");
        barLabels.add("October");


        /*for (int i = 0; i < LIST_DATA.size(); ++i) {
            for (Map.Entry<String, String> entry : LIST_DATA.get(i).entrySet()) {
                if (!LIST_DATA.get(i).isEmpty() && entry.getKey().equals("value")) {
                    for(int j = 0; j<10;j++){
                        barEntries.add(new BarEntry(Float.parseFloat(entry.getValue()), j));
                    }
                    }
                }
            }*/


        BarData barData = new BarData(barLabels, barDataSet);
        barChart.setData(barData);
        barChart.animateY(3000);

        /*final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                addNotificationFuite(getApplicationContext());
            }
        }, 5000);*/

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                addNotificationFuite(getApplicationContext());
            }
        }, 10000);

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                addNotificationDoubleChasse(getApplicationContext());
            }
        }, 27000);



    }

    private void addNotificationFuite(Context context) {
        String message = "La consommation entre " + labels.get(9) + " et " + labels.get(11) + " n'est pas stable."
                + "\nVérifier votre mécanisme de chasse d'eau";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.warning_icon)
                        .setContentTitle("FUITE D'EAU")
                        .setContentText(message)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(message));


        Intent notificationIntent = new Intent(context, MainActivityAdmin.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    private void addNotificationDoubleChasse(Context context) {
        String message = "Un utilisateur à fait une double chasse d'eau entre " + labels.get(4) +
                " et " + labels.get(5) + ". Allez régler le niveau du flotteur.";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.warning_icon)
                        .setContentTitle("DOUBLE CHASSE D'EAU")
                        .setContentText("")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(message));
        Intent notificationIntent = new Intent(context, MainActivityAdmin.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }


}
