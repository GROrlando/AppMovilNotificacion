package com.example.appicomm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appicomm.interfaces.UsuarioApi;
import com.example.appicomm.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView Id;
    TextView Nombre;
    TextView Password;
    TextView Email;
    Button btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edcodigo);
        Id=findViewById(R.id.Id);
        Nombre=findViewById(R.id.Nombre);
        Password=findViewById(R.id.Password);
        Email=findViewById(R.id.Email);
        btnBuscar=findViewById(R.id.sendRequest);


        //GENERAMOS EL EVENTO DEL BOTON BUSCAR USUARIOS
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find(editText.getText().toString());


            }
        });

    }

    private void find(String codigo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:44340/api/Videos/")
                .addConverterFactory(GsonConverterFactory.create()).build() ;//insertar URL Dde nuestra API

        UsuarioApi UsuarioApi = retrofit.create(UsuarioApi.class);
        Call<Usuario> call = UsuarioApi.find(codigo);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario>call, Response<Usuario>response) {
                try {

                    if (response.isSuccessful()) {
                        Usuario p=response.body();
                        String URL_IMG="http://localhost:44340/api/Videos/"+p.getId()+"jpg";
                        Id.setText(p.getId());
                        Nombre.setText(p.getNombre());
                        Password.setText(p.getPassword());
                        Email.setText(p.getEmail());

                    }

                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexion", Toast.LENGTH_SHORT).show();

            }
        });

//        call.enqueue(new Callback<List<String>>() {
//                         @Override
//                         public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                             try{
//                                 if (response.isSuccessful()) {
//                                     List<String> p=response.body();
//                                     Nombre.setText(p.);
//                                 }
//                             }
////
////                             try {
////
////                                 if (response.isSuccessful()){
////                                     List<String> p= response.body();
////                                              String URL_IMG="https://localhost:44305/api"+p.get(getTaskId())+",jpg";
////                                              Nombre.setText(p.get());
////
////                                 }
////
////                             }
//                             catch (Exception ex){
//                                 Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//                             }
//                            // TextView text = findViewById(R.id.Result);
//                            // for(String post : response.body()) {
//                            //     text.setText(text.getText() + post);
//                             //}
//                         }
//                         @Override
//                         public void onFailure(Call<List<String>> call, Throwable t) {
//                         }
//                     }
//                     );
    }
}
