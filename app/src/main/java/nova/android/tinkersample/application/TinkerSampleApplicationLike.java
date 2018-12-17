package nova.android.tinkersample.application;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * nova.android.tinkersample.application.
 *
 * @author Created by WXG on 2018/12/17 017 15:33.
 * @version V1.0
 */
@DefaultLifeCycle(
        application = "nova.android.tinkersample.application.TinkerSampleApplication",
        //这里填写包名和你想要生成的Application类名，tinker会自动生成该类
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false
)
public class TinkerSampleApplicationLike extends DefaultApplicationLike {

    private static final String TAG = "TinkerSampleApplication";

    public TinkerSampleApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long
            applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onBaseContextAttached(Context base) {
        Log.d(TAG, "onBaseContextAttached");
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        TinkerInstaller.install(this);
        Tinker tinker = Tinker.with(getApplication());
    }

}
