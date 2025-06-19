import java.util.Scanner;
public class Dehasher {
    public static void main(String[] args) {
        boolean off=false;
        while (!off){
            Scanner sc=new Scanner(System.in);
            StringBuilder string = new StringBuilder();
            System.out.println("Enter the encryption: ");
            String msg=sc.nextLine();
            System.out.println("Enter the key: ");
            String key=sc.nextLine();
            char[] abcs=new char[26];
            for (int i=0;i<26;i++){
                abcs[i]=(char)(i+97);
            }
            char[] org =abcs.clone();
            int sum=0;
            for (int i=0;i<key.length();i++){
                sum+=key.charAt(i);
            }
            //char save,forward;
            int rot = sum % 26; // rotate only the necessary amount
            for (int r = 0; r < rot; r++) {
                char last = abcs[25];
                for (int j = 25; j > 0; j--) {
                    abcs[j] = abcs[j - 1];
                }
                abcs[0] = last;
            }
            // Step 1: Reverse ASCII shift
            char[] chars = msg.toCharArray();
            for (int i = 0; i < sum; i++) {
                for (int j = 0; j < chars.length; j++) {
                    int temp = chars[j] - 1;
                    if (temp < 32) temp = 126;
                    chars[j] = (char) temp;
                }
            }

            // Step 2: Reverse substitution mapping
            for (int i = 0; i < chars.length; i++) {
                boolean found = false;
                for (int j = 0; j < 26; j++) {
                    if (chars[i] == abcs[j]) {
                        chars[i] = org[j];
                        found = true;
                        break;
                    }
                }
                // Keep non-alphabet chars unchanged
                if (!found) chars[i] = chars[i];
            }
            for (int i=0;i<chars.length;i++){
                string.append(chars[i]);
            }
            System.out.println(string);
            System.out.println("Do you want to encrypt more?(y/n)  ");
            String out=sc.nextLine();
            if (out.equals("y")){
                off=false;
            }
            else{
                off=true;
            }
        }
        System.out.println("Done!");
    }
}
