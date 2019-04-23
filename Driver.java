package com.company;

public class Driver {

    public static Object[] Workbook = new Object[256];
    public static int LargestSheet = 3;

    public static void main(String[]   args) {
        Workbook[0] = "Sheet1";
        Workbook[1] = "Sheet2";
        Workbook[2] = "Sheet3";
        System.out.println("There are 3 sheets in the workbook.");
        for (int i = 0; i < 3 ; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Adding 5 sheets to the workbook.");
        Methods method;
        method = new Methods();
        method.Add();
        method.Add();
        method.Add();
        method.Add();
        method.Add();
        System.out.println("There are now 8 sheets!");
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Given index 1, removing that index from the Workbook!");
        method.remove(1);
        for (int i = 0; i < LargestSheet; i++ ) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Given sheet name Sheet7, removing that from the Workbook.");
        method.remove("Sheet7");
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Moving sheets given their indexes, for this example moving the sheet in index 2 to index 4.");
        method.move(2, 4, true);
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Moving sheets given their names, for this example moving Sheet6.");
        method.move("Sheet6", "Sheet3", true);
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Moving sheets to the end given their name, for this example moving Sheet6.");
        method.moveToEnd("Sheet6");
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Moving sheets to the end given their index, for this example moving the sheet at index 1.");
        method.moveToEnd(1);
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Renaming sheets given a sheet name, for this example using Sheet6 and naming it Dermot is sound!");
        method.rename("Sheet6","Dermot is Sound!");
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        System.out.println("Getting the index of a sheet given its name, for this example using Sheet3.");
        System.out.println(method.index("Sheet3"));
        System.out.println("Getting the sheet name given its index, for this example using index 3.");
        System.out.println(method.sheetName(3));
        System.out.println("Displaying all the sheets in the array.");
        method.Display();
        System.out.println("Getting the amount of sheets in the workbook.");
        System.out.println(method.length());
    }
}
