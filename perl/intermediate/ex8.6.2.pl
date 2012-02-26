#!/bin/perl -w

open my $logfile,"<","ex8.6.2.logfile"
    or die "Cannot open ex8.6.2.logfile! $!";
my %logs = ();
while(<$logfile>){
    /^([^:]*)/;
    my $name = $1;
    if(!$logs{$name}){
	open my $file, '>', "$name.info";
	$logs{$name} = $file;
    }
    print {$logs{$name}} $_;
}
