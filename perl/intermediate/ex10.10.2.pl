#!/usr/bin/perl -w

use strict;
use lib '.';
use Oogaboogoo;

my ($wday,$mday,$month,$year) = (localtime)[6,3,4,5];
#print "Today is $wday, $month $mday, $year\n";
print "Today is " . number_to_day_name($wday) . ", "
    . number_to_month_name($month) . " " . ($mday+1)
    . ", " . ($year+1900) . "\n";
