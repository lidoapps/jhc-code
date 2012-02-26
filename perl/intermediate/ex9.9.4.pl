#!/bin/perl -w

sub data_for_path {
    my $path = shift;
    my $spaces = shift;
    if (-f $path or -l $path){
	print "$spaces$path\n";
	return undef;
    }
    if (-d $path){
	my %directory;
	opendir PATH,$path or die "Cannot open $path: $!";
	my @names = readdir PATH;
	closedir PATH;
	if( $#names == 0 ){
	    print "$spaces$path, an empty directory\n";
	    return undef;
	}else{
	    print "$spaces$path, with contents:\n";
	    for my $name (@names) {
		next if $name eq "." or $name eq "..";
		$directory{$name} = data_for_path ("$path/$name","$spaces  ");
	    }
	    return \%directory;
	}
    }
    warn "$path is neither a file nor a directory\n";
    return undef;
}

data_for_path(".","");

