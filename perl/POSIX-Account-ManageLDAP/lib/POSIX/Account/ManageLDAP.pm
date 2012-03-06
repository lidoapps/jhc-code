package POSIX::Account::ManageLDAP;

use 5.010001;
use strict;
use warnings;
use Net::LDAP;
use List::MoreUtils qw(any);
use Carp;
use Config::Simple;
use Data::Dumper;
use Log::Dispatch;
use Log::Dispatch::File;
use Log::Dispatch::Syslog;

require Exporter;
=head1 NAME

POSIX::Account::ManageLDAP - Perl extension for manager POSIX Account.

=head1 SYNOPSIS

  use POSIX::Account::ManageLDAP;
  my $foo = POSIX::Account::LDAP->new( "mysite.cfg" );

=head1 DESCRIPTION

POSIX::Account::ManageLDAP copied some code from POSIX::Account::LDAP, and customed for particular usage. The LDAP architecture is different from POSIX::Account::LDAP.

=cut

our @ISA = qw(Exporter);
our %EXPORT_TAGS = ( 'all' => [ qw(
	
) ] );

our @EXPORT_OK = ( @{ $EXPORT_TAGS{'all'} } );

our @EXPORT = qw(
		  new
);

our $VERSION = '0.01';

=head1 CONSTRUCTOR

=head2 new

new( config )
Create a new ManageLDAP object.
configfile => configuration file name

=cut

sub new {
  my ($class, $configfile) = @_;
  $configfile = "default.cfg" if ! defined $configfile;
  croak "Config file $configfile does not exists." unless -f $configfile;
  my $self = {};
  bless $self,$class;
  my %conf;
  Config::Simple->import_from($configfile,\%conf);
  $self->{config} = \%conf;
  #init logger
  $self->{logger} = Log::Dispatch->new;
  $self->{config}{"logging.file"} = "manageldap.log"
    unless defined $self->{config}{"logging.file"};
  $self->{config}{"logging.level"} = "info"
    unless defined $self->{config}{"logging.level"};
  $self->{logger}->add(
    Log::Dispatch::File->new(
      filename => $self->{config}{"logging.file"},
      min_level => $self->{config}{"logging.level"},
      mode => '>>',
      newline => 1
    )
  );
  $self;
}

sub ldapconnect{
  my $self = shift;
  my ($conf,$logger) = ($self->{"config"},$self->{"logger"});
  croak "LDAP parameters are not defined or missed!"
    if any { !defined($conf->{$_}) }
	       qw/directory.managerdn directory.managerpw/;
  $conf->{"directory.host"} = "localhost" unless defined $conf->{"directory.host"};
  $conf->{"directory.port"} = 389 unless defined $conf->{"directory.port"};
  #connect to ldap server
  $self->{ldap} = Net::LDAP->new(
    $conf->{"directory.host"}, port => $conf->{"directory.port"}
  );
  $logger->log(level=>"info",message=>"Connect to server $conf->{\"directory.host\"} at port $conf->{\"directory.port\"}.");
  #bind with manager dn and password
  my $message = $self->{ldap}->bind(
    $conf->{"directory.managerdn"},
    password => $conf->{"directory.managerpw"}
  );
  $message->code && die $message->error;
  $logger->log(level=>"info",message=>"Successfully bind with server use $conf->{\"directory.managerdn\"}.");
  #return ldap connect object for convenience
  $self->{ldap};
}
1;
__END__
# Below is stub documentation for your module. You'd better edit it!


=head2 EXPORT

None by default.



=head1 SEE ALSO

Mention other useful documentation such as the documentation of
related modules or operating system documentation (such as man pages
in UNIX), or any relevant external documentation such as RFCs or
standards.

If you have a mailing list set up for your module, mention it here.

If you have a web site set up for your module, mention it here.

=head1 AUTHOR

luyanfei, E<lt>luyanfei@E<gt>

=head1 COPYRIGHT AND LICENSE

Copyright (C) 2012 by luyanfei

This library is free software; you can redistribute it and/or modify
it under the same terms as Perl itself, either Perl version 5.10.1 or,
at your option, any later version of Perl 5 you may have available.


=cut
