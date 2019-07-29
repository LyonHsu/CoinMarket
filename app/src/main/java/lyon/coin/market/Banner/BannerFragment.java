package lyon.coin.market.Banner;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import lyon.coin.market.R;


/**
 * https://www.itread01.com/content/1549965806.html
 */
public class BannerFragment extends Fragment {

    String TAG = BannerFragment.class.getSimpleName();
    View root;
    private ImageView[] tips = new ImageView[3];
    private ArrayList<String> pageview;
    private ImageView imageView;
    private ArrayList<String> imageArray = new ArrayList<>();
    private String[] imageUrl={
            "https://www.digitalprintingireland.ie/media/images/products/slides/31/vinyl-pvc-banners-1.jpg",
        "https://images.zi.org.tw/applealmond/2019/07/22000247/1563724967-7a7a91942c776f326ea2adf0158a3166.jpg",
        "https://tpc.googlesyndication.com/simgad/11471684707674376507?sqp=4sqPyQQ7QjkqNxABHQAAtEIgASgBMAk4A0DwkwlYAWBfcAKAAQGIAQGdAQAAgD-oAQGwAYCt4gS4AV_FAS2ynT4&rs=AOga4qlLhbB6oS0HrpvlJyqW5A3S3dCm_Q"
    };
   boolean isAutoScroll=true;
    ViewPager viewPager;
    final int SCROLL_WHAT = 1;
    int interval = 2*1000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate DetailsFragment");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.banner_fragment, container, false);
        init();
        return root;
    }

    private void init(){
        //將view加進pageview中
        viewPager = (ViewPager)root.findViewById(R.id.viewPager);



        pageview = new ArrayList<>();
        for(int i=0;i<imageUrl.length;i++){
            pageview.add(imageUrl[i]);
        }

        //viewPager下面的圓點，ViewGroup
        ViewGroup group = (ViewGroup)root.findViewById(R.id.viewGroup);
        tips = new ImageView[pageview.size()];
        for(int i =0;i<pageview.size();i++){
            imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20,20));
            imageView.setPadding(20, 0, 20, 0);
            tips[i] = imageView;

            //預設第一張圖顯示為選中狀態
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }

            group.addView(tips[i]);
        }
        //這裡的mypagerAdapter是第三步定義好的。
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter(getActivity(),pageview,tips);
        viewPager.setAdapter(bannerPagerAdapter);
        //這裡的GuiPageChangeListener是第四步定義好的。
        viewPager.addOnPageChangeListener(new GuidePageChangeListener());
        startAutoScroll();
    }

    public  class GuidePageChangeListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }


        @Override
        //切換view時，下方圓點的變化。
        public void onPageSelected(int position) {
            tips[position].setBackgroundResource(R.drawable.page_indicator_focused);
            //這個圖片就是選中的view的圓點
            for(int i=0;i<pageview.size();i++){
                if (position != i) {
                    tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
                    //這個圖片是未選中view的圓點
                }
            }
        }
    }

    public void startAutoScroll() {
        isAutoScroll = true;
        sendScrollMessage(interval);
    }
    mHandler handler = new mHandler();
    private void sendScrollMessage(long delayTimeInMills) {
        /** remove messages before, keeps one message is running at most **/
        handler.removeMessages(SCROLL_WHAT);
        handler.sendEmptyMessageDelayed(SCROLL_WHAT, delayTimeInMills);
    }

    private class mHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SCROLL_WHAT:
                    scrollOnce();
                    sendScrollMessage(interval);
                    break;
            }
        }
    }

    private void scrollOnce(){
        int count = pageview.size();
        int index=viewPager.getCurrentItem();
        index = ++index%count;
        if(index>=pageview.size()){
            index=0;
        }
        viewPager.setCurrentItem(index);
    }
}
