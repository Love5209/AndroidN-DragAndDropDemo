package com.example.noughtchen.andndemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.DropPermissions;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private TextView dropedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "I'm Second Activity！", Snackbar.LENGTH_LONG).show();
            }
        });

        dropedText = (TextView) findViewById(R.id.text_drop);
        dropedText.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                switch (dragEvent.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_STARTED");
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_EXITED");
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_ENDED");
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d(TAG, "ACTION_DROP event");
                        dropedText.setText(dragEvent.getClipData().getItemAt(0).getText());
                        break;

                    default:
                        break;
                }

                return true;
            }
        });
    }

//  如果需要传递URI权限Activity.requestDropPermissions()
    @Override
    public DropPermissions requestDropPermissions(DragEvent event) {
        Log.d(TAG, "requestDropPermissions");
        return super.requestDropPermissions(event);
    }

    @Override
    public void onMultiWindowChanged(boolean inMultiWindow) {
        Log.i(TAG, "inMultiWindow = " + inMultiWindow);
        super.onMultiWindowChanged(inMultiWindow);
    }
}
