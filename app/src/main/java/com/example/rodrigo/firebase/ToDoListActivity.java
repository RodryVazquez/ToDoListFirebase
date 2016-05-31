package com.example.rodrigo.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;

import Models.ContactModel;

public class ToDoListActivity extends AppCompatActivity {

    EditText edtInputPhone,edtInputName;
    Button btnAddContact;
    ListView lstContactList;
    Firebase mRef;
    private static final String urlPartial = "contactList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        edtInputPhone = (EditText)findViewById(R.id.edtInputPhone);
        edtInputName = (EditText)findViewById(R.id.edtInputName);
        btnAddContact = (Button)findViewById(R.id.btnAddContact);
        lstContactList = (ListView)findViewById(R.id.lstContactList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRef = new Firebase(getResources().getString(R.string.baseUrl) + urlPartial);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtInputName.length() > 0 && edtInputPhone.length() > 0){
                    //Guardamos en firebase
                    ContactModel mContactModel = new ContactModel(edtInputPhone.getText().toString(),edtInputName.getText().toString());
                    mRef.push().setValue(mContactModel);
                    edtInputName.setText("");
                    edtInputPhone.setText("");
                }else{
                    Toast.makeText(ToDoListActivity.this, "Los campos son requeridos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Firebase adapter
        FirebaseListAdapter<ContactModel>adapter
                = new FirebaseListAdapter<ContactModel>(this,ContactModel.class,R.layout.to_do_list_adapter,mRef) {
            @Override
            protected void populateView(View view, ContactModel contactModel, int i) {
                ((TextView) view.findViewById(R.id.txtNameAdapter)).setText(contactModel.getName());
                ((TextView) view.findViewById(R.id.txtPhoneAdapter)).setText(contactModel.getPhone());
            }
        };

        lstContactList.setAdapter(adapter);
    }
}
