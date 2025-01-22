package exercises.turing;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s1 = "{}";
        String s2 = "()";
        String s3 = "[]";
        String s4 = "()[]";
        String s5 = "()[]{}";
        String s6 = "([])";
        String s7 = "([{}])";
        String s8 = "(]";
        String s9 = "([]";
        String s10 = null;
        System.out.println("String - " + s1 + " - is valid? " + isValid(s1));
        System.out.println("String - " + s2 + " - is valid? " + isValid(s2));
        System.out.println("String - " + s3 + " - is valid? " + isValid(s3));
        System.out.println("String - " + s4 + " - is valid? " + isValid(s4));
        System.out.println("String - " + s5 + " - is valid? " + isValid(s5));
        System.out.println("String - " + s6 + " - is valid? " + isValid(s6));
        System.out.println("String - " + s7 + " - is valid? " + isValid(s7));
        System.out.println("String - " + s8 + " - is valid? " + isValid(s8));
        System.out.println("String - " + s9 + " - is valid? " + isValid(s9));
        System.out.println("String - " + s10 + " - is valid? " + isValid(s10));
    }

    /**
     * Itera o loop verificando se o elemento atual eh de abertura, se for, empilha ele na stack.
     * Se nao for, verifica o elemento no topo da stack verificando se:
     *  - Eh o elemento de abertura correspondente ao elemento de fechamento, ou seja, elemento atual.
     *      - Se for, por enquanto a string eh valida, entao continua a iteracao
     *      - Se NAO for, retorna false
     * Ao terminar este loop a stack tem que estar vazia, se nao estiver, retorna FALSE
     *
     * ENGLISH:
     *
     * Iterates through the string, checking each character:
     * - If the character is an opening symbol (e.g., '(', '{', '['), it is pushed onto the stack with its corresponding closing symbol.
     * - If the character is a closing symbol (e.g., ')', '}', ']'), it checks the top of the stack:
     *   - If the stack is empty or the top of the stack does not match the current closing symbol, the string is invalid, and the method returns false.
     *   - Otherwise, the matching symbol is removed from the stack, and the iteration continues.
     * At the end of the loop, the stack must be empty for the string to be valid.
     * If not, the method returns false.
     *
     * @param s the input string containing the parentheses to validate
     * @return true if the string contains valid parentheses, false otherwise
     * @throws IllegalArgumentException if the input string is null or blank
     */
    public static boolean isValid(String s) {
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("Invalid String: " + s);

        Stack<Character> stack = new Stack<>();
        for(char current : s.toCharArray()){
            if(current == '('){
                stack.add(')');
            } else if(current == '{'){
                stack.add('}');
            } else if(current == '['){
                stack.add(']');
            } else {
                if(stack.isEmpty() || stack.pop() != current)
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid1(String s) {
        Map<Character, Character> pairs = Map.of(
                ')', '(',
                ']','[',
                '}','{'
        );

        Stack<Character> stack = new Stack<>();
        for(char current : s.toCharArray()){
            boolean isOpenSymbol = pairs.containsValue(current);
            if(isOpenSymbol){
                stack.add(current);

            } else if(pairs.containsKey(current)) {
                if(stack.isEmpty())
                    return false;

                char currentValue = pairs.get(current);
                char topStack = stack.pop();
                if(topStack != currentValue)
                    return false;

            } else {
                throw new IllegalArgumentException("Invalid char: " + current);
            }
        }
        return stack.isEmpty();
    }


    /**
     * Percorrer o array empilhando os itens em uma Stack
     * Remover o elemento no topo da Stack e verificar se ele eh o oposto do elemento na primeiro posicao
     * - Se sim, prossegue
     *  - Remover o elemento no topo da stack e verificar se ele eh o oposto da segunda posicao (i+1)
     *      - Se sim, prossegue
     *      - Se nao, retorna False
     * - Se nao, retorna False
     *
     * Mas como saber os simbolos opostos?
     *
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        boolean result = false;
        Map<Character, Character> pairs = Map.of(
                ')', '(',
                ']','[',
                '}','{'
        );

        Stack<Character> stack = new Stack<>();
        for(char current : s.toCharArray()){
            boolean isOpenSymbol = pairs.containsValue(current);
            if(isOpenSymbol){
                stack.add(current);

            } else if(pairs.containsKey(current)) {
                if(stack.isEmpty())
                    return false;

                char currentValue = pairs.get(current);
                char topStack = stack.pop();
                if(topStack == currentValue)
                    result = true;
                else
                    return false;

            } else {
                throw new IllegalArgumentException("Invalid char: " + current);
            }
        }
        if(!stack.isEmpty())
            return false;

        return result;
    }

}
