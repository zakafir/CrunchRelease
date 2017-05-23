package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ConsoWaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conso_water);

        CombinedChart combinedChart = (CombinedChart) findViewById(R.id.chartChasse);
        CombinedData combinedData = new CombinedData(getXAxisValues());
        combinedData.setData(barData());
        combinedData.setData(lineData());
        combinedChart.setData(combinedData);
        combinedChart.animateY(3000);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 0));
        entries.add(new Entry(0f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(6f, 3));
        entries.add(new Entry(0f, 4));
        entries.add(new Entry(0f, 5));


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("04h");
        labels.add("08h");
        labels.add("12h");
        labels.add("16h");
        labels.add("20h");
        labels.add("00h");
        //Pie chart

        PieChart pieChartChasse = (PieChart) findViewById(R.id.pieChartChasse);
        ArrayList<Entry> entriesPieChart = new ArrayList<>();
        entriesPieChart.add(new Entry(4f, 0));
        entriesPieChart.add(new Entry(8f, 1));
        entriesPieChart.add(new Entry(12f, 2));
        entriesPieChart.add(new Entry(10f, 3));
        entriesPieChart.add(new Entry(18f, 4));
        entriesPieChart.add(new Entry(9f, 5));

        PieDataSet pieDataset = new PieDataSet(entriesPieChart, "# of Calls");

        PieData pieData = new PieData(labels, pieDataset);
        pieDataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        pieChartChasse.setDescription("Description de chart");
        pieChartChasse.setData(pieData);

        pieChartChasse.animateY(2000);
    }
    public static ArrayList<String> getXAxisValues() {
        ArrayList<String> labels = new ArrayList();
        labels.add("04h");
        labels.add("08h");
        labels.add("12h");
        labels.add("16h");
        labels.add("20h");
        labels.add("00h");
        return labels;
    }

    public static LineData lineData(){
            ArrayList<Entry> line = new ArrayList();
            line.add(new Entry(2f, 0));
            line.add(new Entry(4f, 1));
            line.add(new Entry(18f, 2));
            line.add(new Entry(6f, 3));
            line.add(new Entry(9f, 4));
            line.add(new Entry(4f, 5));
            LineDataSet lineDataSet = new LineDataSet(line, "Brand 2");
                lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            LineData lineData = new LineData(getXAxisValues(),lineDataSet);
            return lineData;
        }

    public static BarData barData(){
            ArrayList<BarEntry> group1 = new ArrayList();
                 group1.add(new BarEntry(4f, 0));
                 group1.add(new BarEntry(8f, 1));
                 group1.add(new BarEntry(6f, 2));
                 group1.add(new BarEntry(12f, 3));
                 group1.add(new BarEntry(18f, 4));
                 group1.add(new BarEntry(9f, 5));
            BarDataSet barDataSet = new BarDataSet(group1, "Brand 1");
                 barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            BarData barData = new BarData(getXAxisValues(),barDataSet);
         return barData;
        }
}
