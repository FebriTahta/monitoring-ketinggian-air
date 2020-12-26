package com.example.tris_flood_monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageButton btn_back;
    Button btn_grafik;

    String url="https://rfiproject.com/project/tris_itats/tris_cek.php";
    public static String bulan01 = "";
    public static String hari01 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_back = (ImageButton) findViewById(R.id.btn_kembali);
        btn_grafik = (Button) findViewById(R.id.btgrafik);

        final ListView lv= (ListView) findViewById(R.id.lv);
        Button bt_1 = (Button) findViewById(R.id.bt1);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bulan_01, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.bulan_ganjil, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Downloader(MainActivity.this,url,lv).execute();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, halaman_utama.class);
                startActivity(intent);
            }
        });
        btn_grafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, main_grafik.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinner1)
        {
            String nilai00 = parent.getItemAtPosition(position).toString();
            if (nilai00.equals("januari")) bulan01="01";
            if (nilai00.equals("februari")) bulan01="02";
            if (nilai00.equals("maret")) bulan01="03";
            if (nilai00.equals("april")) bulan01="04";
            if (nilai00.equals("mei")) bulan01="05";
            if (nilai00.equals("juni")) bulan01="06";
            if (nilai00.equals("juli")) bulan01="07";
            if (nilai00.equals("agustus")) bulan01="08";
            if (nilai00.equals("september")) bulan01="09";
            if (nilai00.equals("oktober")) bulan01="10";
            if (nilai00.equals("november")) bulan01="11";
            if (nilai00.equals("desember")) bulan01="12";
        }
        else if(parent.getId() == R.id.spinner2){
            String hari00 = parent.getItemAtPosition(position).toString();
            if (hari00.equals("01")) hari01="01";
            if (hari00.equals("02")) hari01="02";
            if (hari00.equals("03")) hari01="03";
            if (hari00.equals("04")) hari01="04";
            if (hari00.equals("05")) hari01="05";
            if (hari00.equals("06")) hari01="06";
            if (hari00.equals("07")) hari01="07";
            if (hari00.equals("08")) hari01="08";
            if (hari00.equals("09")) hari01="09";
            if (hari00.equals("10")) hari01="10";
            if (hari00.equals("11")) hari01="11";
            if (hari00.equals("12")) hari01="12";
            if (hari00.equals("13")) hari01="13";
            if (hari00.equals("14")) hari01="14";
            if (hari00.equals("15")) hari01="15";
            if (hari00.equals("16")) hari01="16";
            if (hari00.equals("17")) hari01="17";
            if (hari00.equals("18")) hari01="18";
            if (hari00.equals("19")) hari01="19";
            if (hari00.equals("20")) hari01="20";
            if (hari00.equals("21")) hari01="21";
            if (hari00.equals("22")) hari01="22";
            if (hari00.equals("23")) hari01="23";
            if (hari00.equals("24")) hari01="24";
            if (hari00.equals("25")) hari01="25";
            if (hari00.equals("26")) hari01="26";
            if (hari00.equals("27")) hari01="27";
            if (hari00.equals("28")) hari01="28";
            if (hari00.equals("29")) hari01="29";
            if (hari00.equals("30")) hari01="30";
            if (hari00.equals("31")) hari01="31";
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
