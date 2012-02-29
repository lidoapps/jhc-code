#!/usr/bin/perl -w

use DBI;
use strict;

my $dbh = DBI->connect('DBI:mysql:database=shop;host=localhost','shopuser','shoppass')
    or die "Cannot connect to database: " . DBI->errstr;
my $sth = $dbh->prepare('select vend_name,vend_address from vendors')
    or die "Cannot prepare statement: " . DBI->errstr;
$sth->execute;
while( my @row = $sth->fetchrow_array ){
    print "供应商$row[0]的地址为$row[1].\n";
}
$sth->finish;
$dbh->disconnect;

