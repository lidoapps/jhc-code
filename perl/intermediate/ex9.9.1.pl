#!/bin/perl -w

#Using the glob operator, a naive sort of every name in the /bin directory by their relative sizes might be written as:
# my @sorted = sort { -s $a <=> -s $b } glob "/bin/*";
#Rewrite this using the Schwartzian Transform technique.
#If you don't have many files in the /bin directory, perhaps because you don't have a Unix machine, change the argument to glob as needed.

use 5.10.0;
my @sorted =
    map $_->[0],
    sort { $a->[1] <=> $b->[1] }
    map [ $_, -s $_ ],
    glob "/bin/*";
say join "\n",@sorted;
