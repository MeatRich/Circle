package qwe.circle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class UserTest extends AppCompatActivity {

   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // вызываем функцию onCreate класса-родителя
        Test d = new Test(this); // создаем экземпляр нашего класса
        setContentView(d); // и устанавливаем отображение нашего класса
        //setContentView(R.layout.main);
    }

}
