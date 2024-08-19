/* Algorithm: A well-defined set of instructions to solve a particular problem in a finite number of steps.
  
 First, we must understand that there are various ways to approach a problem, which is why we must know the requirements of the problem to create a solution within the designated time and space constraints. 

  Here we are going to start with a basic algorithm with three different time complexity:-
 "Sum of first N natural numbers" 
*/

//In the first example we are using the math formula for calculating the sum giving us output in constant time O(1)
class sum{
    static int func1(int n){
      return n*(n+1)/2;
    }
    public static void main(String[] args) {
        int sum=func1(5);
        System.out.println(sum);
    }
}

