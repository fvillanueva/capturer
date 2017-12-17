package app.io.capter.activities;

import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.io.capter.R;
import app.io.capter.adapters.ImageCaptureAdapter;
import app.io.capter.entity.ImageCapture;
import app.io.capter.helper.DataBaseManager;


public class ImageCapturesActivity extends AppCompatActivity {

    private RecyclerView viewListPlayer;
    private List<ImageCapture> players;
    DataBaseManager dataBaseManager;
    ImageCaptureAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);
        dataBaseManager=new DataBaseManager(this);

        players=getPlayers();
        playerAdapter=new ImageCaptureAdapter(players);
        viewListPlayer=(RecyclerView)findViewById(R.id.viewListImage);
        viewListPlayer.setHasFixedSize(true);
        viewListPlayer.setAdapter(playerAdapter);
        viewListPlayer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    /**
     *
     * @return Lista de Jugadores
     *
     */
    private List<ImageCapture> getPlayers(){
        List<ImageCapture> playerList=new ArrayList<>();
        Cursor cursor=dataBaseManager.getDataPlayer();
        while (cursor.moveToNext()){
            ImageCapture player=new ImageCapture();
            player.setImageByte(cursor.getBlob(2));
            player.setCategory(cursor.getString(1));
            playerList.add(player);
        }
        return playerList;
    }

}
