import java.util.Scanner;
public class hasher {
    public static void main(String[] args) {
        boolean off=false;
        while (!off){
            Scanner sc=new Scanner(System.in);
            StringBuilder string = new StringBuilder();
            System.out.println("Enter the message: ");
            String msg=sc.nextLine();
            char[] chars=new char[msg.length()];
            System.out.println("Enter a key: ");
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
            char save,forward;
            for (int i=0;i<sum;i++){
                forward=abcs[0];
                for(int j=0;j<26;j++){
                    if (j<25){
                        save=abcs[j+1];
                        abcs[j+1]=forward;
                        forward=save;
                    }
                    else{
                        abcs[0]=forward;
                    }
                }
            }
            for (int i=0;i<msg.length();i++){
                boolean on=false;
                for (int j=0;j<26;j++){
                    if (msg.charAt(i)==(org[j])){
                        chars[i]=abcs[j];
                        on=true;
                        break;
                    }
                }
                if (!on){
                    chars[i] = msg.charAt(i);
                }
            }
            for(int i=0;i<sum;i++){
                for (int j=0;j<chars.length;j++){
                    int temp=chars[j];
                    temp++;
                    if (temp>126){
                        temp=32;
                    }
                    chars[j]=(char)temp;
                }
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
