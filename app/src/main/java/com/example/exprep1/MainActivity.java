package com.example.exprep1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public Button button1;
    public Button button2;
    public DrawView drawView;
    public EditText editText;
    public String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawView.getMatrix();

        drawView = (DrawView) findViewById(R.id.draw_view);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.edit);
        button.setOnClickListener(buttonClick);
        button1.setOnClickListener(buttonClick1);
        button2.setOnClickListener(buttonClick2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void SetFigure(int num, int what)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                drawView.setNumber(num);
                drawView.setWhatDo(what);
                drawView.invalidate();
            }
        });
    }

    View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text = editText.getText().toString().trim();
            SetFigure(text.length(), 0);
        }
    };
    View.OnClickListener buttonClick1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text = editText.getText().toString().trim();
            SetFigure(text.length(), 1);
        }
    };
    View.OnClickListener buttonClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bitmap bmp = drawView.saveSignature();
        }
    };
}