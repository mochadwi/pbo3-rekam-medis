package app;

public interface BasePresenter<T> {
    void bind(T view);
    void unBind();
}
