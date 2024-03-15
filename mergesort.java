class Mergesort1
{ 
    void Merge(int a[], int lb, int mid, int ub) 
    { 
        int i, j, k; 
        int n1 = mid - lb + 1; 
        int n2 = ub - mid; 
        int LArray[] = new int[n1]; 
        int RArray[] = new int[n2];

        for (i = 0; i < n1; i++) 
            LArray[i] = a[lb + i]; 
        for (j = 0; j < n2; j++) 
            RArray[j] = a[mid + 1 + j]; 

        i = 0; 
        j = 0; 
        k = lb; 

        while (i < n1 && j < n2) 
        { 
            if (LArray[i] <= RArray[j]) 
            { 
                a[k] = LArray[i]; 
                i++; 
            } 
            else 
            { 
                a[k] = RArray[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < n1)
        { 
            a[k] = LArray[i]; 
            i++; 
            k++; 
        } 

        while (j < n2) 
        { 
            a[k] = RArray[j]; 
            j++; 
            k++; 
        } 
    }

    void Msort(int A[], int lb, int ub) 
    { 
        if (lb < ub) 
        { 
            int mid = (lb + ub) / 2; 
            Msort(A, lb, mid); 
            Msort(A, mid + 1, ub); 
            Merge(A, lb, mid, ub); 
        } 
    }

    public static void main(String args[]) 
    { 
        Mergesort1 m1 = new Mergesort1(); 
        int[] A = { 9,14,3,2,43,14,3,43}; 

        int n = A.length; 

        
        m1.Msort(A,0, n - 1); 
        System.out.println("After Sorting "); 

        for (int i = 0; i < n; i++) 
        { 
            System.out.print(A[i] + " "); 
        } 
    } 
}

