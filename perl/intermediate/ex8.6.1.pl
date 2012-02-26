#!/bin/perl -w

#Write a program that prints the date and the day of the week, but allow the user to choose to send the output either to a file, a scalar, or both at the same time. No matter which output channels the user selects, send the output with a single print statement. If the user chooses to send the output to a scalar, at the end of the program print the scalar's value to standard output.

use IO::Scalar;
use IO::Tee;
use Data::Dumper;

print "1.file 2.scalar 3.both\n";
open my $file_log,'>','ex8.6.1.log'
    or die "Could not open logfile: $!";
my $string_log = '';
open my $scalar_log,'>',\$string_log
    or die "Count not open string ! $!";
my $tee_log = IO::Tee->new($file_log,$scalar_log);
my %logs = (
    "1"=>$file_log,
    "2"=>$scalar_log,
    "3"=>$tee_log
    );
print Dumper(\%logs);
my $line = <STDIN>;
chomp($line);
print {$logs{$line}} localtime,"\n";


