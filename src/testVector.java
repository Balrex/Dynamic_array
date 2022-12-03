public class testVector {
    public static void main(String[] args) {
        myVector mas = new myVector(1);
        /*myVector<Complex> mas = new myVector(1);
        Complex numd1 = new Complex(1,1);
        Complex numd2 = new Complex(-1,1);
        Complex numd3 = new Complex(1,-1);
        Complex numd4 = new Complex(-1,-1);
        mas.AddToEnd(numd1);
        mas.AddToEnd(numd3);
        mas.AddToEnd(numd4);
        mas.print();
        mas.AddIndex(2, numd2);
        mas.print();*/
        for (int i=0; i<10; ++i) {
            mas.arr[i] = (double) i+1;
            mas.size++;
        }
        mas.numb();
        mas.print();
        myVector mas_copy = new myVector(mas.arr); //копируем массив, чтобы в дальнейшем работать с копией
        mas_copy.print();
        mas_copy.numb();
        mas_copy.DelLast();
        mas_copy.AddToEnd(11);
        mas_copy.print();
        mas_copy.numb();
        mas_copy.AddIndex(10, (double) 10);
        mas_copy.DelIndex(5);
        mas_copy.print();
        mas_copy.numb();
        mas_copy.GrowMas();
        mas_copy.numb();
        mas_copy.clear();
        mas_copy.numb();
    }
}
