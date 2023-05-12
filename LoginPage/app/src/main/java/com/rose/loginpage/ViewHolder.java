package com.rose.loginpage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView,imageView1;
    TextView nameView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.profilR);
        imageView1=itemView.findViewById(R.id.photo);
        nameView=itemView.findViewById(R.id.name);

    }
}
