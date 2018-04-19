package com.example.estebanjojoa.quizdosi023214.Parser;

import com.example.estebanjojoa.quizdosi023214.Model.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ESTEBAN JOJOA on 19/04/2018.
 */

public class Json {


    public static List<Users> getData(String content) throws JSONException {

        JSONArray jsonArray = new JSONArray(content);

        List<Users> UsersList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject item = jsonArray.getJSONObject(i);
           JSONObject itemData = item.getJSONObject("address");
            Users users = new Users();
            users.setName(item.getString("name"));
            users.setUsername(item.getString("username"));
            users.setEmail(item.getString("email"));
           users.setStreet(itemData.getString("street"));

            UsersList.add(users);

        }

        return UsersList;


    }

}
