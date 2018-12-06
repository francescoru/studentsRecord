/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsrecords;

import java.util.Arrays;
/**
 *
 * @author Francesco Rubino
 */
public class StudentArrayList<T>  {
    
        // class variablesw 
        private int size = 0;
        //final variable to put the number of elements int he array
        private static final int numberOfElements = 10;
        //array to keep the objects. 
        private Object list[];

        public StudentArrayList() {
            //create an array of size 10 when an object of this class is created. 
                list = new Object[numberOfElements];
        }

        public void add(T e) {
            //add new element
            //check if the array has the capacity. 
                if (size == list.length) {
                        checkIndeces();
                }
                list[size++] = e;
        }


        private void checkIndeces() {
            //check size of the array
                int newSize = list.length * 2;
                list = Arrays.copyOf(list, newSize);
        }

        public T get(int i) {
            //get element in the list at position i
                if (i>= size || i <0) {
                        throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
                }
                return (T) list[i];
        }
        
        public int size(){
            //get size of the list. 
            return this.size;
        }
        
        public void set(int index,T t){
            //set an element in the list. 
            list[index] = t;
        }
        
        public void remove(T t){
            //remove an element from the list. 
            boolean itemRemoved = false;
            for(int i=0 ; i < size; i++){
                if (this.list[i] == t){
                    list[i] = list[i+1];
                }
                if(itemRemoved && i < (size-1)){
                    list[i] = list[i+1];
                }
            }
        }
}
    

