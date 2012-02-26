#!/bin/perl -w
#Write a program that asks the user to enter a pattern (regular expression). Read this as data from the keyboard; don't get it from the command-line arguments. Report a list of files in some hardcoded directory (such as "/etc" or 'C:\\Windows') whose names match the pattern. Repeat this until the user enters an empty string instead of a pattern. The user should not type the forward slashes that are traditionally used to delimit pattern matches in Perl; the input pattern is delimited by the trailing newline. Ensure that a faulty pattern, such as one with unbalanced parentheses, doesn't crash the program.

opendir my $dh,'/home/luyanfei/backup' or die "Cannot open directory: $!";
my @files = readdir $dh;
while(defined(my $line = <STDIN>)){
    last if($line eq "\n");
    chomp $line;     #important!!
    my @results = eval "grep(/$line/," . '@files)';
    warn $@ if $@;
    print((join "\t",@results),"\n");
}
closedir $dh;

