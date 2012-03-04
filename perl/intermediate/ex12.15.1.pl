#!/usr/bin/perl -w

#Give the Animal class the ability to get and set the name and color. Be sure that your result works under use strict. Also make sure your get methods work with both a generic animal and a specific animal instance.

use strict;
use Carp qw(croak);

{
    package Animal;
    use Carp qw(croak);
    sub speak {
	my $class = shift;
	print "a $class goes ", $class->sound, "!\n";
    }
    sub name {
	my $either = shift;
	ref $either ?
	    $either->{name} : "an unnamed $either";
    }
    sub set_name {
	my $self = shift;
	ref $self or croak "This is instance called only method.";
	$self->{name} = shift;
    }
    sub color {
	my $either = shift;
	ref $either ?
	    $either->{color} : "Default color brown";
    }
    sub set_color {
	my $self = shift;
	ref $self or croak "This is instance called only method.";
	$self->{color} = shift;
    }
    sub named {
	my $class = shift;
	my $name = shift;
	bless {'name'=>$name,'color'=>'Brown'},$class;
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

my $tv_horse = Horse->named('Mr. Ed');
$tv_horse->set_name('Mister Ed');
$tv_horse->set_color('grey');
print $tv_horse->name, ' is ', $tv_horse->color, "\n";
print Sheep->name, ' colored ', Sheep->color, ' goes ', Sheep->sound, "\n";
