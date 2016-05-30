package com.example.rodrigo.firebase;

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

    Button btnSunny, btnFuggy;
    TextView txtInfo;
    Firebase mRef;

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
        mRef = new Firebase("https://samplefirebase-fb78d.firebaseio.com/condition");

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

        //
        btnSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Sunny");
            }
        });

        //
        btnFuggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Foggy");
            }
        });
    }
}
