package ru.geekbrains.githubclient.mvp.presenter;

import ru.geekbrains.githubclient.mvp.model.Model;
import ru.geekbrains.githubclient.mvp.view.MainView;

public class Presenter {
    private MainView view;
    private Model model = new Model();

    public Presenter(MainView view) {
        this.view = view;
    }

    public void counterClick(int id) {
        int nextValue = model.getCurrent(id) + 1;
        model.set(id, nextValue);
        view.setButtonText(id, String.valueOf(nextValue));
    }
}
