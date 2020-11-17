package org.research.project.examples.classification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.classification.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
   String data1[],data2[];
   int image[];
   Context context;

   public MyAdapter(Context ct,String s1[],String s2[],int images[]){
       context = ct;
       data1 =s1;
       data2 =s2;
       image =images;
   }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.myImage.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {

       return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2;
        ImageView myImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 =itemView.findViewById(R.id.mangrove_category_text);
            text2 = itemView.findViewById(R.id.description_text);
            myImage =itemView.findViewById(R.id.myimageView);
        }
    }
}
