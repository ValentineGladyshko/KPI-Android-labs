package valentine.lab2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    View resultView;
    TextView nameValue;
    TextView colorLabel;
    TextView colorValue;
    TextView priceValue;

    public ResultFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultView = view.findViewById(R.id.result1_fragment);
        nameValue = view.findViewById(R.id.name_value);
        colorLabel = view.findViewById(R.id.color_label);
        colorValue = view.findViewById(R.id.color_value);
        priceValue = view.findViewById(R.id.price_value);
    }

    public void showResult(String name, int color, String colorName, String startPrice, String endPrice){
        resultView.setVisibility(View.VISIBLE);
        String name1 = "Назва: " + name;
        nameValue.setText(name1);
        colorLabel.setText("Колір: ");
        if (color != -1)
        {
            colorValue.setTextColor(getResources().getColor(color));
        }
        colorValue.setText(colorName);
        String price1 = "Ціна: " + startPrice + " - " + endPrice;
        priceValue.setText(price1);
    }

    public void hideResult(){
        resultView.setVisibility(View.GONE);
    }

}
