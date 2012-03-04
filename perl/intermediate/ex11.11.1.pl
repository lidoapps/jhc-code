#!/usr/bin/perl -w

#Type in the Animal, Cow, Horse, Sheep, and Mouse class definitions. Make it work with use strict. Use our if you're using a recent enough version of Perl. Your program should ask the user to enter the names of one or more barnyard animals. Create a barnyard with those animals, and have each animal speak once.
use strict;
{
    package Animal;
    sub speak {
	my $class = shift;
	print "a $class goes ", $class->sound, "!\n";
    }
}
{
    package Cow;
    our @ISA = qw(Animal);
    sub sound { 'moooo' }
}
{
    package Horse;
    our @ISA = qw(Animal);
    sub sound { 'neigh' }
}
{
    package Sheep;
    our @ISA = qw(Animal);
    sub sound { 'baaaah' }
}
{
    package Mouse;
    our @ISA = qw(Animal);
    sub sound { 'squeak' }
    sub speak {
	my $class = shift;
	$class->SUPER::speak(@_);
	print "[but you can barely hear it!]\n";
    }
}

print "Please input animal names(Cow,Horse,Sheep,Mouse), one animal a line. \n";
my @barnyard;
while(<STDIN>){
    chomp;
    push @barnyard,$_;
}
$_->speak for @barnyard;
