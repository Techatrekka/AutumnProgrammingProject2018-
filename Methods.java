package com.company;

import static com.company.Driver.LargestSheet;
import static com.company.Driver.Workbook;

public class Methods {

    public boolean Add() {
        Variables();
        if (LargestSheet == 256) {

        }
        else {
            Workbook[LargestSheet] = "Sheet" + Integer.toString(LargestSheet + 1);
            LargestSheet++;
        }
        return true;
    }

    public int remove(String sheetname) {
        Variables();
        int remove = 0;
        for (int i = 0; i < LargestSheet; i++) {
            if (sheetname.equals(Workbook[i])) {
                remove = i;
            }
        }
        Workbook[remove] = null;
        int x = 1;
        Workbook[remove] = Workbook[remove + x];
        while (Workbook[remove + x] != null) {
            Workbook[remove + x] = Workbook[remove + 1 + x];
            ++x;
        }
        Workbook[remove + x] = null;
        Variables();
        return remove;
    }

    public String remove(int index) {
        Variables();
        String remove = null;
        Workbook[index] = remove;
        int i = 1;
        Workbook[index] = Workbook[index + i];
        while (Workbook[index + i + 1] != null) {
            Workbook[index + i] = Workbook[index + 1 + i];
            ++i;
        }
        Workbook[index + i] = remove;
        Variables();
        return remove;
    }

    public int move(String from, String to, boolean before) {
        Variables();
        int move = 0;
        int indexFrom = 0;
        int indexTo = 0;
        for (int i = 0; i < LargestSheet; i++) {
            if (Workbook[i].equals(from)) {
                indexFrom = i;
            }
        }
        for (int i = 0; i < LargestSheet; i++) {
            if (Workbook[i].equals(to)) {
                indexTo = i;
            }
        }
        if (indexFrom > indexTo) {
            before = true;
        }
        else {
            before = false;
        }
        move = indexFrom - indexTo;
        Object workbook;
        if (before && Workbook[indexTo] != null && Workbook[indexFrom] != null) {
            if(move == 1) {
                System.out.println("The sheet has been moved 1 space.");
            } else {
                System.out.println("The sheet has been moved " + move + " spaces.");
            }
                workbook = Workbook[indexFrom];
                Workbook[indexFrom] = Workbook[indexTo];
                Workbook[indexTo] = workbook;
        } else {
            move = -1;
        }
        return move;
    }

    public String move(int from, int to, boolean before) {
        Variables();
        before = true;
        String move = "";
        int indexFrom = 0;
        int indexTo = 0;
        for (int i = 0; i < LargestSheet - 1; i++) {
            if (index(Workbook[i].toString()) == from) {
                indexFrom = i;
            }
        }
        for (int i = 0; i < LargestSheet - 1; i++) {
            if (index(Workbook[i].toString()) == to) {
                indexTo = i;
            }
        }
        Object workbook;
        if (before && Workbook[indexTo] != null && Workbook[indexFrom] != null) {
            System.out.println("The sheet that moved is " + Workbook[indexFrom]);
            workbook = Workbook[indexFrom];
            Workbook[indexFrom] = Workbook[indexTo];
            Workbook[indexTo] = workbook;
        } else {
            move = null;
        }
            return move;
    }

    public String moveToEnd(int from) {
        Variables();
        String moveToEnd = "";
        if (index(Workbook[from].toString()) >= 1 && Workbook[from] != null) {
            Workbook[LargestSheet] = Workbook[from];
            Workbook[from] = null;
        }
        Object workbook;
        Workbook[from] = null;
        while (Workbook[from] == null && from != LargestSheet) {
            workbook = Workbook[from];
            Workbook[from] = Workbook[from + 1];
            Workbook[from + 1] = workbook;
            from++;
        }
        Variables();
        return moveToEnd;
    }

    public int moveToEnd(String from) {
        Variables();
        int moveToEnd = 0;
        if (index(from) >= 1) {
            Workbook[LargestSheet] = Workbook[index(from)];
        }
        Object workbook;
        int to = index(from);
        Workbook[to] = null;
        while (Workbook[to] == null && to != LargestSheet) {
            workbook = Workbook[to];
            Workbook[to] = Workbook[to + 1];
            Workbook[to + 1] = workbook;
            to++;
        }
        Variables();
        return moveToEnd;
    }

    public int rename(String currentName, String newName) {
        Variables();
        int rename = 0;
        currentName = Workbook[index(currentName)].toString();
        if (currentName != null) {
            Workbook[index(currentName)] = newName;
        }
        return rename;
    }

    public int index(String sheetName) {
        Variables();
        int indexLoc = 0;
        for (int i = 0; i < Workbook.length - 1; i++) {
            if (sheetName.equals(Workbook[i])) {
                indexLoc = i;
                break;
            }
        }
        return indexLoc;
    }

    public String sheetName(int index) {
        Variables();
        String sheetName = Workbook[index].toString();
        return sheetName;
    }

    public void Display() {
        Variables();
        for (int i = 0; i < LargestSheet; i++) {
            System.out.println(Workbook[i]);
        }
        return;
    }

    public int length() {
        Variables();
        int i  = LargestSheet;
        if (i == 0) {
            System.out.println("There are no Sheets");
        }
        return i;
    }

    public void Variables() {
        LargestSheet = 0;
        for (int i = 0; i < Workbook.length; i++) {
            if (Workbook[i] != null) {
                LargestSheet ++;
            }
        }
    }
}
