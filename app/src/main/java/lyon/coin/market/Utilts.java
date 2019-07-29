package lyon.coin.market;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutionException;

public class Utilts {
    static String TAG = Utilts.class.getSimpleName();


    public static void downloadImage(Context context, String url, final ImageView imageView){
        Glide.with(context).load(url).crossFade().into(imageView);
    }

    public static Bitmap downloadImage(Context mContext, String url, int WIDTH, int HEIGHT){
        Bitmap bitmap=null;
        try {
            bitmap =Glide.with(mContext).load(url).asBitmap().centerCrop().into(WIDTH,HEIGHT).get();
        } catch (InterruptedException e) {
//            Log.e(TAG,"20190611 InterruptedException:"+Utils.FormatStackTrace(e));
        } catch (ExecutionException e) {
//            Log.e(TAG,"20190611 ExecutionException Utils.java downloadImage :"+Utils.FormatStackTrace(e));
        }
        return bitmap;
    }
}
