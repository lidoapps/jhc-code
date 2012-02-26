#!/bin/perl -w

#Read up on the Benchmark module, included with Perl. Write a program that will answer the question "How much does using the Schwartzian Transform speed up the task of Exercise 1?"

use Benchmark qw(:all);

timethese(1000,
	 {
	     "old" => sub { my @sorted = sort { -s $a <=> -s $b } glob "/bin/*";},
	     "new" => sub { my $sorted = map $_->[0],
			    sort { $a->[1] <=> $b->[1] }
			    map [ $_, -s $_ ],
			    glob "/bin/*";
	     }
	 });
