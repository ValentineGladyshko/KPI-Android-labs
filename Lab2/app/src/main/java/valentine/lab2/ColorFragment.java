package valentine.lab2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class ColorFragment extends Fragment {

    RadioButton red;
    RadioButton orange;
    RadioButton yellow;
    RadioButton green;
    RadioButton cyan;
    RadioButton blue;
    RadioButton violet;
    String colorName;
    int color;

    private OnFragmentInteractionListener mListener;

    public ColorFragment() {
        colorName = "";
        color = -1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        red = view.findViewById(R.id.red);
        orange = view.findViewById(R.id.orange);
        yellow = view.findViewById(R.id.yellow);
        green = view.findViewById(R.id.green);
        cyan = view.findViewById(R.id.cyan);
        blue = view.findViewById(R.id.blue);
        violet = view.findViewById(R.id.violet);
        red.setOnClickListener(onRadioButtonClicked);
        orange.setOnClickListener(onRadioButtonClicked);
        yellow.setOnClickListener(onRadioButtonClicked);
        green.setOnClickListener(onRadioButtonClicked);
        cyan.setOnClickListener(onRadioButtonClicked);
        blue.setOnClickListener(onRadioButtonClicked);
        violet.setOnClickListener(onRadioButtonClicked);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    View.OnClickListener onRadioButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((RadioButton) view).isChecked();
            RadioButton radioButton = (RadioButton) view;
            if (checked) {
                colorName = radioButton.getText().toString();
                mListener.onColorChanged();
            }
            switch (view.getId()) {
                case R.id.red:
                    if (checked) {
                        color = R.color.red;
                    }
                    break;
                case R.id.orange:
                    if (checked) {
                        color = R.color.orange;
                    }
                    break;
                case R.id.yellow:
                    if (checked) {
                        color = R.color.yellow;
                    }
                    break;
                case R.id.green:
                    if (checked) {
                        color = R.color.green;
                    }
                    break;
                case R.id.cyan:
                    if (checked) {
                        color = R.color.cyan;
                    }
                    break;
                case R.id.blue:
                    if (checked) {
                        color = R.color.blue;
                    }
                    break;
                case R.id.violet:
                    if (checked) {
                        color = R.color.violet;
                    }
                    break;
            }
        }
    };

    public interface OnFragmentInteractionListener {
        void onColorChanged();
    }
}
