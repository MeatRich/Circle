package qwe.circle;

/**
 * Created by Лёка^_^ on 23.10.2017.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class Test extends View { // наследуем от View

    public Test(Context context) {
        super(context); // в конструкторе вызываем конструктор класса-родителя
    }

    public Color color;
    public int radius;
    public int x;
    public int y;

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);

        Paint paint = new Paint(); // создаем экземпляр класса Paint
        paint.setStyle(Paint.Style.FILL); // используем заливку во всех графических примитивах

        // закрашиваем всё белым цветом
        paint.setColor(Color.WHITE); // указываем, что используем белый цвет
        c.drawPaint(paint);

        // Рисуем красный круг
        paint.setAntiAlias(true); // задаем режим сглаживания
        paint.setColor(Color.RED); // выбираем зеленый цвет
        c.drawCircle(550, 130, 100, paint); // рисуем круг


      /*  // Рисуем черный прямоугольник
        paint.setColor(Color.BLACK); // выбираем черный цвет
        c.drawRect(20, 200, 460, 230, paint); // рисуем прямоугольник

        // Рисуем текст
        paint.setColor(Color.BLUE); // указываем, что используем синий цвет
        paint.setStyle(Paint.Style.FILL); // используем заливку
        paint.setAntiAlias(true); // режим сглаживания
        paint.setTextSize(30); // задаем размер текста
        c.drawText("Текст", 30, 200, paint); // задаем текст и его координаты*/

        // восстанавливаем холст
        c.restore();
    }

}