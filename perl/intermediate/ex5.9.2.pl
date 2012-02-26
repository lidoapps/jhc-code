#!/bin/perl -w

# List the source machines in order from most to least data transferred. Within each group, list the destination machines in order from most to least data transferred to that target from the source machine.
use diagnostics;
use YAML;
my %total_bytes;

sub my_compare($$){
    my ($a,$b) = @_;
#    print "\$a=$a,\$b=$b\n";
    $total_bytes{$b}{'size'} <=> $total_bytes{$a}{'size'};
}

open COCONET,'<./alpaca_files/ch04/coconet.dat';

while (<COCONET>) {
    chomp;
    next if(/^#/ || ! length) ;
    my ($source, $destination, $bytes) = split;
    $total_bytes{$source}{$destination} += $bytes;
    $total_bytes{$source}{'size'} += $bytes;
}
close COCONET;
print Dump(\%total_bytes);

for my $source ( sort(my_compare keys %total_bytes) ){
#    print "${total_bytes{$source}{size}}\t$source\n";
    my @dests = sort { $total_bytes{$source}->{$b} <=> $total_bytes{$source}->{$a}; } keys %{$total_bytes{$source}};
    for my $dest (@dests){
	next if $dest eq 'size';
	print "$source=>$dest:$total_bytes{$source}{$dest}\n";
    }
}

