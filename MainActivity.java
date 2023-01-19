package com.example.lab_1;

import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout b_1,b_2,b_3;
    private Button btn;
    private  boolean start_stop=false;
    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_1 = findViewById(R.id.bulb_1);
        b_2 = findViewById(R.id.bulb_2);
        b_3 = findViewById(R.id.bulb_3);
        btn = findViewById(R.id.btn);
    }
//Emulator: Warning: Quick Boot / Snapshots not supported on this machine. A CPU with EPT + UG features is currently needed. We will address this in a future release.
////16:50	Emulator: emulator: WARNING: EmulatorService.cpp:448: Cannot find certfile: C:\Users\Kosta\.android\emulator-grpc.cer security will be disabled.
////16:50	Emulator: Started GRPC server at 127.0.0.1:8554
    public void onClickStart(View view) {
//        btn.setText("Stop");
//        b_1.setBackgroundResource(R.color.green);
//        btn.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.red));
        final Context context = getApplicationContext();
        if(!start_stop){
            start_stop=true;
            btn.setText(getString(R.string.stop));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (start_stop) {
                        counter++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                switch (counter) {
                                    case 1:
                                        b_1.setBackgroundColor(getResources().getColor(R.color.greens));
                                        b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                        break;
                                    case 2:
                                        b_1.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
                                        b_2.setBackgroundColor(ContextCompat.getColor(context,R.color.yellow));
                                        b_3.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
                                        break;
                                    case 3:
                                        b_1.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.grey));
                                        b_2.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.grey));
                                        b_3.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.red));
                                        counter = 0;
                                        break;
                                }
                            }
                        });
                        //                     setBackgroundColor(Color.parseColor("#e7eecc"));      setBackgroundColor(getResources().getColor(R.color.green));     setBackgroundResource(R.color.green);
                        //b_1.setBackgroundResource(R.color.green);//setBackgroundColor(getResources().getColor(R.color.green));//.setBackgroundResource(Color.BLUE);//setBackgroundColor(Color.parseColor("#e7eecc"));
                        //setBackgroundResource(R.color.green);//setBackgroundColor(MainActivity.this.getResources().getColor(R.color.green));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }else {
            start_stop=false;
            btn.setText(getString(R.string.start));
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop=false;
    }

   /* @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
*/

}
