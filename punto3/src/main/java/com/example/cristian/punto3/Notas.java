package com.example.cristian.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Notas extends ActionBarActivity {

    //Variables donde se guardarán las notas y la calificación final
    int flagMas5=0;
    float quices, exposiciones, practicas, proyecto, notaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas);

        final EditText ebQuices = (EditText) findViewById(R.id.eQuices);
        final EditText ebExpos = (EditText) findViewById(R.id.eExpos);
        final EditText ebPracticas =  (EditText) findViewById(R.id.ePracticas);
        final EditText ebProyecto =  (EditText) findViewById(R.id.eProyecto);
        final TextView tbResultado = (TextView) findViewById(R.id.tNotaFinal);

        Button bbCalcular = (Button) findViewById(R.id.bCalcular);

        bbCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ebQuices.getText().toString().matches("")) {
                    Toast.makeText(Notas.this, "Ingrese la nota correspondiente a los quices", Toast.LENGTH_LONG).show();
                     return;
                }

                else if (ebExpos.getText().toString().matches("")) {
                    Toast.makeText(Notas.this, "Ingrese la nota correspondiente a las exposiciones", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (ebPracticas.getText().toString().matches("")) {
                    Toast.makeText(Notas.this, "Ingrese la nota correspondiente a las prácticas de laboratorio", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (ebProyecto.getText().toString().matches("")) {
                    Toast.makeText(Notas.this, "Ingrese la nota correspondiente al proyecto", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    quices = Float.parseFloat(ebQuices.getText().toString());
                    exposiciones = Float.parseFloat(ebExpos.getText().toString());
                    practicas = Float.parseFloat(ebPracticas.getText().toString());
                    proyecto = Float.parseFloat(ebProyecto.getText().toString());

                    if (quices > 5 || exposiciones > 5 || practicas > 5 || proyecto > 5){
                        Toast.makeText(Notas.this, "Las notas deben ser iguales o menores a 5", Toast.LENGTH_SHORT).show();
                        flagMas5=1;
                        return;
                    }

                    else if(quices < 0 || exposiciones < 0 || practicas < 0 || proyecto < 0){
                        Toast.makeText(Notas.this, "Las notas constan de números positivos", Toast.LENGTH_SHORT).show();
                        flagMas5=1;
                        return;
                    }

                    else flagMas5=0;

                    if(flagMas5==0){
                        notaFinal=(float)(0.15*quices+0.1*exposiciones+0.4*practicas+0.35*proyecto);
                        tbResultado.setText(Float.toString(notaFinal));
                    }

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notas, menu);
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
