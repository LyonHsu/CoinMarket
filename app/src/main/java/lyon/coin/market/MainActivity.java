package lyon.coin.market;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import lyon.coin.market.ContentViewPage.CoinMarketFragment;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getName();
    FragmentManager fragmentManager;
    CoinMarketFragment coinMarketFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        coinMarketFragment = new CoinMarketFragment();

        try {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction
                    .replace(R.id.mainLayout, coinMarketFragment, "CoinMarketFragment");

            transaction.commit();
        }catch (IllegalStateException e){
            Log.e(TAG,"IllegalStateException refreshHeaderFragment:"+e);
        }
    }
}
