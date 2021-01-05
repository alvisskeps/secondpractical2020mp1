package lv.alvis.repositoryg_alvis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button goBackToMain = (Button) findViewById(R.id.button_back_to_main);
        Button readPreferences = (Button) findViewById(R.id.button_read_preferences);
        TextView textField = (TextView) findViewById(R.id.text_field);
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.SHARED_PREFS, MODE_PRIVATE);

        goBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        readPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String preferencesValue = sharedPreferences.getString(MainActivity.KEY, "");

                if (preferencesValue.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Nothing Found", Toast.LENGTH_SHORT).show();
                } else {
                    textField.setText(preferencesValue);
                }
            }
        });
    }
}