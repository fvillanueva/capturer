package app.io.capter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.io.capter.R;
import app.io.capter.entity.ImageCapture;

import app.io.capter.R;
import app.io.capter.utilities.Util;

/**
 * Adaptador de Datos del Jugador
 */

public class ImageCaptureAdapter extends RecyclerView.Adapter<ImageCaptureAdapter.ViewHolder> {


    private List<ImageCapture> data;

    public ImageCaptureAdapter(List<ImageCapture> data) {
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView category;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imagePlayer);
            category = (TextView) itemView.findViewById(R.id.category);

        }

    }

    @Override
    public ImageCaptureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_imagecapture, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ImageCaptureAdapter.ViewHolder holder, int position) {
        ImageCapture imageCapture = data.get(position);
        holder.imageView.setImageBitmap(Util.getImage(imageCapture.getImageByte()));
        holder.category.setText("Score: " + imageCapture.getCategory());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
