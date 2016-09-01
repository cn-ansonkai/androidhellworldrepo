package com.sfit.gwk.helloworldandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;


public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener mSelectedCallback;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int pos);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Ipsum.Headlines));

    }

    @Override
    public void onStart() {
        super.onStart();

        // When in two-pane layout, say layout-large
        // ...
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity)
    }
}

