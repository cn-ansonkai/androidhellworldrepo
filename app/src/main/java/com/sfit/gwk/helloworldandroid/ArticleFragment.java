package com.sfit.gwk.helloworldandroid;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleFragment extends Fragment {

    final static String ARG_POSITION_KEY = "com.sfit.gwk.POSITION";
    int mCurrentSelectedPosition = -1;

    public ArticleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ArticleFragment.
     */
    public static ArticleFragment newInstance() {
        ArticleFragment fragment = new ArticleFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(ARG_POSITION_KEY);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

   @Override
    public void onStart() {
       super.onStart();
       // During startup, check if there are arguments passed to the fragment.
       // onStart is a good place to do this because the layout has already been
       // applied to the fragment at this point so we can safely call the method
       // below that sets the article text.
       Bundle args = getArguments();
       if (args != null) {
           updateArticleView(args.getInt(ARG_POSITION_KEY));
       } else if (mCurrentSelectedPosition != -1) {
           //pos has been set during instantiation
           updateArticleView(mCurrentSelectedPosition);
       }
   }

    public void updateArticleView(int pos) {
        TextView artcleView = (TextView)getActivity().findViewById(R.id.article_text_view);
        artcleView.setText(Ipsum.Articles[pos]);
        mCurrentSelectedPosition = pos;
    }

    @Override
    public void onSaveInstanceState(Bundle pstate) {
        super.onSaveInstanceState(pstate);

        pstate.putInt(ARG_POSITION_KEY, mCurrentSelectedPosition);
    }

}
