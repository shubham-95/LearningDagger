package com.shubham.learningdagger.Interfaces;

public interface BasePresenter<T> {
    void TakeView(T view); //Binds view with our presenter
    void DropView(); // Drops the reference to the view.
}
