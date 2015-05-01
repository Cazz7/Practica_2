package com.example.cristian.p4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class calcularArea extends ActionBarActivity {

    //variables que almacenan los datos que se obtienen desde la interfaz
    Double area,lado1;
    TextView toArea;
    //bandera

    int opc=0;
    double aux,aux2,aux3;
    //*******************************//**************************************//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_area);

        //Instanciación
        final EditText eoBase = (EditText)findViewById(R.id.eBase);
        final EditText eoAltura= (EditText)findViewById(R.id.eAltura);
        final EditText eoRadio= (EditText)findViewById(R.id.eRadio);
        final EditText eoLado1= (EditText)findViewById(R.id.eLado1);
        final EditText eoLado2= (EditText)findViewById(R.id.eLado2);
        toArea= (TextView)findViewById(R.id.tResultado);

        Button bCalcular = (Button)findViewById(R.id.bCalcular);
        //***********************************//***************************
        //Listener
        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (opc){
                    case 1:
                        if( eoLado1.getText().toString().length() == 0 ) {
                           eoLado1.setError(getResources().getString(R.string.errorLadoCuadrado));
                        }
                        else{
                            lado1 =Double.parseDouble(eoLado1.getText().toString());
                            toArea.setText(Double.toString(Math.pow(lado1,2)));
                        }
                        break;
                    case 2:
                        if( eoAltura.getText().toString().length() == 0 ) {
                            eoAltura.setError(getResources().getString(R.string.errorAlturaTriangulo));
                        }
                        else if(eoBase.getText().toString().length() == 0) {
                            eoBase.setError(getResources().getString(R.string.errorBaseTriangulo));
                        }
                        else{
                            aux =(Double.parseDouble(eoBase.getText().toString()))*(Double.parseDouble(eoAltura.getText().toString()));
                            toArea.setText(Double.toString(aux/2));
                        }
                        break;
                    case 3:
                        if( eoRadio.getText().toString().length() == 0 ) {
                            eoRadio.setError(getResources().getString(R.string.errorRadioCirculo));
                        }
                        else{
                            aux2 =(Math.PI)*(Math.pow(Double.parseDouble(eoRadio.getText().toString()),2));
                            toArea.setText(Double.toString(aux2));
                        }
                        break;
                    case 4:


                        if( eoLado1.getText().toString().length() == 0 ) {
                           eoLado1.setError(getResources().getString(R.string.errorLargoRectangulo));
                        }
                        else if(eoLado2.getText().toString().length() == 0) {
                            eoLado2.setError(getResources().getString(R.string.errorAnchoRectangulo));
                        }
                        else{
                            aux3 =(Double.parseDouble(eoLado1.getText().toString()))*(Double.parseDouble(eoLado2.getText().toString()));
                            toArea.setText(Double.toString(aux3));
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("YourTextViewTextIdentifier", toArea.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        toArea.setText(savedInstanceState.getString("YourTextViewTextIdentifier"));
    }

    //Método llamado por el onRdioButtonClicked
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked

        switch (view.getId()) {
            case R.id.rbCuadrado:

                if (checked)
                    opc=1;
                break;
            case R.id.rbTriangulo:
                if (checked)
                    opc=2;
                break;
            case R.id.rbCirculo:
                if (checked)
                    opc=3;
                break;
            case R.id.rbRectangulo:
                if (checked)
                    opc=4;
                break;
            default:
                break;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calcular_area, menu);
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
