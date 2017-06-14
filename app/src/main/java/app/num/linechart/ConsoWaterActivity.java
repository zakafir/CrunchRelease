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
import java.util.Map;

import static app.num.linechart.MainActivityAdmin.LIST_DATA;

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
        int compteur = 0;
        for (int i = 0; i < LIST_DATA.size(); ++i) {
            for (Map.Entry<String, String> entry : LIST_DATA.get(i).entrySet()) {
                if (!LIST_DATA.get(i).isEmpty() && entry.getValue().equals("1h")) {
                    if (!labels.contains(entry.getValue())) {
                        switch (entry.getValue()){
                            case "1h-5h-9h-10h": compteur = compteur+1;
                        }
                        labels.add(entry.getValue());
                }
                } else if (!LIST_DATA.get(i).isEmpty() && entry.getValue().equals("5h")) {
                    if (!labels.contains(entry.getValue())) {
                        switch (entry.getValue()){
                            case "1h-5h-9h-10h": compteur = compteur+1;
                        }
                        labels.add(entry.getValue());
                    }
                }
                else if (!LIST_DATA.get(i).isEmpty() && entry.getValue().equals("9h")) {
                    if (!labels.contains(entry.getValue())) {
                        switch (entry.getValue()){
                            case "1h-5h-9h-10h": compteur = compteur+1;
                        }
                        labels.add(entry.getValue());
                    }
                }
                else if (!LIST_DATA.get(i).isEmpty() && entry.getValue().equals("10h")) {
                    if (!labels.contains(entry.getValue())) {
                        switch (entry.getValue()){
                            case "1h-5h-9h-10h": compteur = compteur+1;
                        }
                        labels.add(entry.getValue());
                    }
                }
            }
        }

        PieChart pieChartChasse = (PieChart) findViewById(R.id.pieChartChasse);
        ArrayList<Entry> entriesPieChart = new ArrayList<>();
        entriesPieChart.add(new Entry(4.1f, 0));
        entriesPieChart.add(new Entry(8.6f, 1));
        entriesPieChart.add(new Entry(10.9f, 3));
        entriesPieChart.add(new Entry(9.11f, 5));

        PieDataSet pieDataset = new PieDataSet(entriesPieChart, "");

        PieData pieData = new PieData(labels, pieDataset);
        pieDataset.setColors(ColorTemplate.VORDIPLOM_COLORS); //
        pieChartChasse.setDescription("Quantité d'eau perdue");
        pieChartChasse.setData(pieData);

        pieChartChasse.animateY(2000);
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
            line.add(new Entry(2f, 1));
            line.add(new Entry(9f, 2));
            line.add(new Entry(3f, 3));
            line.add(new Entry(4.5f, 4));
            line.add(new Entry(2f, 5));
            LineDataSet lineDataSet = new LineDataSet(line, "Conso moyenne");
            LineData lineData = new LineData(getXAxisValues(),lineDataSet);
            return lineData;
        }
    private BarData barData(){
            ArrayList<BarEntry> group1 = new ArrayList();
                 group1.add(new BarEntry(2f, 0));
                 group1.add(new BarEntry(4f, 1));
                 group1.add(new BarEntry(18f, 2));
                 group1.add(new BarEntry(6f, 3));
                 group1.add(new BarEntry(9f, 4));
                 group1.add(new BarEntry(4f, 5));
            BarDataSet barDataSet = new BarDataSet(group1, "Consommation de la chasse");
                 barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
            BarData barData = new BarData(getXAxisValues(),barDataSet);
         return barData;
        }
}
