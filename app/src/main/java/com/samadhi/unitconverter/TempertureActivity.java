package com.samadhi.unitconverter;

import static android.icu.text.ListFormatter.Type.AND;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class TempertureActivity extends AppCompatActivity {

    Spinner convertFrom;
    Spinner convertTo;
    Button convert;
    EditText editTextTemp;
    TextView result;
    String[] unitTypes = {"Celcius","Fahrenheit","Kelvin"};
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperture);

        setSupportActionBar(toolbar);

        convertFrom = (Spinner) findViewById(R.id.spinnerConvertFrom);
        convertTo = (Spinner) findViewById(R.id.spinnerConvertTo);
        convert = (Button) findViewById(R.id.btnTempConverter);
        editTextTemp = (EditText) findViewById(R.id.editTextTemp);
        result = (TextView) findViewById(R.id.tvTempResult);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(TempertureActivity.this, android.R.layout.simple_list_item_1,unitTypes);

        convertFrom.setAdapter(spinnerAdapter);
        convertTo.setAdapter(spinnerAdapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double beginingQty;
                double endingQty;
                String beginingUnitType;
                String endingUnitType;

                Temperture_Conversion tempConverter = new Temperture_Conversion();



                if(!editTextTemp.getText().toString().equals("")){

                    beginingUnitType = convertFrom.getSelectedItem().toString();
                    endingUnitType = convertTo.getSelectedItem().toString();
                    beginingQty = Double.parseDouble(editTextTemp.getText().toString());

                    tempConverter.setBeginingQty(beginingQty);
                    tempConverter.setBeginingUnitType(beginingUnitType);
                    tempConverter.setEndingUnitType(endingUnitType);

                    if (beginingUnitType == endingUnitType){
                        Toast.makeText(getApplicationContext(),"Source unit and Destination unit are same",Toast.LENGTH_LONG ).show();
                        result.setText("");
                    }else {

                        if ((beginingUnitType == "Celcius") && (endingUnitType == "Fahrenheit")){
                            endingQty = tempConverter.convertCelsiustoFahrenheit();
                            tempConverter.setEndingQty(endingQty);
                            result.setText(tempConverter.toString());

                        } else if ((beginingUnitType == "Celcius") && (endingUnitType == "Kelvin")){
                            endingQty = tempConverter.convertCelsiustoKelvin();
                            tempConverter.setEndingQty(endingQty);
                            result.setText(tempConverter.toString());

                        }else if ((beginingUnitType == "Fahrenheit") && (endingUnitType == "Celcius")){
                            endingQty = tempConverter.convertFahrenheittoCelsius();
                            tempConverter.setEndingQty(endingQty);
                            result.setText(tempConverter.toString());

                        }else if ((beginingUnitType == "Fahrenheit") && (endingUnitType == "Kelvin")){
                            endingQty = tempConverter.convertFahrenheittoKelvin();
                            tempConverter.setEndingQty(endingQty);
                            result.setText(tempConverter.toString());

                        }else if ((beginingUnitType == "Kelvin") && (endingUnitType == "Celcius")){
                            endingQty = tempConverter.convertKelvintoCelsius();
                            tempConverter.setEndingQty(endingQty);
                            result.setText(tempConverter.toString());

                        }else if ((beginingUnitType == "Kelvin") && (endingUnitType == "Fahrenheit")){
                            endingQty = tempConverter.convertKelvintoFahrenheit();
                            tempConverter.setEndingQty(endingQty);
                            result.setText(tempConverter.toString());
                        }


                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Enter the Temperature to process",Toast.LENGTH_LONG ).show();
                    result.setText("");
                }

            }

        });
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getSupportActionBar().setTitle("Temperture Conversion");

    }
}