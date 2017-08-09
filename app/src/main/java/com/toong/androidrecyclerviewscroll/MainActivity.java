package com.toong.androidrecyclerviewscroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_scroll_to_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLinearLayoutManager.scrollToPosition(0);
            }
        });

        findViewById(R.id.button_scroll_to_position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                mLinearLayoutManager.scrollToPosition(20);
                // see https://stackoverflow.com/a/45580762/5381331
                mLinearLayoutManager.scrollToPositionWithOffset(20, -rv.getPaddingTop());
            }
        });

        rv = (RecyclerView) findViewById(R.id.rv);
        mLinearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLinearLayoutManager);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("" + i);
        }

        rv.setAdapter(new SimpleRVAdapter(list));
    }

    private void changePadding(int paddingTop) {
        rv.setPadding(rv.getPaddingLeft(), paddingTop, rv.getPaddingRight(), rv.getPaddingBottom());
    }
}
