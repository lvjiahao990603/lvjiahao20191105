package com.bawie.lvjiahao20191105.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bawie.lvjiahao20191105.R;

import de.greenrobot.event.EventBus;

public class AnyEventa extends AppCompatActivity  {
    private String discrible;
    private Button btn;

    public String getDiscrible() {
        return discrible;
    }

    public void setDiscrible(String discrible) {
        this.discrible = discrible;
    }

    public AnyEventa(String discrible) {
        this.discrible = discrible;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_any_eventa);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new AnyEventa("nothing is impossible"));
            }
        });
        EventBus.getDefault().register(this);
    }
}
