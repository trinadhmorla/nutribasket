package com.trinadh.nutribasket.PaymentIntegrationMethods;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.trinadh.nutribasket.Activities.MainActivity;
import com.trinadh.nutribasket.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderConfirmed extends AppCompatActivity {

    @BindView(R.id.continueShopping)
    Button continueShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmed);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.continueShopping)
    public void onClick(View view) {
        Intent intent = new Intent(OrderConfirmed.this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OrderConfirmed.this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}
