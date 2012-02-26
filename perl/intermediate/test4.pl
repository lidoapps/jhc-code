#!/bin/perl -w
use 5.10.1;

sub check_required_items {
  my $who = shift;
  my @required = qw(preserver sunscreen water_bottle jacket);
  for my $item (@required) {
    unless (grep $item eq $_, @_) { # not found in list?
      print "$who is missing $item.\n";
    }
  }
  unshift @_,"new_preserver";
  say join ",",@_;
}

my @gilligan = qw(red_shirt hat lucky_socks water_bottle);
check_required_items('gilligan', @gilligan);
say join ",", @gilligan;
