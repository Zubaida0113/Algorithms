public class stackimplementation {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    /*
     * In your stackimplementation.java file:
     * The Node class is not declared as public, which means it is package-private
     * and can only be accessed within the same package.
     * The Stack class is declared as public, allowing it to be accessed from other
     * packages.
     * The head variable and methods like isEmpty() and push() are declared as
     * static, meaning they can be accessed without creating an instance of the
     * Stack class. If you have specific scenarios or code examples where you're
     * unsure about using static or public, feel free to share, and I can provide
     * more tailored guidance!
     */

    static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node n = new Node(data);
            if (isEmpty()) {
                head = n;
                return;
            }
            n.next = head;
            head = n;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
       // Stack s = new Stack();
    //    If peek() is defined as a static method in the Stack class, it should be accessed using the class name (e.g., Stack.peek()) rather than through an instance of the class (e.g., s.peek()). Static methods belong to the class itself rather than to any specific instance of the class.

        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        
        System.out.println(Stack.peek());
        Stack.push(4);
        System.out.println(Stack.peek());

        while(!Stack.isEmpty()){
            System.out.println(Stack.peek());
            Stack.pop();
        }
        System.out.println(Stack.peek());
    }
}