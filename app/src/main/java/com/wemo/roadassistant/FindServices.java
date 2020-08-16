package com.wemo.roadassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FindServices extends AppCompatActivity {

    private Button generalUser, serProvider, addService, btnMechanic, btnFuel, btnLifter, btnPuncture;
    private Context context;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_services);
        context = this;
        /*mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();*/

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
                Intent intent = new Intent(FindServices.this, FormActivity.class);
                startActivity(intent);
            }
        });
    }

    /*private List<String> fetchCheckBoxData(){
        List<String> listCheckBox = new ArrayList<>();
        for (int i = 0; i <checkBoxData.length() ; i++) {
            listCheckBox.add(checkBoxData.toString());
        }
        return listCheckBox;
    }*/

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