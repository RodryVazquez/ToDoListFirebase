package com.example.rodrigo.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends AppCompatActivity {

    EditText edtInputPhone,edtInputName;
    Button btnAddContact;
    ListView lstContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        edtInputPhone = (EditText)findViewById(R.id.edtInputPhone);
        edtInputName = (EditText)findViewById(R.id.edtInputName);
        btnAddContact = (Button)findViewById(R.id.btnAddContact);
        lstContactList = (ListView)findViewById(R.id.lstContactList);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
