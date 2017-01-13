
#include<stdio.h>

int main()
{
  unsigned char S[256];
  unsigned char K[256];
  unsigned char key[7] = {0x1A, 0x2B, 0x3C, 0x4D, 0x5E, 0x6F, 0x77};
  unsigned char S2[256]; 

  unsigned char tmp;
  int i=0,j=0,N=7;
  for(i=0; i<=255; i++)
  {
    S[i] = i;
    K[i] = key[i % N];
  }
  i=0;
  j=0;
  for(i=0; i<=255; i++)
  {
    j=(j + S[i] + K[i]) % 256;
    tmp = S[i];
    S[i] = S[j];
    S[j] = tmp;
  }
  i=0,j=0;

  //after initialization phase
  printf("\nIndex of i=%d",i);
  printf("\nIndex of j=%d",j);
  printf("\n\n");

  int n=0;
  for(i=0; i<16; i++)
  {
    for(j=0; j<16; j++)
    {
      printf("0x%2x ", S[n]);
      S2[n] = S[n];
      n++;
    }
    printf("\n");
  }

  //after 100 bytes of keystream have been generated
  int m=0;
  i=0,j=0;
  for(m=0; m<100; m++)
  {
    i=(i+1)%256;
    j=(j+S[i])%256;
    tmp = S[i];
    S[i] = S[j];
    S[j] = tmp;
  } 

  printf("\nIndex of i=%d",i);
  printf("\nIndex of j=%d",j);
  printf("\n\n");

  i=0,j=0,n=0;
  for(i=0; i<16; i++)
  {
    for(j=0; j<16; j++)
    {
      printf("0x%2x ", S[n]);
      n++;
    }
    printf("\n");
  }

  //after 1000 bytes of keystream have been generated
  m=0,i=0,j=0;
  for(m=0; m<1000; m++)
  {
    i=(i+1) % 256;
    j=(j+S2[i]) % 256;
    tmp = S2[i];
    S2[i] = S2[j];
    S2[j] = tmp;
  } 

  printf("\nIndex of i=%d",i);
  printf("\nIndex of j=%d",j);
  printf("\n\n");

  i=0,j=0,n=0;
  for(i=0; i<16; i++)
  {
    for(j=0; j<16; j++)
    {
      printf("0x%2x ", S2[n]);
      n++;
    }
    printf("\n");
  }
}