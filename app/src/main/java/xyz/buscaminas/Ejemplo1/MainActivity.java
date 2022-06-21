package xyz.buscaminas.Ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtuno,txtdos,txtsigno;
    Button igualar,sumar,restar,multiplicar,dividir;
    float num1=0,num2=0,resultado=0,accion=0;
    Intent pagina;
    public static boolean validarnumero(String datos){
        return datos.matches("[-][0-9]{1,10}|[0-9]{1,10}|[0-9]{1,10}[.][0-9]{1,10}|[-][0-9]{1,10}[.][0-9]{1,10}");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtuno=(EditText) findViewById(R.id.numero1);
        txtdos=(EditText) findViewById(R.id.numero2);
        txtsigno=(EditText) findViewById(R.id.signo);
        sumar=(Button) findViewById(R.id.suma);
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(validarnumero(txtuno.getText().toString().trim())){
                    if(validarnumero(txtdos.getText().toString().trim())){
                        txtsigno.setText("+");
                        num1=Float.parseFloat(txtuno.getText().toString());
                        num2=Float.parseFloat(txtdos.getText().toString());
                        resultado=num1+num2;
                        accion=1;
                    }
                    else{
                        txtsigno.setText("Operacion");
                    }
                }
                else{
                    txtsigno.setText("Operacion");
                }
            }
        });
        restar=(Button) findViewById(R.id.resta);
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarnumero(txtuno.getText().toString().trim())){
                    if(validarnumero(txtdos.getText().toString().trim())){
                        txtsigno.setText("-");
                        num1=Float.parseFloat(txtuno.getText().toString());
                        num2=Float.parseFloat(txtdos.getText().toString());
                        resultado=num1-num2;
                        accion=1;
                    }
                    else{
                        txtsigno.setText("Operacion");
                        accion=0;
                    }
                }
                else {
                    txtsigno.setText("Operacion");
                    accion=0;
                }
            }
        });
        multiplicar=(Button) findViewById(R.id.multiplica);
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarnumero(txtuno.getText().toString().trim())){
                    if(validarnumero(txtdos.getText().toString().trim())){
                        txtsigno.setText("x");
                        num1=Float.parseFloat(txtuno.getText().toString());
                        num2=Float.parseFloat(txtdos.getText().toString());
                        resultado=num1*num2;
                        accion=1;
                    }
                    else{
                        txtsigno.setText("Operacion");
                        accion=0;
                    }
                }
                else{
                    txtsigno.setText("Operacion");
                    accion=0;
                }
            }
        });
        dividir=(Button) findViewById(R.id.divide);
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarnumero(txtuno.getText().toString().trim())){
                    if(validarnumero(txtdos.getText().toString().trim())){
                        txtsigno.setText("÷");
                        num1=Float.parseFloat(txtuno.getText().toString());
                        num2=Float.parseFloat(txtdos.getText().toString());
                        resultado=num1/num2;
                        accion=1;
                    }
                    else{
                        txtsigno.setText("Operacion");
                        accion=0;
                    }
                }
                else{
                    txtsigno.setText("Operacion");
                    accion=0;
                }
            }
        });
        igualar=(Button) findViewById(R.id.igual);
        igualar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(accion==1){
                    accion=0;
                    pagina=new Intent(getApplicationContext(),MainActivity2.class);
                    pagina.putExtra("resultado",resultado);
                    startActivity(pagina);
                }
            }
        });
    }
}