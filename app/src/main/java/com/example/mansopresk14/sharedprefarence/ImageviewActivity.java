package com.example.mansopresk14.sharedprefarence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.view.View;
import android.widget.*;

import android.widget.Toolbar;

import java.util.ArrayList;

public class ImageviewActivity extends AppCompatActivity
{
    ImageView selectedImage;
    Button order;
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    ImageView imageView;
    ListView lv;
    Integer[] imageId = {
            R.drawable.dosa,
            R.drawable.puri,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        order=(Button) findViewById(R.id.bt1);
        selectedImage = (ImageView) findViewById(R.id.selectedImage); // init a ImageView
        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        selectedImage.setImageResource(intent.getIntExtra("image", 0));

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  it=new Intent(ImageviewActivity.this,Order.class);
                startActivity(it);
            }
        });



        imageView = (ImageView)findViewById(R.id.imageview1);
//        android.support.v7.widget.Toolbar mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                // Your code
//                finish();
//            }
//        });


        ExpandList = (ExpandableListView) findViewById(R.id.ex_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(ImageviewActivity.this, ExpListItems, imageId);
        ExpandList.setAdapter(ExpAdapter);


        ExpandList.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(android.widget.ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                showToastMsg(group_name + "n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new android.widget.ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "n Expanded");

            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "n Expanded");

            }
        });

    }

    public ArrayList<Group> SetStandardGroups() {

        ArrayList<Group> group_list = new ArrayList<Group>();
        ArrayList<Child> child_list;

        // Setting Group 1
        child_list = new ArrayList<Child>();
        Group gru1 = new Group();
        gru1.setName("Dosa");

        Child ch1_1 = new Child();
        ch1_1.setName("Cost 20");
        child_list.add(ch1_1);

        Child ch1_2 = new Child();
        ch1_2.setName("7am-10am");
        child_list.add(ch1_2);


        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<Child>();
        Group gru2 = new Group();
        gru2.setName("SAMSUNG");

        Child ch2_1 = new Child();
        ch2_1.setName("Galaxy Grand");
        child_list.add(ch2_1);

        Child ch2_2 = new Child();
        ch2_2.setName("Galaxy Note");
        child_list.add(ch2_2);

        Child ch2_3 = new Child();
        ch2_3.setName("Galaxy Mega");
        child_list.add(ch2_3);

        Child ch2_4 = new Child();
        ch2_4.setName("Galaxy Neo");
        child_list.add(ch2_4);

        gru2.setItems(child_list);

        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);

        return group_list;
    }

    public void showToastMsg(String Msg) {
        Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
    }
    }


