package org.athome.alex.ny_times_kr1_2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Uri geoLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share: {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("plain/text");
                i.putExtra(Intent.EXTRA_SUBJECT, "Новости от NY Times");
                i.putExtra(Intent.EXTRA_TEXT, "Сегодня такие новости:");
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }
            }
                break;
            case R.id.menu_photo: {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }
            }
                break;
            case R.id.menu_map:
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(geoLocation);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }
                break;
        }
        return true;
    }
}
