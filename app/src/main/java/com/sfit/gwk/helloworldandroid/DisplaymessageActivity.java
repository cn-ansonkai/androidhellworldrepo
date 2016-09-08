package com.sfit.gwk.helloworldandroid;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplaymessageActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaymessage);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_M);
        TextView textView = new TextView(this); //(TextView)findViewById(R.id.firs_text_view);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup)findViewById(R.id.activity_displaymessage);
        layout.addView(textView);

        if (findViewById(R.id.activity_displaymessage) != null) {
            if(savedInstanceState != null) {
                return;
            }
            HeadlinesFragment headlinesFragment = new HeadlinesFragment();
            headlinesFragment.setArguments(intent.getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_displaymessage, headlinesFragment).commit();

        }


    }

    public void onArticleSelected(int pos) {
        // if two-pane layout
        //else
        ArticleFragment articleFrag = ArticleFragment.newInstance();
        Bundle args = new Bundle();
        args.putInt(ArticleFragment.ARG_POSITION_KEY, pos);
        articleFrag.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.activity_displaymessage, articleFrag);
        transaction.addToBackStack(null);

        transaction.commit();

    }
}
