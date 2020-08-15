package com.wemo.roadassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class FindServices extends AppCompatActivity {

    private Button generalUser, serProvider, addService, btnSubmit, btnMechanic, btnFuel, btnLifter, btnPuncture;
    private Context context;
    private Spinner spin;
    private ArrayAdapter aa;
    private EditText et_fullname, et_cnic, et_phone, et_shop_area, et_shop_name, et_shop_address, et_working_hours, et_email_address
            , et_map_latitude, et_map_longitude;
    private CheckBox one, two, three, four, five, six;

    private String[] services = { "Car Mechanic", "Puncture Shop", "Fuel Station", "Vehicle Lifter"};

    private StringBuilder checkBoxData;

    private List<String> allData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_services);
        context = this;
        aa = new ArrayAdapter(context,android.R.layout.simple_spinner_item,services);
        allData = new ArrayList<>();
        checkBoxData = new StringBuilder();

        initView();
    }

    private void initView() {
        generalUser = findViewById(R.id.genUser);
        serProvider = findViewById(R.id.serProvider);
        addService = findViewById(R.id.addSerProvider);

        generalUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(context);
            }
        });

        serProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Login Page wala kam hoga", Toast.LENGTH_SHORT).show();
            }
        });

        addService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.user_form);
                initViewsForm();
            }
        });
    }

    private void initViewsForm() {
        et_fullname = findViewById(R.id.et_fullname);
        et_cnic = findViewById(R.id.et_cnic);
        et_phone = findViewById(R.id.et_phone);
        et_shop_area = findViewById(R.id.et_shop_area);
        et_shop_name = findViewById(R.id.et_shop_name);
        et_shop_address = findViewById(R.id.et_shop_address);
        et_working_hours = findViewById(R.id.et_working_hours);
        et_email_address = findViewById(R.id.et_email_address);
        et_map_latitude = findViewById(R.id.et_map_latitude);
        et_map_longitude = findViewById(R.id.et_map_longitude);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        btnSubmit = findViewById(R.id.btn_submit);
        spin = findViewById(R.id.sp_type);
        AdapterView.OnItemSelectedListener adapterOnItemListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(getApplicationContext(),services[position] , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spin.setOnItemSelectedListener(adapterOnItemListener);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "DB ka Structure bnana hai with Firebase", Toast.LENGTH_SHORT).show();
                allData.add(et_fullname.getText().toString());
                allData.add(et_cnic.getText().toString());
                allData.add(et_phone.getText().toString());
                allData.add(et_shop_area.getText().toString());
                allData.add(et_shop_name.getText().toString());
                allData.add(et_shop_address.getText().toString());
                allData.add(et_working_hours.getText().toString());
                allData.add(et_email_address.getText().toString());
                allData.add(et_map_latitude.getText().toString());
                allData.add(et_map_longitude.getText().toString());
                allData.add(checkBox().toString());
                allData.add(spin.getSelectedItem().toString());

                Log.d("myTag", "onClick: " + allData);

            }
        });
    }

    private StringBuilder checkBox() {
        if(one.isChecked()){
            checkBoxData.append("Fuel ");
        }if(two.isChecked()){
            checkBoxData.append("\nPuncture ");
        }if(three.isChecked()){
            checkBoxData.append("\nMechanic ");
        }if(four.isChecked()){
            checkBoxData.append("\nCar Lifting ");
        }if(five.isChecked()){
            checkBoxData.append("\nAll Services of Bike ");
        }if(six.isChecked()){
            checkBoxData.append("\nAll Services of Car ");
        }
        return checkBoxData;
    }

    public void showDialog(Context context) {
        /***Is dialog main User k click lgne hain js main Map open hoga***/
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();
        initViewDialog(dialog);
    }

    private void initViewDialog(Dialog dialog) {
        btnMechanic = dialog.findViewById(R.id.btn_mechanic);
        btnFuel = dialog.findViewById(R.id.btn_petrol);
        btnLifter = dialog.findViewById(R.id.btn_lifter);
        btnPuncture = dialog.findViewById(R.id.btn_puncture);

        btnMechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindServices.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        btnFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindServices.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        btnLifter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindServices.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        btnPuncture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindServices.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}