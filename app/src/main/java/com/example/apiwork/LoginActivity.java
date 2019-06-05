package com.example.apiwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apiwork.APIInterface.APIInterface;
import com.example.apiwork.APIManager.APIClient;
import com.example.apiwork.APIResponse.Registration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.et_email);
        password =(EditText)findViewById(R.id.et_password);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loaddata();
            }
        });
    }

    private void Loaddata() {
        String useremail = email.getText().toString();
        String userpassword = password.getText().toString();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Registration> response = apiInterface.GET_BRAND_RESPONSE_CALL_LOGIN(useremail,userpassword);
        response.enqueue(new Callback<Registration>() {
            @Override
            public void onResponse(Call<Registration> call, Response<Registration> response) {
                Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Registration> call, Throwable t) {
                Log.e("##", t.getMessage());
            }
        });

    }
}
