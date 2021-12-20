package com.example.belleza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author cristian
 */
public class MainActivity1 extends AppCompatActivity {

    Button botonGET;
    TextView mostrarJSON;

    @Override
    protected void onCreate(Bundle savInstanSt) {
        super.onCreate(savInstanSt);
        setContentView(R.layout.activity_main1);

        botonGET = (Button) findViewById(R.id.botonGET);
        mostrarJSON = (TextView) findViewById(R.id.mostrarJSON);

        botonGET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lladoGET();
            }
        });
    }

    private void lladoGET() {
        String url = "https://g4b38bc80046af7-db202112192146.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/tabla/tabla";


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        mostrarJSON.setText(jsonObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    //Metodo para mostrar y ocultar el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    //Metodo para asignar las funciones correspondientes a las opciones.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int identf= item.getItemId();

        if (identf == R.id.id_productos){
            Toast.makeText(getApplicationContext(), "Seleccion Productos", Toast.LENGTH_SHORT).show();
            Intent segundaPantalla = new Intent(this,MainActivity2.class);
            startActivity(segundaPantalla);
        } else if(identf == R.id.id_servicios){
            Toast.makeText(getApplicationContext(), "Seleccion Servicios", Toast.LENGTH_SHORT).show();
            Intent terceraPantalla = new Intent(this, MainActivity3.class);
            startActivity(terceraPantalla);
        } else if(identf == R.id.id_sucursales){
            Toast.makeText(getApplicationContext(), "Seleccion Sucursales", Toast.LENGTH_SHORT).show();
            Intent cuartaPantalla = new Intent(this,MainActivity4.class);
            startActivity(cuartaPantalla);
        }
        return super.onOptionsItemSelected(item);
    }
}