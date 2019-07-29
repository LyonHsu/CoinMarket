package lyon.coin.market.ContentViewPage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import lyon.coin.market.R;

public class SubContentFragment extends Fragment {
    String TAG = SubContentFragment.class.getSimpleName();
    Context context;
    View root;
    String subTabTitle;
    FragmentManager fragmentManager;

    public SubContentFragment(Context context , String subTabTitle) {
        this.context=context;
        this.subTabTitle=subTabTitle;
        fragmentManager = getFragmentManager();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate DetailsFragment");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.sub_content_page, container, false);
        init();
        return root;
    }

    private void init(){
        ListView listView = (ListView) root.findViewById(R.id.subListView);
    }
}
