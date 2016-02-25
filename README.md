Marco d’Amore (260519138)
and
David Rapoport (260498767)

Resources used:
For guidance on how to make case insensitive keywords
http://www.sable.mcgill.ca/listarchives/sablecc-list/msg00234.html
Idea to allow for "male" or "m" or "M" or "Male" in pop_specs was found in the reference compiler grammar
Some test files taken from
https://github.com/Sable/Oncotime

Current assumptions:
No Types allowed for script params 
length of x doesn't work, use x.length, also x.length only works in a print statement
we can only assign a table or a list to a variable in the computation block
Currently events cannot be parametrized
we do not allow the empty list [] for events