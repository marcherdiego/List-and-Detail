package com.test.listdetail.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.otto.Subscribe;
import com.test.listdetail.managers.BusManager;
import com.test.listdetail.domain.Client;
import com.test.listdetail.ui.adapters.ListAdapter;
import com.test.listdetail.ui.adapters.ListAdapter.ClientClickEvent;
import com.test.listdetail.R;
import com.test.listdetail.utils.Constants;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.list) RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Client> clientsList = new LinkedList<>();
        for (String name : Constants.NAMES) {
            Client client = new Client();
            client.setName(name);
            clientsList.add(client);
        }
        for (int i = 0; i < clientsList.size(); ++i) {
            Client client = clientsList.get(i);
            client.setCompany(Constants.COMPANIES[i % Constants.COMPANIES.length]);
            client.setId(i);
            client.setImage(Constants.IMAGES[i % Constants.IMAGES.length]);
        }
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ListAdapter(clientsList));
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusManager.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusManager.getInstance().unregister(this);
    }

    @Subscribe
    public void onClientClick(ClientClickEvent event) {
        startActivity(
                new Intent(this, ClientActivity.class)
                        .putExtra("client", event.client)
        );
    }
}
