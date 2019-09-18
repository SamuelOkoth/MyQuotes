package com.example.quotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.quotes.models.Quote;
import com.example.quotes.util.ItemTouchHelperAdapter;
import com.example.quotes.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseReadListAdapter extends FirebaseRecyclerAdapter<Quote, FirebaseReadViewHolder> implements ItemTouchHelperAdapter {
    private Query mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Quote> mQuotes = new ArrayList<>();

    public FirebaseReadListAdapter(FirebaseRecyclerOptions<Quote> options,
                                   Query ref,
                                   OnStartDragListener onStartDragListener,
                                   Context context){
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mQuotes.add(dataSnapshot.getValue(Quote.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onBindViewHolder(@NonNull final FirebaseReadViewHolder firebaseReadViewHolder, int position, @NonNull Quote quote) {
        firebaseReadViewHolder.bindQuote(quote);
        firebaseReadViewHolder.mQuoteTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(firebaseReadViewHolder);
                }
                return false;
            }
        });

        firebaseReadViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReadDetailActivity.class);
                intent.putExtra("position", firebaseReadViewHolder.getAdapterPosition());
                intent.putExtra("quotes", Parcels.wrap(mQuotes));
                mContext.startActivity(intent);
            }
        });
    }
    @NonNull
    @Override
    public FirebaseReadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.read_list_item_drag, parent, false);
        return new FirebaseReadViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition){
        Collections.swap(mQuotes, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFirebase();
        return false;
    }
    @Override
    public void stopListening() {
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }

    @Override
    public void onItemDismiss(int position){
        mQuotes.remove(position);
        getRef(position).removeValue();
    }
    private void setIndexInFirebase() {
        for (Quote quote : mQuotes) {
            int index = mQuotes.indexOf(quote);
            DatabaseReference ref = getRef(index);
            quote.setIndex(Integer.toString(index));
            ref.setValue(quote);
        }
    }
}