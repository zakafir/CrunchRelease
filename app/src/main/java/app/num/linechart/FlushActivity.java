package app.num.linechart;

import android.os.Bundle;
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
        lineChartChasse.animateY(3000);


        //Bar chart

        BarChart barChart = (BarChart) findViewById(R.id.barChartFlush);
        ArrayList <BarEntry> barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(4f, 0));
                barEntries.add(new BarEntry(8f, 1));
                barEntries.add(new BarEntry(6f, 2));
                barEntries.add(new BarEntry(12f, 3));
                barEntries.add(new BarEntry(18f, 4));
                barEntries.add(new BarEntry(9f, 5));


        BarDataSet barDataSet = new BarDataSet(barEntries, "# of Calls");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        // creating barLabels
        ArrayList<String> barLabels = new ArrayList();
                barLabels.add("January");
                barLabels.add("February");
                barLabels.add("March");
                barLabels.add("April");
                barLabels.add("May");
                barLabels.add("June");

        BarData barData = new BarData(barLabels, barDataSet);
        barChart.setData(barData);
        barChart.setDescription("Some description");
        barChart.animateY(3000);


    }
}
