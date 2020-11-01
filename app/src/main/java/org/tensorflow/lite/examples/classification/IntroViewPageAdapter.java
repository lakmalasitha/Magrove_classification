package org.tensorflow.lite.examples.classification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class IntroViewPageAdapter extends PagerAdapter {

    Context mcontext;
    List<ScreemItem> mlistscreen;

    public IntroViewPageAdapter(Context mcontext, List<ScreemItem> mlistscreen) {
        this.mcontext = mcontext;
        this.mlistscreen = mlistscreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen,null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);
        TextView title =layoutScreen.findViewById(R.id.intro_title);
        TextView desc= layoutScreen.findViewById(R.id.intro_desc);

        title.setText(mlistscreen.get(position).getTitle());
        desc.setText(mlistscreen.get(position).getDescription());
        imgSlide.setImageResource(mlistscreen.get(position).getScreenImg());

        container.addView(layoutScreen);
        return layoutScreen;



    }

    @Override
    public int getCount() {
        return mlistscreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
