import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;


public class Main {

    public static void main(String[] args) {

        //CSV = Comma-Separated Values
        //   text file that uses a comma to separate values

        String file = "src\\vhod.csv";
        BufferedReader reader = null;
        String line = "";
        String[] tabela = null;
        List<List<String>> tab = new ArrayList<>();

        int length = 0;
        JTextArea j = new JTextArea();
        JFrame frame = new JFrame("MOS Graf");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,1));
frame.add(j);




        try {
            reader = new BufferedReader(new FileReader(file));
            List<String> tab9 = null;
            while ((line = reader.readLine()) != null) {

                String[] row = line.split(", ");

               // tab9 = new ArrayList<>();
                length=row.length;
for(int i=0;i< row.length;i++){
    tab.add(Collections.singletonList(row[i]));


}
/*
               tab0.add(row[0]);
                 tab.add(tab0);


                tab1.add(row[1]);
                 tab.add(tab1);

                tab2.add(row[2]);
                 tab.add(tab2);

                tab3.add(row[3]);
                tab4.add(row[4]);

                 tab.add(tab3);
                tab.add(tab4);







               /* tab9.add(tab0);
                tab9.add(tab1);
                tab9.add(tab2);
                tab9.add(tab3);
                tab9.add(tab4);*/





//tab.add(tab0);
                //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
//use this if your values already contain commas
                for (String index : row) {
                    index=index+"   ";
                    System.out.printf("%-20s", index);
                    j.append( index);

//tab9.add(index);

                }
                System.out.println(" ");
j.append("  ");
                j.append("“\n”");
            }
            tab.add(tab9);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(tab);
        System.out.println(tab.get(1));
        System.out.println(tab.get(1).get(0));
        System.out.println(length);
String nazivMetode=null;

        int pozitiv= 1;
        int negativ=0;
        int Savage=100;
        int Laplace=0;
        for(int i = 1; i < length;i++){

            if(negativ< Integer.parseInt((String) tab.get(i+length).get(0))){
                negativ=Integer.parseInt((String) tab.get(i+length).get(0));
                nazivMetode=(String) tab.get(i).get(0);
            }
          /*  if(negativ>Integer.parseInt((String) tab.get(i).get(2))){
                negativ=Integer.parseInt((String) tab.get(i).get(2));
                nazivMetode=(String) tab.get(i).get(0);
            }*/


        }
        System.out.println("Pesimist: "+negativ+" naziv metode: "+nazivMetode);
        j.append("“\n”");
        j.append("Pesimist: "+negativ+" naziv metode: "+nazivMetode);

        for(int i = 1; i < length;i++){

            if(pozitiv< Integer.parseInt((String) tab.get(i+length).get(0))){
                pozitiv=Integer.parseInt((String) tab.get(i+length).get(0));
                nazivMetode=(String) tab.get(i).get(0);
            }
            if(pozitiv<Integer.parseInt((String) tab.get(i+length*2).get(0))){
                pozitiv=Integer.parseInt((String) tab.get(i+length*2).get(0));
                nazivMetode=(String) tab.get(i).get(0);
            }


        }
        System.out.println("Optimist: "+pozitiv+" naziv metode: "+nazivMetode);
        j.append("“\n”");
        j.append("Optimist: "+pozitiv+" naziv metode: "+nazivMetode);
        int[] vr= new int[(length)];
        int[] vrn= new int[(length)];
        String[] st=new String[length];
        for(int i = 1; i < length;i++) {
System.out.println(negativ - Integer.parseInt((String) tab.get(i + length).get(0)));
System.out.println((pozitiv - Integer.parseInt((String) tab.get(i + length * 2).get(0))));

            //if(Savage> (pozitiv -Integer.parseInt((String) tab.get(i+length*2).get(0)))){
            if((negativ - Integer.parseInt((String) tab.get(i + length).get(0)))!=0 ) {

                System.out.println("mmm");
                vrn[i] = (pozitiv - Integer.parseInt((String) tab.get(i + length * 2).get(0)));
            }
            if((negativ - Integer.parseInt((String) tab.get(i + length).get(0)))==0)
            {
                vr[i]=100;
            }
                if(((pozitiv - Integer.parseInt((String) tab.get(i + length * 2).get(0)))!=0))
                {
                    vr[i]=(negativ - Integer.parseInt((String) tab.get(i + length).get(0)));
                }
            if(((pozitiv - Integer.parseInt((String) tab.get(i + length * 2).get(0)))==0))
            {
                vr[i]=100;
            }
                st[i] = (String) tab.get(i).get(0);
            }
            // }
            // if(Savage > (negativ-Integer.parseInt((String) tab.get(i+length).get(0)))){

            // }



            for(int i = 0; i < length;i++){
if(Savage>=vr[i]&&vr[i]!=0){
    Savage=vr[i];
    nazivMetode=st[i];

}
if (Savage<=vrn[i]&&vrn[i]!=0){
    Savage=vrn[i];
    nazivMetode=st[i];
}

            }



        System.out.println("Savage: "+Savage+" naziv metode: "+nazivMetode);
        j.append("“\n”");
        j.append("Savage: "+Savage+" naziv metode: "+nazivMetode);


        for(int i = 1; i < length;i++){

            if(Laplace< (Integer.parseInt((String) tab.get(i+length).get(0))+Integer.parseInt((String) tab.get(i+length*2).get(0)))/2 ){
                Laplace=(Integer.parseInt((String) tab.get(i+length).get(0))+Integer.parseInt((String) tab.get(i+length*2).get(0)))/2;
                nazivMetode=(String) tab.get(i).get(0);
            }

        }
        System.out.println("Laplace: "+Laplace+" naziv metode: "+nazivMetode);
        j.append("“\n”");
        j.append("Laplace: "+Laplace+" naziv metode: "+nazivMetode);

System.out.println("Hurwitzev kriterij:");
        j.append("“\n”");
        j.append("Hurwitzev kriterij:");
        j.append("“\n”");
        System.out.print("h");
        j.append("h");
for(int i=1;i<length;i++){
    j.append("       "+tab.get(length-i).get(0));
    System.out.print("       "+tab.get(length-i).get(0));
}
System.out.println();
        j.append("“\n”");
for (int h=0;h<11;h++){
    System.out.println();
    j.append("“\n”");
    j.append((double) h/10+"   ");
    System.out.print((double) h/10+"   ");
for (int i = 1; i < length;i++){
//System.out.println(i);

    System.out.print("     "+((Double.parseDouble((String) tab.get(length*2-i).get(0) )*(10-h))+
            Double.parseDouble((String) tab.get(length*3-i).get(0))*h)/10+ "      ");
    j.append("                     "+((Double.parseDouble((String) tab.get(length*2-i).get(0) )*(10-h))+
            Double.parseDouble((String) tab.get(length*3-i).get(0))*h)/10+ "         ");


    }

}




        XYSeriesCollection dataset = new XYSeriesCollection();
        for(int i=1;i<length;i++) {
            XYSeries neki = new XYSeries(tab.get(length-i).get(0));
            dataset.addSeries(neki);
            for (int h = 0; h < 11; h++) {

                neki.add(h, ((Double.parseDouble((String) tab.get(length * 2 - i).get(0)) * (10 - h)) +
                        Double.parseDouble((String) tab.get(length * 3 - i).get(0)) * h) / 10);

            }
        }



        //
        // Generate the graph
        JFreeChart chart = ChartFactory.createXYLineChart(
                "H. kriterij", // Title
                "Delež optimizma", // x-axis Label
                "Predviden profit (V Miljonih)", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
        ChartPanel cp = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        cp.setMouseWheelEnabled(true);
        frame.add(cp);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




             /*  try {
            ChartUtilities.saveChartAsJPEG(new File("C:\\chart.jpg"), chart, 500, 300);
        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }*/
    }


    }
