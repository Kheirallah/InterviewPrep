package com.kheirallah.inc.affirm;

public class LoanProcessorService {
}

/*
//LoansService
process_loan(loan_amount) // processes a loan
get_loan_volume() // returns the amount processed over the past hour

class LoansServiceImpl {

   DateFormatter date = new DateFormatter("hh:mm:ss");
   //List<Float> loans = new ArrayList<>();
   Map<Date, List<Float>> loans = new TreeMap<>();

   //float totalLoans = 0;

   public void process_loan(Float loan_amount) {
       ctl = loans.get(DateTime.getCurrentSystemTime());
       List<Float> loansAtTime = ctl.getValue();
       if (loan_amount > 0) {
           loansAtTime.add(loan_amount);
           loans.put(ctl.getKey(), loansAtTime);
       }
   }

   //LogN
   public Float get_loan_volume() {
       float totalLoans = 0;
       for(Map.Entry entry : loans.entrySet()) {
        //   if (DateTime.getCurrentSystemTime - entry.getKey() > 1) {
        //       return totalLoans;
        //   }
           if (DateTime.getCurrentSystemTime() - entry.getKey() < 3600000 && >= 0) {
               totalLoans += entry.getValue();
           }

       }
       return totalLoans;
   }

   // 2:30.000 1, 2:30.001 2, ....., 3:30.001, 3
   // get_loan_volume() 3:30.001

   //1000ms -> 1s -> 60s -> 1m -> 60m -> 1hr
   //60m * 60s 3600000ms
}
 */