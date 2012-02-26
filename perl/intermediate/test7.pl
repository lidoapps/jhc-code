#!/bin/perl

#use File::Find;
#
#my $total_size = 0;
#find(sub{$total_size += -s if -f;},'.');
#print $total_size,"\n";


count_down(  );
count_down(  );
count_down(  );
{
  my $countdown = 10;
  sub count_down { $countdown-- }
  sub count_remaining { $countdown }
}

print "we're down to ", count_remaining(  ), " coconuts!\n";

