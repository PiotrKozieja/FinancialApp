import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVsave {
    public static void cName(){ ///column name
        try {
            String nazwaPliku = "dane.csv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku, true));
            writer.write("Date:;Stocks:;sPrice:;Value:;Saving:");
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void Write(int i, int j,int NOS, int StockP, int SV, int SavingAcc) {
        try {
            String nazwaPliku = "FinancialData.csv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku, true));
            //writer.write(j+" "+i+" "+NOS + " " + StockP + " " + NOS * StockP + " " + SavingAcc);
            ///writer.write(String.format("%02d.%02d",j,i)+"    "+"NOS: "
            ///+String.format("%04d", NOS)+"      StockP: "+String.format("%4d", StockP)+"      SValue: "+ String.format("%06d", NOS*StockP) 
            ///+"   SavingAcc: "+SavingAcc);
            writer.write(String.format("%02d.%02d",j,i)+";"+NOS+";"+StockP+";"+NOS * StockP + ";"+SavingAcc+"");
            writer.newLine();
            writer.close();
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cName();
        Write(1,1,1000, 3000, 9000, 30);
    }
}
