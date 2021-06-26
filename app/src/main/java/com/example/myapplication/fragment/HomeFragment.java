package com.example.myapplication.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.SearchActivity;
import com.example.myapplication.adapter.TrendingAdapter;
import com.example.myapplication.model.trending.GifTrendingResultsItem;
import com.example.myapplication.view.GifViewModel;
import com.tenor.android.core.network.ApiClient;
import com.tenor.android.core.response.WeakRefCallback;
import com.tenor.android.core.response.impl.GifsResponse;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private TrendingAdapter gifTrendingAdapter;
    private RecyclerView rvGifTrending;
    //    private GifTrendingViewModel gifTrendingViewModel;
    private GifViewModel gifViewModel;

    private ImageButton btnSearch;
    private EditText et_search;
    private ProgressDialog progressDialog;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setTitle("Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Trying Fetching Data");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_search = view.findViewById(R.id.et_search);
        et_search.setOnEditorActionListener((v, actionId, event) -> {
            String gif =et_search.getText().toString();
            if (gif.isEmpty()){
                Toast.makeText(this.getContext(), "Please fill the search box!", Toast.LENGTH_SHORT).show();
            }else{
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    progressDialog.show();
                    Intent intent = new Intent(getContext(), SearchActivity.class);
                    intent.putExtra("tag",gif);
                    getContext().startActivity(intent);
                }
            }
            return false;
        });

        /*btnSearch = view.findViewById(R.id.fragmentcategories_btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gif =et_search.getText().toString();
                if (gif.isEmpty()){
                    Toast.makeText(getContext(), "Please fill the search box!", Toast.LENGTH_SHORT).show();
                }else{
//                    progressDialog.show();
                    Intent intent = new Intent(getContext(), SearchActivity.class);
                    intent.putExtra("tag",gif);
                    getContext().startActivity(intent);
                }
            }
        });*/

        gifTrendingAdapter = new TrendingAdapter(getContext());
        gifTrendingAdapter.notifyDataSetChanged();

        rvGifTrending = view.findViewById(R.id.rv);
        rvGifTrending.setLayoutManager(new GridLayoutManager(getContext(),2));

        gifViewModel = new ViewModelProvider(this).get(GifViewModel.class);
        gifViewModel.setGifTrending();
        gifViewModel.getGifTrending().observe(this,getGifTrending);

        rvGifTrending.setAdapter(gifTrendingAdapter);
    }

    private Observer<ArrayList<GifTrendingResultsItem>> getGifTrending = new Observer<ArrayList<GifTrendingResultsItem>>() {
        @Override
        public void onChanged(ArrayList<GifTrendingResultsItem> gifTrendingResultsItems) {
            if (gifTrendingResultsItems != null){
                gifTrendingAdapter.setData(gifTrendingResultsItems);
            }
        }
    };
}