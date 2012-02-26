#!/bin/perl -w

#Write a program that takes in multiple directory names from the command line, then prints out their contents. Use a function that takes a directory handle reference that you made using IO::Dir.

use IO::Dir;

sub print_content{
    my $dir = shift;
    for my $file(readdir($dir)){
	print "Found: $file\n";
    }
}

for my $dir (@ARGV){
    my $d = IO::Dir->new($dir);
    print_content $d;
}
