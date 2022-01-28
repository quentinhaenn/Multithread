package boiteAuLettre;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private int maxLength;
    private List<String> messages;
    private ReentrantLock lock;
    private Condition empty, full;

    public Buffer(int taille){
        maxLength = taille;
        messages = new LinkedList<String>();
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public Condition getEmpty() {
        return empty;
    }

    public void setEmpty(Condition empty) {
        this.empty = empty;
    }

    public Condition getFull() {
        return full;
    }

    public void setFull(Condition full) {
        this.full = full;
    }
}
