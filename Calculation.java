import java.lang.Math;
public class Calculation {


    ////PV to wartość początkowa (np 10 000)
    ///r to stopa zwrotu (np 8%),
    ///t to liczba lat
    ///FV to przyszla wartosc
    public static void c1(int PV,double r, double t){
        r = r/100;
        double FV = PV*Math.pow(r+1,t);
        System.out.println((int)FV);
    }


    ///zwraca sredni wzrost na miesiac na podstawie wzrostu rocznego
    public static double percentCalc(double r) {
        double exit = Math.pow(1 + (r / 100), 1.0 / 12) - 1;
        String formattedExit = String.format("%.6f", exit).replace(",", ".");
        return Double.parseDouble(formattedExit);
    }
    ///Wypisuje miesiac, rok, wzrost zainwestowanej kwoty oraz gotowke gotowa do inwestycji;
    /////add to kwota ktora bedzie doplacana co miesiac
    public static void monthCalc(int PV, double r, double t, int add){
        double perc = percentCalc(r);
        double amount = (double)PV;
        int addc = add;
        System.out.println("00.01"+"    Cash: "+Math.round(amount)+"     Additional cash: "+0);
        for(int i=1;i<=t;i++){
            for(int j=1;j<=12;j++){
                amount=amount*(1+perc);
                System.out.println(String.format("%02d.%02d",j,i)+"    Cash: "+Math.round(amount)+"     Additional cash: "+addc);
                addc+=add;
            }
        }
    }
    public static void show(int j, int i,int NOS,int StockP,int SavingAcc){
        System.out.println(String.format("%02d.%02d",j,i)+"    "+"NOS: "
        +String.format("%04d", NOS)+"      StockP: "+String.format("%4d", StockP)+"      SValue: "+ String.format("%06d", NOS*StockP) 
        +"   SavingAcc: "+SavingAcc);
    }
    public static void showStats(int NOS,int StockP,int SavingAcc,int add, int Pv, double t){
        System.out.println("\nAfter this time you've got "+NOS+" stocks, they are worth "+NOS*StockP+", you also 've got "+SavingAcc+" ready to buy another stock");
        System.out.println("Your total profit is "+(int)(NOS*StockP-12*t*add-Pv+SavingAcc));
        System.out.println("Your profit per month is "+(NOS*StockP-12*t*add-Pv+SavingAcc)/(12*t));
        ///System.out.println(StockP+" "+NOS+" "+t+" "+add+" "+Pv+" "+SavingAcc);
    }
    ///StockP cena Akcji
    /// Mod Month od dividend (Number of month ex. June = 6)
    /// Dr Divident rate (ex 8% = 8)
    ///PV to wartość początkowa (np 10 000)
    ///r to stopa zwrotu roczna (np 8%),
    ///t to liczba lat
    ///FV to przyszla wartosc
    ///add to kwota ktora bedzie doplacana co miesiac
    public static int[] EntryStock(int StockP, int PV){
        int NOS = PV/StockP;
        int SavingAcc = PV-NOS*StockP;
        int[] end = {NOS,SavingAcc};
        return end;
    }
    ///Terminal Calculation
    public static void StockCalc(int StockP,int Mod,int Dr,int Pv,double r,double t,int add){
        int NOS =EntryStock(StockP, Pv)[0];        ///number of stocks
        int SavingAcc = EntryStock(StockP, Pv)[1]; ///SavingAccount
        double Mperc = percentCalc(r);
        System.out.println("\nLegend:\n\nDate: Number of stocks:  StockPrice:        StockValue:     Saving account:\n");
        for(int i=1;i<=t;i++){              ///years
            System.out.println("------------------------Year: "+i+"-----------------------------------------------");
            for(int j=1;j<=12;j++){         ///months
                SavingAcc+=add;
                StockP = (int)(Math.round(StockP*(1+Mperc)));
                if(j == Mod){
                    int dividendAdd = (int)(NOS*Math.round(StockP*((double)Dr/100)));
                    SavingAcc+= dividendAdd;
                    System.out.println("\nDividend per action: "+(Math.round(StockP*((double)Dr/100)))+" Counted by stock price: "+ StockP+", NOS: "+NOS);
                    System.out.println("Dividend added:"+dividendAdd+"\n");
                }
                if(SavingAcc>=StockP){
                    NOS+=SavingAcc/StockP;
                    SavingAcc-=(SavingAcc/StockP)*StockP;
                }
                show(j, i, NOS, StockP, SavingAcc);
            }
            
        }showStats(NOS, StockP, SavingAcc, add, Pv, t);
    }

    //Creating csv file
    public static void StockCalc1(int StockP,int Mod,int Dr,int Pv,double r,double t,int add){
        int NOS =EntryStock(StockP, Pv)[0];        ///number of stocks
        int SavingAcc = EntryStock(StockP, Pv)[1]; ///SavingAccount
        double Mperc = percentCalc(r);
        String[][] exitArr;
        for(int i=1;i<=t;i++){              ///years
            for(int j=1;j<=12;j++){         ///months
                SavingAcc+=add;
                StockP = (int)(Math.round(StockP*(1+Mperc)));
                if(j == Mod){
                    int dividendAdd = (int)(NOS*Math.round(StockP*((double)Dr/100)));
                    SavingAcc+= dividendAdd;
                }
                if(SavingAcc>=StockP){
                    NOS+=SavingAcc/StockP;
                    SavingAcc-=(SavingAcc/StockP)*StockP;
                }
                ///System.out.println(NOS+" "+StockP+" "+NOS*StockP+" "+SavingAcc);
                CSVsave.Write(i, j, NOS, StockP, j, SavingAcc);
            }
        }
        System.out.println("\nFinancial calculation added to FinancialData.csv");
    }
    public static boolean checkInput(String stockP, String mod, String dr, String pv, String r, String t, String add) {
        try {
            int stockPrice = Integer.parseInt(stockP);
            int modValue = Integer.parseInt(mod);
            int drValue = Integer.parseInt(dr);
            int pvValue = Integer.parseInt(pv);
            double rValue = Double.parseDouble(r);
            double tValue = Double.parseDouble(t);
            int addValue = Integer.parseInt(add);
            return true;
        } 
        catch (NumberFormatException e) {

            return false;
        }
    }

    public static void main(String[] args) {
        ///c1(10000,8,1);
        ///percentCalc(5);
        ///System.out.println(percentCalc(5));
        ///monthCalc(10000, 8, 2,1000);
        //System.out.println(Arrays.toString(EntryStock(3000, 10000)));
        ///StockCalc(3000, 6, 5, 10000, 8,2, 1000);
        ///StockCalc(3000, 6, 4, 20000, 5,5, 1000);
        ///StockCalc1(3000, 6, 5, 10000, 8,2, 1000);
        

    }
    
}
