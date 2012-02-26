#!/bin/perl -w

# The program from Exercise 2 in Chapter 5 needs to read the entire datafile each time it runs. However, the Professor has a new router logfile each day and doesn't want to keep all that data in one giant file that takes longer and longer to process. Fix up that program to keep the running totals in a datafile so the Professor can simply run it on each day's logs to get the new totals.

use diagnostics;
use Storable;
use YAML;

if(! -f 'datafile'){
    my %total_bytes = ();
    store \%total_bytes,'datafile';
}
my $total_bytes = retrieve 'datafile';

sub my_compare($$){
    my ($a,$b) = @_;
#    print "\$a=$a,\$b=$b\n";
    $total_bytes->{$b}{'size'} <=> $total_bytes->{$a}{'size'};
}

open COCONET,'<./alpaca_files/ch04/coconet.dat';

while (<COCONET>) {
    chomp;
    next if(/^#/ || ! length) ;
    my ($source, $destination, $bytes) = split;
    $total_bytes->{$source}{$destination} += $bytes;
    $total_bytes->{$source}{'size'} += $bytes;
}
close COCONET;
print Dump(\%total_bytes);
store \%total_bytes,'datafile';

for my $source ( sort(my_compare keys %$total_bytes) ){
#    print "${total_bytes{$source}{size}}\t$source\n";
    my @dests = sort { $total_bytes->{$source}->{$b} <=> $total_bytes->{$source}->{$a}; } keys %{$total_bytes->{$source}};
    for my $dest (@dests){
	next if $dest eq 'size';
	print "$source=>$dest:$total_bytes->{$source}{$dest}\n";
    }
}

