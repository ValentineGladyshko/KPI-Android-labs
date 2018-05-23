package valentine.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements ButtonFragment.OnFragmentInteractionListener,
            NameFragment.OnFragmentInteractionListener,
            ColorFragment.OnFragmentInteractionListener,
            PriceFragment.OnFragmentInteractionListener{

    NameFragment nameFragment;
    ColorFragment colorFragment;
    PriceFragment priceFragment;
    ButtonFragment buttonFragment;
    ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameFragment = (NameFragment) getSupportFragmentManager().findFragmentById(R.id.name_fragment);
        colorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.color_fragment);
        priceFragment = (PriceFragment) getSupportFragmentManager().findFragmentById(R.id.price_fragment);
        buttonFragment = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.button_fragment);
        resultFragment = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.result_fragment);
    }

    @Override
    public void onButtonClicked() {
        String name = nameFragment.name.getText().toString();
        int color = colorFragment.color;
        String colorName = colorFragment.colorName;
        String startPrice = priceFragment.startPrice.getText().toString();
        String endPrice = priceFragment.endPrice.getText().toString();
        resultFragment.showResult(name, color, colorName, startPrice, endPrice);
    }

    @Override
    public void onColorChanged() {
        if (resultFragment != null)
            resultFragment.hideResult();
    }

    @Override
    public void onNameChanged() {
        if (resultFragment != null)
            resultFragment.hideResult();
    }

    @Override
    public void onPriceChanged() {
        if (resultFragment != null)
            resultFragment.hideResult();
    }
}
