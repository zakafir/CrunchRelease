package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

        //btn semaine
        Button btnSemaine = (Button) findViewById(R.id.btnSemaine);

        btnSemaine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pie chart

                PieChart pieChartChasse = (PieChart) findViewById(R.id.pieChartTap);
                ArrayList<Entry> entriesPieChart = new ArrayList<>();
                entriesPieChart.add(new Entry(40.1f, 0));
                entriesPieChart.add(new Entry(85.6f, 1));
                entriesPieChart.add(new Entry(70f, 2));
                entriesPieChart.add(new Entry(61f, 3));
                entriesPieChart.add(new Entry(90f, 5));
                entriesPieChart.add(new Entry(19.5f, 4));


                PieDataSet pieDataset = new PieDataSet(entriesPieChart, "");

                PieData pieData = new PieData(getXAxisValuesPieWeek(), pieDataset);
                pieDataset.setColors(ColorTemplate.COLORFUL_COLORS); //
                pieChartChasse.setDescription("Consommation d'eau");
                pieChartChasse.setData(pieData);

                pieChartChasse.animateY(2000);


            }
        });



        //btn mois
        Button btnMois = (Button) findViewById(R.id.btnMois);

        btnMois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pie chart

                PieChart pieChartChasse = (PieChart) findViewById(R.id.pieChartTap);
                ArrayList<Entry> entriesPieChart = new ArrayList<>();
                entriesPieChart.add(new Entry(450.1f, 0));
                entriesPieChart.add(new Entry(396f, 1));
                entriesPieChart.add(new Entry(303f, 2));
                entriesPieChart.add(new Entry(215f, 3));
                entriesPieChart.add(new Entry(191f, 5));
                entriesPieChart.add(new Entry(576f, 4));


                PieDataSet pieDataset = new PieDataSet(entriesPieChart, "");

                PieData pieData = new PieData(getXAxisValuesPieMonth(), pieDataset);
                pieDataset.setColors(ColorTemplate.JOYFUL_COLORS); //
                pieChartChasse.setDescription("Consommation d'eau");
                pieChartChasse.setData(pieData);

                pieChartChasse.animateY(2000);


            }
        });



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

    private ArrayList<String> getXAxisValuesPieWeek() {
        ArrayList<String> labels = new ArrayList();
        labels.add("Lundi");
        labels.add("Mardi");
        labels.add("Mercredi");
        labels.add("Jeudi");
        labels.add("Vendredi");
        labels.add("Samedi");
        return labels;
    }

    private ArrayList<String> getXAxisValuesPieMonth() {
        ArrayList<String> labels = new ArrayList();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
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
        lineDataSet.setDrawCubic(true);
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
