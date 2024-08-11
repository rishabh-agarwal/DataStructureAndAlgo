package leetcode;

import java.util.Stack;

class BasicCalculatorII {
    public static int calculate(String s)
    {
        if(s=="")
            return 0;

        Stack<Integer> stk = new Stack<>();
        char sgn ='+';
        int m=0;
        int r=0;

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
                m=m*10+(ch-'0');

            else if((!Character.isDigit(ch) && ch !=' ') || i==s.length()-1 )
            {
                if(sgn =='+')
                    stk.push(m);
                else if(sgn =='-')
                    stk.push(-m);
                else if(sgn =='*')
                    stk.push(stk.pop()*m);
                else if( sgn == '/')
                    stk.push(stk.pop()/m);


                m=0;
                sgn=ch;

            }

        }


        while(!stk.isEmpty())
        {
            r=r+stk.pop();
        }


        return r;

    }

    public static void main(String[] args) {
        calculate("3+2*2");
    }
}
