package lyon.coin.market.ContentViewPage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import lyon.coin.market.R;

public class ContentFragment extends Fragment {
    String TAG = ContentFragment.class.getSimpleName();
    Context context;
    View root;
    String tabTitle;
    public ContentFragment(Context context , String tabTitle) {
        this.context=context;
        this.tabTitle=tabTitle;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate DetailsFragment");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.content_page, container, false);
        init();
        return root;
    }

    private void init(){
        TextView textView = (TextView) root.findViewById(R.id.text);
        textView.append(":"+tabTitle);

//        if(tabTitle.contains("熱門排行")){
//            getSubContent();
//        }else{
//            RelativeLayout layout = (RelativeLayout) root.findViewById(R.id.subContent);
//            layout.setVisibility(View.GONE);
//        }
    }

    private void getSubContent(){
        final String title []={
                "子分類",
                "7-11",
                "全家",
                "肯德基",
                "麥當勞",
                "摩斯",
                "21世界",
                "頂呱呱",
                "漢堡王",

        };
        final ArrayList<String> mTitle = new ArrayList();
        for(int i=0;i<title.length;i++){
            mTitle.add(title[i]);
        }
        ViewPager mViewPager = (ViewPager) root.findViewById(R.id.subViewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new SubContentFragment(getActivity(),title[position]);
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

        TabLayout tabLayout = (TabLayout)root.findViewById(R.id.subTabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

}
