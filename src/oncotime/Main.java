package oncotime;

import oncotime.parser.*;
import oncotime.lexer.*;
import oncotime.node.*;
import java.io.*;
import java.util.*;
 
class Main {
  public static void main(String args[]) {
    PrintWriter out = null;
    try {
          Lexer l = 
         new Lexer (
            new PushbackReader(new InputStreamReader(System.in), 1024));
      // Tokenize and Parse
      Parser p = new Parser(l);
      Start ast = p.parse();
      System.out.println("Valid");

      // Pretty Print
      // String arg = args[0];
      // String[] dirs = arg.split("/");
      // arg = dirs[dirs.length-1];
      // String[] file = arg.split("\\.");
      // int i = file.length;
      // String filename = file[i-2] + ".pretty." + file[i-1];
      // out = new PrintWriter(filename) ;
      // PrettyPrinter.out = out;
      // (new PrettyPrinter()).print(ast);

      // Lines.setLines(ast);

      // //Build Symbol Table
      // TypeChecker tc = new TypeChecker(file[i-2], ast);
      // tc.buildSymbolTable();
      // HashMap<Node,MiniType> types = tc.typeCheck();
      // CodeGen cg = new CodeGen(tc.declTypes, tc.exprTypes, ast, file[i-2]);
      // cg.buildCCode();
    } 
   catch(Exception e) 
    { 
      System.out.print("Invalid ");
      System.out.println(e); 
    }
    finally{
      if (out != null)
        out.close();
    }
  }
}
