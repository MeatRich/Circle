package qwe.circle;


import android.content.Intent;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Locale;

import android.view.View.OnClickListener;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.app.Activity;

/**
 * Created by Лёка^_^ on 20.10.2017.
 */

public class User extends Activity implements OnClickListener {

    public ArrayList <Circle> firstStage;
    public ArrayList <Circle> fourthStage;
    public ArrayList <Circle> secondStage;
    public ArrayList <Circle> thirdStage;
    public String sex;
    public String arm;
    public Date age;
    public String patronymic;
    public String name;
    public String surname;

    String[] optionSex = {"Мужской", "Женский"};
    String[] optionArm = {"Правая", "Левая"};

    Button newTest, save;
    SharedPreferences sPref, sPref1, sPref2, sPref3;

    EditText nameActivity, surnameActivity, patronymicActivity, birthdayActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, optionSex);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner3);
        spinner.setAdapter(adapter);
        // выделяем элемент
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ваш выбор: " + optionSex[selectedItemPosition], Toast.LENGTH_SHORT);
                toast.show();
                sex = spinner.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        // адаптер
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, optionArm);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner4);
        spinner1.setAdapter(adapter1);
        // выделяем элемент
        spinner1.setSelection(0);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ваш выбор: " + optionArm[selectedItemPosition], Toast.LENGTH_SHORT);
                toast.show();
                arm = spinner.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        surnameActivity = (EditText) findViewById(R.id.editText7);
        nameActivity = (EditText) findViewById(R.id.editText8);
        patronymicActivity = (EditText) findViewById(R.id.editText9);
        birthdayActivity = (EditText) findViewById(R.id.editText10);

        newTest = (Button) findViewById(R.id.button4);
        newTest.setOnClickListener(this);

        save = (Button) findViewById(R.id.button5);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                Intent intent = new Intent(User.this, UserTest.class);
                startActivity(intent);
                break;
            case R.id.button5:
                saveText();
                break;
            default:
                break;
        }
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString(surname, surnameActivity.getText().toString());
        ed.commit();
        sPref1 = getPreferences(MODE_PRIVATE);
        Editor ed1 = sPref1.edit();
        ed1.putString(name, nameActivity.getText().toString());
        ed1.commit();
        sPref2 = getPreferences(MODE_PRIVATE);
        Editor ed2 = sPref2.edit();
        ed2.putString(patronymic, patronymicActivity.getText().toString());
        ed2.commit();
        String birthday = new String();
        sPref3 = getPreferences(MODE_PRIVATE);
        Editor ed3 = sPref3.edit();
        ed3.putString(birthday, birthdayActivity.getText().toString());
        ed3.commit();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            age = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();// вывод сообщения, что текст сохранён
    }
}
