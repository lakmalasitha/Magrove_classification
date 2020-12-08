package org.research.project.examples.classification;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.classification.R;

import static android.content.ContentValues.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[], data2[];
    int image[];
    Context context;

//   private onItemClickListner mListner;

    //shift o the new page
//    public interface onItemClickListner{
//        void onItemClick(int position);
//   }
//   public void setOnItemClickListner(onItemClickListner listner){
//        mListner =listner;
//   }

    public MyAdapter(Context ct, String s1[], String s2[], int images[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        image = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.myImage.setImageResource(image[position]);
        holder.firebasebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), GetFirebaseData.class);
                intent.putExtra("position", position);
                intent.putExtra("image_name", image[position]);
                intent.putExtra("name", data1[position]);
                intent.putExtra("desc", data2[position]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {

        return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageView myImage;
        Button firebasebtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.mangrove_category_text);
            text2 = itemView.findViewById(R.id.description_text);
            myImage = itemView.findViewById(R.id.myimageView);
            firebasebtn = itemView.findViewById(R.id.firebasebtn);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(mListner !=null){
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION){
//                            mListner.onItemClick(position);
//                        }
//                    }
//                }
//            });
        }
    }
}
