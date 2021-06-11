package com.ailbaz.moststarredrepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RepoAdaptor mRepoAdaptor;
    private ArrayList<RepoViewModel> mRepoList;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Trending Repos");



        mRecycleView=findViewById(R.id.RecycleView);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRepoList=new ArrayList<>();

        mQueue= Volley.newRequestQueue(this);

        getData();

    }



    private void getData(){

        String url = "https://api.github.com/search/repositories?q=created:%3E2017-10-22&sort=stars&order=desc";

        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject repo = jsonArray.getJSONObject(i);

                                String nameOfORepo=repo.getString("name");
                                String descriptionOfRepo=repo.getString("description");
                                int numberOfStarsOfRepo=repo.getInt("stargazers_count");
                                String[] fullnameOfRepo=repo.getString("full_name").split("/");
                                String nameOfOwner=fullnameOfRepo[0];

                              mRepoList.add(new RepoViewModel(nameOfORepo,descriptionOfRepo,numberOfStarsOfRepo,nameOfOwner));

                            }

                            mRepoAdaptor=new RepoAdaptor(MainActivity.this,mRepoList);
                            mRecycleView.setAdapter(mRepoAdaptor);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

}