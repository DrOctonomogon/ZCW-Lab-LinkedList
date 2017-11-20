public class DLinkedList<E extends Comparable> {

    DNode<E> start;

    public DLinkedList() {
        start = null;
    }


    public class DNode<E extends Comparable> {

        private E value;
        private DNode<E> next;
        private DNode<E> previous;

        public DNode(DNode<E> next, DNode<E> previous, E value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        //        @Override
        public int compareTo(E e) {
            int retVal = 0;
            if (this.getValue().compareTo(e) > 0) {
                retVal = 1;
            } else if (this.getValue().compareTo(e) < 0) {
                retVal = -1;
            }
            return retVal;
        }

        public DNode<E> getNext() {
            return next;
        }

        public void setNext(DNode<E> next) {
            this.next = next;
        }

        public DNode<E> getPrevious() {
            return previous;
        }

        public void setPrevious(DNode<E> previous) {
            this.previous = previous;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

    }

    public void add(E value) {
        if (start != null) {
            DNode<E> pointer = start;

            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            DNode<E> node = new DNode<>(null, pointer, value);
            pointer.setNext(node);
        } else {
            start = new DNode<>(null, null, value);
        }
    }

    public void remove(int index) {
        DNode<E> pointer = start;
        int counter = 0;

        if (start != null && index == 0) {
            start = pointer.getNext();
        }
        while (pointer.getNext() != null) {
            if (counter == index) {
                DNode<E> a = pointer.getPrevious();
                DNode<E> b = pointer.getNext();
                a.setNext(b);
                b.setPrevious(a);
                break;
            }
            pointer = pointer.getNext();
            counter++;
        }
    }

    public boolean contains(E value) {
        boolean contained = false;
        DNode<E> pointer = start;

        while (pointer.getNext() != null) {
            if (pointer.getValue().equals(value)) {
                contained = true;
                break;
            }
            pointer = pointer.getNext();
        }

        if (pointer.getNext() == null && !contained) {
            if (pointer.getValue().equals(value)) {
                contained = true;
            }
        }
        return contained;
    }

    public int find(E value) {
        int counter = 1;
        int index = -1;
        DNode<E> pointer = start;

        if (value.equals(pointer.getValue())) {
            return 0;
        }
        pointer = pointer.getNext();
        while (pointer.getNext() != null) {
            if (pointer.getValue().equals(value)) {
                index = counter;
                break;
            }
            counter++;
            pointer = pointer.getNext();
        }
        if (pointer.getValue().equals(value) && index == -1) {
            index = counter;
        }

        return index;
    }

    public int size() {
        DNode<E> pointer = start;
        int count = 1;

        if (start == null) {
            return 0;
        } else if (start.getNext() == null) {
            return 1;
        }

        while (pointer.getNext() != null) {
            count++;
            pointer = pointer.getNext();
        }
        return count;
    }

    public E get(int index) {
        DNode<E> pointer = start;
        E ret = null;

        if (index == 0) {
            return pointer.getValue();
        }

        if (pointer != null) {
            int count = 0;

            while (pointer.getNext() != null) {
                if (index == count) {
                    ret = pointer.getValue();
                }
                count++;
                pointer = pointer.getNext();
            }

            if (pointer.getNext() == null && ret == null) {
                if (index == count) {
                    ret = pointer.getValue();
                }
            }
        }
        return ret;
    }

    public DLinkedList copy() {
        DNode<E> pointer = start;
        DLinkedList<E> listCopy = new DLinkedList<>();

        if (pointer == null) {
            return null;
        }

        while (pointer.getNext() != null) {
            listCopy.add(pointer.getValue());
            pointer = pointer.getNext();
        }
        listCopy.add(pointer.getValue());

        return listCopy;
    }


//    public void sort() {
//        DNode<E> pointer = start;
//
//        int listSize = this.size();
//
//        for(int i = 0; i < listSize; i++) {
//
//            if(pointer.getValue().compareTo(pointer.getNext().getValue()) > 0) {
//                pointer.getNext().setPrevious(pointer.getPrevious()); // b.prev = a.prev
//                pointer.setNext(pointer.getNext().getNext()); //
//
//            }
//
//        }
//
//    }


    public void sort() {
        DNode<E> a = start;
        DNode<E> b = a.getNext();

        E nextVal = b.getValue();

        while (b.getNext() != null) {

            if (a.compareTo(nextVal) > 0) {
                if (a.getPrevious() == null) {
                    swapAB(a, b);
                    start = b;
                } else if (b.getNext() != null) {
                    swapAB(a, b);
                }
            } else if (a.compareTo(nextVal) < 0) {
                a = b;
            }

            b = a.getNext();
            nextVal = b.getValue();

        }
        if (b.getNext() == null && a.compareTo(nextVal) > 0) {
            swapAB(a, b);
            //            a.setNext(null);
//            b.setPrevious(a.getPrevious());
//            a.setPrevious(b);
//            b.setNext(a);
        }
    }

    private void swapAB(DNode<E> a, DNode<E> b) {
        a.setNext(b.getNext());
        b.setPrevious(a.getPrevious());
        a.setPrevious(b);
        b.setNext(a);
    }

}
