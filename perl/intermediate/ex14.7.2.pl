#!/usr/bin/perl -w

#Starting with the script you wrote for the previous exercise, add a UNIVERSAL::debug function that prints a timestamp before the message you pass to it. Call the debug method on the MyDate object. What happens? How does this get around the AUTOLOAD mechanism?

{
    package MyDate;
    use strict;
    use Carp qw(croak);

    sub UNIVERSAL::debug{
	print scalar localtime, " $_[1]\n";
    }
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
$date->debug("test message.");
