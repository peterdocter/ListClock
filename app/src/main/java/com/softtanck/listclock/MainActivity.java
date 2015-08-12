package com.softtanck.listclock;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.softtanck.listclock.adapter.ClockAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private List<Long> tims;

    private Random random = new Random();

    private ClockAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        tims = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tims.add(getRandomTime());
        }
        adapter = new ClockAdapter(MainActivity.this,tims);
        listView.setAdapter(adapter);
    }

    private long getRandomTime() {
        long curTime = System.currentTimeMillis();
        long[] t = new long[]{500, 200, 640, 120, 300, 450, 100, 1000, 1540, 2500};
        return curTime + t[random.nextInt(9)] * 1000;
    }
}