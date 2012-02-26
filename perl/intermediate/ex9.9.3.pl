#!/bin/perl -w
use 5.10.0;

sub transform_word {
    my $word = shift;
    $word =~ tr/A-Z/a-z/;
    $word =~ tr/a-z//cd;
    $word;
}

my @names = (Gilligan, Skipper, "the Professor", Ginger, "Mary Ann");
my @sorted = 
    map $_->[0],
    sort { $a->[1] cmp $b->[1] }
    map [ $_, transform_word $_ ],
    @names;
say join "\n",@sorted;

