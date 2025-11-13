#include <stdio.h>

void f(int k,int a,int b,int c){
    if(k==1){
        printf("%d %d\n",a,c);
        return;
    }
    f(k-1,a,c,b);
    f(1,a,b,c);
    f(k-1,b,a,c);
}

int main()
{
    int n;
    scanf("%d",&n);
    printf("%d\n",(1<<n)-1);
    f(n,1,2,3);
}