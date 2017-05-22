package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart lineChartChasse = (LineChart) findViewById(R.id.chartChasse);
        LineChart lineChartLavabo = (LineChart) findViewById(R.id.chartLavabo);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 0));
        entries.add(new Entry(0f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(6f, 3));
        entries.add(new Entry(0f, 4));
        entries.add(new Entry(0f, 5));

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(false);
        dataset.setDrawFilled(true);

        lineChartChasse.setData(data);
        lineChartChasse.animateY(5000);


        /**
         * Chart Lavabo
         * */

        ArrayList<Entry> entriesLavabo = new ArrayList<>();
        entriesLavabo.add(new Entry(0f, 0));
        entriesLavabo.add(new Entry(0f, 1));
        entriesLavabo.add(new Entry(3f, 2));
        entriesLavabo.add(new Entry(3f, 3));
        entriesLavabo.add(new Entry(0f, 4));
        entriesLavabo.add(new Entry(0f, 5));
        entriesLavabo.add(new Entry(3f, 6));
        entriesLavabo.add(new Entry(3f, 7));
        entriesLavabo.add(new Entry(0f, 8));
        entriesLavabo.add(new Entry(0f, 9));

        LineDataSet dataset2 = new LineDataSet(entriesLavabo, "# of Calls");

        ArrayList<String> labels2 = new ArrayList<String>();
        labels2.add("Janvier");
        labels2.add("Fevrier");
        labels2.add("Mars");
        labels2.add("Avril");
        labels2.add("Mai");
        labels2.add("Juin");
        labels2.add("Juillet");
        labels2.add("Aout");
        labels2.add("Septembre");
        labels2.add("Octobre");

        LineData data2 = new LineData(labels2, dataset2);
        dataset2.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset2.setDrawCubic(false);
        dataset2.setDrawFilled(true);

        lineChartLavabo.setData(data2);
        lineChartLavabo.animateY(5000);
    }
}
