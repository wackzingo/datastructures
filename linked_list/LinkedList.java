public class LinkedList<T> implements iterable {

    private Node<T> head;

    /**
    * Make an empty list.
    */
    public LinkedList() {
      head = null;
    }

    /**
    * Return true if list is empty.
    */
    public boolean isEmpty() {
      return head == null;
    }

    /**
    * Inserts new node at beginning of list.
    */
    public void addFirst(T data) {
      head = new Node<T>(data, head);

    }

    /**
    * Returns data stored at first element in the list.
    */
    public T getFirst() {
      if(head == null) throw NoSuchElementException();
      return head.data;
    }

    /**
    * Removes and returns data stored at first element in the list.
    */
    public T removeFirst() {
      T tmp = getFirst();
      head = head.next;
      return tmp;
    }

    /**
    * Inserts new node at end of list.
    */
    public void addLast(T data) {
      if(head == null) {
        addFirst(data);
      } else {
        Node<T> tmp = head;
        while(tmp.next != null) {
          tmp = tmp.next;
        }
        tmp.next = new Node(data, null);
      }
    }

    /**
    * Returns data stored at the last element in the list.
    */
    public T getLast() {
      if(head == null) throw NoSuchElementException();

      Node<T> tmp = head;

      while(tmp != null) {
        tmp = tmp.next;
      }
      return tmp.data;
    }


    /**
    * Removes all nodes from the list.
    */
    public void clear() {
      head = null;
    }

    /**
    * Returns true if the list contains the specified data.
    */
    public boolean contains(T data) {
      for(T tmp : this) {
        if(tmp.equals(data)) {
          return true;
        }
      }

      return false;
    }

    /**
    * Get data located at pos i in the list.
    */
    public T get(int pos) {
      if(head == null)  throw IndexOutOfBoundsException();

      Node<T> tmp = head;

      for(int i = 0; i < pos; i++) {
        tmp = tmp.next;
      }

      if(tmp.next == null) throw IndexOutOfBoundsException();

      return tmp.data;
    }


    /**
    * Displays the list as a string.
    */
    public String toString() {
      StringBuilder str = new StringBuilder();
      String seperator = "";
      str.append("[");
      for(Object o: this ) {
        str.append(seperator);
        str.append(o);
        seperator = ", ";
      }
      str.append("]");
      return str.toString();

    }


    private static class Node<T> {
      private T data;
      private Node<T> next;

      public Node(T data, Node next) {
        this.data = data;
        this.next = next;
      }
    }


    public Iterator<T> iterator() {
      return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> next;
        public LinkedListIterator() {
          return head;
        }

        public boolean hasNext() {
          return head != null;
        }

        public T next() {
          if(!hasNext()) throw NoSuchElementException();

          T next = next.data;
          next = next.next;
          return next;
        }

        public void remove() { throw UnsupportedOperationException();}
    }
}
