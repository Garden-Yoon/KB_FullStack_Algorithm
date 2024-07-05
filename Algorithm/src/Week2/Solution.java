package Week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    boolean solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        // for 반복문을 돌려서 문자 하나하나에 접근한다 (각 괄호에 접근)
        for (int i = 0; i < s.length(); i++) {
            // 반복문을 돌리면서 괄호 하나씩을 분리해준다
            char c = s.charAt(i);
            // 열린 괄호면 stack에 넣어준다
            if (c == '(') {
                stack.push(c);
            }
            // 닫힌 괄호이면 stack의 top을 살펴본다
            else if (c == ')') {
                // 스택이 비어있지 않고, 스택의 맨 위가 '('일 경우 pop해준다
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                // stack의 맨 위가 '('가 아니거나 스택이 비어있을 경우
                else {
                    return false;
                }
            }
        }
        // 다 돌았는데 스택이 비어있으면(isEmpty) true, 비어있지 않으면 false 반환
        // 반복문을 마치고 스택이 비어있으면 모든 괄호가 짝이 맞음
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "";
        boolean result = s.solution(s1);
        if (result) {
            System.out.println("괄호 짝 모두 맞음");
        } else {
            System.out.println("괄호 짝이 맞지 않음");
        }
    }
}

// 참고 : 강사님과 약간 다른방식임ㅎ