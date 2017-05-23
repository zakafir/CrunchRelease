package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class TapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);

        CombinedChart tapCombinedChart = (CombinedChart) findViewById(R.id.tapChartChasse);
        CombinedData combinedData = new CombinedData(getXAxisValues());
        combinedData.setData(barData());
        combinedData.setData(lineData());
        tapCombinedChart.setData(combinedData);
        tapCombinedChart.animateY(2000);
    }


    private ArrayList<String> getXAxisValues() {
        ArrayList<String> labels = new ArrayList();
        labels.add("04h");
        labels.add("08h");
        labels.add("12h");
        labels.add("16h");
        labels.add("20h");
        labels.add("00h");
        return labels;
    }

    private LineData lineData(){
        ArrayList<Entry> line = new ArrayList();
        line.add(new Entry(1f, 0));
        line.add(new Entry(3.5f, 1));
        line.add(new Entry(1f, 2));
        line.add(new Entry(1.5f, 3));
        line.add(new Entry(2.5f, 4));
        line.add(new Entry(2f, 5));
        LineDataSet lineDataSet = new LineDataSet(line, "Consommation moyenne du robinet");
        LineData lineData = new LineData(getXAxisValues(),lineDataSet);
        return lineData;
    }

    private BarData barData(){
        ArrayList<BarEntry> group1 = new ArrayList();
        group1.add(new BarEntry(2f, 0));
        group1.add(new BarEntry(7f, 1));
        group1.add(new BarEntry(2f, 2));
        group1.add(new BarEntry(3f, 3));
        group1.add(new BarEntry(5f, 4));
        group1.add(new BarEntry(4f, 5));
        BarDataSet barDataSet = new BarDataSet(group1, "Consommation du robinet");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(getXAxisValues(),barDataSet);
        return barData;
    }
}
