/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package position;

/**
 *
 * @author Enubs
 */
public class LinkedPositionalList<E> implements PositionalList<E> {

    private static class Node<E> implements Position<E>{

        private Node<E> prev;
        private E element;
        private Node<E> next;
        
        public Node(Node<E> prev, E element, Node<E> next){
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
        
        @Override
        public E getElement() throws IllegalStateException {
            if(next == null){
                throw new IllegalStateException("Position is no longer valid.");
            }
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }// end of Node<E> class
    
    private Node<E> header, trailer;
    private int size;
    
    public LinkedPositionalList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(header, null, null);
        header.setNext(trailer);
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Invalid position.");
        }
        
        Node<E> node = (Node<E>) p;
        
        if(node.getNext() == null){
            throw new IllegalArgumentException("p is no longer valid");
        }
        return node;
    }
    
    private Position<E> position(Node<E> node){
        if(node == header || node == trailer){
            return null;
        }
        
        return node;
    }
    
    private Position<E> addBetween(Node<E> prev, E element, Node<E> next){
        Node<E> newNode = new Node<>(prev, element, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
        return position(newNode);
    }
    
    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getPrev();
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getNext();
    }

    @Override
    public Position<E> addFirst(E element) {
        return addBetween(header, element, header.getNext());
    }

    @Override
    public Position<E> addLast(E element) {
        return addBetween(trailer.getPrev(), element, trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E element) {
        Node<E> node = validate(p);
        return addBetween(node.getPrev(), element, node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E element) {
        Node<E> node = validate(p);
        return addBetween(node, element, node.getNext());
    }

    @Override
    public E set(Position<E> p, E element) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(element);
        return temp;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        E temp = node.getElement();
        node.setNext(null);
        node.setPrev(null);
        node.setElement(null);
        return temp;
    }
    
}
