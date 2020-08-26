public class LinkedListDeque <T> implements Deque<T>{
    private class IniNode {
        public IniNode prev;
        public T item;
        public IniNode next;

        public IniNode(IniNode p, T f, IniNode r) {
            prev = p;
            item = f;
            next = r;
        }
    }

    private IniNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IniNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    @Override
    public void addFirst(T item) {
        sentinel.next = new IniNode(sentinel, item ,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        sentinel.prev.next = new IniNode (sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }
    @Override
    public boolean isEmpty() {
        if (sentinel.next.item == null) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        IniNode p = sentinel;
        while (p.next.item != null) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println(" ");
    }
    @Override
    public T removeFirst() {
        T outcome = sentinel.next.item;
        if (outcome != null) {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size += -1;
        }
        return outcome;
    }
    @Override
    public T removeLast() {
        T outcome = sentinel.prev.item;
        if (outcome != null) {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size += -1;
        }
        return outcome;
    }
    @Override
    public T get(int index) {
        IniNode p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index += -1;
        }
        return p.item;
    }

    private T get_helper(IniNode a, int index) {
        if (index == 0) {
            return a.next.item;
        } else{
            index += -1;
            return get_helper(a.next,index);
        }
    }
    public T getRecursive(int index) {
        return get_helper(sentinel, index);
    }
}
