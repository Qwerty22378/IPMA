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
                System.out.printf("%s",ma[l][c]);

            }
            System.out.println();
        }
    }

    //convert array array to MA array
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
    public static void tempDeviation() {

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
    public static void D() {

    }

    //------------------------------------------------------E-----------------------------------------------------------
    //calculates percentage of each alert type
    public static void alertPercentage() {

    }

    public static void E() {

    }

    //------------------------------------------------------F-----------------------------------------------------------
    //calculates temp rise to get catastrophic in all terrain
    public static void tempRiseCatastrophic() {

    }

    public static void F() {

    }

    //------------------------------------------------------G-----------------------------------------------------------
    //calculate the percentage of that changed
    public static void alertChanged() {

    }

    public static void G() {

    }

    //------------------------------------------------------H-----------------------------------------------------------
    public static void H() {

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
        //Converter e imprimir mapa de alertas
        String[][] ma = convertToMA(tempArray);
        C(ma);
    }


    //initiates app
    public static void main(String[] args) {
        answers();
    }
}
