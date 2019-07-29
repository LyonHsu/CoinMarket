package lyon.coin.market.ContentViewPage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import lyon.coin.market.R;
import lyon.coin.market.Utilts;

public class SamplePagerAdapter extends PagerAdapter {
    ArrayList<View> mPages;
    ArrayList<String> pageTitles;
    LayoutInflater layoutInflater;
    Context context;
    public SamplePagerAdapter(Context context,ArrayList<View> mPages,ArrayList<String> pageTitles){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mPages=mPages;
        this.pageTitles=pageTitles;
        this.context=context;
    }

    @Override
    public int getCount() {
        return mPages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.exchange_page, container, false);
        TextView textView = (TextView) itemView.findViewById(R.id.text);
        textView.append(":"+pageTitles.get(position));
        container.addView(itemView);
        Log.d("MainActivityInstanti",position+"");

        return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles.get(position);
    }
}
