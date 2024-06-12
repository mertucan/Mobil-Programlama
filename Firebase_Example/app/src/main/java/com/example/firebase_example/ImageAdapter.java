package com.example.firebase_example;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

public class ImageAdapter extends RecylerView.Adapter<ImageAdapter.ImageViewHolder>{
    Context mContext;
    List<Models> mImages;

    public ImageAdapter(Context context, List<Models> images)
    {
        this.mContext = context;
        this.mImages = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_layout, parent, false);

        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position)
    {
        Models image = mImages.get(position);

        Picasso.get().load(image.getUrl()).into(holder.imageView);
    }
}
