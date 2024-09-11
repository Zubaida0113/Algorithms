public class check_sorted_array {
    static boolean sorted_check(int[] arr){
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                flag=true;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        int []arr={3,5,7,1,8};
        boolean ans=sorted_check(arr);
        System.out.println(ans);
    }
}
