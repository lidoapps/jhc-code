#!/usr/bin/perl -w

#Add a Person class at the same level as Animal, and have both of them inherit from a new class called LivingCreature. Also make the speak method take a parameter of what to say, falling back to the sound (humming for a Person) if no parameter is given. Since this isn't Dr. Dolittle, make sure the animals can't talk. (That is, don't let speak have any parameters for an animal.) Try not to duplicate any code, but be sure to catch likely errors of usage, such as forgetting to define a sound for an animal.
#Demonstrate the Person class by invoking a person with nothing to say, and then demonstrate it a second time by invoking a person with something to say.
use strict;
{
    package LivingCreature;
    sub speak {
	my $class = shift;
	my $whattosay = shift;
	if($whattosay){
	    print "a $class speaks: $whattosay\n";
	}else{
	    print "a $class goes ", $class->sound, "!\n";
	}
    }
}
{
    package Person;
    our @ISA = qw(LivingCreature);
    sub sound { "humming" }
}
{
    package Animal;
    our @ISA = qw(LivingCreature);
    sub speak {
	my $class = shift;
	$class->SUPER::speak;
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

my $p = 'Person';
$p->speak;
$p->speak("hello everyone.");
