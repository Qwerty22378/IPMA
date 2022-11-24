package src;

import java.util.Scanner;

public class main {
    //-------------------------------------useful functions for all answers---------------------------------------------
    static Scanner sc = new Scanner(System.in);

    public static void printTempArray(int[][] array) {
        for (int l = 0; l < array.length; l++) {
            for (int c = 0; c < array[l].length; c++) {
                System.out.printf("%4d", array[l][c]);
            }
            System.out.printf("%n");
        }
    }

    public static void printMAArray(String[][] ma) {
        for (int l = 0; l < ma.length; l++) {
            for (int c = 0; c < ma[0].length; c++) {
                System.out.printf("%s", ma[l][c]);

            }
            System.out.println();
        }
    }

    //convert  array to MA array
    public static String[][] convertToMA(int[][] array) {
        String[][] ma = new String[array.length][array[0].length];

        final int Catastrophic = 40;
        final int Extreme = 30;
        final int High = 20;

        for (int l = 0; l < array.length; l++) {
            for (int c = 0; c < array[0].length; c++) {
                if (array[l][c] >= Catastrophic)
                    ma[l][c] = "C";
                else if (array[l][c] >= Extreme)
                    ma[l][c] = "E";
                else if (array[l][c] > High)
                    ma[l][c] = "H";
                else if (array[l][c] <= High)
                    ma[l][c] = "M";
            }
        }
        return ma;
    }

    //

    //calculates new temp array for a given temp deviation
    public static int[][] tempDeviation(int[][] a, int deviation) {
        int[][] array = a;

        for (int l = 0; l < array.length; l++) {
            for (int c = 0; c < array[l].length; c++) {
                array[l][c] += deviation;
            }
        }

        return array;
    }

    //------------------------------------------------------A-----------------------------------------------------------
    //reads location date and time
    public static void readMetaData() {
        sc.nextLine();
    }

    //reads temperature array
    public static int[][] readArray() {
        int lines, columns;

        lines = sc.nextInt();
        columns = sc.nextInt();

        int[][] array = new int[lines][columns];

        for (int l = 0; l < lines; l++) {
            for (int c = 0; c < columns; c++) {
                array[l][c] = sc.nextInt();
            }
        }

        return array;
    }


    //------------------------------------------------------B-----------------------------------------------------------
    public static void B(int[][] tempArray) {
        System.out.println("b)");
        printTempArray(tempArray);
        System.out.printf("%n");
    }

    //------------------------------------------------------C-----------------------------------------------------------
    public static void C(String[][] array) {
        System.out.println("c)");
        printMAArray(array);
        System.out.printf("%n");

    }

    //------------------------------------------------------D-----------------------------------------------------------
    public static void D(int[][] mt, String[][] ma) {
        System.out.println("d)");

        printTempArray(mt);
        System.out.printf("%n");

        printMAArray(ma);
        System.out.printf("%n");
    }

    //------------------------------------------------------E-----------------------------------------------------------
    //calculates percentage of each alert type
    public static float[] alertPercentage(String[][] array) {
        int cat = 0, ext = 0, hig = 0, mod = 0;
        float[] perc = new float[4];
        for (int l = 0; l < array.length; l++) {
            for (int c = 0; c < array[l].length; c++) {
                if (array[l][c].equals("C"))
                    cat++;
                else if (array[l][c].equals("H"))
                    hig++;
                else if (array[l][c].equals("E"))
                    ext++;
                else if (array[l][c].equals("M"))
                    mod++;
            }
        }
        perc[0] = ((mod / ((float) (array.length) * (array[0].length))) * 100);
        perc[1] = ((hig / ((float) (array.length) * (array[0].length))) * 100);
        perc[2] = ((ext / ((float) (array.length) * (array[0].length))) * 100);
        perc[3] = ((cat / ((float) (array.length) * (array[0].length))) * 100);
        return perc;
    }

    public static void E(float[] perc) {
        System.out.println("e)");

        System.out.printf("MODERATE     : %.2f%n", perc[0]);
        System.out.printf("HIGH         : %.2f%n", perc[1]);
        System.out.printf("EXTREME      : %.2f%n", perc[2]);
        System.out.printf("CATASTROPHIC : %.2f%n", perc[3]);

        System.out.printf("%n");

    }

    //------------------------------------------------------F-----------------------------------------------------------
    //calculates temp rise to get catastrophic in all terrain
    public static int findMin(int[][] array) {
        int min = array[0][0];
        for (int l = 0; l < array.length; l++)
            for (int c = 0; c < array[l].length; c++)
                if (min > array[l][c])
                    min = array[l][c];

        return min;
    }

    public static int tempRiseCatastrophic(int[][] tempArray) {
        final int Catastrophic = 40;
        int min = findMin(tempArray);
        return Catastrophic - min;
    }

    public static void F(int temp) {
        System.out.println("f)");
        System.out.printf("To get all terrain on CATASTROPHIC alert, the temperature has to rise : %dºC %n", temp);
        System.out.printf("%n");
    }

    //------------------------------------------------------G-----------------------------------------------------------
    //calculate the percentage of that changed
    public static void alertChanged() {

    }

    public static void G() {

    }

    //------------------------------------------------------H-----------------------------------------------------------
    // calculates new ma array for wind coming from north (if a tile is C south of that tile becomes C)
    public static String[][] windFromNorth(String[][] maArray) {
        String[][] array = maArray;
        for (int l = 0; l < array.length - 1; l++){
            for(int c = 0; c < array[l].length; c++){
                if(array[l][c].equals("c")){
                    array[l + 1][c] = "C";
                }
            }
        }
        return array;
    }

    public static void H(String[][] array) {
        System.out.println("h)");
        printMAArray(array);
        System.out.printf("%n");
    }

    //------------------------------------------------------I-----------------------------------------------------------
    public static void I() {

    }

    //------------------------------------------------------J-----------------------------------------------------------
    public static void J() {

    }

    //------------------------------------------------------------------------------------------------------------------

    //handles variables answer's order
    public static void answers() {
        //-------------A-------------
        readMetaData();
        int[][] tempArray = readArray();


        //-------------B-------------
        //print answer
        B(tempArray);

        //-------------C-------------
        //Convert temp to ma array
        String[][] ma = convertToMA(tempArray);
        //print answer
        C(ma);

        //-------------D-------------
        // Calculate temp array with a deviation
        final int Deviation = -10;
        int[][] tempArrayDeviated = tempDeviation(tempArray, Deviation);
        String[][] maArrayDeviated = convertToMA(tempArrayDeviated);
        //print answer
        D(tempArrayDeviated, maArrayDeviated);

        //-------------E-------------
        float[] alertPerc = alertPercentage(maArrayDeviated);
        E(alertPerc);

        //-------------F-------------
        int tempRise = tempRiseCatastrophic(tempArrayDeviated);
        //print answer
        F(tempRise);


        //-------------H-------------
        //calculate new ma array for
        String[][] windMaArray = windFromNorth(maArrayDeviated);
        //print answer
        H(windMaArray);



    }


    //initiates app
    public static void main(String[] args) {
        answers();
    }
}
