# Before `make install' is performed this script should be runnable with
# `make test'. After `make install' it should work as `perl POSIX-Account-ManageLDAP.t'

#########################

# change 'tests => 1' to 'tests => last_test_to_print';

use Test::More 'no_plan';
BEGIN { use_ok('POSIX::Account::ManageLDAP') };

#########################

# Insert your test code below, the Test::More module is use()ed here so read
# its man page ( perldoc Test::More ) for help writing this test script.

my $obj = POSIX::Account::ManageLDAP->new;
ok(defined $obj,"POSIX::Account::ManageLDAP instatiated successed.");
ok($obj->{logger}->isa('Log::Dispatch'), "logger initiated successfully.");
$obj->ldapconnect;
ok($obj->{ldap}->isa('Net::LDAP'),'Connect to serve successfully.');

