import java.io.*;
import java.util.*;


public class Othello {
    int turn;
    int winner;
    int board[][];
    //add required class variables here
    private int I;
    private int J;


    public Othello(String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        turn = sc.nextInt();
        board = new int[8][8];
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j){
                board[i][j] = sc.nextInt();
            }
        }
        winner = -1;
        //Student can choose to add preprocessing here
    }


    //add required helper functions here


    public int boardScore() {
        /* Complete this function to return num_black_tiles - num_white_tiles if turn = 0, 
         * and num_white_tiles-num_black_tiles otherwise. 
        */if (turn==0) {
            int ct=0;
            int gt=0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == 0)ct++;
                    if (board[i][j]==1)gt++;
                }
            }
            return ct-gt;}
        else {
            int ct = 0;
            int gt=0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == 1) ct++;
                    if (board[i][j]==0)gt++;

                }
            }
            return ct-gt;
        }

    }
    private int boarde(int bd[][]) {
        /* Complete this function to return num_black_tiles - num_white_tiles if turn = 0,
         * and num_white_tiles-num_black_tiles otherwise.
         */if (turn==0) {
            int ct=0;
            int gt=0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (bd[i][j] == 0)ct++;
                    if (bd[i][j]==1)gt++;
                }
            }
            return ct-gt;}
        else {
            int ct = 0;
            int gt=0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (bd[i][j] == 1) ct++;
                    if (bd[i][j]==0)gt++;
                }
            }
            return ct-gt;
        }

    }
    private boolean possible(int i,int j,int chance,int[][] bd)
    {
        if (chance==0)
        {
            if (i+1<7)
            {
                if (bd[i+1][j]==1)
                {
                    int itt=i+1;
                    while (itt<8 && bd[itt][j]==1)
                    {
                        itt++;
                    }
                    if (itt<8) {if (bd[itt][j] == 0)return true;}

                }
            }
            if (i-1>0)
            {
                if (bd[i-1][j]==1)
                {
                    int itt=i-1;
                    while (itt>-1 && bd[itt][j]==1)
                    {
                        itt--;
                    }
                    if (itt>-1) {if (bd[itt][j]==0)return true;}

                }

            }
            if (j+1<7)
            {
                if (bd[i][j+1]==1)
                {
                    int itt=j+1;
                    while (itt<8 && bd[i][itt]==1)
                    {
                        itt++;
                    }
                    if (itt<8) {if (bd[i][itt] == 0)return true;}

                }
            }
            if (j-1>0)
            {
                if (bd[i][j-1]==1)
                {
                    int itt=j-1;
                    while (itt>-1 && bd[i][itt]==1)
                    {
                        itt--;
                    }
                    if (itt>-1) {if (bd[i][itt]==0)return true;}

                }

            }
            if (i+1<7&&j+1<7)
            {
                if (bd[i+1][j+1]==1)
                {
                    int itti=i+1;
                    int ittj=j+1;
                    while (itti<8 &&ittj<8 && bd[itti][ittj]==1)
                    {
                        itti++;
                        ittj++;
                    }
                    if (itti<8 && ittj<8) {if (bd[itti][ittj] == 0)return true;}
                }

            }
            if (i-1>0&&j-1>0)
            {
                if (bd[i-1][j-1]==1)
                {
                    int itti=i-1;
                    int ittj=j-1;
                    while (itti>-1 &&ittj>-1 && bd[itti][ittj]==1)
                    {
                        itti++;
                        ittj++;
                    }
                    if (itti>-1 && ittj>-1) {if (bd[itti][ittj] == 0)return true;}
                }

            }
            if (i-1>0&&j+1<7)
            {
                if (bd[i-1][j+1]==1)
                {
                    int itti=i-1;
                    int ittj=j+1;
                    while (itti>-1&& ittj<8&&bd[itti][ittj]==1)
                    {
                        itti--;
                        ittj++;
                    }
                    if (itti>-1 && ittj<8) {if (bd[itti][ittj] == 0)return true;}
                }
            }
            if (i+1<7&&j-1>0)
            {
                if (bd[i+1][j-1]==1)
                {
                    int itti=i+1;
                    int ittj=j-1;
                    while (ittj>-1&& itti<8&&bd[itti][ittj]==1)
                    {
                        ittj--;
                        itti++;
                    }
                    if (ittj>-1 && itti<8) {if (bd[itti][ittj] == 0)return true;}
                }
            }


        }
        if (chance==1)
        {
            if (i+1<7)
            {
                if (bd[i+1][j]==0)
                {
                    int itt=i+1;
                    while (itt<8 && bd[itt][j]==0)
                    {
                        itt++;
                    }
                    if (itt<8) {if (bd[itt][j] == 1)return true;}

                }
            }
            if (i-1>0)
            {
                if (bd[i-1][j]==0)
                {
                    int itt=i-1;
                    while (itt>-1 && bd[itt][j]==0)
                    {
                        itt--;
                    }
                    if (itt>-1) {if (bd[itt][j]==1)return true;}

                }

            }
            if (j+1<7)
            {
                if (bd[i][j+1]==0)
                {
                    int itt=j+1;
                    while (itt<8 && bd[i][itt]==0)
                    {
                        itt++;
                    }
                    if (itt<8) {if (bd[i][itt] == 1)return true;}

                }
            }
            if (j-1>0)
            {
                if (bd[i][j-1]==0)
                {
                    int itt=j-1;
                    while (itt>-1 && bd[i][itt]==0)
                    {
                        itt--;
                    }
                    if (itt>-1) {if (bd[i][itt]==1)return true;}

                }

            }
            if (i+1<7&&j+1<7)
            {
                if (bd[i+1][j+1]==0)
                {
                    int itti=i+1;
                    int ittj=j+1;
                    while (itti<8 &&ittj<8 && bd[itti][ittj]==0)
                    {
                        itti++;
                        ittj++;
                    }
                    if (itti<8 && ittj<8) {if (bd[itti][ittj] == 1)return true;}
                }

            }
            if (i-1>0&&j-1>0)
            {
                if (bd[i-1][j-1]==0)
                {
                    int itti=i-1;
                    int ittj=j-1;
                    while (itti>-1 &&ittj>-1 && bd[itti][ittj]==0)
                    {
                        itti++;
                        ittj++;
                    }
                    if (itti>-1 && ittj>-1) {if (bd[itti][ittj] == 1)return true;}
                }

            }
            if (i-1>0&&j+1<7)
            {
                if (bd[i-1][j+1]==0)
                {
                    int itti=i-1;
                    int ittj=j+1;
                    while (itti>-1&& ittj<8&&bd[itti][ittj]==0)
                    {
                        itti--;
                        ittj++;
                    }
                    if (itti>-1 && ittj<8) {if (bd[itti][ittj] == 1)return true;}
                }
            }
            if (i+1<7&&j-1>0)
            {
                if (bd[i+1][j-1]==0)
                {
                    int itti=i+1;
                    int ittj=j-1;
                    while (ittj>-1&& itti<8&&bd[itti][ittj]==0)
                    {
                        ittj--;
                        itti++;
                    }
                    if (ittj>-1 && itti<8) {if (bd[itti][ittj] == 1)return true;}
                }
            }


        }
        return false;
    }
    private void fliper(int bd[][],int i,int j,int chance)
    {
        if (chance==0) {
            bd[i][j] = chance;

            if (i + 1 < 7) {
                if (bd[i + 1][j] == 1) {
                    int itt = i + 1;
                    while (itt < 8 && bd[itt][j] == 1) {
                        itt++;
                    }
                    if (itt < 8) {
                        if (bd[itt][j] == 0) {
                            int k = i;
                            while (k < itt) {
                                bd[k][j] = 0;
                                k++;
                            }
                        }
                    }
                }

            }
            if (i - 1 > 0) {
                if (bd[i - 1][j] == 1) {
                    int itt = i - 1;
                    while (itt > -1 && bd[itt][j] == 1) {
                        itt--;
                    }
                    if (itt > -1) {
                        if (bd[itt][j] == 0) {
                            int k = i;
                            while (k > itt) {
                                bd[k][j] = 0;
                                k--;
                            }
                        }

                    }

                }
            }
            if (j + 1 < 7) {
                if (bd[i][j + 1] == 1) {
                    int itt = j + 1;
                    while (itt < 8 && bd[i][itt] == 1) {
                        itt++;
                    }
                    if (itt < 8) {
                        if (bd[i][itt] == 0) {
                            int k = j;
                            while (k < itt) {
                                bd[i][k] = 0;
                                k++;
                            }
                        }
                    }

                }
            }

            if (j - 1 > 0) {
                if (bd[i][j - 1] == 1) {
                    int itt = j - 1;
                    while (itt > -1 && bd[i][itt] == 1) {
                        itt--;
                    }
                    if (itt > -1) {
                        if (bd[i][itt] == 0) {
                            int k = j;
                            while (k > itt) {
                                bd[i][k] = 0;
                                k--;
                            }
                        }
                    }

                }

            }
            if (i + 1 < 7 && j + 1 < 7) {
                if (bd[i + 1][j + 1] == 1) {
                    int itti = i + 1;
                    int ittj = j + 1;
                    while (itti < 8 && ittj < 8 && bd[itti][ittj] == 1) {
                        itti++;
                        ittj++;
                    }
                    if (itti < 8 && ittj < 8) {
                        if (bd[itti][ittj] == 0) {
                            int k = i;
                            int l = j;
                            while (k < itti && l < ittj) {
                                bd[k][l] = 0;
                                k++;
                                l++;
                            }
                        }
                    }
                }

            }
            if (i - 1 > 0 && j - 1 > 0) {
                if (bd[i - 1][j - 1] == 1) {
                    int itti = i - 1;
                    int ittj = j - 1;
                    while (itti > -1 && ittj > -1 && bd[itti][ittj] == 1) {
                        itti--;
                        ittj--;
                    }
                    if (itti > -1 && ittj > -1) {
                        if (bd[itti][ittj] == 0) {
                            int k = i;
                            int l = j;
                            while (k > itti && l > ittj) {
                                bd[k][l] = 0;
                                k--;
                                l--;
                            }
                        }
                    }
                }

            }
            if (i - 1 > 0 && j + 1 < 7) {
                if (bd[i - 1][j + 1] == 1) {
                    int itti = i - 1;
                    int ittj = j + 1;
                    while (itti > -1 && ittj < 8 && bd[itti][ittj] == 1) {
                        itti--;
                        ittj++;
                    }
                    if (itti > -1 && ittj < 8) {
                        if (bd[itti][ittj] == 0) {
                            int k = i;
                            int l = j;
                            while (k > itti && l < ittj) {
                                bd[k][l] = 0;
                                k--;
                                l++;
                            }
                        }
                    }
                }
            }
            if (i + 1 < 7 && j - 1 > 0) {
                if (bd[i + 1][j - 1] == 1) {
                    int itti = i + 1;
                    int ittj = j - 1;
                    while (ittj > -1 && itti < 8 && bd[itti][ittj] == 1) {
                        ittj--;
                        itti++;
                    }
                    if (ittj > -1 && itti < 8) {
                        if (bd[itti][ittj] == 0) {
                            int k = i;
                            int l = j;
                            while (k < itti && l > ittj) {
                                bd[k][l] = 0;
                                k++;
                                l--;
                            }
                        }
                    }
                }
            }
        }
        if (chance==1) {
            bd[i][j] = chance;

            if (i + 1 < 7) {
                if (bd[i + 1][j] == 0) {
                    int itt = i + 1;
                    while (itt < 8 && bd[itt][j] == 0) {
                        itt++;
                    }
                    if (itt < 8) {
                        if (bd[itt][j] == 1) {
                            int k = i;
                            while (k < itt) {
                                bd[k][j] = 1;
                                k++;
                            }
                        }
                    }
                }

            }
            if (i - 1 > 0) {
                if (bd[i - 1][j] == 0) {
                    int itt = i - 1;
                    while (itt > -1 && bd[itt][j] == 0) {
                        itt--;
                    }
                    if (itt > -1) {
                        if (bd[itt][j] == 1) {
                            int k = i;
                            while (k > itt) {
                                bd[k][j] = 1;
                                k--;
                            }
                        }

                    }

                }
            }
            if (j + 1 < 7) {
                if (bd[i][j + 1] == 0) {
                    int itt = j + 1;
                    while (itt < 8 && bd[i][itt] == 0) {
                        itt++;
                    }
                    if (itt < 8) {
                        if (bd[i][itt] == 1) {
                            int k = j;
                            while (k < itt) {
                                bd[i][k] = 1;
                                k++;
                            }
                        }
                    }

                }
            }

            if (j - 1 > 0) {
                if (bd[i][j - 1] == 0) {
                    int itt = j - 1;
                    while (itt > -1 && bd[i][itt] == 0) {
                        itt--;
                    }
                    if (itt > -1) {
                        if (bd[i][itt] == 1) {
                            int k = j;
                            while (k > itt) {
                                bd[i][k] = 1;
                                k--;
                            }
                        }
                    }

                }

            }
            if (i + 1 < 7 && j + 1 < 7) {
                if (bd[i + 1][j + 1] == 0) {
                    int itti = i + 1;
                    int ittj = j + 1;
                    while (itti < 8 && ittj < 8 && bd[itti][ittj] == 0) {
                        itti++;
                        ittj++;
                    }
                    if (itti < 8 && ittj < 8) {
                        if (bd[itti][ittj] == 1) {
                            int k = i;
                            int l = j;
                            while (k < itti && l < ittj) {
                                bd[k][l] = 1;
                                k++;
                                l++;
                            }
                        }
                    }
                }

            }
            if (i - 1 > 0 && j - 1 > 0) {
                if (bd[i - 1][j - 1] == 0) {
                    int itti = i - 1;
                    int ittj = j - 1;
                    while (itti > -1 && ittj > -1 && bd[itti][ittj] ==0) {
                        itti--;
                        ittj--;
                    }
                    if (itti > -1 && ittj > -1) {
                        if (bd[itti][ittj] ==1) {
                            int k = i;
                            int l = j;
                            while (k > itti && l > ittj) {
                                bd[k][l] =1;
                                k--;
                                l--;
                            }
                        }
                    }
                }

            }
            if (i - 1 > 0 && j + 1 < 7) {
                if (bd[i - 1][j + 1] ==0) {
                    int itti = i - 1;
                    int ittj = j + 1;
                    while (itti > -1 && ittj < 8 && bd[itti][ittj] ==0) {
                        itti--;
                        ittj++;
                    }
                    if (itti > -1 && ittj < 8) {
                        if (bd[itti][ittj] ==1) {
                            int k = i;
                            int l = j;
                            while (k > itti && l < ittj) {
                                bd[k][l] =1;
                                k--;
                                l++;
                            }
                        }
                    }
                }
            }
            if (i + 1 < 7 && j - 1 > 0) {
                if (bd[i + 1][j - 1] ==0) {
                    int itti = i + 1;
                    int ittj = j - 1;
                    while (ittj > -1 && itti < 8 && bd[itti][ittj] ==0) {
                        ittj--;
                        itti++;
                    }
                    if (ittj > -1 && itti < 8) {
                        if (bd[itti][ittj] == 1) {
                            int k = i;
                            int l = j;
                            while (k < itti && l > ittj) {
                                bd[k][l] = 1;
                                k++;
                                l--;
                            }
                        }
                    }
                }
            }
        }
    }

