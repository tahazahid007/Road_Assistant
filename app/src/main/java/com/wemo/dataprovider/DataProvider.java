package com.wemo.dataprovider;

import com.wemo.model.UserForm;
import com.wemo.roadassistant.FindServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static List<UserForm> userFormsItemList;
    public static Map<String,UserForm> dataItemMap;
    public static UserForm user;

    static {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        user = new UserForm();
        userFormsItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();


        addItem(new UserForm(null,
                FindServices.et_fullname.getText().toString(),
                FindServices.et_cnic.getText().toString(),
                FindServices.et_phone.getText().toString(),
                FindServices.et_shop_area.getText().toString(),
                FindServices.et_shop_name.getText().toString(),
                FindServices.et_shop_address.getText().toString(),
                FindServices.et_working_hours.getText().toString(),
                FindServices.et_email_address.getText().toString(),
                FindServices.et_map_latitude.getText().toString(),
                FindServices.et_map_longitude.getText().toString(),
                FindServices.spin.getSelectedItem().toString(),
                FindServices.checkBoxText.toString()));
    }

    private static void addItem(UserForm cityDataItem){
        userFormsItemList.add(cityDataItem);
        dataItemMap.put(user.getId(), cityDataItem);
    }
}
