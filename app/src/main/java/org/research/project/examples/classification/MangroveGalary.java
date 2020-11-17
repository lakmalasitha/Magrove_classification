package org.research.project.examples.classification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.tensorflow.lite.examples.classification.R;

public class MangroveGalary extends AppCompatActivity {
    RecyclerView recyclerView;
    String s1[],s2[];
    int images[]={R.drawable.acanthus_illicifolius,R.drawable.acrostichu_aureum,R.drawable.aegicerus_corniculatum,R.drawable.avicennia_marina,R.drawable.avicennia_officinalis,R.drawable.bruguiera_cylindrica,R.drawable.bg,R.drawable.nypa_fruiticans,
            R.drawable.ceriops_tagal,R.drawable.excoecaria_agallocha,R.drawable.heritiera_littoralis,R.drawable.lumnitzera_littorea,R.drawable.lumnitzera_racemosa,R.drawable.nypa_fruiticans,R.drawable.rhizophora_mucronata,R.drawable.scyphiphora_hydrophylacea,
            R.drawable.sonneratia_alba,R.drawable.sonneratia_caseolaris,R.drawable.xylocarpus_granatum};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangrove_galary);

        recyclerView = findViewById(R.id.recycleview);
        s1= getResources().getStringArray(R.array.mangrove_category);
        s2=getResources().getStringArray(R.array.description);

        MyAdapter adapter =new MyAdapter(this,s1,s2,images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}