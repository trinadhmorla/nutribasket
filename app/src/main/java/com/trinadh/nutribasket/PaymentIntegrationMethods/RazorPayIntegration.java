package com.trinadh.nutribasket.PaymentIntegrationMethods;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.trinadh.nutribasket.Adapter.CartListAdapter;
import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.Fragments.ChoosePaymentMethod;
import com.trinadh.nutribasket.Fragments.MyCartList;
import com.trinadh.nutribasket.R;

import org.json.JSONObject;

public class RazorPayIntegration extends AppCompatActivity implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razor_pay_integration);
        startPayment();
    }

    public void startPayment() {
        /**
         * You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
        final AppCompatActivity activity = this;

        final Checkout co = new Checkout();

        try {
            JSONObject options = new JSONObject();
            options.put("name", getResources().getString(R.string.app_name));
            options.put("description", "Payment for "+ MyCartList.cartistResponseData.getProducts().size()+" products");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://rzp-mobile.s3.amazonaws.com/images/rzp.png");
            options.put("currency", "INR");

            JSONObject preFill = new JSONObject();
            preFill.put("email", ChoosePaymentMethod.userEmail);
            preFill.put("contact", ChoosePaymentMethod.mobileNo);
            options.put("prefill", preFill);
            String payment = CartListAdapter.totalAmountPayable;

            double total = Double.parseDouble(payment);
            total = total * 100;
            options.put("amount", Math.round(total));
            co.open(activity, options);
        } catch (Exception e) {
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        Config.addOrder(RazorPayIntegration.this,
                razorpayPaymentID,
                "RazorPay Payment-Gateway");

    }

    @Override
    public void onPaymentError(int code, String response) {
        finish();
        try {
            Toast.makeText(this, "Payment error please try again", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("OnPaymentError", "Exception in onPaymentError", e);
        }
    }
}
