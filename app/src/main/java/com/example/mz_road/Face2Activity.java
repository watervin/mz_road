package com.example.mz_road;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mz_road.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class Face2Activity extends AppCompatActivity {



    TextView result, confidence;
    ImageView imageView;
    Button picture;
    Button btn_send;
    Button btn_result;
    TextView tvagain;
    String result2;
    int imageSize = 224;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face2);



        result = findViewById(R.id.result);
        imageView = findViewById(R.id.imageView);
        picture = findViewById(R.id.button);
        tvagain = findViewById(R.id.tvagain);
//        btn_send = findViewById(R.id.btn_send);
        tvagain.setVisibility(View.INVISIBLE);
        View btn_result = findViewById(R.id.btn_result);




        picture.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           // Launch camera if we have permission
                                           if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                                               Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                               startActivityForResult(cameraIntent, 1);

                                           } else {
                                               //Request camera permission if we don't have it.
                                               requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                                           }
                                           tvagain.setVisibility(View.VISIBLE);
                                           picture.setText("사진 다시 찍기");
                                       }

                                   }

        );

        //값 보내기
        result2 = "hi";
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                Intent myIntent = new Intent(Face2Activity.this, PostActivity.class);
                myIntent.putExtra("feeling", result2).toString();
                myIntent.putExtra("feeling2", result2).toString();
                startActivity(myIntent);

            }
        });

//        btn_result.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(Face2Activity.this, ResultMainFace.class);
//                myIntent.putExtra("feeling", result2).toString();
//                myIntent.putExtra("feeling2", result2).toString();
//                startActivity(myIntent);
//
//            }
//        });

        Log.d("show",result2);


    }

    public void classifyImage(Bitmap image){
        try {
            Model model = Model.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer= ByteBuffer.allocateDirect(4*imageSize*imageSize*3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int [] intValues = new int[imageSize*imageSize];
            image.getPixels(intValues,0,image.getWidth(),0,0,image.getWidth(),image.getHeight());
            int pixel=0;
            for(int i=0;i<imageSize;i++){
                for(int j=0;j<imageSize;j++){
                    int val = intValues[pixel++];
                    byteBuffer.putFloat(((val>>16)&0xFF)*(1.f/255.f));
                    byteBuffer.putFloat(((val>>8)&0xFF)*(1.f/255.f));
                    byteBuffer.putFloat((val&0xFF)*(1.f/255.f));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Model.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            int maxPos=0;
            float maxConfidence =0;
            for(int i=0; i<confidences.length;i++){
                if(confidences[i]>maxConfidence){
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }

            String[] classes = {"Anger","Happy","Hurt","Neutral","Sad","Unrest"};
            Log.i("show",classes[maxPos]);
            result.setText(classes[maxPos]);
            String s="";
            for(int i=0; i<classes.length;i++){
                s+=String.format("%s: %.1f%%\n", classes[i], confidences[i]*100);
            }


            result2 = classes[maxPos];

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            int dimension= Math.min(image.getWidth(),image.getHeight());
            image=ThumbnailUtils.extractThumbnail(image,dimension,dimension);
            imageView.setImageBitmap(image);

            image=Bitmap.createScaledBitmap(image, imageSize,imageSize,false);
            classifyImage(image);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}