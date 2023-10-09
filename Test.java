package practice;

import java.util.Scanner;
abstract class Account{
    String Customer_name;
    long Acc_Id;
    String Acc_Type;
    Account(String Customer_name,long Acc_Id, String Acc_Type){
        this.Customer_name=Customer_name;
        this.Acc_Id=Acc_Id;
        this.Acc_Type=Acc_Type;
    }
    abstract void deposit();
    abstract void balance();
    abstract void witdrawal();
    abstract void Interest();

    abstract void display();

}
class Curr_Acct extends Account{
    double balance=0,min_balance=1000;
    double dep,witdraw;
    double updated_balance;

    Curr_Acct(String Customer_name,long Acc_Id, String Acc_Type){
        super(Customer_name,Acc_Id,Acc_Type);
    }

    void display(){
        System.out.println(Customer_name+" " +Acc_Id+" "+Acc_Type);}


    void deposit(){

        System.out.println("enter the money to deposit= ");
        Scanner sc=new Scanner(System.in);
        dep=sc.nextDouble();
        balance=balance+dep;
    }


    void witdrawal(){
        System.out.println("enter money to withdraw");
        Scanner sc=new Scanner(System.in);
        witdraw=sc.nextDouble();
        balance-=witdraw;
        System.out.println("balance= "+balance);
        if (balance<min_balance){
            balance-=100;
            System.out.println("your balance less then minimum");}
    }
    void balance(){
        System.out.println("Balance in account= "+balance);
    }
    void Interest(){
        System.out.println("no interest for current account ");
    }
}
class Savn_Acct extends Account{
    double balance=0;
    double dep,witdraw;
    double updated_balance;
    double rate=10,time=2;

    Savn_Acct(String Customer_name,long Acc_Id, String Acc_Type){
        super(Customer_name,Acc_Id,Acc_Type);
    }
    void display(){
        System.out.println(Customer_name+" " +Acc_Id+" "+Acc_Type);}


    void deposit(){
        System.out.println("enter the money to deposit= ");
        Scanner sc=new Scanner(System.in);
        dep=sc.nextDouble();
        balance=balance+dep;
    }


    void witdrawal(){
        System.out.println("enter money to withdraw");
        Scanner sc=new Scanner(System.in);
        witdraw=sc.nextDouble();
        balance-=witdraw;

    }
    void balance(){
        System.out.println("Balance in account= "+balance);
    }
    void Interest(){
        double  interest=balance*(Math.pow((1+rate/100.0),time)-1);
        System.out.println("your interest"+interest);
    }
}
class Demo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Account  c=new Curr_Acct("Alok",1002034455,"Current Account");
        Account b=new Savn_Acct ("Alok",1002034455,"Saving Account");
        while(true){
            System.out.println("enter the account type::: \n1. Current account \n2. Savings account\n3.Exit\n");
            int a=sc.nextInt();
            switch(a){

                case 1:
                    System.out.println("your Account is Current type");
		    while(true){
                    System.out.println("enter feature u wanna access:::  \n1.display Acc.details  \n 2.deposit money  \n 3.withdrae monay \n 4.balance\n 5.exit \n");
                    int m= sc.nextInt();
                    switch(m) {
                        case 1:
                            c.display();
                            break;
                        case 2:
                            c.deposit();
                            break;
                        case 3:
                            c.witdrawal();
                            break;
                        case 4:
                            c.balance();
                            break;
                        case 5:
                            	System.exit(0);
				}
                    }
                case 2:
                    System.out.println("your Account is saving  type");
		    while(true){
                    System.out.println("enter feature u wanna access:::  \n1.display Acc.details  \n 2.deposit money  \n 3.withdrae monay \n 4.balance \n 5.exit\n");
                    int p= sc.nextInt();
                    switch(p) {
                        case 1:
                            c.display();
                            break;
                        case 2:
                            c.deposit();
                            break;
                        case 3:
                            c.witdrawal();
                            break;
                        case 4:
                            c.balance();
                            break;
                        case 5:
                           	System.exit(0);
				}
                    }
                case 3:
                	System.exit(0);
                    
                default :  System.out.println("Enter properly");
                sc.close();
            }
        }
    }
}





