package com.trinadh.nutribasket.FCM;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.trinadh.nutribasket.Extras.Config;
import com.trinadh.nutribasket.MVP.RegistrationResponse;
import com.trinadh.nutribasket.Retrofit.Api;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

}