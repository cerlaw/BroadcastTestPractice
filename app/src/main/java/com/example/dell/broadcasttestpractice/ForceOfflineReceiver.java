package com.example.dell.broadcasttestpractice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.view.WindowManager;

/**
 * Created by DELL on 2016/11/9.
 */

public class ForceOfflineReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Warning!");
        dialog.setMessage("You are forced to be offline. Please try to login" +
                "again");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
                Intent intent = new Intent(context,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.
                TYPE_TOAST);//原来使用TYPE_SYSTEM_ALERT无法弹出对话框，当api>=19
                            //推荐使用TYPE_TOAST or TYPE_APPLICATION_PANEL
        alertDialog.show();
    }
}
