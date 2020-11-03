package com.pyn.jetpackpractice.databinding;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.pyn.jetpackpractice.R;
import com.squareup.picasso.Picasso;

public class ImageViewBindingAdapter {

    @BindingAdapter("image")
    public static void setImage(ImageView imageView, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.get().load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageView);
        }else {
            imageView.setBackgroundColor(Color.DKGRAY);
        }
    }

    @BindingAdapter("image")
    public static void setImage(ImageView imageView, int imageResource){
        imageView.setImageResource(imageResource);
    }
}
