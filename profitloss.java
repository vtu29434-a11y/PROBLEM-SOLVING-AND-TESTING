import java.util.*;
public class profitloss{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n =sc.nextInt();
int[] nums=new int[n];
for(int i=0;i<n;i++){
nums[i]=sc.nextInt();
}
int currentsum=nums[0];
int maxsum=nums[0];
for(int i=1;i<n;i++){
currentsum=Math.max(nums[i],currentsum+nums[i]);
maxsum=Math.max(maxsum,currentsum);
}
System.out.println(maxsum);
sc.close();
}
}