package com.kalela.philipkalela.newstock.feature.all_users_dashboard.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kalela.philipkalela.newstock.feature.all_users_dashboard.model.Users;
import com.kalela.philipkalela.newstock.feature.R;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Users> users;

    public UsersAdapter(Context context, ArrayList<Users> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(
                viewGroup.getContext()).inflate(R.layout.list_item_view_card, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder viewHolder, final int i) {
        final Users singleUser = users.get(i);

        viewHolder.usernameTextView.setText(singleUser.getUsername());
        viewHolder.emailTextView.setText(singleUser.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public View mView;
        public TextView usernameTextView;
        public TextView emailTextView;
        public ImageView mImageView;
        public RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
