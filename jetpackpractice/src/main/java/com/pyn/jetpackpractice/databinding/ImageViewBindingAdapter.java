package com.pyn.jetpackpractice.databinding;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.pyn.jetpackpractice.R;
import com.squareup.picasso.Picasso;

public class ImageViewBindingAdapter {

    @BindingAdapter(value = {"imageUrl", "defaultImageResource"}, requireAll = false)
    public static void setImage(ImageView imageView, String imageUrl, int imageResource) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.get().load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageView);
        } else {
            imageView.setBackgroundColor(imageResource);
        }
    }

    @BindingAdapter("image")
    public static void setImage(ImageView imageView, int imageResource) {
        imageView.setImageResource(imageResource);
    }

    @BindingAdapter("padding")
    public static void setPadding(View view, int oldPadding, int newPadding) {
        Log.d("ImageViewBindingAdapter", "oldPadding = " + oldPadding + "  newPadding = " + newPadding);
        if (oldPadding != newPadding) {
            view.setPadding(newPadding, newPadding, newPadding, newPadding);
        }
    }
}
