package com.example.buoi06;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;

public class SingleClickListener implements View.OnClickListener{
    private long mLastClickTime = 0;
    //check sự kiện 2 lần  bấm liên tiếp phải cách nhau ít nhất 1s

    @Override
    public void onClick(View view) {
        //1000 là 1s
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
    }
//    gọi ra để dùng thì ở bên dưới

//    findViewById(R.id.btnKotlin).setOnClickListener(new SingleClickListener() {
//        @Override
//        public void onClick(View view) {
//            super.onClick(view);
//
//            startActivity(new Intent(MainActivity.this, Buoi8Activity.class));
//        }
//    });
}
