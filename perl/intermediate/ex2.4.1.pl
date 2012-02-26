#!/bin/perl -w

#Write a program that takes a list of filenames on the command line and uses grep to select the ones whose size in bytes is less than 1000. Use map to transform the strings in this list, putting four space characters in front of each and a newline character after. Print the resulting list.

my @files = grep {
    my($dev, $ino, $mode, $nlink, $uid, $gid, $rdev,
       $size, $atime, $mtime, $ctime, $blksize, $blocks)
	= stat;
    $size < 1000;
} @ARGV;

print map "    $_\n",@files;

    
