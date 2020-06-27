package com.example.watch;

//import android.app.Activity;
//import android.content.Context;
//import android.content.res.Resources;
//import android.util.TypedValue;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.Toast;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    public Integer[] myImages = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_popular)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public int getCount() {
            return myImages.length;
        }

        @Override
        public Object getItem(int position) {
            return myImages[position];
        }


        public long getItemId(int position) {
            return 0;
        }
        public ImageAdapter(Context c){
            mContext=c;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView==null){

                imageView = new ImageView(mContext);

                int w = 650;
                int h = 900;

                imageView.setLayoutParams(new GridView.LayoutParams(w, h));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);}

            else {
                imageView = (ImageView) convertView;}

            imageView.setBackgroundResource(myImages[position]);
            return imageView;
        }



    }
}
