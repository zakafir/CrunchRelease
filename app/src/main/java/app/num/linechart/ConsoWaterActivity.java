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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import static app.num.linechart.MainActivityAdmin.LIST_DATA;
import static app.num.linechart.ParsingData.after;
import static app.num.linechart.ParsingData.before;
import static app.num.linechart.ParsingData.between;

public class ConsoWaterActivity extends AppCompatActivity {

    float[] compteur = new float[60];
    ArrayList<String> labels = new ArrayList<String>();

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
        combinedChart.setVisibleXRangeMaximum(10);

        float compteurPieChart[] = new float[2];

        PieChart pieChartChasse = (PieChart) findViewById(R.id.pieChartChasse);
        ArrayList<Entry> entriesPieChart = new ArrayList<>();
        String valuePieChart;
        for (int i = 0; i < LIST_DATA.size(); ++i) {
            for (Map.Entry<String, String> entry : LIST_DATA.get(i).entrySet()) {
                if (!LIST_DATA.get(i).isEmpty() && entry.getValue().contains("2016")) {
                    valuePieChart = after(entry.getValue(), "-");
                    compteurPieChart[0] += Float.parseFloat(valuePieChart);
                } else if (!LIST_DATA.get(i).isEmpty() && entry.getValue().contains("2017")) {
                    valuePieChart = after(entry.getValue(), "-");
                    compteurPieChart[1] += Float.parseFloat(valuePieChart);
                }
            }
        }
        entriesPieChart.add(new Entry(compteurPieChart[0], 0));
        entriesPieChart.add(new Entry(compteurPieChart[1], 1));

        PieDataSet pieDataset = new PieDataSet(entriesPieChart, "Consommation d'eau 2016/2017");
        ArrayList<String> pieChartLabels = new ArrayList<String>();
        pieChartLabels.add("2016");
        pieChartLabels.add("2017");
        PieData pieData = new PieData(pieChartLabels, pieDataset);
        pieDataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        pieChartChasse.setDescription("Consommation annuelle");
        pieChartChasse.setData(pieData);

        pieChartChasse.animateY(2000);
    }

    private ArrayList<String> getXAxisValues() {
        String value;
        String lbl;
        int j = 0;
        for (int i = 0; i < LIST_DATA.size(); ++i) {
            for (Map.Entry<String, String> entry : LIST_DATA.get(i).entrySet()) {
                if (!LIST_DATA.get(i).isEmpty() && entry.getKey().equals("hour")) {
                    lbl = before(entry.getValue(), "-")
                            .concat("h").concat(after(entry.getValue(), "-"));

                    value = between(entry.getValue(), "-", "-");
                    compteur[j] += Float.parseFloat(value);
                    j++;
                    labels.add(lbl);
                }
            }
        }
        return labels;
    }

    private LineData lineData() {
        ArrayList<Entry> line = new ArrayList();
        for (int i = 0; i < compteur.length; ++i) {
            if (compteur[i] != 0.0) {
                line.add(new Entry(compteur[i] / 4f, i));
            }
        }
        LineDataSet lineDataSet = new LineDataSet(line, "Conso moyenne");
        LineData lineData = new LineData(getXAxisValues(), lineDataSet);
        lineDataSet.setDrawCubic(true);
        return lineData;
    }

    private BarData barData() {

        ArrayList<BarEntry> group1 = new ArrayList();
        for (int i = 0; i < compteur.length; ++i) {
            if (compteur[i] != 0.0) {
                group1.add(new BarEntry(compteur[i], i));
            }
        }
        BarDataSet barDataSet = new BarDataSet(group1, "Consommation total");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(getXAxisValues(), barDataSet);
        return barData;
    }

    private int getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h");
        return Integer.parseInt(sdf.format(cal.getTime()));
    }

    private int getCurrentMinute() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return Integer.parseInt(sdf.format(cal.getTime()));
    }


}
