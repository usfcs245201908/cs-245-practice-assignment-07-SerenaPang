public class LinkedList<T> implements List<T> {
    private Node first;
    private Node last;

    private int size;

    private Object[] elements=null;
    private int current;
    private int capacity;
    public static final int DEFAULT_SIZE=10;
    public LinkedList(){
        this(DEFAULT_SIZE);
    }
    public LinkedList(int size){
        if (size<0){
            throw new RuntimeException();
        }else {
            this.elements=new Object[size];
            this.current=0;
            capacity=size;
        }
    }

    public void add(Object obj) {
        Node newNode = new Node();
        newNode.value = obj;
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        this.size++;
        this.current++;
    }

    public T remove(int index) {
        checkElementIndex(index);

        this.size--;
        this.current--;
        return (T) getNode(index);
    }

    public Node<T> getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(int pos, T item) {
//        checkElementIndex(pos);
        Node temp = null;
        if(first!=null) {
            temp = first;
            for(int i=0;i<pos;i++) {
                temp = temp.next;
            }
        }
        Node newNode = new Node();
        newNode.value = item;
        if(temp!=null) {
            newNode.prev=temp.prev;
            newNode.next=temp;
            temp.prev=newNode;
            newNode.prev.next=newNode;
            this.size++;
        }
        this.current++;

    }

    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).value;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int size() {
        return this.size;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            add(index);
    }

    private boolean isElementIndex(int index) {

        return index >= 0 && index < size;
    }


}
