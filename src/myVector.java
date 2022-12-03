import java.util.Arrays;
public class myVector<T> {
    int size, maxsize = 10;
    T[] arr=(T[]) new Object[maxsize];

    public myVector() {
    }

    public myVector(int maxsize) {
        if (maxsize >= 0) {
            this.maxsize = maxsize * 2 + 10;
            this.arr = Arrays.copyOf(this.arr, this.maxsize);
        } else
            System.out.println("Размер массива не может быть отрицательным. Устанавливаем размер по умолчанию.");
    }
    //конструктор копирования массива
    public myVector(T arr[]) {
        this.maxsize = arr.length * 2 + 10;
        this.size=arr.length;
        this.arr = Arrays.copyOf(arr, this.maxsize);
    }
    //добавление элемента в конец массива
    public void AddToEnd(T data) {
        size++;
        if (size >= maxsize) {
            GrowMas();
        }
        arr[size-1] = data;
    }
    //удаление последнего элемента
    public void DelLast() {
        if (size != 0) {
            size--;
            arr[size] = null;
        }
    }
    //удаление элемента по индексу
    public void DelIndex(int id) {
        if (id == 1) {
            arr = Arrays.copyOfRange(arr, 1, size);
            size--;
        } else if (id > 1 && id < size) {
            T tmp1[] = Arrays.copyOfRange(arr, 0, id-1);
            T tmp2[] = Arrays.copyOfRange(arr, id, size+1);
            arr=Arrays.copyOf(tmp1, maxsize);
            for (int i = id-1,  j = 0; j<size-id; i++, j++) {
                arr[i] = tmp2[j];
            }
            arr[size-1]=null;
            size--;
        } else if (id == size) {
            arr[id - 1] = null;
            size--;
        } else
            System.out.println("Вы ввели несуществующий индекс.");
    }
    //добаление элемента по индексу
    public void AddIndex(int id, T data) {
        size++;
        if (size >= maxsize) {
            GrowMas();
        }
        T[] tmp_arr =(T[]) new Object[maxsize];
        if (id > 1 && id <= size) {
            T tmp1[] =Arrays.copyOfRange(arr, 0, id - 1);
            T problem=arr[size-2];
            tmp_arr =Arrays.copyOf(tmp1, maxsize);
            tmp_arr[id-1] = data;
            for (int i = id; i < size; ++i)
                tmp_arr[i] = arr[i - 1];
                tmp_arr[size-1]=problem;
        } else if (id == 1) {
            tmp_arr[0] = data;
            for (int i = 1; i < size; ++i)
                tmp_arr[i] = arr[i - 1];
        } else if (id > size) {
            if (id > maxsize)
                do {
                    GrowMas();
                } while (maxsize <= id);
            tmp_arr = Arrays.copyOf(tmp_arr, maxsize);
            arr=Arrays.copyOf(arr, maxsize);
            tmp_arr = Arrays.copyOfRange(arr, 0, id-1);
            tmp_arr[id - 1] = data;
        } else
            System.out.println("Вы ввели некоректный индекс.");
        this.arr = tmp_arr;
    }
    //увеличение масимального размера массива
    public void GrowMas() {
        this.maxsize = maxsize * 2 + 10;
        arr = Arrays.copyOf(arr, this.maxsize);
    }

    public void numb() {
        System.out.println("Длинна массива: " + maxsize);
        if (size != 0)
            System.out.println("Колличество элементов в массиве: " + size);
        else
            System.out.println("Массив пуст.");
    }

    public void print() {
        System.out.println("------------------");
        if (size != 0) {
            for (int i = 0; i < size; ++i)
                System.out.println(arr[i]+" ->");
            System.out.println("null");
        }else
            System.out.println("Массив пуст.");
        System.out.println("------------------");
    }
    //очистка массива
    public void clear(){
        Arrays.fill(arr, 0);
        size=0;
        System.out.println("Массив очищен");
    }
}
