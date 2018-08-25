package com.shuai.maskguideview.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.shuai.maskguideview.Guide;
import com.shuai.maskguideview.example.R;
import com.shuai.maskguideview.GuideBuilder;
import com.shuai.maskguideview.example.component.SimpleComponent;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2;
    Guide guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);


        button2.post(new Runnable() {
            @Override
            public void run() {
                showGuideView();
            }
        });
    }

    public void showGuideView() {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(button1)
                .setFullingViewId(R.id.fullpage)
                .setAlpha(150)
                .setHighTargetCorner(20)
                .setHighTargetPadding(10)
                .setOverlayTarget(false)
                .setOutsideTouchable(false);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
                Toast.makeText(MainActivity.this, "button1 show", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDismiss() {
                Toast.makeText(MainActivity.this, "button1 dismiss", Toast.LENGTH_SHORT).show();
                showGuideView2();
            }
        });

        builder.addComponent(new SimpleComponent());
        guide = builder.createGuide();
        guide.setShouldCheckLocInWindow(true);
        guide.show(this);
    }




    public void showGuideView2() {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(button2)
                .setFullingViewId(R.id.fullpage)
                .setAlpha(150)
                .setHighTargetCorner(20)
                .setHighTargetPadding(10)
                .setOverlayTarget(false)
                .setOutsideTouchable(false);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
                Toast.makeText(MainActivity.this, "button2 show", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDismiss() {
                Toast.makeText(MainActivity.this, "button2 dismiss", Toast.LENGTH_SHORT).show();
            }
        });

        builder.addComponent(new SimpleComponent());
        guide = builder.createGuide();
        guide.setShouldCheckLocInWindow(true);
        guide.show(this);
    }

}
