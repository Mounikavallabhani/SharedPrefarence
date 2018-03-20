package com.example.mansopresk14.sharedprefarence;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.stfalcon.bottomtablayout.BottomTabLayout;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.pizza,
            R.drawable.spoons,
            R.drawable.bakes,
            R.drawable.drink
    };

    SharedPreferences sharedpreferences;
    public static final int CAM_REQ_CODE = 123;
    public static final int GAL_REQ_CODE = 321;

    public static final int CAM_PERMISSION_ACCESS_CODE = 111;
    public static final String CAM_PERMISSION_NAME[] = {android.Manifest.permission.CAMERA};
    public static final int GAL_PERMISSION_ACCESS_CODE = 222;
    public static final String GAL_PERMISSION_NAME[] = {android.Manifest.permission.READ_EXTERNAL_STORAGE};


    ImageView iv1;


    String choice[] = {"CAMERA", "GALLERY"};

    Bitmap bit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addTabs(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();





        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String fname  = sharedpreferences.getString("Name",null);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);
        TextView name = (TextView)hView.findViewById(R.id.tv1);
        iv1 = (ImageView)hView.findViewById(R.id.iv1);


        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String uname = sharedpreferences.getString("Name", null);


        if(sharedpreferences!=null){
            if(uname!=null||uname==""){
                name.setText(fname);

            }
            else {
                Intent it = new Intent(NavActivity.this, MainActivity.class);
                startActivity(it);

            }
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            CameraImportFragment cameraImportFragment = new CameraImportFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,cameraImportFragment)
                    .addToBackStack(null)
                    .commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);


        } else if (id == R.id.nav_gallery) {
            GallaryImportFragment galleryFragment = new GallaryImportFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,galleryFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

            Intent it = new Intent(NavActivity.this, MainActivity.class);
           getApplicationContext().getSharedPreferences("MyPrefs", 0).edit().clear().commit();
            startActivity(it);
           }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new AppleFragment(), "Delivery");
        adapter.addFrag(new OrangeFragment(), "Dining Out");
        adapter.addFrag(new GrapesFragment(), "Desserts&Bakes");
        adapter.addFrag(new BananaFragment(), "Drinks &Nightlife");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void camera(View v) {

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setIcon(R.drawable.camera);
        adb.setTitle(" Select One ");
        adb.setItems(choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        int res = ContextCompat.checkSelfPermission(NavActivity.this, android.Manifest.permission.CAMERA);
                        if (res == PackageManager.PERMISSION_GRANTED) {
                            Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(cam, CAM_REQ_CODE);
                        } else {
                            ActivityCompat.requestPermissions(NavActivity.this, CAM_PERMISSION_NAME, CAM_PERMISSION_ACCESS_CODE);
                        }
                        break;
                    case 1:
                        int res1 = ContextCompat.checkSelfPermission(NavActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE);

                        if (res1 == PackageManager.PERMISSION_GRANTED) {
                            Intent gal = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(gal, GAL_REQ_CODE);
                        } else {
                            ActivityCompat.requestPermissions(NavActivity.this, GAL_PERMISSION_NAME, GAL_PERMISSION_ACCESS_CODE);
                        }

                        break;
                }
            }
        });
        adb.create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAM_PERMISSION_ACCESS_CODE:
                if (CAM_PERMISSION_NAME.equals(permissions[0]) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cam, CAM_REQ_CODE);
                }
                break;

            case GAL_PERMISSION_ACCESS_CODE:
                if (GAL_PERMISSION_NAME.equals(permissions[0]) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent gal = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(gal, GAL_REQ_CODE);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
//
                switch (requestCode) {
                    case CAM_REQ_CODE:
                        if (resultCode == RESULT_OK) {
                            Bundle b = intent.getExtras();
                            bit = (Bitmap) b.get("data");
                            iv1.setImageBitmap(bit);
                        }
                        break;

                    case GAL_REQ_CODE:
                        if (resultCode == RESULT_OK) {
                            Uri img = intent.getData();
                            try {
                                bit = MediaStore.Images.Media.getBitmap(this.getContentResolver(), img);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            iv1.setImageBitmap(bit);
                        }
                        break;
                }


//        if (resultCode == Activity.RESULT_OK) {
//            InputStream stream;
//            try {
//                stream = getContentResolver().openInputStream(intent.getData());
//                // Encoding Image into Base64
//                Bitmap realImage = BitmapFactory.decodeStream(stream);
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                realImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                byte[] b = baos.toByteArray();
//                //Converting Base64 into String to Store in SharedPreferences
//                encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
//                //NOw storing String to SharedPreferences
//                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("my_image", encodedImage);
//                editor.commit();
//                Toast.makeText(getApplicationContext(), "Image has been Stored!", Toast.LENGTH_LONG).show();
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
            }


}












