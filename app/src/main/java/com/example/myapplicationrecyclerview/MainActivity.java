package com.example.myapplicationrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //datos
        final String[] datos =
                new
                        String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        final String[] listaAlumnos =
                new
                        String[]{"WENDY MARGOTH ACOSTA MESTANZA","ALLISSON ANDREA ACURIO BUSTAMANTE",
                                 "DARLEY STEVEN ALAVA LARA","ANDERSON GUSTAVO ANDRADE CORONADO",
                                 "KEVIN ANDRES BELTRAN ESPINOZA","EDISON MICHAEL CACERES RIVAS",
                                 "MARVIN JOEL CADENA TOALA","FERNANDO SAMUEL CHANG LITARDO",
                                 "ANGIE JAMILLE CORTEZ CHICHANDE","WILLIAM RAMON DOICELA AYALA"};

        //adaptador
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);


        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, listaAlumnos);


        //asignar el adaptador a la vista
        Spinner cmbOpciones = (Spinner)findViewById(R.id.cbListaOP);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);
        cmbOpciones.setOnItemSelectedListener(this);


        ListView lstOpciones = (ListView)findViewById(R.id.lstLISTA);
        lstOpciones.setAdapter(adaptador2);
        lstOpciones.setOnItemClickListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView txtItem =
                (TextView)findViewById(R.id.txtItem);
        txtItem.setText("Seleccionado: " + adapterView.getItemAtPosition(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        TextView txtItem =
                (TextView)findViewById(R.id.txtItem);
        txtItem.setText("Alumno seleccionado es: " + adapterView.getItemAtPosition(i));


    }
}