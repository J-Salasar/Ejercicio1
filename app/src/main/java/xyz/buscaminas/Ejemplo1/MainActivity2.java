package xyz.buscaminas.Ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText txtresultado;
    Button regresar;
    Intent pagina2;
    float extraer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtresultado=(EditText) findViewById(R.id.respuesta);
        extraer=getIntent().getExtras().getFloat("resultado");
        txtresultado.setText(String.valueOf(extraer));
        regresar=(Button) findViewById(R.id.atras);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagina2=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(pagina2);
            }
        });
    }
}