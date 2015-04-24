package com.example.cristian.punto5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;






public class punto5 extends ActionBarActivity {


    int flagGen;
    String sexo;
    static int fYear;
    static int fMonth;
    static int fDay;
    static String cYear;
    static String cMonth;
    static String cDay;
    String strDeporte="";
    String strLectura="";
    String strCine="";
    String strOtros="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punto5);

        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono = (EditText) findViewById(R.id.eTel);
        final TextView tFecha = (TextView) findViewById(R.id.tFecha);
        final TextView tName = (TextView) findViewById(R.id.tNombre);
        final TextView tMail = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel = (TextView) findViewById(R.id.tTelefono);
        final TextView tGen = (TextView) findViewById(R.id.tGenero);
        final TextView tHobbies = (TextView) findViewById(R.id.tHobbies);
        final TextView tCiudad = (TextView) findViewById(R.id.tCiudad);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final Spinner sCiudad = (Spinner) findViewById(R.id.sCiudades);

        final CheckBox cCine = (CheckBox) findViewById(R.id.checkCine);
        final CheckBox cDeportes = (CheckBox) findViewById(R.id.checkDeportes);
        final CheckBox cLectura =  (CheckBox) findViewById(R.id.checkLectura);
        final CheckBox cOtros = (CheckBox) findViewById(R.id.checkOtros);

        Button boton = (Button) findViewById(R.id.bOk);

        final Spinner spinner = (Spinner) findViewById(R.id.sCiudades);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);




        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cDeportes.isChecked()) {
                    //cDeportes.setChecked(false);
                    strDeporte="Deportes";
                }else strDeporte="";

                if (cCine.isChecked()) {
                   // cCine.setChecked(false);
                    strCine="Cine";
                }else strCine="";

                if (cLectura.isChecked()) {
                  //  cLectura.setChecked(false);
                    strLectura="Lectura";
                }else strLectura="";

                if (cOtros.isChecked()) {
               //     cOtros.setChecked(false);
                    strOtros="Otros";
                }else strOtros="";

                switch(flagGen){
                    case 1:
                        tGen.setText(R.string.masculino);
                        break;
                    case 2:
                        tGen.setText(R.string.femenimo);
                        break;
                    default:
                        break;
                }

                int fDay = datePicker.getDayOfMonth();
                int fMonth = datePicker.getMonth() + 1;
                int fYear = datePicker.getYear();

                cYear=String.valueOf(fYear);
                cMonth=String.valueOf(fMonth);
                cDay=String.valueOf(fDay);

                tName.setText(eNombre.getText());
                tMail.setText(eCorreo.getText());
                tTel.setText(eTelefono.getText());
                tFecha.setText(cDay+"/"+cMonth+"/"+cYear);
                tCiudad.setText(sCiudad.getSelectedItem().toString());
                tHobbies.setText(strDeporte+" "+strCine+" "+strLectura+" "+strOtros);
            }
        });

    }

   /* public void check(){


    }*/

        // Check which radio button was clicked
        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.rbMasculino:
                    if (checked)
                        flagGen = 1;
                    break;
                case R.id.rbFemenino:
                    if (checked)
                        flagGen = 2;
                    break;
                default:
                    break;

            }


    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
           return new DatePickerDialog(getActivity(), this, year, month, day);

        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto5, menu);
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
