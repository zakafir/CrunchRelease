package app.num.linechart;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.flask.colorpicker.OnColorSelectedListener;

public class LedActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample2);

		ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_picker_view);
		colorPickerView.addOnColorChangedListener(new OnColorChangedListener() {
			@Override public void onColorChanged(int selectedColor) {
				// Handle on color change
				Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));
			}
		});
		colorPickerView.addOnColorSelectedListener(new OnColorSelectedListener() {
			@Override
			public void onColorSelected(int selectedColor) {
				Toast.makeText(
						LedActivity.this,
						"selectedColor: " + Integer.toHexString(selectedColor).toUpperCase(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}