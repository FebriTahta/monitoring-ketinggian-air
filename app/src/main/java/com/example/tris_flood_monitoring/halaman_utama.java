package com.example.tris_flood_monitoring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.annotation.NonNull;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class halaman_utama extends AppCompatActivity {

    ImageView imagev1, imagev2, imagev3, imagev4;
    Firebase banjir1;
    String nurul;
    TextView tv1, tv2;
    ImageButton btn_pindahhalaman;

    final String CHANNEL_ID = "flood" ;
    String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        imagev1 = (ImageView) findViewById(R.id.lvl);
        imagev2 = (ImageView) findViewById(R.id.lvl2);
        imagev3 = (ImageView) findViewById(R.id.lvl3);
        imagev4 = (ImageView) findViewById(R.id.lvl4);
        tv1 = (TextView) findViewById(R.id.lvlW);
        tv2 = (TextView) findViewById(R.id.levelw);
        btn_pindahhalaman = (ImageButton) findViewById(R.id.btnlist);

        banjir1 = new Firebase("https://tugasakhir-82765.firebaseio.com/tris/banjir");

        banjir1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    nurul = String.valueOf(dataSnapshot.getValue().toString());
                    tv1.setText(nurul);

                    if(Integer.valueOf(tv1.getText().toString()) <= 5 )
                    {
                        tv2.setText("aman");
                        imagev1.setVisibility(View.VISIBLE);
                        imagev2.setVisibility(View.INVISIBLE);
                        imagev3.setVisibility(View.INVISIBLE);
                        imagev4.setVisibility(View.INVISIBLE);

                        createNotificationChannel();
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(halaman_utama.this, CHANNEL_ID);
                        builder.setSmallIcon(R.drawable.icongps);
                        builder.setContentTitle("Level Aman");
                        builder.setContentText("Silahkan Berkatifitas ;)");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(halaman_utama.this);

                        // notificationId is a unique int for each notification that you must define
                        notificationManager.notify(376, builder.build());

                    }
                    else if(Integer.valueOf(tv1.getText().toString()) > 5 &&  Integer.valueOf(tv1.getText().toString()) <= 10)
                    {
                        tv2.setText("siaga 2");
                        imagev1.setVisibility(View.INVISIBLE);
                        imagev2.setVisibility(View.VISIBLE);
                        imagev3.setVisibility(View.INVISIBLE);
                        imagev4.setVisibility(View.INVISIBLE);

                        createNotificationChannel();
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(halaman_utama.this, CHANNEL_ID);
                        builder.setSmallIcon(R.drawable.icongps);
                        builder.setContentTitle("Level Siaga 2");
                        builder.setContentText("Air sungai meningkat, tapi masih dalam batas aman");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(halaman_utama.this);

                        // notificationId is a unique int for each notification that you must define
                        notificationManager.notify(376, builder.build());
                    }
                    else if(Integer.valueOf(tv1.getText().toString()) > 10 &&  Integer.valueOf(tv1.getText().toString()) <= 15)
                    {
                        tv2.setText("siaga 1");
                        imagev1.setVisibility(View.INVISIBLE);
                        imagev2.setVisibility(View.INVISIBLE);
                        imagev3.setVisibility(View.VISIBLE);
                        imagev4.setVisibility(View.INVISIBLE);

                        createNotificationChannel();
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(halaman_utama.this, CHANNEL_ID);
                        builder.setSmallIcon(R.drawable.icongps);
                        builder.setContentTitle("Level Siaga 1");
                        builder.setContentText("Air sungai mengalami kenaikan yang signifikan !");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(halaman_utama.this);

                        // notificationId is a unique int for each notification that you must define
                        notificationManager.notify(376, builder.build());
                    }
                    else if(Integer.valueOf(tv1.getText().toString()) > 15 &&  Integer.valueOf(tv1.getText().toString()) <= 40)
                    {
                        tv2.setText("waspada banjir");
                        imagev1.setVisibility(View.INVISIBLE);
                        imagev2.setVisibility(View.INVISIBLE);
                        imagev3.setVisibility(View.INVISIBLE);
                        imagev4.setVisibility(View.VISIBLE);

                        createNotificationChannel();
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(halaman_utama.this, CHANNEL_ID);
                        builder.setSmallIcon(R.drawable.icongps);
                        builder.setContentTitle("Waspada Banjir");
                        builder.setContentText("Siap - siap menghadapi banjir");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(halaman_utama.this);

                        // notificationId is a unique int for each notification that you must define
                        notificationManager.notify(376, builder.build());
                    }
                } catch(NumberFormatException nfe) {

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        btn_pindahhalaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(halaman_utama.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "keamanan";
            String description = "savety";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
