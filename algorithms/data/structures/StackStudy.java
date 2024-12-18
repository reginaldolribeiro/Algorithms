package algorithms.data.structures;

import java.util.Stack;

public class StackStudy {

    // *******************************************************

    // stack = LIFO data structure. Last-In First-Out
    //               stores objects into a sort of "vertical tower"
    //               push() to add objects to the top
    //               pop() to remove objects from the top

    // uses of stacks?
    // 1. undo/redo features in text editors
    // 2. moving back/forward through browser history
    // 3. backtracking algorithms (maze, file directories)
    // 4. calling functions (call stack)

    // *******************************************************
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        System.out.println("Initial Stack " + stack);

        System.out.println("Is empty? " + stack.empty());

        stack.push("Teste1");
        stack.push("Teste2");
        stack.push("Teste3");
        System.out.println("\nPopulated Stack " + stack);

        System.out.println("Is empty? " + stack.empty());

        stack.pop(); // removes the top most object from the stack
//        stack.pop(); // removes the top most object from the stack
//        stack.pop(); // removes the top most object from the stack

//        if(!stack.empty()){
//            stack.pop();
//        }

        System.out.println(stack.peek());

//        System.out.println(stack.search("Teste1")); // returns the position

        System.out.println("\nFinal Stack " + stack);
    }

}
