package com.santhiya.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button map,mail,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map=findViewById(R.id.mapbtn);
        mail=findViewById(R.id.mailbtn);
        url=findViewById(R.id.urlbtn);



        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0"));
                Intent chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to={"santhiya10082001@gmail.com","santhiyamyil@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Hi,this was my first Mail to you");
                intent.putExtra(Intent.EXTRA_TEXT,"Mail through");
                intent.setType("message/rfc822");
                Intent chooser=Intent.createChooser(intent,"Send mail");
                startActivity(chooser);
            }
        });

        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.whatsap"));
                Intent chooser=Intent.createChooser(intent,"Launch market");
                startActivity(chooser);
            }
        });



    }
}