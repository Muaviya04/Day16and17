public class InsertionSort {
    public static void Insertion(int array[]){
        int n = array.length;

        for(int j = 1;j<n ; j++) {
            int key = array[j];
            int i = j - 1;

            while ((i>-1) && (array[i]>key)){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;

        }
    }

    public static void main(String[] args) {
        int[] arr1 = {23,45,6,7,5,4,3,22,};
        System.out.println("Before Insertion");
        for(int i:arr1){
            System.out.print(i+ " ");
        }
        System.out.println();
        Insertion(arr1);

        System.out.println("After Insertion sort");
        for(int i : arr1){
            System.out.print(i+ " ");
        }
    }
}
