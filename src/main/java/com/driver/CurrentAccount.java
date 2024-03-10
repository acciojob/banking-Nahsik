package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        if(balance < 5000){
              throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public void validateLicenseId() throws Exception {
         
         int[] frq = new int[26];
         boolean isValid = true;
         for(int i=0;i<this.tradeLicenseId.length();i++){
            int c = tradeLicenseId.charAt(i)-'A';
            frq[c]++;
            if(frq[c] > tradeLicenseId.length()/2){
               throw new Exception("Valid License can not be generated");
            }
            if(i>0 && tradeLicenseId.charAt(i-1)==tradeLicenseId.charAt(i)){
                isValid = false;
            }
         }
         
         if(isValid){
            return;
         }
         StringBuffer stringBuffer = new StringBuffer();
         int prv = -1;
         for(int i=0;i<26;i++){
               if(frq[i]>0){
                prv = i;
                stringBuffer.append( i+'A');
                frq[i]--;
                break;
               }
         }

         while(stringBuffer.length() < tradeLicenseId.length()){
            for(int i=0;i<26;i++){
                if(frq[i]>0 && i!=prv){
                    prv = i;
                    stringBuffer.append( i+'A');
                    frq[i]--;
                    break;
                   }
            }
         }
            this.tradeLicenseId = stringBuffer.toString();
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

    }

    public String getTradeLicenseId(){
         return this.tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId ){
        this.tradeLicenseId = tradeLicenseId;
   }

}
