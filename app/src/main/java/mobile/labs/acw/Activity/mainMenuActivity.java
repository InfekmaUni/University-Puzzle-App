package mobile.labs.acw.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Set;

import mobile.labs.acw.Class.Managers.GameManager;
import mobile.labs.acw.Class.Managers.ImageManager;
import mobile.labs.acw.Class.Managers.JsonManager;
import mobile.labs.acw.Class.PuzzleImage;
import mobile.labs.acw.R;

/**
 * Created by Alexander on 22/02/2017.
 */

public class mainMenuActivity extends AppCompatActivity {

    public static final String PUZZLE_DIRECTORY = "http://www.hull.ac.uk/php/349628/08027/acw/";
    public static final String PUZZLE_INDEX = "index.json";
    public static final String PUZZLE_FILES = "puzzles/";
    public static final String PUZZLE_PICTURESET = "picturesets/";
    public static final String PUZZLE_IMAGES = "images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        if( !ImageManager.m_Init )
            new ImageManager(getApplicationContext()); // initialise ImageManager
        if( !JsonManager.m_Init)
            new JsonManager(getApplicationContext()); // initialise JsonManager
        if( !GameManager.m_Init )
         new GameManager(getApplicationContext(), JsonManager.getJsonList()); // initialise GameManager

        // setup start button listener
        Button startBut = (Button) findViewById(R.id.start_button);
        startBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), playGameActivity.class);
                startActivity(intent);
            }
        });

        // setup exit button listener
        Button exitBut = (Button) findViewById(R.id.exit_button);
        exitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

}
