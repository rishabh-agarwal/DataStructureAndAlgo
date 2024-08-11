package leetcode;

/**
 * Leetcode: 875
 */
public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        int speed = 1;

        while (true) {
            int hourspent = 0;
            for (int pile: piles) {
                hourspent += Math.ceil((double)pile / speed);
                if (hourspent > h)
                    break;
            }
            if(hourspent<=h)
                return speed;
            else
                speed++;
        }
    }

    public static void main(String[] args) {
        //System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }
}
