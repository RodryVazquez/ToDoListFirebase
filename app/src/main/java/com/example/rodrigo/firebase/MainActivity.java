package com.example.rodrigo.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnSunny, btnFuggy,btnShowToDoList;
    TextView txtInfo;
    Firebase mRef;
    private static final String urlPartial = "condition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtInfo = (TextView)findViewById(R.id.txtInfo);
        btnSunny = (Button)findViewById(R.id.btnSunny);
        btnFuggy = (Button)findViewById(R.id.btnFoggy);
        btnShowToDoList = (Button)findViewById(R.id.btnShowToDoList);

        mRef = new Firebase(getResources().getString(R.string.baseUrl) + urlPartial);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                txtInfo.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                mRef.setValue("Hello cochi");
            }
        });

        btnSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Sunny");
            }
        });

        btnFuggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Foggy");
            }
        });

        btnShowToDoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ToDoListActivity.class);
                startActivity(intent);
            }
        });
    }
}
