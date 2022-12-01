package SudokuSolver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import com.microsoft.z3.IntExpr;

public class Sudoku {
    // Create a new context and solver
    public static void main(String[] args) throws IOException{
    Context ctx = new Context();
    Solver solver = ctx.mkSolver();
    String inputPath = System.getProperty("user.dir") + "/input.txt";
    String data[][] = new String[9][9];
    IntExpr var[][] = new IntExpr[9][9];

     // Read from input.txt
     readtxt(inputPath,data);

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            IntExpr x = ctx.mkIntConst(i + "," + j);
            var[i][j] = x;
            BoolExpr p3 = ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), x), ctx.mkLe(x, ctx.mkInt(9))); // 1 <= x <= 9
            if(Integer.parseInt(data[i][j]) != 0){
                p3 =  ctx.mkAnd(p3,ctx.mkEq(x, ctx.mkInt(Integer.parseInt(data[i][j])))); // x = input value if non zero
            }
            solver.add(p3);
        }
    }
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if(i % 3 == 0 && j % 3 == 0){ // make each 3 x 3 block distinct
                solver.add(ctx.mkDistinct(var[i][j],var[i+1][j],var[i+2][j],var[i][j+1],var[i+1][j+1],var[i+2][j+1],var[i][j+2],var[i+1][j+2],var[i+2][j+2]));
            }
        }
        solver.add(ctx.mkDistinct(var[i][0],var[i][1], var[i][2],var[i][3],var[i][4],var[i][5],var[i][6],var[i][7],var[i][8])); // make row distinct
        solver.add(ctx.mkDistinct(var[0][i],var[1][i], var[2][i],var[3][i],var[4][i],var[5][i],var[6][i],var[7][i],var[8][i])); // make column distinct
    }
    writetxt(solver,System.getProperty("user.dir") + "/output.txt",var);

    }

    public static void readtxt(String path, String[][] arr) throws IOException{
        BufferedReader b = new BufferedReader(new FileReader(path));

        for (int i = 0; i < 9; i++) {
            arr[i] = b.readLine().split(" ");
        }
        b.close();
}

public static void writetxt(Solver solver, String path, IntExpr var[][]) throws IOException{
    BufferedWriter w = new BufferedWriter(new FileWriter(path));

    if(solver.check() == Status.UNSATISFIABLE){
        w.write("No Solution");
    }else{
    Model model = solver.getModel();
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            w.write(model.getConstInterp(var[i][j]) + " ");
        }
        w.newLine();
    }
}
    w.flush();
    w.close();
}

}