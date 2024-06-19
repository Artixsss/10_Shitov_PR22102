package com.example.a10_shitov_pr22102;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;


    public Draw2D(Context context) {
        super(context);
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.cat_bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);

        canvas.drawCircle(width - 60, 60, 50, mPaint);

        mPaint.setColor(Color.GREEN);

        canvas.drawRect(0, canvas.getHeight() - 30, width, height, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(64);
        canvas.drawText("Лужайка только для котов", 30, height - 32, mPaint);

// Текст под углом

        int x = width - 350;
        int y = 400;

        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(54);
        String str2rotate = "Лучик солнца!";

        canvas.save();
// Создаём ограничивающий прямоугольник для наклонного текста
// поворачиваем холст по центру текста
        canvas.rotate(-45, x + mRect.exactCenterX(), y + mRect.exactCenterY());

// Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, mPaint);

// восстанавливаем холст
        canvas.restore();


        canvas.drawBitmap(mBitmap, width - mBitmap.getWidth(), height - mBitmap.getHeight() - 10, mPaint);
    }
}