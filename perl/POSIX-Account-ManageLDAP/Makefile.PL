use 5.010001;
use ExtUtils::MakeMaker;
# See lib/ExtUtils/MakeMaker.pm for details of how to influence
# the contents of the Makefile that is written.
WriteMakefile(
    NAME              => 'POSIX::Account::ManageLDAP',
    VERSION_FROM      => 'lib/POSIX/Account/ManageLDAP.pm', # finds $VERSION
    PREREQ_PM         => {
			  Net::LDAP => 0.44,
			  Log::Dispatch => 2.29,
			  Config::Simple => 4.58
			 }, # e.g., Module::Name => 1.1
    ($] >= 5.005 ?     ## Add these new keywords supported since 5.005
      (ABSTRACT_FROM  => 'lib/POSIX/Account/ManageLDAP.pm', # retrieve abstract from module
       AUTHOR         => 'luyanfei <luyanfei@cpan.org>') : ()),
);
