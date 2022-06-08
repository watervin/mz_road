package com.example.mz_road;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Game extends AppCompatActivity {
    TextView textView;
    String url = "https://www.gamemeca.com/ranking.php";
    String  msg;
    Button btn_map;
    String final_result;

    final Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textView = findViewById(R.id.tv1);

        Intent secondIntent = getIntent();
        final_result = secondIntent.getStringExtra("final_result");
        Log.i("main_test", "final_test값 보내기 $final_result");


        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Game.this, KakaoMap.class);
                myIntent.putExtra("final_result", final_result).toString();
                startActivity(myIntent);
            }


        });

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Bundle bundle = msg.getData();
                textView.setText(bundle.getString("message"));

            }
        };
        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    doc = Jsoup.connect(url).get();
                    Elements rank1 = doc.select("#content > div.ranking_list > div.rank-list > div.content-left > table > tbody > tr:nth-child(1) > td:nth-child(4) > div.game-name > a");
                    Elements rank2 = doc.select("#content > div.ranking_list > div.rank-list > div.content-left > table > tbody > tr:nth-child(2) > td:nth-child(4) > div.game-name > a");
                    Elements rank3 = doc.select("#content > div.ranking_list > div.rank-list > div.content-left > table > tbody > tr:nth-child(3) > td:nth-child(4) > div.game-name > a");
                    String rank1_txt=rank1.text();
                    String rank2_txt=rank2.text();
                    String rank3_txt=rank3.text();

                    msg = "1위 )" + rank1_txt+"\n\n"+"2위 )"+rank2_txt+"\n\n"+"3위 )"+rank3_txt;
                    bundle.putString("message",msg);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
