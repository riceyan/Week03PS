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
    RadioGroup rgPayment;
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
        rgPayment = findViewById(R.id.radioGroupPayment);
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
                double totalAmt = Double.parseDouble(String.valueOf(etInputAmt.getText()));
                double totalPax = Double.parseDouble(String.valueOf(etInputPax.getText()));
                double discount = Double.parseDouble(String.valueOf(etInputDisc.getText()));

                if (tbtnSVS.isChecked()) {
                    totalAmt = totalAmt * 1.1; //service charge

                } else if (tbtnGST.isChecked()) {
                    totalAmt = totalAmt * 1.08;

                } else if (tbtnSVS.isChecked() && tbtnGST.isChecked()) {
                    totalAmt = totalAmt * 1.18;
                } else {
                    totalAmt = totalAmt;
                }
                double totalBill = totalAmt - (totalAmt * (discount / 100));
                double splitTotalBill = totalBill / totalPax;

                int checkedRadioId = rgPayment.getCheckedRadioButtonId();
                if (checkedRadioId == R.id.radioButtonCash) {
                    tvTotal.setText(String.format("Total Bill: $%.2f", totalBill));
                    tvSplit.setText(String.format("Each Pays: $%.2f in cash", splitTotalBill));
                } else if (checkedRadioId == R.id.radioButtonPayNow) {
                    tvTotal.setText(String.format("Total Bill: $%.2f", totalBill));
                    tvSplit.setText(String.format("Each Pays: $%.2f in cash", splitTotalBill));
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               etInputAmt.getText().clear();
               etInputPax.getText().clear();
               etInputDisc.getText().clear();

               if (tbtnSVS.isChecked()) {
                   tbtnSVS.setChecked(false);
               }
               if (tbtnGST.isChecked()) {
                   tbtnGST.setChecked(false);
               }
               if (rbCash.isChecked()) {
                   rbCash.setChecked(false);
               }
               if (rbPayNow.isChecked()) {
                   rbPayNow.setChecked(false);
               }
               tvTotal.setText("");
               tvSplit.setText("");
            }
        });

    }

}