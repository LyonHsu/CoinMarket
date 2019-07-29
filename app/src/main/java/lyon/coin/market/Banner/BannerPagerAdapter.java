package lyon.coin.market.Banner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import lyon.coin.market.R;
import lyon.coin.market.Utilts;

public class BannerPagerAdapter extends PagerAdapter {
    private ArrayList<String> pageview;
    private ImageView[] tips ;
    LayoutInflater layoutInflater;
    Context context;
    public BannerPagerAdapter(Context context, ArrayList<String> pageview, ImageView[] tips){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.pageview = pageview;
        this.tips= tips;
        this.context=context;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d("MainActivityDestroy",position+"");
        if (pageview.get(position)!=null) {
            container.removeView((View)object);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.banner_view, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
        Utilts.downloadImage(context,pageview.get(position),imageView);
        container.addView(itemView);
        Log.d("MainActivityInstanti",position+"");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"imageView["+position+"] touch",Toast.LENGTH_LONG).show();
            }
        });
        return itemView;
    }

    @Override
    public int getCount() {
        return pageview.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object==view;
    }



}
