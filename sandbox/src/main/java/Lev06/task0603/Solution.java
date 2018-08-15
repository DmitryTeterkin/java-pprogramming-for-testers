package Lev06.task0603;

/* 
По 50 000 объектов Cat и Dog
*/

public class Solution {
    public static void main(String[] args) {
        Cat[] array = new Cat[50000];
        for(int i = 0; i < 50000; i++){
            array[i] = new Cat();
        }
        Dog[] fjg = new Dog[50000];
        for(int j = 0; j < 50000; j++){
            fjg[j] = new Dog();
        }
    }  //напишите тут ваш код
}


class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
