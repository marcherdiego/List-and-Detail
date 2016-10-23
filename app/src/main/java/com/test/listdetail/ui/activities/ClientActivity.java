package com.test.listdetail.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.listdetail.domain.Client;
import com.test.listdetail.R;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView image = (ImageView) findViewById(R.id.image);
        TextView company = (TextView) findViewById(R.id.company);
        Client client = (Client) getIntent().getSerializableExtra("client");
        image.setImageResource(client.getImage());
        company.setText(client.getCompany());
        toolbar.setTitle(client.getName());
        setSupportActionBar(toolbar);
    }
}
