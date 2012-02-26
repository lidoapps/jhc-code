#!/usr/bin/perl -w

use lib '.';
require 'Oogaboogoo.pm';

my ($wday,$mday,$month,$year) = (localtime)[6,3,4,5];
#print "Today is $wday, $month $mday, $year\n";
print "Today is " . Oogaboogoo::number_to_day_name($wday) . ", "
    . Oogaboogoo::number_to_month_name($month) . " " . ($mday+1)
    . ", " . ($year+1900) . "\n";
