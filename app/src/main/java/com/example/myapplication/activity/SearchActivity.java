package com.example.myapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GifSearchAdapter;
import com.example.myapplication.model.search.GifSearchResultsItem;
import com.example.myapplication.view.GifViewModel;
import com.tenor.android.core.constant.StringConstant;
import com.tenor.android.core.model.impl.Result;
import com.tenor.android.core.response.BaseError;
import com.tenor.android.core.response.impl.GifsResponse;
import com.tenor.android.core.util.AbstractLayoutManagerUtils;
import com.tenor.android.core.util.AbstractListUtils;
import com.tenor.android.core.util.AbstractUIUtils;
import com.tenor.android.core.weakref.WeakRefOnScrollListener;
import com.tenor.android.core.widget.adapter.AbstractRVItem;

import java.util.ArrayList;
import java.util.List;

/**
 * SearchActivity will display GIFs in a "waterfall" vertical layout,
 * where the aspect ratio of the GIFs will be maintained.
 *
 * Related search terms will be displayed in a horizontal top bar.
 * Clicking one will open a new instance of SearchActivity.
 */
public class SearchActivity extends AppCompatActivity {
    private RecyclerView rv_search_item;
    private GifSearchAdapter gifSearchAdapter;
    private GifViewModel gifViewModel;

    private TextView tvTag;
    private ImageView iv_back;

    private ImageButton btnSearch;
    private EditText et_search;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //getSupportActionBar().hide();

        Intent intent = getIntent();
        iv_back = findViewById(R.id.back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*et_search = findViewById(R.id.et_search);
        //et_search.setText(intent.getStringExtra("tag"));
        et_search.setOnEditorActionListener((v, actionId, event) -> {
            String gif =et_search.getText().toString();
            if (gif.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill the search box!", Toast.LENGTH_SHORT).show();
            }else{
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    progressDialog.show();
                    Intent intentSearch = new Intent(getApplicationContext(), SearchActivity.class);
                    //intentSearch.putExtra("tag",gif);
                    getApplicationContext().startActivity(intentSearch);
                }
            }
            return false;
        });

        /*btnSearch = findViewById(R.id.activitysearch_btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gif =et_search.getText().toString();
                if (gif.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill the search box!", Toast.LENGTH_SHORT).show();
                }else{
//                    progressDialog.show();
                    Intent intentSearch = new Intent(getApplicationContext(), SearchActivity.class);
                    intentSearch.putExtra("tag",gif);
                    getApplicationContext().startActivity(intentSearch);
                }
            }
        });
        tvTag = findViewById(R.id.activitysearch_tv_tag);
        tvTag.setText("#"+intent.getStringExtra("tag"));*/

        gifSearchAdapter = new GifSearchAdapter(getApplicationContext());
        gifSearchAdapter.notifyDataSetChanged();

        rv_search_item = findViewById(R.id.rv_2);
        rv_search_item.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        gifViewModel = new ViewModelProvider(this).get(GifViewModel.class);
        gifViewModel.setGifSearch(intent.getStringExtra("tag"));
        gifViewModel.getGifSearch().observe(this,getGifSearch);
//
        rv_search_item.setAdapter(gifSearchAdapter);
    }

    public Observer<ArrayList<GifSearchResultsItem>> getGifSearch = new Observer<ArrayList<GifSearchResultsItem>>() {
        @Override
        public void onChanged(ArrayList<GifSearchResultsItem> gifSearchResultsItems) {
            if (gifSearchResultsItems !=null){
                gifSearchAdapter.setData(gifSearchResultsItems);
            }
        }
    };


}