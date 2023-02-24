package com.doubleclick.floatinglayoutandroid;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

import com.doubleclick.floatinglayoutandroid.callback.FloatingListener;
import com.doubleclick.floatinglayoutandroid.component.FloatingComponent;
import com.doubleclick.floatinglayoutandroid.service.FloatingService;


public class FloatingResult extends ResultReceiver {

    private FloatingListener floatingListener;

    public FloatingResult(Handler handler, FloatingListener floatingListener) {
        super(handler);
        this.floatingListener = floatingListener;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (floatingListener != null) {
            if (resultCode == FloatingComponent.ACTION_ON_CREATE) {
                if (FloatingService.view != null)
                    floatingListener.onCreateListener(FloatingService.view);
            }
            if (resultCode == FloatingComponent.ACTION_ON_CLOSE) {
                floatingListener.onCloseListener();
            }
        }
        super.onReceiveResult(resultCode, resultData);
    }
}
