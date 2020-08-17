package com.wemo.roadassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;

import com.wemo.database.MyDBHandler;
import com.wemo.model.UserForm;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderData extends AppCompatActivity {
    private MyDBHandler myDBHandler;
    private List<UserForm> userFormsList;
    private List<UserForm> userList;
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private UserForm userForm;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_data);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        context = this;
        myDBHandler = new MyDBHandler(context);
        userFormsList = myDBHandler.getAllUser();
        userList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mAdapter = new MyAdapter(userFormsList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        /*LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);*/

        prepareMovieData();
    }

    private void prepareMovieData() {
        /*String name, shopName, shopAddress;
        name = userForm.getFullName();
        shopName = userForm.getShopName();
        shopAddress = userForm.getShopAddress();

        UserForm userForm = new UserForm(name,shopName,shopAddress);
//        UserForm listUser = new UserForm(userForm.getFullName(),userForm.getShopName() ,userForm.getShopAddress() );

//        UserForm userForm = new UserForm("Nazir", "Nazir Appratus", "Colony Gate");*/

        for (UserForm item: userFormsList) {
            userList.add(item);

        }

        mAdapter.notifyDataSetChanged();
    }
}