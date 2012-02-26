#!/bin/perl -w

#Read the list of files in the current directory and convert the names to their full path specification. Don't use the shell or an external program to get the current directory. The File::Spec and Cwd modules, both of which come with Perl, should help. Print each path with four spaces before it and a newline after it, just like you did for Exercise 1 of Chapter 2. Can you reuse part of that answer for this problem?

use File::Spec::Functions qw/ curdir rel2abs /;

my $dir = rel2abs(curdir());
opendir my $dh,$dir or die "Cannot open $dir: $!";
my @files = readdir $dh;
print map "    " . $_ . "\n",@files;
closedir $dh;
