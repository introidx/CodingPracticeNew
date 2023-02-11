package math;

public class MathsProblems {
    public static void main(String[] args) {
        System.out.println(findPalindromeNumber(226574));

    }

    public static boolean findPalindromeNumber(int a){
        int copyA = a;
        int b =0;
        while (copyA > 0){
            int x = copyA % 10;
            b = b * 10 + x;
            copyA = copyA /10;
        }
        System.out.println(b);
        return a == b;

    }
    /* int currPos, char d/u, int steps
    *  if currPos < 1 || currPos > 20 return -1
    *
    *
    * */

    public static int findThePositionOFLift(int currPos, char c, int steps){
        if(c == 'd'){
            currPos = currPos - steps;
        }else {
            currPos = currPos + steps;
        }
        return currPos >= 1 && currPos <=20  ? currPos : -1;
    }
}
