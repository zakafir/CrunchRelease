package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;

import static app.num.linechart.ConsoWaterActivity.barData;
import static app.num.linechart.ConsoWaterActivity.getXAxisValues;
import static app.num.linechart.ConsoWaterActivity.lineData;

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
}
