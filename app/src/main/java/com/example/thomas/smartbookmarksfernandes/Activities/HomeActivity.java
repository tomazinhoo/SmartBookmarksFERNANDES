package com.example.thomas.smartbookmarksfernandes.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thomas.smartbookmarksfernandes.R;

public class HomeActivity extends AppCompatActivity {

    private Button buttonShowBooks, buttonShowComments, buttonAddComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonShowBooks = (Button) findViewById(R.id.buttonShowBooks);
        buttonShowComments = (Button) findViewById(R.id.buttonShowComments);
        buttonAddComment = (Button) findViewById(R.id.buttonAddComment);

        buttonShowBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BooksActivity.class);
                startActivity(intent);
            }
        });
    }
}
