package com.example.hotelbilling;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText idliQty, dosaQty, parottaQty, omletQty, offboilQty, pooriSetQty, pooriSingleQty;
    TextView resultTxt;
    Button calcBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idliQty = findViewById(R.id.idliQty);
        dosaQty = findViewById(R.id.dosaQty);
        parottaQty = findViewById(R.id.parottaQty);
        omletQty = findViewById(R.id.omletQty);
        offboilQty = findViewById(R.id.offboilQty);
        pooriSetQty = findViewById(R.id.pooriSetQty);
        pooriSingleQty = findViewById(R.id.pooriSingleQty);
        resultTxt = findViewById(R.id.resultTxt);
        calcBtn = findViewById(R.id.calcBtn);
        clearBtn = findViewById(R.id.clearBtn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = 0;
                total += getQty(idliQty) * 10;
                total += getQty(dosaQty) * 10;
                total += getQty(parottaQty) * 15;
                total += getQty(omletQty) * 20;
                total += getQty(offboilQty) * 15;
                total += getQty(pooriSetQty) * 40;
                total += getQty(pooriSingleQty) * 20;
                resultTxt.setText("Total: ₹" + total);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idliQty.setText("");
                dosaQty.setText("");
                parottaQty.setText("");
                omletQty.setText("");
                offboilQty.setText("");
                pooriSetQty.setText("");
                pooriSingleQty.setText("");
                resultTxt.setText("Total: ₹0");
            }
        });
    }

    private int getQty(EditText e) {
        String s = e.getText().toString();
        if (s.isEmpty()) return 0;
        return Integer.parseInt(s);
    }
}
