package com.sfit.gwk.helloworldandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_M = "com.sfit.gwk.MESSAGE";

//  private String textInEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        EditText editText = (EditText)findViewById(R.id.edit_message);
//        textInEdit = editText.getText().toString();
//
//    }


    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplaymessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_M, message);
        startActivity(intent);
    }
}
