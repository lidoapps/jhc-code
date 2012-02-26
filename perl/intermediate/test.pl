#!/bin/perl -w

my @input_numbers = (1, 2, 4, 8, 16, 32, 64);
my @odd_digit_sum = grep digit_sum_is_odd($_), @input_numbers;
print join "\n",@odd_digit_sum ;

sub digit_sum_is_odd {
        my $input = shift;
        my @digits = split //, $input;  # Assume no nondigit characters
        my $sum;
        $sum += $_ for @digits;
        return $sum % 2;
}

my %hash = map {$_,3*$_} @input_numbers;
