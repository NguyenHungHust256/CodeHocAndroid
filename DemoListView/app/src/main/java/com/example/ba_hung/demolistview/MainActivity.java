package com.example.ba_hung.demolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ContactModel> arrContacts = new ArrayList<>();
    private ListView lstContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        lstContact = (ListView) findViewById(R.id.lst_contact);
        ContactAdapter adapter = new ContactAdapter(this, arrContacts);

        lstContact.setAdapter(adapter);
    }

    private void initialData()
    {
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us1));
        arrContacts.add(new ContactModel("Nguyen Hoang Huy", "01695932469",R.drawable.us2));
        arrContacts.add(new ContactModel("Phan Thi Nhu", "01695932469",R.drawable.us3));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us4));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us5));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us6));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us7));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us8));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us9));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us10));
        arrContacts.add(new ContactModel("Nguyen Ba Hung", "01695932469",R.drawable.us8));


    }
}
