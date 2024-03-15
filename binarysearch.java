public class binarysearch {
    void search(int[] arr,int val){
        int lb=0;
        int ub=arr.length;
        
        while(lb!=ub){
            int mid=(lb+ub)/2;
            if(arr[mid]==val){
                System.out.println(+(mid+1) +" position");
                return;
            }
            else if(val>arr[mid]){
                lb=mid+1;
            }
            else ub=mid-1;
        }
        
        
    }
    public static void main(String args[]){
        binarysearch bsrch=new binarysearch();
        int[] x={1,2,3,4,5,6,7,8,9,10};
        int y=1;
        bsrch.search(x,y);
    }
    
}
