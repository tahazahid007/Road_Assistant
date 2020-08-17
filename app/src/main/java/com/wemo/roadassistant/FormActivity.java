package com.wemo.roadassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.wemo.database.MyDBHandler;
import com.wemo.model.UserForm;

import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    private Spinner spin;
    private StringBuilder checkBoxData;
    private List<String> allData;
    private ArrayAdapter aa;
    private EditText et_fullname, et_cnic, et_phone, et_shop_area, et_shop_name, et_shop_address, et_working_hours, et_email_address, et_map_latitude, et_map_longitude;
    private CheckBox one, two, three, four, five, six;
    private String[] services = { "Car Mechanic", "Puncture Shop", "Fuel Station", "Vehicle Lifter"};
    private Button btnSubmit;
    private Context context;

    public MyDBHandler myDBHandler;
    public UserForm userForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_form);
        context = this;
        aa = new ArrayAdapter(context,android.R.layout.simple_spinner_item,services);
        allData = new ArrayList<>();
        checkBoxData = new StringBuilder();
        myDBHandler = new MyDBHandler(context);
        userForm = new UserForm();
        myDBHandler = new MyDBHandler(context);
        userForm = new UserForm();


        initViewsForm();
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
//                Toast.makeText(context, "DB ka Structure bnana hai with Firebase", Toast.LENGTH_SHORT).show();

                if(et_fullname.getText().toString().isEmpty()){
                    allData.add(et_fullname.getText().toString());
                }
                else {
                    assert et_fullname != null;
                    et_fullname.setError("Please Enter your Name");
                }

                if(et_cnic.getText().toString().isEmpty()){
                    allData.add(et_cnic.getText().toString());
                }
                else {
                    assert et_cnic != null;
                    et_cnic.setError("Please Enter your CNIC");
                }

                if(et_phone.getText().toString().isEmpty()){
                    allData.add(et_phone.getText().toString());
                }else {
                    assert et_phone != null;
                    et_phone.setError("Please Enter your Mobile Number");
                }

                if(et_shop_area.getText().toString().isEmpty()){
                    allData.add(et_shop_area.getText().toString());
                }
                else {
                    assert et_shop_area != null;
                    et_shop_area.setError("Please Enter Area of Shop");
                }

                if(et_shop_name.getText().toString().isEmpty()){
                    allData.add(et_shop_name.getText().toString());
                }else {
                    assert et_shop_name != null;
                    et_shop_name.setError("Please Enter Shop Name");
                }

                if(et_shop_address.getText().toString().isEmpty()){
                    allData.add(et_shop_address.getText().toString());
                }else {
                    assert et_shop_address != null;
                    et_shop_address.setError("Please Enter Shop Address");
                }

                if(et_working_hours.getText().toString().isEmpty()){
                    allData.add(et_working_hours.getText().toString());
                }else {
                    assert et_working_hours != null;
                    et_working_hours.setError("Please Enter your Working Hours");
                }

                if(et_email_address.getText().toString().isEmpty()){
                    allData.add(et_email_address.getText().toString());
                }else {
                    assert et_email_address != null;
                    et_email_address.setError("Please Enter you Email");
                }

                if(et_map_latitude.getText().toString().isEmpty()){
                    allData.add(et_map_latitude.getText().toString());
                }else {
                    assert et_map_latitude != null;
                    et_map_latitude.setError("Please Enter your Location Latitude");
                }

                if(et_map_longitude.getText().toString().isEmpty()){
                    allData.add(et_map_longitude.getText().toString());
                }else {
                    assert et_map_longitude != null;
                    et_map_longitude.setError("Please Enter your Location Longitude");
                }

                if(one.isChecked()
                        || two.isChecked()
                        || three.isChecked()
                        || four.isChecked()
                        || five.isChecked()
                        || six.isChecked())
                {
                    allData.add(checkBox().toString());
                }else {
                    one.setError("Please Select");
                    two.setError("Please Select");
                    three.setError("Please Select");
                    four.setError("Please Select");
                    five.setError("Please Select");
                    six.setError("Please Select");
                }

                allData.add(spin.getSelectedItem().toString());

                Log.d("myTag", "onClick: " + allData);
//                mRef.setValue(allData.get(0).toString());

                //creating data for DB
                userForm.setFullName(et_fullname.getText().toString());
                userForm.setCnic(et_cnic.getText().toString());
                userForm.setPhoneNumber(et_phone.getText().toString());
                userForm.setShopArea(et_shop_area.getText().toString());
                userForm.setShopName(et_shop_name.getText().toString());
                userForm.setShopAddress(et_shop_address.getText().toString());
                userForm.setWorkingHours(et_working_hours.getText().toString());
                userForm.setEmailAddress(et_email_address.getText().toString());
                userForm.setLatitude(et_map_latitude.getText().toString());
                userForm.setLongitude(et_map_longitude.getText().toString());
                userForm.setServiceOffer(checkBox().toString());
                userForm.setShopType(spin.getSelectedItem().toString());

                if(btnSubmit.isPressed()
                        && !et_fullname.getText().toString().isEmpty()
                        && !et_cnic.getText().toString().isEmpty()
                        && !et_phone.getText().toString().isEmpty()
                        && !et_shop_area.getText().toString().isEmpty()
                        && !et_shop_name.getText().toString().isEmpty()
                        && !et_shop_address.getText().toString().isEmpty()
                        && !et_working_hours.getText().toString().isEmpty()
                        && !et_email_address.getText().toString().isEmpty()
                        && !et_map_latitude.getText().toString().isEmpty()
                        && !et_map_longitude.getText().toString().isEmpty()
                        && !checkBox().toString().isEmpty()
                        && !spin.getSelectedItem().toString().isEmpty())
                {
                    //adding data in DB
                    myDBHandler.addUser(userForm);
                    setContentView(R.layout.activity_find_services);
                }
                else {
                    et_fullname.setError("Please Enter your Name");
                    et_cnic.setError("Please Enter your CNIC");
                    et_phone.setError("Please Enter your Mobile Number");
                    et_shop_area.setError("Please Enter your Shop Area");
                    et_shop_name.setError("Please Enter your Shop Name");
                    et_shop_address.setError("Please Enter your Shop Address");
                    et_working_hours.setError("Please Enter your Working Hours");
                    et_email_address.setError("Please Enter your Email");
                    et_map_latitude.setError("Please Enter your Shop Location Latitude");
                    et_map_longitude.setError("Please Enter your Shop Location Longitude");
                    Toast.makeText(context, "Please fill this Form", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private StringBuilder checkBox() {
        if(one.isChecked()){
            checkBoxData.append("Fuel ");
        }if(two.isChecked()){
            checkBoxData.append("Puncture ");
        }if(three.isChecked()){
            checkBoxData.append("Mechanic ");
        }if(four.isChecked()){
            checkBoxData.append("Car Lifting ");
        }if(five.isChecked()){
            checkBoxData.append("All Services of Bike ");
        }if(six.isChecked()){
            checkBoxData.append("All Services of Car ");
        }
        return checkBoxData;
    }
}