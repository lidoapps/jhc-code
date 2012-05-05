/*  创建books数据库*/
DROP DATABASE if exists books;
create database books default character set utf8;

use books;
/*  创建 Account 表  */
DROP TABLE if exists `Account`;
CREATE TABLE `Account` ( 
        `id` int auto_increment primary key ,
	`balance` double NULL ,
	`creditcard` varchar(20) NOT NULL 
)engine=innodb;

INSERT `Account` ( `id` , `balance` , `creditcard` ) VALUES ( 1 , 7500.0000 , '12345678901' );

/*  创建authorISBN  表  */
DROP TABLE if exists `authorISBN`;
CREATE TABLE `authorISBN` (  
       `authorID` int NOT NULL ,
       `isbn` varchar(20) NOT NULL,
       key(isbn)
)engine=innodb;

INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130895725' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0132261197' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130895717' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0135289106' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0139163050' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '013028419x' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130161438' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130856118' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130125075' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0138993947' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130852473' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130829277' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0134569555' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130829293' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130284173' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130284181' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 1 , '0130895601' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130895725' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0132261197' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130895717' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0135289106' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0139163050' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '013028419x' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130161438' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130856118' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130125075' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0138993947' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130852473' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130829277' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0134569555' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130829293' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130284173' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130284181' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 2 , '0130895601' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 3 , '013028419x' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 3 , '0130161438' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 3 , '0130856118' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 3 , '0134569555' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 3 , '0130829293' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 3 , '0130284173' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 3 , '0130284181' );
INSERT `authorISBN` ( `authorID` , `isbn` ) VALUES ( 4 , '0130895601' );

/*  创建authors 表*/
DROP TABLE if exists `authors`;
CREATE TABLE `authors` ( 
       `authorID` int auto_increment primary key,
       `firstName` varchar(20) NOT NULL ,
       `lastName` varchar(30) NOT NULL 
)engine=innodb;

INSERT `authors` ( `authorID` , `firstName` , `lastName` ) VALUES ( 1 , 'Harvey' , 'Deitel' );
INSERT `authors` ( `authorID` , `firstName` , `lastName` ) VALUES ( 2 , 'Paul' , 'Deitel' );
INSERT `authors` ( `authorID` , `firstName` , `lastName` ) VALUES ( 3 , 'Tem' , 'Nieto' );
INSERT `authors` ( `authorID` , `firstName` , `lastName` ) VALUES ( 4 , 'Sean' , 'Santry' );

/*  创建 BookOrder 表*/
DROP TABLE if exists `BookOrder`;
CREATE TABLE `BookOrder` (  
       `orderId` int primary key,
       `username` varchar(20) NOT NULL ,
       `zipcode` varchar(8) NULL ,
       `phone` varchar(20) NULL ,
       `creditcard` varchar(20) NULL ,
       `total` double NULL 
)engine=innodb;

INSERT `BookOrder` ( `orderId` , `username` , `zipcode` , `phone` , `creditcard` , `total` ) VALUES ( 1 , 'accp' , '100020' , '8888866666' , '12345678901' , 50.00 );
INSERT `BookOrder` ( `orderId` , `username` , `zipcode` , `phone` , `creditcard` , `total` ) VALUES ( 2 , 'accp' , '100020' , '8888866666' , '12345678901' , 118.50 );
INSERT `BookOrder` ( `orderId` , `username` , `zipcode` , `phone` , `creditcard` , `total` ) VALUES ( 3 , 'accp' , '100020' , '88886666' , '12345678901' , 100.00 );
INSERT `BookOrder` ( `orderId` , `username` , `zipcode` , `phone` , `creditcard` , `total` ) VALUES ( 7 , 'accp' , '100020' , '12345678' , '12345678901' , 390.00 );

/*  创建 publishers 表*/
DROP TABLE if exists `publishers`;
CREATE TABLE `publishers` (  `publisherID` int auto_increment primary key , `publisherName` varchar(30) NOT NULL ) engine=innodb;

INSERT `publishers` ( `publisherID` , `publisherName` ) VALUES ( 1 , 'Prentice Hall' );
INSERT `publishers` ( `publisherID` , `publisherName` ) VALUES ( 2 , 'Prentice Hall PTG' );

/*  创建 titles 表*/
DROP TABLE if exists `titles`;
CREATE TABLE `titles` ( `isbn` varchar(20) NOT NULL primary key ,
       `title` varchar(100) NOT NULL ,
       `editionNumber` int NOT NULL ,
       `copyright` varchar(4) NOT NULL ,
       `publisherID` int NOT NULL ,
       `imageFile` varchar(20) NOT NULL ,
       `price` double(18, 0) NOT NULL 
)engine=innodb;

INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130125075' , 'Java How to Program (Java 2)' , 3 , '2000' , 1 , 'jhtp3.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130161438' , 'Internet and World Wide Web How to Program' , 1 , '2000' , 1 , 'iw3htp1.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130284173' , 'XML How to Program' , 1 , '2001' , 1 , 'xmlhtp1.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130284181' , 'Perl How to Program' , 1 , '2001' , 1 , 'perlhtp1.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '013028419x' , 'e-Business and e-Commerce How to Program' , 1 , '2001' , 1 , 'ebechtp1.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130829277' , 'The Complete Java Training Course (Java 1.1)' , 2 , '1998' , 2 , 'javactc2.jpg' , 100 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130829293' , 'The Complete Visual Basic 6 Training Course' , 1 , '1999' , 2 , 'vbctc1.jpg' , 110 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130852473' , 'The Complete Java 2 Training Course' , 3 , '2000' , 2 , 'javactc3.jpg' , 110 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130856118' , 'The Complete Internet and World Wide Web Programming Training Course' , 1 , '2000' , 2 , 'iw3ctc1.jpg' , 110 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130895601' , 'Advanced Java 2 Platform How to Program' , 1 , '2002' , 1 , 'advjhtp1.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130895717' , 'C++ How to Program' , 3 , '2001' , 1 , 'cpphtp3.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0130895725' , 'C How to Program' , 3 , '2001' , 1 , 'chtp3.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0132261197' , 'C How to Program' , 2 , '1994' , 1 , 'chtp2.jpg' , 50 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0134569555' , 'Visual Basic 6 How to Program' , 1 , '1999' , 1 , 'vbhtp1.jpg' , 70 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0135289106' , 'C++ How to Program' , 2 , '1998' , 1 , 'cpphtp2.jpg' , 50 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0138993947' , 'Java How to Program (Java 1.1)' , 2 , '1998' , 1 , 'jhtp2.jpg' , 50 );
INSERT `titles` ( `isbn` , `title` , `editionNumber` , `copyright` , `publisherID` , `imageFile` , `price` ) VALUES ( '0139163050' , 'The Complete C++ Training Course' , 3 , '2001' , 2 , 'cppctc3.jpg' , 110 );

/*  创建 userinfo 表*/
DROP TABLE if exists `userinfo`;
CREATE TABLE `userinfo` (  `userId` int auto_increment primary key ,
       `loginname` varchar(20) NOT NULL ,
       `password` varchar(10) NULL 
)engine=innodb;

INSERT `userinfo` ( `userId` , `loginname` , `password` ) VALUES ( 1 , 'accp' , 'accp' );
