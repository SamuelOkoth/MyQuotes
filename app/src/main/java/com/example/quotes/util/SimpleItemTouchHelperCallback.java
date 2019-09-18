package com.example.quotes.util;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
private final ItemTouchHelperAdapter mAdapter;

public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter adapter) {
        mAdapter = adapter;
        }

@Override
public boolean isLongPressDragEnabled() {
        return true;
        }

@Override
public boolean isItemViewSwipeEnabled() {
        return true;
        }

@Override
public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
        }

@Override
public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source,
        RecyclerView.ViewHolder target) {
        if (source.getItemViewType() != target.getItemViewType()) {
        return false;
        }
        mAdapter.onItemMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
        }

@Override
public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
        }
}