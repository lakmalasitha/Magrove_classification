package org.research.project.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.tensorflow.lite.examples.classification.R;

import java.util.ArrayList;

public class GetFirebaseData extends AppCompatActivity {
    ImageView img;
    TextView t1,t2,kingdom,family,common_name,clade,conservation_status,genus,species,order,type_of_mangrove,features_of_flower,features_of_fruits,
            type_of_roots,leaf_arr,range,general_characters,other_character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_firebase_data);
        img =(ImageView)findViewById(R.id.moreImg);
        t1 =(TextView)findViewById(R.id.title1);
        t2 =(TextView)findViewById(R.id.title2);
        kingdom =(TextView)findViewById(R.id.kingdom);
        common_name =(TextView)findViewById(R.id.common_name);
        family =(TextView)findViewById(R.id.family);
        clade =(TextView)findViewById(R.id.clade);
        conservation_status =(TextView)findViewById(R.id.conservation_status);
        genus =(TextView)findViewById(R.id.genus);
        order =(TextView)findViewById(R.id.order);
        species =(TextView)findViewById(R.id.species);
        type_of_mangrove =(TextView)findViewById(R.id.type_of_mangrove);
        features_of_flower =(TextView)findViewById(R.id.features_of_flower);
        features_of_fruits =(TextView)findViewById(R.id.features_of_fruits);
        type_of_roots =(TextView)findViewById(R.id.type_of_roots);
        leaf_arr =(TextView)findViewById(R.id.leaf_arr);
        range =(TextView)findViewById(R.id.range);
        general_characters =(TextView)findViewById(R.id.general_characters);
        other_character =(TextView)findViewById(R.id.other_characters);


            int position = getIntent().getIntExtra("position", 0);
            img.setImageResource(getIntent().getIntExtra("image_name",0));
            t1.setText(getIntent().getStringExtra("name"));
            t2.setText(getIntent().getStringExtra("desc"));
            kingdom.setText(getResources().getStringArray(R.array.kingdom)[position]);
            family.setText(getResources().getStringArray(R.array.family)[position]);
            common_name.setText(getResources().getStringArray(R.array.common_name)[position]);
            clade.setText(getResources().getStringArray(R.array.clade)[position]);
            conservation_status.setText(getResources().getStringArray(R.array.conservation_status)[position]);
            genus.setText(getResources().getStringArray(R.array.genus)[position]);
             species.setText(getResources().getStringArray(R.array.species)[position]);
            order.setText(getResources().getStringArray(R.array.order)[position]);
            type_of_mangrove.setText(getResources().getStringArray(R.array.type_of_mangrove)[position]);
            features_of_flower.setText(getResources().getStringArray(R.array.features_of_flower)[position]);
            features_of_fruits.setText(getResources().getStringArray(R.array.features_of_fruits)[position]);
            type_of_roots.setText(getResources().getStringArray(R.array.type_of_roots)[position]);
            leaf_arr.setText(getResources().getStringArray(R.array.leaf_arr)[position]);
            range.setText(getResources().getStringArray(R.array.range)[position]);
            general_characters.setText(getResources().getStringArray(R.array.general_characters)[position]);
            other_character.setText(getResources().getStringArray(R.array.other_characters)[position]);





    }
}