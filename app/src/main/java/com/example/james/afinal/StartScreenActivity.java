package com.example.james.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.james.afinal.dialog.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartScreenActivity extends BaseActivity implements View.OnTouchListener {
    private GestureDetector mGD;

    @BindView(R.id.start_screen)
    TextView textView;

    @OnClick(R.id.customd)
    public void onClick(View view){
        CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListner() {
            @Override
            public void onOkClick(String msg) {
                shortToast(msg);
            }
        });
        customDialog.show();
    }


    private int location =0;
    private int sumX = 0;
    private int sumY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        ButterKnife.bind(this);
        mGD = new GestureDetector(this, new simpleGestureListener());
        textView.setOnTouchListener(this);
        textView.setFocusable(true);
        textView.setClickable(true);
        textView.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGD.onTouchEvent(event);

    }
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{

        public simpleGestureListener() {
            super();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            sumX +=distanceX;
            sumY +=distanceY;


            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if(Math.abs(sumX)>300){
                    Intent intent1;
                    intent1 = new Intent(StartScreenActivity.this, MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("msg","Welcome to the app");
                        intent1.putExtra("Bundle",bundle);
                    startActivity(intent1);
                }
                else if(Math.abs(sumY)>300){
                Intent intent;
                intent = new Intent(StartScreenActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("msg","Welcome to the app");
                    intent.putExtra("Bundle",bundle);
                startActivity(intent);
            }else{
                shortToast("Swipe harder");

            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            return super.onContextClick(e);
        }
    }
}
