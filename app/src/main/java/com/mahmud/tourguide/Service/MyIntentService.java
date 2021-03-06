package com.mahmud.tourguide.Service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;

import com.mahmud.tourguide.Activity.Imtiaz.EventListActivity;
import com.mahmud.tourguide.database.Imtiaz.CostManager;
import com.mahmud.tourguide.database.Imtiaz.EventManager;
import com.mahmud.tourguide.model.Imtiaz.CostModel;
import com.mahmud.tourguide.model.Imtiaz.TourEvent;
import com.mahmud.tourguide.R;

import java.util.ArrayList;



public class MyIntentService extends IntentService {

    EventManager eventManager;
    ArrayList<TourEvent> tourEvents;

    CostManager costManager;
    ArrayList<CostModel>costModels;




    Handler handler;


    public MyIntentService() {
        super("MyIntentService");
        handler=new Handler(Looper.getMainLooper());
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        handler.post(new Runnable() {
            @Override
            public void run() {

                eventManager=new EventManager(MyIntentService.this);
                tourEvents=eventManager.getAllEvents();
                for (TourEvent atour:tourEvents) {
                    String tourName=atour.getDestination();
                    double tourBudget=atour.getEventBudget();
                    costManager=new CostManager(MyIntentService.this);
                    costModels=costManager.getAllCosts(tourName);

                    double calculationTotal=0;
                    for (CostModel acostModel:costModels) {

                        calculationTotal=calculationTotal+acostModel.getCostAmount();
                    }
                    double seventyFivePercentage=tourBudget*(75/100);
                    double hundredPercentage=tourBudget;

                    if(calculationTotal>=seventyFivePercentage)
                    {
                        NotificationCompat.Builder builder =
                                new NotificationCompat.Builder(MyIntentService.this)
                                        .setSmallIcon(R.mipmap.ic_launcher)

                                        .setContentTitle("Tk 75% expended")
                                        .setContentText(tourName +" event has gone over 75% on expense");

                        Intent notificationIntent = new Intent(MyIntentService.this, EventListActivity.class);
                        PendingIntent contentIntent = PendingIntent.getActivity(MyIntentService.this, 0, notificationIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT);
                        builder.setContentIntent(contentIntent);

                        // Add as notification
                        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        manager.notify(0, builder.build());
                    }

                    if(calculationTotal>=hundredPercentage)
                    {
                        NotificationCompat.Builder builder =
                                new NotificationCompat.Builder(MyIntentService.this)
                                        .setSmallIcon(R.mipmap.ic_launcher)
                                        .setContentTitle("Tk 100% expended")
                                        .setContentText(tourName +" event has gone over 100% on expense");

                        Intent notificationIntent = new Intent(MyIntentService.this, EventListActivity.class);
                        PendingIntent contentIntent = PendingIntent.getActivity(MyIntentService.this, 0, notificationIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT);
                        builder.setContentIntent(contentIntent);

                        // Add as notification
                        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        manager.notify(0, builder.build());
                    }
                }






                //notification code


            }
        });

    }
}
