package ru.geekbrains.githubclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.geekbrains.githubclient.mvp.presenter.Presenter;
import ru.geekbrains.githubclient.mvp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private Presenter presenter;

    private Button buttonCounter1;
    private Button buttonCounter2;
    private Button buttonCounter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        buttonCounter1 = findViewById(R.id.btn_counter1);
        buttonCounter2 = findViewById(R.id.btn_counter2);
        buttonCounter3 = findViewById(R.id.btn_counter3);

        buttonCounter1.setOnClickListener(this);
        buttonCounter2.setOnClickListener(this);
        buttonCounter3.setOnClickListener(this);

        findViewById(R.id.btn_counter1).setTag(0);
        findViewById(R.id.btn_counter2).setTag(1);
        findViewById(R.id.btn_counter3).setTag(2);

    }

    @Override
    public void setButtonText(int index, String text) {
        Button button = getWindow().getDecorView().getRootView().findViewWithTag(index);
        button.setText(text);
    }

    @Override
    public void onClick(View view) {
        presenter.counterClick((int) view.getTag());
    }
}