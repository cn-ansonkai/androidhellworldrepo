package com.sfit.gwk.helloworldandroid;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener mSelectedCallback;

    public interface OnHeadlineSelectedListener {
        void onArticleSelected(int pos);
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
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mSelectedCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        // Notify the parent activity of selected item
        mSelectedCallback.onArticleSelected(pos);

        // Set the item as checked to be highlighted when in two-pane layout
        // getListView().setItemChecked(pos, true);
    }
}

