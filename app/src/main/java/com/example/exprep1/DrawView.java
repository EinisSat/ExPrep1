package com.example.exprep1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class DrawView extends View {
    public Matrix matrix;
    public int number;
    public int whatDo;
    public boolean fillFlag = false;
    public DrawView(Context context) {
        super(context);
    }
    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
    public DrawView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber()
    {
        return number;
    }
    public void setWhatDo(int what)
    {
        this.whatDo = what;
    }
    public int getWhatDo()
    {
        return whatDo;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Paint paint;
        if(whatDo == 1);
            //canvas;
        else if(whatDo == 2)
            canvas.save();
        else {
        for(int i = 0; i < number; i++) {
            paint = new Paint();
            int random = new Random().nextInt(5);
            switch (random) {
                case 0:
                    paint.setColor(Color.GREEN);
                    break;
                case 1:
                    paint.setColor(Color.RED);
                    break;
                case 2:
                    paint.setColor(Color.WHITE);
                    break;
                case 3:
                    paint.setColor(Color.BLUE);
                    break;
                case 4:
                    paint.setColor(Color.YELLOW);
                    break;
                case 5:
                    paint.setColor(Color.MAGENTA);
                    break;
            }
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(10f);
            int randomX = new Random().nextInt(width);
            int randomY = new Random().nextInt(height);
            int randomRadius = new Random().nextInt(width / 5) + 20;
            canvas.drawCircle(randomX, randomY, randomRadius, paint);
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLACK);
            int randomBorder = new Random().nextInt(10);
            paint.setStrokeWidth(randomBorder);
            canvas.drawCircle(randomX, randomY, randomRadius, paint);
        }}
    }
    public Bitmap saveSignature(){

        Bitmap  bitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.draw(canvas);

        File file = new File(Environment.getExternalStorageDirectory() + "/sign.png");

        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
