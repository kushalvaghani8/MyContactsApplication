package com.example.mycontactsapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> myContactsResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        ListView mContactList = (ListView) findViewById(R.id.contactListView);
        ContactList first = new ContactList("test");
        ContactList second = new ContactList("test 2");
      //  ContactList third = new ContactList("test","test", 12333434);

        ArrayList<ContactList> contacts = new ArrayList<>();
        contacts.add(first);
        contacts.add(second);
     //   contacts.add(third);
        ArrayList<String> contactsStrings = new ArrayList<>();

        contactsStrings.add("Test");
        contactsStrings.add("Test2");
        contactsStrings.add("Test3");
        contactsStrings.add("Test4");
        ArrayAdapter contactAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, contactsStrings);
        mContactList.setAdapter(contactAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intentAdd = new Intent(this, AddContact.class);
                startActivity(intentAdd);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}