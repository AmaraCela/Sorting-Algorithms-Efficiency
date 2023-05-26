import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        try( PrintWriter writer = new PrintWriter("sortingResults.txt"))
        {
            int start = 50;
            for(int i = 0;i<5;i++)
            {
               Integer [] array = new Integer[start];
               for (int j=0;j<start;j++)
               {
                   array[j] = (int)(Math.random()*start);
               }
               writer.print("The time it takes to sort " +start+" elements using insertion sort is: ");
               System.out.print("The time it takes to sort " +start+" elements using insertion sort is: ");
               long startTime = System.nanoTime();
               insertionSort(array);
               long endTime = System.nanoTime();
               System.out.println((endTime-startTime)/1_000_000.0);
               writer.println((endTime-startTime)/1_000_000.0);
               writer.println();

               writer.print("The time it takes to sort " +start+" elements using bubble sort is: ");
               System.out.print("The time it takes to sort " +start+" elements using bubble sort is: ");
               startTime = System.nanoTime();
                insertionSort(array);
                endTime = System.nanoTime();
                System.out.println((endTime-startTime)/1_000_000.0);
                writer.println((endTime-startTime)/1_000_000.0);
                writer.println();

               writer.print("The time it takes to sort " +start+" elements using selection sort is: ");
               System.out.print("The time it takes to sort " +start+" elements using selection sort is: ");
                startTime = System.nanoTime();
                insertionSort(array);
                endTime = System.nanoTime();
                System.out.println((endTime-startTime)/1_000_000.0);
                writer.println((endTime-startTime)/1_000_000.0);
                writer.println();

               writer.print("The time it takes to sort " +start+" elements using merge sort is: ");
               System.out.print("The time it takes to sort " +start+" elements using merge sort is: ");
                startTime = System.nanoTime();
                insertionSort(array);
                endTime = System.nanoTime();
                System.out.println((endTime-startTime)/1_000_000.0);
                writer.println((endTime-startTime)/1_000_000.0);
                writer.println();


               writer.print("The time it takes to sort " +start+" elements using quick sort is: ");
               System.out.print("The time it takes to sort " +start+" elements using quick sort is: ");
                startTime = System.nanoTime();
                insertionSort(array);
                endTime = System.nanoTime();
                System.out.println((endTime-startTime)/1_000_000.0);
                writer.println((endTime-startTime)/1_000_000.0);
                writer.println();


               writer.print("The time it takes to sort " +start+" elements using heap sort is: ");
               System.out.print("The time it takes to sort " +start+" elements using heap sort is: ");
                startTime = System.nanoTime();
                insertionSort(array);
                endTime = System.nanoTime();
                System.out.println((endTime-startTime)/1_000_000.0);
                writer.println((endTime-startTime)/1_000_000.0);
                writer.println();


               start *=4;
           }

        }
        catch(IOException ex)
        {
            System.out.println("Input output exception occurred");
        }
    }

    public static <E extends Comparable<E>> E[] insertionSort(E [] array1)
    {

        E[]array = (E[])new Comparable[array1.length];
        System.arraycopy(array1,0,array,0,array.length);
        for(int i=1;i<array.length;i++)
        {
            E temp;
            int k=i;
            for(int j=i-1;j>=0;j--)
            {
                if(array[k].compareTo(array[j])<0)
                {
                    temp = array[k];
                    array[k] = array[j];
                    array[j] = temp;
                    k--;
                }
            }
        }
        return array;
    }

    public static <E extends Comparable<E>> E[] bubbleSort(E [] array1)
    {
        E[]array = (E[])new Comparable[array1.length];
        System.arraycopy(array1,0,array,0,array.length);
        for(int i=0;i<array.length-1;i++)
        {
            E temp;
            for(int j=0;j<array.length-1-i;j++)
            {
                if(array[j].compareTo(array[j+1])>0)
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    public static  <E extends Comparable<E>> E[] selectionSort(E [] array1)
    {
        E[]array = (E[])new Comparable[array1.length];
        System.arraycopy(array1,0,array,0,array.length);
        for(int i=0;i< array.length-1;i++)
        {
            E temp;
            for(int j=i+1;j< array.length;j++)
            {
                if(array[j].compareTo(array[i])<0)
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static <E extends Comparable<E>> E[] mergeSort(E [] array1)
    {
        E[]array = (E[])new Comparable[array1.length];
        System.arraycopy(array1,0,array,0,array.length);
        if(array.length!=1)
        {
            E[] left = (E[])new Comparable[array.length/2];
            System.arraycopy(array,0,left,0,array.length/2);
            mergeSort(left);
            E[] right = (E[])new Comparable[array.length- left.length];
            System.arraycopy(array,array.length/2,right,0,array.length-left.length);
            mergeSort(right);
            merge(array,left,right);
        }
        return array;

    }


    public static <E extends Comparable<E>>void merge(E newArray [],E []left, E[]right)
    {

        int l = 0;
        int r = 0;
        for(int i = 0 ;i <newArray.length;i++)
        {

            if(l==left.length)
            {
                System.arraycopy(right,r,newArray,i,(right.length-r));
                return;

            }
            else if(r==right.length)
            {
                System.arraycopy(left,l,newArray,i,(left.length-l));
                return;

            }
            else if(left[l].compareTo(right[r])<0)
            {
                newArray[i] =left[l++];
            }
            else if (left[l].compareTo(right[r])>0)
            {
                newArray[i] = right[r++];
            }
            else {
                newArray[i++] = left[l++];
                newArray[i] = right[r++];
            }

        }

    }

    public static <E extends Comparable<E>> E[] quickSort(E [] array1)
    {
        E[]array = (E[])new Comparable[array1.length];
        System.arraycopy(array1,0,array,0,array.length);
        quickSort(array,0, array.length-1);
        return array;
    }
    public static <E extends Comparable<E>> void quickSort(E [] array, int low, int high)
    {
        if(low<=high)
        {
        int pivot = low;
        int i = low+1;
        int j = high;
        E temp;
        while (i<j)
        {
            while (array[i].compareTo(array[pivot])<=0 && i<=high-1)
            {
                i++;
            }
            while (array[j].compareTo(array[pivot])>=0 && j>pivot)
            {
                j--;
            }
            if(i<j)
            {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if(array[j].compareTo(array[pivot])<0) {
            temp = array[j];
            array[j] = array[pivot];
            array[pivot] = temp;
        }
        quickSort(array,low,j-1);
        quickSort(array,j+1,high);
        }
    }

    public static <E extends Comparable<E>> void buildMaxHeap(E [] arr)
    {
        E [] tempArr = (E[])new Comparable[arr.length];
        for(int i=0;i< arr.length;i++)
        {
            tempArr[i] = arr[i];
            int j = i;
            int parent = (i-1)/2;
            while (j>0)
            {
                if(tempArr[j].compareTo(tempArr[parent])>0)
                {
                    E temp = tempArr[j];
                    tempArr[j] = tempArr[parent];
                    tempArr[parent] = temp;
                    j = parent;
                    parent = (parent-1)/2;
                }
                else
                {
                    break;
                }
            }
        }
       System.arraycopy(tempArr,0,arr,0,arr.length);

    }

    public static <E extends Comparable<E>> E[] heapSort(E [] arr)
    {
        E[]array = (E[])new Comparable[arr.length];
        System.arraycopy(arr,0,array,0,array.length);
        buildMaxHeap(arr);
        int l = arr.length;
        for(int i= 0;i < arr.length;i++)
        {
            E temp = arr[arr.length-i-1] ;
            arr[arr.length-i-1] = arr[0];
            arr[0] = temp;
            l = l-1;
            int j = 0;
            while (true)
            {
                if(((2*j)+1)>= l)
                {
                    break;
                }
                else if(((2*j)+2) >= l)
                {
                    if(arr[j].compareTo(arr[(2*j)+1])<0) {
                        temp = arr[(2 * j) + 1];
                        arr[(2 * j) + 1] = arr[j];
                        arr[j] = temp;

                    }
                    break;
                }
                else{
                    if(arr[(j)].compareTo(arr[(2*j)+1])<0 || arr[(j)].compareTo(arr[(2*j)+2])<0) {
                        if (arr[(2 * j) + 1].compareTo(arr[(2 * j) + 2]) > 0) {
                            temp = arr[(2 * j) + 1];
                            arr[(2 * j) + 1] = arr[j];
                            arr[j] = temp;
                            j = (2 * j) + 1;
                        } else {
                            temp = arr[(2 * j) + 2];
                            arr[(2 * j) + 2] = arr[j];
                            arr[j] = temp;
                            j = (2 * j) + 2;
                        }
                    }
                    else {
                        break;
                    }
                }


            }

        }
        return array;
    }

}