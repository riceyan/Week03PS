package sg.edu.rp.c346.id21017809.week03ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvAmt;
    EditText etInputAmt;
    TextView tvPax;
    EditText etInputPax;
    ToggleButton tbtnSVS;
    ToggleButton tbtnGST;
    TextView tvDisc;
    EditText etInputDisc;
    RadioButton rbCash;
    RadioButton rbPayNow;
    Button btnSplit;
    Button btnReset;
    TextView tvTotal;
    TextView tvSplit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAmt = findViewById(R.id.textViewAmount);
        etInputAmt = findViewById(R.id.editTextAmount);
        tvPax = findViewById(R.id.textViewPax);
        etInputPax = findViewById(R.id.editTextPax);
        tbtnSVS = findViewById(R.id.toggleButtonSVS);
        tbtnGST = findViewById(R.id.toggleButtonGST);
        tvDisc = findViewById(R.id.textViewDiscount);
        etInputDisc = findViewById(R.id.editTextDiscount);
        rbCash = findViewById(R.id.radioButtonCash);
        rbPayNow = findViewById(R.id.radioButtonPayNow);
        btnSplit = findViewById(R.id.buttonSplit);
        btnReset = findViewById(R.id.buttonReset);
        tvTotal = findViewById(R.id.textViewTotal);
        tvSplit = findViewById(R.id.textViewSplit);

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                String totalAmt = String.format("%.2f",(etInputAmt/(etInputDisc/100.0)));
                Double.parseDouble(totalAmt);
                tvTotal.setText(totalAmt);
                Double.parseDouble(totalAmt);
                tvSplit.setText(doubleSplit);

            }
        });

        tbtnSVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                boolean isChecked = tbtnSVS.isChecked();
                if (isChecked) {
                    etInput.setEnabled(true);
                } else {
                    etInput.setEnabled(false);
                }
            }
        });

        tbtnGST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                boolean isChecked = tbtnGST.isChecked();
                if (isChecked) {
                    etInput.setEnabled(true);
                } else {
                    etInput.setEnabled(false);
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                String stringResponse = etInput.getText().toString();
                int checkedRadioId = rgGender.getCheckedRadioButtonId();
                String newStringResponse;
                if(checkedRadioId == R.id.radioButtonCash){
                    //when cash selected
                    newStringResponse = "Each pays: $" + doubleSplit + " in cash";
                }
                else{
                    //when payNow selected
                    newStringResponse = "Each pays: $" + doubleSplit + " via Paynow to";
                }
                tvDisplay.setText(newStringResponse);
            }
        });

    }

}