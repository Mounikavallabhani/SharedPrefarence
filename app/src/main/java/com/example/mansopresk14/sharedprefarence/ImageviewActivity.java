package com.example.mansopresk14.sharedprefarence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ImageviewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    int count = 0;
    TextView add;
    ImageView selectedImage;
    Button order;
    ImageView increse, decrese;
    public static final String[] titles = new String[] { "cost 20",
            "cost 15", "cost 30" };

    public static final String[] descriptions = new String[] {
            "7am-10am",
            "7am-10am",
            "7am-10am" };

    public static final Integer[] images = { R.drawable.dosa,
            R.drawable.puri, R.drawable.idly};

    ListView listView;
    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        add = (TextView) findViewById(R.id.add);
        order = (Button) findViewById(R.id.bt1);
        increse = (ImageView) findViewById(R.id.increse);
        decrese = (ImageView) findViewById(R.id.decrease);
        selectedImage = (ImageView) findViewById(R.id.selectedImage); // init a ImageView
        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        selectedImage.setImageResource(intent.getIntExtra("image", 0));
        increse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                add.setText(String.valueOf(count));
            }
        });
        decrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                add.setText(String.valueOf(count));
            }
        });

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ImageviewActivity.this, Order.class);
                startActivity(it);
            }
        });



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}