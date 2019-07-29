package lyon.coin.market.ExchangeTiket;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import lyon.coin.market.ContentViewPage.CoinMarketFragment;
import lyon.coin.market.MainActivity;
import lyon.coin.market.R;

public class ExchangeActivity extends AppCompatActivity {

    private String TAG = ExchangeActivity.class.getName();
    FragmentManager fragmentManager;
    ExchangePageFragment exchangePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        exchangePageFragment = new ExchangePageFragment(this);

        try {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction
                    .replace(R.id.mainLayout, exchangePageFragment, "exchangePageFragment");

            transaction.commit();
        }catch (IllegalStateException e){
            Log.e(TAG,"IllegalStateException refreshHeaderFragment:"+e);
        }
    }
}
