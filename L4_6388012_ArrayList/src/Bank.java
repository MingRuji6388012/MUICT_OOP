import java.util.ArrayList;
import java.util.List;


public class Bank {
    //1.variable
    private List<BankAccount> accounts;
    //2.constructor
    public Bank(){
        accounts = new ArrayList<BankAccount>();   // ArrayList of BankAccount --> BankAccount[] accounts = new BankAccount[]
    }
    //3.methods
    //add an account to this bank
    public void PrintAccount(){
        System.out.println(accounts);
    }

    public void addAccount(BankAccount a){
        accounts.add(a);
    }
    //gets the sum of the balances of all accounts in this bank
    public double getTotalBalance(){

        //**************** YOUR CODE HERE****************
        double totalbalance = 0;
        for(BankAccount num : accounts){
            totalbalance += num.getBalance();
        }
        return totalbalance;
        //*********************************************
    }
    //counts the number of bank account whose balance is at least given value.
    public int countBalanceAtLeast(double atLeast){

        //**************** YOUR CODE HERE****************
        int count = 0;
        for(BankAccount num : accounts){
            if(num.getBalance() >= atLeast){
                count++;
            }
        }
        return count;
        //*********************************************
    }

    //finds a bank account with a given number
    public BankAccount find(int accountNumber){

        //**************** YOUR CODE HERE****************
        for(BankAccount num : accounts){
            if(num.getAccountNumber() == accountNumber){
                return num;
            }
        }
        return null;
        //*********************************************
    }

    //gets the bank account with the largest balance.
    public BankAccount getMax(){

        //**************** YOUR CODE HERE****************
        if(accounts.size() > 1){
            double MAX = accounts.get(0).getBalance(); //get account at ArrayList index 0 --> getBalance
            int index = 0;
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getBalance() > MAX) {
                    MAX = accounts.get(i).getBalance();
                    index = i;
                }
            }
            return accounts.get(index);
        }
        else return null;
        //*********************************************
    }

    //gets the bank account with the minimum balance.
    public BankAccount getMin(){

        //**************** YOUR CODE HERE****************
        if(accounts.size() > 1){
            double MIN = accounts.get(0).getBalance(); //get account at ArrayList index 0 --> getBalance
            int index = 0;
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getBalance() < MIN) {
                    MIN = accounts.get(i).getBalance();
                    index = i;
                }
            }
            return accounts.get(index);
        }else return null;
        //*********************************************
    }


    //finds duplicate accounts by checking the account numbers in O(N) without using Set and Map
    //return the list of all the accounts that are later found to be duplicate, if there is no duplicate simply return an empty list
    public List<BankAccount> findDuplicate(){

        //**************** YOUR CODE HERE****************
        //This is option 2: Palindrome
        //This method call at "Palindrome" class
        Palindrome.IsItPalindrome();
        return null;
        //*********************************************
    }

}

