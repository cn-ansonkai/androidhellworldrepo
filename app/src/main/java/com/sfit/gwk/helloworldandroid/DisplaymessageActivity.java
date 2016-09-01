package com.sfit.gwk.helloworldandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplaymessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaymessage);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_M);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup)findViewById(R.id.activity_displaymessage);
        layout.addView(textView);

        if (findViewById(R.id.activity_displaymessage) != null) {
            if(savedInstanceState != null) {
                return;
            }
            ArticleFragment articleFragment = ArticleFragment.newInstance();
            articleFragment.setArguments(intent.getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_displaymessage,articleFragment).commit();

        }


    }
}
