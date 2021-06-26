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

}