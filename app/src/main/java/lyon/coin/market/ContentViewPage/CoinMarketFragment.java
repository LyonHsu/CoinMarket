package lyon.coin.market.ContentViewPage;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import lyon.coin.market.Banner.BannerFragment;
import lyon.coin.market.R;


public class CoinMarketFragment extends Fragment {
    String TAG = CoinMarketFragment.class.getSimpleName();
    View root;
    BannerFragment bannerFragment ;
    String title []={
            "熱門排行",
            "品牌通路",
            "商品類型",

            "熱門排行 2",
            "品牌通路 2",
            "商品類型 2",
    };
    FragmentManager fragmentManager;
    ArrayList<String> mTitle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate DetailsFragment");
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.coin_market_fragment, container, false);
        init();
        banner();
        return root;
    }

    private void init(){
        ArrayList<View> mPages = new ArrayList();
        mTitle = new ArrayList();
        for(int i=0;i<title.length;i++){
            mTitle.add(title[i]);
        }
        ViewPager mViewPager = (ViewPager) root.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return new ContentFragment(getActivity(),title[position]);
            }

            @Override
            public int getCount() {
                return mTitle.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        mViewPager.setCurrentItem(0);
        TabLayout tabLayout = (TabLayout)root.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        RelativeLayout myExchangeTiketBtn = (RelativeLayout)root.findViewById(R.id.myExchangeTiketBtn);
        myExchangeTiketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void banner(){

        bannerFragment = new BannerFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        try {
            transaction.replace(R.id.bannerLayout, bannerFragment, "BannerFragment");
            transaction.commit();
        }catch (IllegalStateException e){
            Log.e(TAG,"IllegalStateException refreshHeaderFragment:"+e);
        }
    }

}
