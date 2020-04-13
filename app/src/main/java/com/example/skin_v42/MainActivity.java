package com.example.skin_v42;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = findViewById(R.id.title);
         image = findViewById(R.id.image);

        FirebaseApp.initializeApp(this);
        FirebaseFirestore data = FirebaseFirestore.getInstance();
        data.collection("mods")
                .get()
                .addOnCompleteListener(task -> {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        String string = document.getString("title");
                        title.setText(string);
                        String imageUri = document.getString("images");
                        loadImage(imageUri);
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Download error!", Toast.LENGTH_LONG);
                });
    }

    public void loadImage(String uriImage){
        Picasso.get().load(uriImage).into(image);
    }
}
