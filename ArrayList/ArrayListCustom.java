package DSA.Arrays;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ArrayListCustom<E> extends AbstractList<E> implements List<E>{

    //variables
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;
    private int size;

    //constructors
    public ArrayListCustom(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    //functions
    public void ensureCapacity(int minCapacity){
        if(elementData.length < minCapacity){
            modCount++;
            grow(minCapacity);
        }
    }

    private Object[] grow(int minCapacity){
        int oldCapacity = elementData.length;
        int newCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        if(oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            newCapacity = Math.max(oldCapacity+minCapacity, oldCapacity+(oldCapacity>>1));
            return elementData = Arrays.copyOf(elementData, newCapacity);
        }
        return elementData = new Object[newCapacity];
    }

    private Object[] grow(){
        return grow(size+1);
    }

    private void RangeCheck(int index){
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    @Override
    public E get(int index) {
        RangeCheck(index);
        return elementData(index);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index){
        return (E) elementData[index];
    }

    public E set(int index, E element){
        RangeCheck(index);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public boolean add(E e){
        modCount++;
        add(e, elementData, size);
        return true;
    }

    private void add(E e, Object[] elementData, int s){
        if(s == elementData.length){
            elementData = grow();
        }
        elementData[s] = e;
        size = s+1;
    }

    public E remove(int index){
        RangeCheck(index);

        @SuppressWarnings("unchecked")
                E oldvalue = (E) elementData[index];
        fastRemove(elementData, index);
        return oldvalue;
    }

    private void fastRemove(Object[] elementData, int i){
        modCount++;
        final int newSize;
        if((newSize = size - 1) > i)
            System.arraycopy(elementData, i+1, elementData, i, newSize - i);
        elementData[size = newSize] = null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return super.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return super.parallelStream();
    }

    @Override
    public void addFirst(E e) {
        super.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        super.addLast(e);
    }

    @Override
    public E getFirst() {
        return super.getFirst();
    }

    @Override
    public E getLast() {
        return super.getLast();
    }

    @Override
    public E removeFirst() {
        return super.removeFirst();
    }

    @Override
    public E removeLast() {
        return super.removeLast();
    }

    @Override
    public List<E> reversed() {
        return super.reversed();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return super.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        super.sort(c);
    }
}
