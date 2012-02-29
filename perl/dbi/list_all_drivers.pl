#!/usr/bin/perl -w

use DBI;
use strict;

my @drivers = DBI->available_drivers;
die "No drivers found!\n" unless @drivers;
for my $driver (@drivers) {
    print "Driver: $driver\n";
    my @datasources = DBI->data_sources( $driver );
    for my $datasource (@datasources){
	print "\tData Source is $datasource\n";
    }
    print "\n";
}

