package com.test.listdetail.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.test.listdetail.managers.BusManager;
import com.test.listdetail.domain.Client;
import com.test.listdetail.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.view.LayoutInflater.from;

public class ListAdapter extends Adapter<ListAdapter.ViewHolder> {

    private final List<Client> clientList;
    private final Bus bus;

    public ListAdapter(List<Client> clientList) {
        this.clientList = clientList;
        this.bus = BusManager.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Client client = clientList.get(position);
        holder.name.setText(client.getName());
        holder.company.setText(client.getCompany());
        holder.image.setImageResource(client.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus.post(new ClientClickEvent(client));
            }
        });
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name) TextView name;
        @Bind(R.id.company) TextView company;
        @Bind(R.id.image) ImageView image;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static class ClientClickEvent {

        public final Client client;

        ClientClickEvent(Client client) {
            this.client = client;
        }
    }
}