package com.example.assignment7;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
public class MainActivity extends AppCompatActivity {
 String BASE_URL = "http://192.168.1.131:4001/api/v1/";
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 Button b2 = findViewById(R.id.submitButton);
 b2.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 TextView user = findViewById(R.id.emailText);
 TextView email = findViewById(R.id.emailText);
 TextView message = findViewById(R.id.messageText);
 final DataModel model = new
DataModel(user.getText().toString(),email.getText().toString(),message.getText().toString());
 postDetails(model);
 }
 } );
 }
 protected void postDetails(DataModel current_model) {
 Retrofit retrofit = new Retrofit.Builder()
 .baseUrl(BASE_URL)
 .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to
directly convert json data to object
 .build();
 APIService apiService = retrofit.create(APIService.class);

apiService.postData(current_model.getUser(),current_model.getEmail(),current_model.getValue()).enqueue(new
Callback<POST>() {
 @Override
 public void onResponse(Call<POST> call, Response<POST> response) {
 Toast.makeText(getApplicationContext(), "Message Submitted Successfully",
Toast.LENGTH_SHORT).show();
 clearData();
 }
 @Override
 public void onFailure(Call<POST> call, Throwable t) {
 Toast.makeText(getApplicationContext(), "Message Submitted Successfully",
Toast.LENGTH_SHORT).show();
 clearData();
 }
 });
 //Button CLick Event
 }
 protected void clearData()
 {
 TextView email = findViewById(R.id.emailText);
 TextView message = findViewById(R.id.messageText);
 //email.setText("");
 message.setText("");
 }
}
