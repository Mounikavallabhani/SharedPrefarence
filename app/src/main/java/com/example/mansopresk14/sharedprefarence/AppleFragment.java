package com.example.mansopresk14.sharedprefarence;

        import android.content.Intent;
        import android.os.Bundle;

        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ImageView;

/**
 * Created by Mansopresk14 on 3/5/2018.
 */

public class AppleFragment extends Fragment  {
    private CustomAdapter adapter;
    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;
    ImageView image;
    View view;


    public AppleFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
       // image=(ImageView)view.findViewById(R.id.image);
//         holder.image.setOnTouchListener(new View.OnTouchListener() {

}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apple, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CustomAdapter(this);
        recyclerView.setAdapter(adapter); // set the Adapter to RecyclerVie
        return view;
    }

}


















