#!/usr/bin/perl -w
#这个脚本用于罗列出网页中所有的a标签，使用时需要传入两个参数，第一个是目标网页的url，第二个参数指该网站url编码字符集（如utf8或gbk等）可省略。
use strict;
use URI::Escape;
use Encode;
use utf8;
use LWP::UserAgent;
use HTML::TreeBuilder;
#use Data::Dumper;

#获取参数传入的url和url编码字符集
my ($url,$urlencode) = @ARGV;
die "No url provided." unless defined $url;
#urlencode默认值为GBK，也是淘宝网url编码字符集
$urlencode = "GBK" unless defined $urlencode;
#初始化客户端对象
my $ua = LWP::UserAgent->new;
$ua->agent("softbeispider/0.1");
#构造HTTP请求
my $req = HTTP::Request->new(GET=>$url);
#发出GET请求
my $res = $ua->request($req);
#分析请求的结果
if (!$res->is_success){
  print $res->status_line,"\n";
}
else{
  #找出所有a标签，并过滤掉href属性不是以http://开头的标签
  my $root = HTML::TreeBuilder->new_from_content($res->content);
  my @elements = grep { 
    defined $_->attr('href')
    && $_->attr('href') =~ /^\s*http:\/\/.*/
  } $root->find_by_tag_name('a');
#  print Dumper(@elements);
  
  #打印结果，以四个空格分隔
  map {
    my $href = encode( "utf8", decode($urlencode,uri_unescape( $_->attr('href') ) ) );
    my $text = encode( "utf8", decode($urlencode,$_->as_text) );
    $text =~ s/\s//g;  #删除链接名中的空格
    print $text,"    ",$href,"\n";
  } @elements;
}
