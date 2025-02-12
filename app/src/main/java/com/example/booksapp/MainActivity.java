package com.example.booksapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.NetworkInterface;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editSearch;
    private Button buttonSearch;
    private RecyclerView recyclerView;
    private ArrayList<itemData> values;
    private itemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSearch=findViewById(R.id.edit_query);
        buttonSearch=findViewById(R.id.recycler_view);
        recyclerView=findViewById(R.id.recycler_view);

        values=new ArrayList<>();
        itemAdapter=new itemAdapter(this,values);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBooks();
            }
        });
    }
    private void searchBooks(){
        String queryString=editSearch.getText().toString();
        ConnectivityManager connMgr=(ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connMgr.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnected() && queryString.length()>0){
            new FetchBook(this,values,itemAdapter,recyclerView)
                    .execute(queryString);


        }else
            Toast.makeText(this, "Please check your network connection"
                    , Toast.LENGTH_SHORT).show();
    }
}