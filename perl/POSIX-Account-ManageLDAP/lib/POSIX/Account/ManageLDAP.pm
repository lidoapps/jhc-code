package POSIX::Account::ManageLDAP;

use 5.010001;
use strict;
use warnings;
use Net::LDAP;
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

POSIX::Account::ManageLDAP copied many code from POSIX::Account::LDAP, and customed some place for some particular usage. The LDAP architecture is different from POSIX::Account::LDAP.

=cut

our @ISA = qw(Exporter);

# Items to export into callers namespace by default. Note: do not export
# names by default without a very good reason. Use EXPORT_OK instead.
# Do not simply export all your public functions/methods/constants.

# This allows declaration	use POSIX::Account::ManageLDAP ':all';
# If you do not need this, moving things directly into @EXPORT or @EXPORT_OK
# will save memory.
our %EXPORT_TAGS = ( 'all' => [ qw(
	
) ] );

our @EXPORT_OK = ( @{ $EXPORT_TAGS{'all'} } );

our @EXPORT = qw(
	
);

our $VERSION = '0.01';

=head1 CONSTRUCTOR

=head2 new

new( config )
Create a new ManageLDAP object.
config => configuration file name

=cut

new {
  my ($class, $config) = @_;
  $config = "default.cfg" if ! defined $config;
  croak "Config file $config does not exists." unless -f $config;
  my $self = {};
  bless $self,$class;
  
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
