package org.research.project.examples.classification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.tensorflow.lite.examples.classification.R;

public class MangroveGalary extends AppCompatActivity {
    RecyclerView recyclerView;
    String s1[],s2[];
    int images[]={R.drawable.a,R.drawable.b,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangrove_galary);

        recyclerView = findViewById(R.id.recycleview);
        s1= getResources().getStringArray(R.array.mangrove_category);
        s2=getResources().getStringArray(R.array.description);

        MyAdapter adapter =new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}