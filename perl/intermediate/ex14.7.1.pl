#!/usr/bin/perl -w

#Write a module named MyDate that has an AUTOLOAD method that handles the calls to the methods named day, month, and year, returning the appropriate value for each one. For any other method, the AUTOLOAD should carp about the unknown method name. Write a script that uses your module and prints the values for the date, month, and year.

{
    package MyDate;
    use strict;
    use Carp qw(croak);
    sub new {
	my $self = {};
	bless $self, shift;
	$self;
    }
    sub AUTOLOAD {
	my @elements = qw/day month year/;
	our $AUTOLOAD;
	(my $method = $AUTOLOAD) =~ s/.*:://s;
	if ($method eq 'day'){
	    eval q/ sub day { (localtime)[3]; } /;
	    die $@ if $@;
	    goto &day;
	}
	elsif ($method eq 'month'){
	    eval q/ sub month { (localtime)[4]; } /;
	    die $@ if $@;
	    goto &month;
	}
	elsif ($method eq 'year'){
	    eval q/ sub year { (localtime)[5]+1900; } /;
	    die $@ if $@;
	    goto &year;
	}
	else{
	    croak "$_[0] does not know how to $method.\n";
	}
	
    }
    sub DESTROY {}
}

use strict;

my $date = MyDate->new;
print "day is: ", $date->day, "\n";
print "month is: ", $date->month, "\n";
print "year is: ",$date->year, "\n";
$date->abc;
