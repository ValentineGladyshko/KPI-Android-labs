package valentine.lab1;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String colorName;
    TextView startPrice;
    TextView endPrice;
    EditText editTextName;
    CrystalRangeSeekbar priceRange;
    int  start = 0, end = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.name);
        startPrice = (TextView) findViewById(R.id.start_price);
        endPrice = (TextView) findViewById(R.id.end_price);
        priceRange = (CrystalRangeSeekbar) findViewById(R.id.priceRange);
        priceRange.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                startPrice.setText(String.valueOf(minValue));
                start = minValue.intValue();
                endPrice.setText(String.valueOf(maxValue));
                end = maxValue.intValue();
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        RadioButton radioButton = (RadioButton) view;
        if (checked) {
            colorName = radioButton.getText().toString();
        }
        switch(view.getId()) {
            case R.id.red:
                if (checked){
                }
                break;
            case R.id.orange:
                if (checked){
                }
                break;
            case R.id.yellow:
                if (checked){
                }
                break;
            case R.id.green:
                if (checked){
                }
                break;
            case R.id.cyan:
                if (checked){
                }
                break;
            case R.id.blue:
                if (checked){
                }
                break;
            case R.id.violet:
                if (checked){
                }
                break;
        }
    }
    public void sendMessage(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Квіти");
        String message="Назва: " + editTextName.getText().toString()
                + "\nКолір: " + colorName + "\nЦіна: " + start
                + " - " + end;
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
