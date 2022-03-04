package Listener;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvnw5.R;

import org.w3c.dom.Text;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView,
                                 final ClickListener clickListener) {
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                }

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }
        });

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());

        if (child instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) child;

            for (int _numChildren = viewGroup.getChildCount() - 1; _numChildren >= 0; --_numChildren) {
                View _child = viewGroup.getChildAt(_numChildren);
                Rect _bounds = new Rect();
                _child.getHitRect(_bounds);
                if (_bounds.contains((int) e.getX() - viewGroup.getLeft(), (int) e.getY() - viewGroup.getTop())) {
                    if (_child instanceof ImageView)
                        return false;

                }
            }

        }

        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildAdapterPosition(child));
        }

        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());

        if (child instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) child;

            for (int _numChildren = viewGroup.getChildCount() - 1; _numChildren >= 0; --_numChildren) {
                View _child = viewGroup.getChildAt(_numChildren);
                Rect _bounds = new Rect();
                _child.getHitRect(_bounds);
                if (_bounds.contains((int) e.getX() - viewGroup.getLeft(), (int) e.getY() - viewGroup.getTop())) {
                    if (_child instanceof ImageView) {
                        

                    }

                }
            }

        }

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
