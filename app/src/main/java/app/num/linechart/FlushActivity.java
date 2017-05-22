package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class FlushActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flush);


        LineChart lineChartChasse = (LineChart) findViewById(R.id.chartFlush);

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
    }
}
