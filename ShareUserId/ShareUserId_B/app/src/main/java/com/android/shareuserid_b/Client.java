package com.android.shareuserid_b;

import android.os.Bundle;
import android.view.View;

import com.android.libcore.cachemanager.CacheManager;
import com.android.libcore.log.L;
import com.android.libcore_ui.activity.BaseActivity;
import com.android.libcore_ui.permanentdbcache.PermanentCacheDBHelper;
import com.android.shareduserid_b.R;

import java.text.SimpleDateFormat;

/**
 * Description: 客户端
 *
 * @author zzp(zhao_zepeng@hotmail.com)
 * @since 2015-12-04
 */
public class Client extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String time = simpleDateFormat.format(System.currentTimeMillis());
        CacheManager.setPermanent("time", time);
        L.e("time", CacheManager.getPermanent("time", String.class, "time error"));

        PermanentCacheDBHelper.getInstance().set("time", time);
        L.e("database", PermanentCacheDBHelper.getInstance().get("time"));
    }

    public void finishThisApp(View view){
        finish();
    }
}
