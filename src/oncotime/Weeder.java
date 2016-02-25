package oncotime;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PushbackReader;
import java.util.List;

import oncotime.lexer.Lexer;
import oncotime.node.AGroupFileGrammar;
import oncotime.node.AScriptGrammar;
import oncotime.node.AUse;
import oncotime.node.PGrammar;
import oncotime.node.PGroup;
import oncotime.node.PUse;
import oncotime.node.TGroupFile;
import oncotime.parser.Parser;

public class Weeder {
	
	PGrammar start;
	String cwd = System.getProperty("user.dir");
	
	public Weeder(PGrammar s)
	{
		start = s;
	}
	
	public void addDependencies()
	{
		if(!(start instanceof AScriptGrammar))
		{
			// We can't add dependencies to a group file
			return;
		}
		AScriptGrammar g = (AScriptGrammar) start;
		List<PGroup> groups = g.getGroups();
		for(PUse use : g.getUses())
		{
			AUse ause = (AUse) use;
			for(TGroupFile gFile : ause.getFiles())
			{
				String filename = gFile.getText();
				PGrammar groupGrammar = null;
				try {
					groupGrammar = parse(cwd + '/' + filename);
				} catch (FileNotFoundException e) {
					System.err.println("File does not exist: "+cwd+'/' +filename);
					System.exit(1);
				}
				if(!(groupGrammar instanceof AGroupFileGrammar))
				{
					System.err.println(filename +" is not a group file");
					System.exit(1);
				}
				AGroupFileGrammar groupFileGrammar = (AGroupFileGrammar) groupGrammar;
				groups.addAll(groupFileGrammar.getGroups());
			}
		}
	}
	
	public static PGrammar parse(String filename) throws FileNotFoundException
	  {
	    Lexer l = 
	     new Lexer (
	        new PushbackReader(new FileReader(filename), 1024));
	      Parser p = new Parser(l);
	    	  PGrammar ast;
			try {
				ast = p.parse().getPGrammar();
			} catch (Exception e) {
				System.err.println("Error parsing " + filename);
				System.err.println(e.getMessage());
				System.exit(1);
				return null;
			} 
	      return ast;
	  }
}
