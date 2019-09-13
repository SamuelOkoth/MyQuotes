package com.example.quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
      private SharedPreferences mSharedPreferences;
      private SharedPreferences.Editor mEditor;
      private ValueEventListener mSearchedAuthorReferenceListener;
      private DatabaseReference mSearchedAuthorReference;
    @BindView(R.id.addButton) Button mAddButton;
    @BindView(R.id.readButton) Button mReadButton;
    @BindView(R.id.picButton) Button mPicButton;
    @BindView(R.id.authorEditText) EditText mAuthorEditText;
    @BindView(R.id.savedQuotesButton) Button mSavedQuotesButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSearchedAuthorReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_AUTHOR);

        mSearchedAuthorReferenceListener = mSearchedAuthorReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot authorSnapshot : dataSnapshot.getChildren()) {
                    String author = authorSnapshot.getValue().toString();
                    Log.d("Author updated", "author: " + author); //log
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
       });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };


        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(addIntent);
            }

        });


        mReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //               String author = mAuthorEditText.getText().toString();
//                if(!(author).equals("")) {
//                    addToSharedPreferences(author);
//                  }
                if (view == mReadButton) {
                    String author = mAuthorEditText.getText().toString();
                    saveAuthorToFirebase(author);

                    Intent addIntent = new Intent(MainActivity.this, ReadActivity.class);
                    addIntent.putExtra("author", author);
                    startActivity(addIntent);

                }
            }


            public void saveAuthorToFirebase(String author) {
                mSearchedAuthorReference.push().setValue(author);
            }





//            private void addToSharedPreferences(String author) {
//                mEditor.putString(Constants.PREFERENCES_AUTHOR_KEY, author).apply();
//
//            }
   });
        mSavedQuotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mSavedQuotesButton) {
                    Intent intent = new Intent(MainActivity.this, SavedReadListActivity.class);
                    startActivity(intent);
                }
            }

        });

        mPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MainActivity.this, PicActivity.class);
                startActivity(addIntent);
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedAuthorReference.removeEventListener(mSearchedAuthorReferenceListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_logout){
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}


