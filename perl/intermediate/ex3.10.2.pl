#!/bin/perl -w

# Parse the International Standard Book Number from the back of this book (0596102062). Install the Business::ISBN module from CPAN and use it to extract the country code and the publisher code from the number.

use Business::ISBN;

my $book = Business::ISBN->new('0596102062');
print $book->group_code,"\n";
print $book->publisher_code,"\n";
