package ceng.anadolu.bim492;

public interface Subject
{

    void register(Player B);
    void unregister(Player B);
    void notifyObserver();

}