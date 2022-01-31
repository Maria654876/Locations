package com.example.locations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.TextView;

import com.example.locations.recycleview.LocationAdapter;
import com.example.locations.recycleview.Location;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 1;


    ArrayList<Location> locations = new ArrayList<Location>();

    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        textChanged();


        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LocationAdapter locationAdapter = new LocationAdapter(this, locations);
        recyclerView.setAdapter(locationAdapter);
    }
    private void setInitialData(){

        locations.add(new Location (R.drawable.image12));
        locations.add(new Location ( R.drawable.image13));
        locations.add(new Location ( R.drawable.image14));
        locations.add(new Location ( R.drawable.image15));
        locations.add(new Location ( R.drawable.image16));
    }


    public void textChanged(){
        EditText editText =findViewById(R.id.editLocation);
        TextView textView=findViewById(R.id.textView2);
        textView.setText(editText.getText());
    }




    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
            }
        }
    }


    public String getPath(Uri uri) {
        if( uri == null ) {
            // TODO perform some logging or show user feedback
            return null;
        }
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // this is our fallback here
        return uri.getPath();
    }

    /*
     *Здраствуйте, попыталась сохранить фото в бд, но что-то не получилось
     * Сохранять фото в бд нельзя, можно только ссылку, пробовала сохранить путь но не получилось
     * Поэтому просто вывела в RecyclerView картинки)
     */


}