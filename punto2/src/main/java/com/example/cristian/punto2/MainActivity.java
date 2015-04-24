package com.example.cristian.punto2;

import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    int opc=0;
    float num1;
    float num2;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        final TextView eResultado = (TextView) findViewById(R.id.tResultado);
        final EditText eNumero1 = (EditText) findViewById(R.id.eNum1);
        final EditText eNumero2 = (EditText) findViewById(R.id.eNum2);

        Button bCalcular = (Button) findViewById(R.id.bCalcular);


       bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (eNumero1.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "No ingresaste el número 1", Toast.LENGTH_LONG).show();
                    opc=0;
                    return;
                }

                else if (eNumero2.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "No ingresaste el número 2", Toast.LENGTH_LONG).show();
                    opc=0;
                    return;
                }

                else {
                    num1 = Float.parseFloat(eNumero1.getText().toString());
                    num2 = Float.parseFloat(eNumero2.getText().toString());
                    switch (opc) {
                        case 1:
                            result = num1 + num2;
                            eResultado.setText(Float.toString(result));
                            break;
                        case 2:
                            result = num1 - num2;
                            eResultado.setText(Float.toString(result));
                            break;
                        case 3:
                            result = num1 * num2;
                            eResultado.setText(Float.toString(result));
                            break;
                        case 4:
                            result = num1 / num2;
                            eResultado.setText(Float.toString(result));
                            break;
                        default:
                            break;

                    }
                }
            }

        });

    }
    //fin onCreate

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.rSumar:

                    if (checked)
                        opc=1;
                    break;
                case R.id.rRestar:
                    if (checked)
                        opc=2;
                    break;
                case R.id.rMultiplicar:
                    if (checked)
                        opc=3;
                    break;
                case R.id.rDividir:
                    if (checked)
                        opc=4;
                    break;
            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
