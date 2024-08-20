/* Algorithm: A well-defined set of instructions to solve a particular problem in a finite number of steps.
  
 First, we must understand that there are various ways to approach a problem, which is why we must know the requirements of the problem to create a solution within the designated time and space constraints. 

  Here we are going to start with a basic algorithm with two different time complexity:-
 "Sum of first N natural numbers" 
*/

/* 1. In the first example we are using the math formula for calculating the sum giving us output in constant time. So time complexity is O(1) as the sum is calculated once. Like suppose n=5, then the function call will return value of sum = 5*(5+1)/= 5*6/2 = 5*3 =15


class sum{
    static int func1(int n){
      return n*(n+1)/2;
    }
    public static void main(String[] args) {
        int sum=func1(5);
        System.out.println(sum);
    }
}
    Time complexity = O(1)
    Space complexity = O(1)
*/


/* 2. In the second example we are using loops and temporary variable to find the sum of first n natural numbers, giving us output in linear time which is more than first exmaple. So time complexity is O(n) as the loop will calculate the value of temp variable for (n times) at each iteration. The space or memory used here is constant.


class sum{
  static int func1(int n){
    int ans=0;
    for(int i=1;i<=n;i++){
      ans=ans+i;
    }
    return ans;
  }
  public static void main(String[] args) {
      int sum=func1(5);
      System.out.println(sum);
  }
}
  Time complexity = O(1)
    Space complexity = O(1)
*/
