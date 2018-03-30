package com.example.bnfg.retrofit_gps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bnfg.retrofit_gps.model.post.Post;
import com.example.bnfg.retrofit_gps.model.remote.APIService;
import com.example.bnfg.retrofit_gps.model.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mResponseTv;
    private APIService mAPIService;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText lat = (EditText) findViewById(R.id.latitude);
        final EditText lon = (EditText) findViewById(R.id.longitude);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double latitude = new Double(lat.getText().toString().trim());
                Double longitude = new Double(lon.getText().toString().trim());
                if((!latitude.equals(null))&&(!longitude.equals(null)))
                sendPost(latitude, longitude);
               /* if(!TextUtils.isEmpty(latitude) && !TextUtils.isEmpty(longitude)) {

                }*/
            }
            public void sendPost(double latitude, double longitude) {
                mAPIService.savePost(latitude,longitude).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        if(response.isSuccessful()) {
                            showResponse(response.body().toString());
                            Log.i(TAG, "post submitted to API." + response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Log.e(TAG, "Unable to submit post to API.");
                    }
                });
            }

            public void showResponse(String response) {
                if(mResponseTv.getVisibility() == View.GONE) {
                    mResponseTv.setVisibility(View.VISIBLE);
                }
                mResponseTv.setText(response);
            }});

    }}
