package Oogaboogoo;
use base Exporter;
our @EXPORT = qw(number_to_day_name number_to_month_name);

my @day = qw(ark dip wap sen pop sep kir);
sub number_to_day_name { my $num = shift @_; $day[$num]; }
my @month = qw(diz pod bod rod sip wax lin sen kun fiz nap dep);
sub number_to_month_name { my $num = shift; $month[$num]; };
1;
