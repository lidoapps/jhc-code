#!/usr/bin/perl -w
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
    sub DESTROY {
	my $self = shift;
	print '[',$self->name,"has died.]\n";
    }
}
{
    package Horse;
    use Carp qw(croak);
    our @ISA = qw(Animal);
    sub sound { 'neigh' }
    
}
{
    package RaceHorse;
    use Carp qw(croak);
    our @ISA = qw(Horse);
    sub won { shift->{wins}++; }
    sub placed { shift->{places}++; }
    sub showed { shift->{shows}++; }
    sub lost { shift->{lossess}++; }
    sub standings{
	my $self = shift;
	join ' ', map $self->{$_},qw(wins places shows losses);
    }
    sub named {
	my $self = shift->SUPER::named(@_);
	dbmopen my %HASH,"horse.dbm",0644;
	$self->{$_} =  defined $HASH{$_} ? $HASH{$_} : 0
	    for qw(wins places shows losses);
	dbmclose %HASH;
	$self;
    }
    sub DESTROY {
	my $self = shift;
	$self->SUPER::DESTROY;
	dbmopen my %HASH,"horse.dbm",0644;
	$HASH{$_} = $self->{$_} for qw(wins places shows losses);
	dbmclose %HASH;
    }
}

my $total = 4;
while($total--){
my $runner = RaceHorse->named('Billy Boy');
$runner->won;
print $runner->name, ' has standings ', $runner->standings, ".\n";
}
