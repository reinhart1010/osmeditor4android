package de.blau.android.util;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImagePagerAdapter extends PagerAdapter {

    protected final Context      mContext;
    protected LayoutInflater     mLayoutInflater;
    protected final ImageLoader  loader;
    protected final List<String> images;

    /**
     * Construct a new adapter
     * 
     * @param context an Android Context
     * @param loader the PhotoLoader to use
     * @param images list of images
     */
    public ImagePagerAdapter(@NonNull Context context, @NonNull ImageLoader loader, @NonNull List<String> images) {
        mContext = context;
        this.loader = loader;
        this.images = images;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public int getItemPosition(Object item) {
        return POSITION_NONE; // hack so that everything gets updated on notifyDataSetChanged
    }
}
