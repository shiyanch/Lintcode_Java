package String;

/**
 * Space Replacement
 *
 * Write a method to replace all spaces in a string with %20.
 * The string is given in a characters array,
 * you can assume it has enough space for replacement
 * and you are given the true length of the string.
 *
 * You code should also return the new length of the string after replacement.
 */
public class SpaceReplacement {
    public int replaceBlank(char[] string, int length) {
        if (string == null) {
            return 0;
        }

        int numOfSpace = 0;
        for (int i=0; i<length; i++) {
            if (string[i] == ' ') {
                numOfSpace++;
            }
        }

        int newLength = length + 2 * numOfSpace;
        int index = length;
        while (newLength > 0) {
            if (string[index] == ' ') {
                string[newLength--] = '0';
                string[newLength--] = '2';
                string[newLength--] = '%';
                index--;
            }
            else {
                string[newLength--] = string[index--];
            }
        }
        return length+2*numOfSpace;
    }

    public static void main(String[] args) {
        char[] string = {'h',' ','w','s','d','s',' ','3'};
        System.out.println(new SpaceReplacement().replaceBlank(string, 3));
    }
}
