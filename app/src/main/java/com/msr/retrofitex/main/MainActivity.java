package com.msr.retrofitex.main;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.msr.retrofitex.R;
import com.msr.retrofitex.model.Model;
import com.msr.retrofitex.rest.ApiClient;
import com.msr.retrofitex.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static Dialog getProgressDialog(Context ctx, String txt) {

        Dialog dialog = new Dialog(ctx);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //		dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.progress_dialog);
        TextView tv = (TextView) dialog.findViewById(R.id.dialog_text);
        tv.setText(txt);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();

        return dialog;
    }

    private void makeRequest() {
       Dialog progressDialog = getProgressDialog(this, "Please wait");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Model> call = apiService.getLiveMatches("url");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }
}
