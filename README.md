Marco d’Amore (260519138)
and
David Rapoport (260498767)

Resources used:
For guidance on how to make case insensitive keywords
http://www.sable.mcgill.ca/listarchives/sablecc-list/msg00234.html
Idea to allow for "male" or "m" or "M" or "Male" in pop_specs was found in the reference compiler grammar
Some test files taken from
https://github.com/Sable/Oncotime

Current assumptions/design choice/todo:
No Types allowed for script params // TODO?
length of x doesn't work, use x.length, also x.length only works in a print statement
we can only assign a table or a list to a variable in the computation block
Currently events cannot be parametrized //TODO
When using a group, you must surround it with angle brackets, we call this an identifier_expansion
we allow for integers, identifiers, identifier_expansions, postalcode, quoted string (which can have whitespace in it)
    do we need quoted strings? postal code can either be of the form H2W1V2 or H2W. since both are valid identifiers as 
    well, postal code is defined earlier on in the tokens, so it is illegal to say Group id H2W = {...}
currently I'm a bit confused about sequences, we allow for arrows or bars in between sequence units
    a sequence unit can be either a list, or a single identifier or identifier_expansion, a negation of a single/list of
    identifier or identifier_expansion or start/end. Should we allow start/end to be negated or included in a list?