package edu.westga.chrisyaninvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import edu.westga.chrisyaninvestmentcalculator.model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {
    private EditText interest, periods, payment;
    private TextView futureValue;
    private Button btnCalculate;
    InvestmentCalculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.btnCalculate = (Button) findViewById(R.id.btnCalculate);
        this.btnCalculate.setEnabled(false);

        this.interest = (EditText) findViewById(R.id.txtRate);
        this.payment = (EditText) findViewById(R.id.txtPayment);
        this.periods = (EditText) findViewById(R.id.txtPeriods);
        this.futureValue = (TextView) findViewById(R.id.txtFutureValue);

        this.interest.addTextChangedListener(textWatcher);
        this.payment.addTextChangedListener(textWatcher);
        this.periods.addTextChangedListener(textWatcher);

        this.calculator = new InvestmentCalculator();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
        {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            checkFieldsForEmptyValues();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    private  void checkFieldsForEmptyValues(){
        Button b = (Button) findViewById(R.id.btnCalculate);

        String s1 = this.payment.getText().toString();
        String s2 = this.interest.getText().toString();
        String s3 = this.periods.getText().toString();

        if(s1.equals("") && s2.equals("") && s3.equals(""))
        {
            b.setEnabled(false);
        }

        else if(!s1.equals("") && s2.equals("") && s3.equals("")){
            b.setEnabled(false);
        }


        else if(!s2.equals("") && s1.equals("") && s3.equals(""))
        {
            b.setEnabled(false);
        }

        else if(!s3.equals("") && s2.equals("") && s1.equals(""))
        {
            b.setEnabled(false);
        }

        else
        {
            b.setEnabled(true);
        }
    }

    public void calculateFutureValue(View view) {
        if(this.calculator.isValidDouble(this.interest.getText().toString()) &&
                this.calculator.isValidDouble(this.payment.getText().toString()) &&
                this.calculator.isValidInt(this.periods.getText().toString()) ) {
            this.calculator.setInterest(Double.parseDouble(this.interest.getText().toString()));
            this.calculator.setPeriods(Integer.parseInt(this.periods.getText().toString()));
            this.calculator.setPayment(Double.parseDouble(this.payment.getText().toString()));
        } else {
            return;
        }

        double futureValue = this.calculator.calculate();

        this.futureValue.setText(String.format("$%.2f", futureValue));
    }
}
