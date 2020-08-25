public class LinkedListDeque <T>{
    public class IniNode {
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

    public void addFirst(T item) {
        sentinel.next = new IniNode(sentinel, item ,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new IniNode (sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        if (sentinel.next.item == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IniNode p = sentinel;
        while (p.next.item != null) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println(" ");
    }

    public T removeFirst() {
        T outcome = sentinel.next.item;
        if (outcome != null) {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size += -1;
        }
        return outcome;
    }

    public T removeLast() {
        T outcome = sentinel.prev.item;
        if (outcome != null) {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size += -1;
        }
        return outcome;
    }

    public T get(int index) {
        IniNode p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index += -1;
        }
        return p.item;
    }

    public LinkedListDeque(LinkedListDeque other) {
        while (! (other.isEmpty())){
            T current = (T) other.get(0);
            sentinel.next = new IniNode(sentinel, current ,sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            size += 1;
            other.removeFirst();
        }
    }

    private T helper(LinkedListDeque other, int index) {
        if(index == 0) {
            return (T) other.sentinel.next.item;
        }
        else{
            other.sentinel.next = other.sentinel.next.next;
            return helper(other, index - 1);
        }
    }

    public T getRecursive(int index) {
        LinkedListDeque copy = new LinkedListDeque(this);
        return helper(copy, index);
    }
}
