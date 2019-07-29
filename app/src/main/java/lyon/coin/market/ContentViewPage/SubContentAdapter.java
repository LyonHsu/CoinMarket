package lyon.coin.market.ContentViewPage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SubContentAdapter extends BaseAdapter {
    String TAG = SubContentAdapter.class.getSimpleName();
    Context context;
    public SubContentAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
