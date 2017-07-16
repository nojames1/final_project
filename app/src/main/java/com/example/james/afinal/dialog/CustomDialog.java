package com.example.james.afinal.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.james.afinal.R;

import butterknife.ButterKnife;
import butterknife.OnClick;



public class CustomDialog extends Dialog {

    private final ICustomDialogListner listener;
    public interface ICustomDialogListner{
        public void onOkClick(String msg);
    }


    @OnClick(R.id.dialog_custom_btn)
    public void ok(View view){
        listener.onOkClick("you clicked cancel");
        cancel();
    }
    public CustomDialog(@NonNull Context context, ICustomDialogListner listner) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);
        this.listener = listner;
    }
}
