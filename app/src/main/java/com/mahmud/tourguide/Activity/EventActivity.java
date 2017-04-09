package com.mahmud.tourguide.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;

import com.mahmud.tourguide.Activity.Imtiaz.AddEventActivity;
import com.mahmud.tourguide.Activity.Imtiaz.EventListActivity;
import com.mahmud.tourguide.ActivityWeather.DhakaActivity;
import com.mahmud.tourguide.Nearby.HomeActivityNearby;
import com.mahmud.tourguide.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Locale.US;

public class EventActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Dialog dialog;

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText travel_desti, trave_budget,trave_from_date,trave_to_date;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_event) {


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(EventActivity.this, UserProfileActivity.class);
            startActivity(intent);

         } else if (id == R.id.nav_Nearby) {
            Intent intent = new Intent(EventActivity.this, HomeActivityNearby.class);
            startActivity(intent);

        } else if (id == R.id.nav_Weather) {
            Intent intent = new Intent(EventActivity.this, DhakaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(EventActivity.this, AboutActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            Intent intent= new Intent(EventActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addEventDIalogOpen(MenuItem item) {
        Intent intent = new Intent(EventActivity.this, AddEventActivity.class);
        startActivity(intent);





       /* dialog = new Dialog( this );
        dialog.setContentView( R.layout.add_event_dialog_layout );
        dialog.show();*/

       /* travel_desti = (EditText) dialog.findViewById( R.id.travel_Destination_ET );
        trave_budget = (EditText) dialog.findViewById( R.id.travel_Estimate_Budget_ET );
        trave_from_date = (EditText) dialog.findViewById( R.id.travel_From_Date_ET );
        trave_to_date  = (EditText) dialog.findViewById( R.id.travel_To_Date_ET );

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                //updateLabel();
            }
        };
        trave_from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EventActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                String myFormat = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat,US);
                trave_from_date.setText(sdf.format(myCalendar.getTime()));
            }
        });
        trave_to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EventActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                String myFormat = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat,US);
                trave_to_date.setText(sdf.format(myCalendar.getTime()));
            }
        });
*/

    }

    public void EventList(View view) {
        Intent intent = new Intent(EventActivity.this, EventListActivity.class);
        startActivity(intent);
    }
}
