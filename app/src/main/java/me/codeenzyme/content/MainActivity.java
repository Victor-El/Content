package me.codeenzyme.content;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String[] words;
    private RecyclerView recyclerView;
    private WordsAdapter wordsAdapter;
    private LinearLayoutManager linearLayoutManager;
    //private String[] test = {"Hello", "hi"};

    Cursor cursor;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        words = new String[]{"Dev", "Tech", "FrontEnd", "BackEnd", "Recursion"};

        wordsAdapter = new WordsAdapter(words, this);

        recyclerView.setAdapter(wordsAdapter);

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserDictionary.Words.APP_ID, "me.codeenzyme.content");
        contentValues.put(UserDictionary.Words.FREQUENCY, 200);
        contentValues.put(UserDictionary.Words.WORD, "CodeEnzyme");
        contentValues.put(UserDictionary.Words.LOCALE, "en_us");

        getContentResolver().insert(UserDictionary.Words.CONTENT_URI, contentValues);

        cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI, new String[] {UserDictionary.Words._ID, UserDictionary.Words.WORD}, null, null, null, null);

//        while(cursor.moveToNext()) {
//            Log.d("Cursor", cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD)));
//        }

        Log.d("Cursor", cursor.getCount() + "");
    }
}