# assumes sablecc script is on your PATH

#.PHONY oncotime

# to compile the code
oncotime: clean grammar
	javac -Xlint oncotime/*.java oncotime/lexer/*.java oncotime/parser/*.java oncotime/node/*.java oncotime/analysis/*.java 

# to generate the compiler code
grammar: oncotime.sablecc
	sablecc oncotime.sablecc

check:	
	./check

clean:	
	rm -rf oncotime/*.class oncotime/lexer/ oncotime/parser/ oncotime/node/ oncotime/analysis/ result
