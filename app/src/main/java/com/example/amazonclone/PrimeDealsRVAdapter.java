package com.example.amazonclone;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PrimeDealsRVAdapter extends RecyclerView.Adapter<PrimeDealsRVAdapter.ViewHolder> {
    private static String TAG = "PrimeDealsRVAdapter";
    private ArrayList<String> imageUrls;
    private ArrayList<String> names;
    private Context context;
    @LayoutRes
    private int res;

    public PrimeDealsRVAdapter(ArrayList<String> imageUrls, ArrayList<String> names, Context context, @LayoutRes int res) {
        this.imageUrls = imageUrls;
        this.names = names;
        this.context = context;
        this.res = res;
    }

    @NonNull
    @Override
    public PrimeDealsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
        return new PrimeDealsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrimeDealsRVAdapter.ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(imageUrls.get(position)).into(holder.image);
        holder.name.setText(names.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked here");
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.nav_image);
            name = itemView.findViewById(R.id.nav_name);
        }
    }
}