private int number(int n)
{
    if (n%2==0)return 1;
    else return 0;
}
private int marks(int i,int j)
    {
        return 8*i+j;
    }
private void printer(int bd[][])
{
    for (int i=0;i<8;i++)
    {
        for (int j=0;j<8;j++)
        {
            // System.out.print(bd[i][j]);
        }
        // System.out.println("");
    }
}
private int besthelper(int bd[][],int k,int cur,int chance)
{
    int kig=Integer.MAX_VALUE;


    if (cur==k)
    {

        return boarde(bd);


    }

int pill=cur+1;
    for (int i=0;i<8;i++)
    {
        for (int j=0;j<8;j++)
        {

            if (bd[i][j]==-1)
            {if (number(pill)==0){
               if(possible(i,j,chance,bd))
               {
                // System.out.println("check");
                   int dummy[][]=new int[8][8];
                   for (int t=0;t<8;t++)
                   {
                       for (int h = 0; h < 8; h++)
                       {
                           dummy[t][h]=bd[t][h];
                       }
                   }
                   fliper(dummy,i,j,chance);
//                   if (number(pill)==0)fliper(dummy,i,j,chance);
//                   else
//                   {if (chance==0)
//                   {if(possible(i,j,1,dummy))fliper(dummy,i,j,1);}
//                   else {
//                       if (possible(i,j,0,dummy))fliper(dummy,i,j,0);}
//                   }
                //    System.out.println("dummy");
                   printer(dummy);
                   int newitt=besthelper(dummy,k,pill,chance);

                   if (kig==Integer.MAX_VALUE)
                   {kig=newitt;
                       if (pill==1)
                       {
                           I=i;
                           J=j;
                       }
                      }
                   else
                   {
                           if (number(pill) == 0) {
                               if (newitt > kig) {

                                   kig = newitt;
                                   if (pill==1)
                                   {
                                       I=i;
                                       J=j;
                                   }
                               }
//                               if (newitt.score== kgf.score)
//                               {
//                                   if (marks(newitt.i,newitt.j)<marks(kgf.i,kgf.j))
//                                   {
//                                       kgf.i=newitt.i;
//                                       kgf.j=newitt.j;
//                                   }
//                               }
                               if (newitt== kig)
                               {
                                   if (pill==1){
                                       if (marks(i,j)<marks(I,J))
                                       {
                                           I=i;
                                           J=j;
                                       }}
                               }

                           } else {
                               if (newitt < kig) {

                                   kig = newitt;
                                   if (pill==1)
                                   {
                                       I=i;
                                       J=j;
                                   }
                               }
                               if (newitt== kig)
                               {
                                   if (pill==1){
                                   if (marks(i,j)<marks(I,J))
                                   {
                                       I=i;
                                       J=j;
                                   }}
                               }
                           }

                   }

               }}
                else
            {
                if (chance==0)
                {
                    if (possible(i,j,1,bd))
                    {
                        // System.out.println("check");
                        int dummy[][]=new int[8][8];
                        for (int t=0;t<8;t++)
                        {
                            for (int h = 0; h < 8; h++)
                            {
                                dummy[t][h]=bd[t][h];
                            }
                        }
                        fliper(dummy,i,j,1);
                        // System.out.println("dummy");
                        printer(dummy);
                         int newitt=besthelper(dummy,k,pill,chance);

                        if (kig==Integer.MAX_VALUE)
                        {kig=newitt;
                            if (pill==1)
                            {
                                I=i;
                                J=j;
                            }
                        }
                        else
                        {
                                if (number(pill) == 0) {
                                    if (newitt > kig) {

                                        kig = newitt;
                                        if (pill==1)
                                        {
                                            I=i;
                                            J=j;
                                        }
                                    }

                                } else {
                                    if (newitt < kig) {

                                        kig = newitt;
                                        if (pill==1)
                                        {
                                            I=i;
                                            J=j;
                                        }
                                    }
//                                    if (newitt.score== kgf.score)
//                                    {
//                                        if (marks(newitt.i,newitt.j)<marks(kgf.i,kgf.j))
//                                        {
//                                            kgf.i=newitt.i;
//                                            kgf.j=newitt.j;
//                                        }
//                                    }
                                    if (newitt== kig)
                                    {
                                        if (pill==1){
                                            if (marks(i,j)<marks(I,J))
                                            {
                                                I=i;
                                                J=j;
                                            }}
                                    }
                                }

                        }

                    }

                }
                else
                {
                    if (possible(i,j,0,bd))
                    {
                        // System.out.println("check");
                        int dummy[][]=new int[8][8];
                        for (int t=0;t<8;t++)
                        {
                            for (int h = 0; h < 8; h++)
                            {
                                dummy[t][h]=bd[t][h];
                            }
                        }
                        fliper(dummy,i,j,0);
                        // System.out.println("dummy");
                        printer(dummy);
                        int newitt=besthelper(dummy,k,pill,chance);

                        if (kig==Integer.MAX_VALUE)
                        {kig=newitt;
                            if (pill==1)
                            {
                                I=i;
                                J=j;
                            }
                        }
                        else
                        {
                                if (number(pill) == 0) {
                                    if (newitt > kig) {

                                        kig = newitt;
                                        if (pill==1)
                                        {
                                            I=i;
                                            J=j;
                                        }
                                    }
//                                    if (newitt.score== kgf.score)
//                                    {
//                                        if (marks(newitt.i,newitt.j)<marks(kgf.i,kgf.j))
//                                        {
//                                            kgf.i=newitt.i;
//                                            kgf.j=newitt.j;
//                                        }
//                                    }
                                    if (newitt== kig)
                                    {
                                        if (pill==1){
                                            if (marks(i,j)<marks(I,J))
                                            {
                                                I=i;
                                                J=j;
                                            }}
                                    }
                                } else {
                                    if (newitt < kig) {

                                        kig = newitt;
                                        if (pill==1)
                                        {
                                            I=i;
                                            J=j;
                                        }
                                    }
//                                    if (newitt== kig)
//                                    {
//                                        if (marks(newitt.i,newitt.j)<marks(kgf.i,kgf.j))
//                                        {
//                                            kgf.i=newitt.i;
//                                            kgf.j=newitt.j;
//                                        }
//                                    }
                                    if (newitt== kig)
                                    {
                                        if (pill==1){
                                            if (marks(i,j)<marks(I,J))
                                            {
                                                I=i;
                                                J=j;
                                            }}
                                    }
                                }

                        }

                    }

                }
            }
            }

        }
    }
    return kig;
}

    public int bestMove(int k) {
        /* Complete this function to build a Minimax tree of depth k (current board being at depth 0),
         * for the current player (siginified by the variable turn), and propagate scores upward to find
         * the best move. If the best move (move with max score at depth 0) is i,j; return i*8+j
         * In case of ties, return the smallest integer value representing the tile with best score.
         * 
         * Note: Do not alter the turn variable in this function, so that the boardScore() is the score
         * for the same player throughout the Minimax tree.
        */
        int bd[][]=new int[8][8];
        for (int t=0;t<8;t++)
        {
            for (int h = 0; h < 8; h++)
            {
                bd[t][h]=board[t][h];
            }
        }
        int ans=besthelper(bd,k,0,turn);
        return marks(I,J);
    }

    public ArrayList<Integer> fullGame(int k) {
        /* Complete this function to compute and execute the best move for each player starting from
         * the current turn using k-step look-ahead. Accordingly modify the board and the turn
         * at each step. In the end, modify the winner variable as required.
         */
        return new ArrayList<Integer>();
    }

    public int[][] getBoardCopy() {
        int copy[][] = new int[8][8];
        for(int i = 0; i < 8; ++i)
            System.arraycopy(board[i], 0, copy[i], 0, 8);
        return copy;
    }

    public int getWinner() {
        return winner;
    }

    public int getTurn() {
        return turn;
    }
}