package com.example.shahalam.messmealcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etRate, etBua, etFuel, etOthers,etName,etMealNo, etCredit;
    TextView tvName, tvMeal, tvMealBua,tvMealBuaFuel,tvTotalCost,tvCredit,tvReturn, whoPay, payTaka;
    Button btCalculate;
    ImageView imo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRate = findViewById(R.id.rateETid);
        etBua = findViewById(R.id.buaETid);
        etFuel = findViewById(R.id.fuelETid);
        etOthers = findViewById(R.id.othersETid);
        etName = findViewById(R.id.nameETid);
        etMealNo = findViewById(R.id.mealNoETid);
        etCredit = findViewById(R.id.creditETid);
        tvName = findViewById(R.id.showNameTVid);
        tvMeal = findViewById(R.id.showMealCostTVid);
        tvMealBua = findViewById(R.id.showMealBuaTVid);
        tvMealBuaFuel = findViewById(R.id.showMealBuaFuelTVid);
        tvTotalCost = findViewById(R.id.showTotalCostTVid);
        tvCredit = findViewById(R.id.showCreditTVid);
        tvReturn = findViewById(R.id.showPayAmountTVid);
        btCalculate = findViewById(R.id.calculateBTid);
        whoPay = findViewById(R.id.showWhoPayId);
        payTaka = findViewById(R.id.showPayAmountTVid);
        imo = findViewById(R.id.imoticonId);




        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // EditText to string......
                String nameString, rateString, buaString, fuelString, othersString, mealNoString, creditString;

                nameString = etName.getText().toString();
                rateString = etRate.getText().toString();
                buaString = etBua.getText().toString();
                fuelString = etFuel.getText().toString();
                othersString = etOthers.getText().toString();
                mealNoString = etMealNo.getText().toString();
                creditString = etCredit.getText().toString();

                // String to float.....
                float rate, bua, fuel, others,mealNo,credit;
                rate = Float.valueOf(rateString);
                bua = Float.valueOf(buaString);
                fuel = Float.valueOf(fuelString);
                others = Float.valueOf(othersString);
                mealNo = Float.valueOf(mealNoString);
                credit = Float.valueOf(creditString);


                float mealCost, mealBuaCost, mealBuaFuelCost, totalCost;

                mealCost = rate * mealNo;
                mealBuaCost = mealCost + bua;
                mealBuaFuelCost = mealBuaCost + fuel;
                totalCost = mealBuaFuelCost + others;


                // float to string
                String mealCostString, mealBuaCostString, mealBuaFuelCostString, totalCostString;
                mealCostString = String.valueOf(mealCost);
                mealBuaCostString = String.valueOf(mealBuaCost);
                mealBuaFuelCostString = String.valueOf(mealBuaFuelCost);
                totalCostString = String.valueOf(totalCost);


                // string to textView
                tvCredit.setText(creditString);
                tvMealBuaFuel.setText(mealBuaFuelCostString);
                tvMealBua.setText(mealBuaCostString);
                tvMeal.setText(mealCostString);
                tvName.setText(nameString);
                tvTotalCost.setText(totalCostString);

                float payAmount;
                String payAmountString;

                if(credit>totalCost)
                {
                    payAmount = credit - totalCost;
                    payAmountString = String.valueOf(payAmount);
                    whoPay.setText("Manager will pay: ");
                    payTaka.setText(payAmountString);
                    imo.setImageResource(R.drawable.smile);

                }
                if(credit<totalCost)
                {
                    payAmount = totalCost - credit;
                    payAmountString = String.valueOf(payAmount);
                    whoPay.setText("Bordar will pay: ");
                    payTaka.setText(payAmountString);
                    imo.setImageResource(R.drawable.sad);
                }
                if (credit==totalCost)
                {
                    whoPay.setText("WOW! No one have to pay ");
                    payTaka.setText("");
                    imo.setImageResource(R.drawable.devile);
                }

            }

        });



    }
}
