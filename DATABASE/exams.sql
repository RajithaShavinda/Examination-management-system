-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 22, 2017 at 07:29 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `exams`
--
CREATE DATABASE IF NOT EXISTS `exams` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `exams`;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Type` varchar(8) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`UserName`, `Password`, `Type`) VALUES
('111', '111', 'admin'),
('222', '222', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `sID` varchar(15) NOT NULL,
  `dateTime` varchar(20) NOT NULL,
  `Des` varchar(100) NOT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`nid`, `sID`, `dateTime`, `Des`) VALUES
(1, '1444', '2017/10/21 15:07 PM', 'hello'),
(2, '1444', '2017/10/21 20:18 PM', 'Setm || hello students'),
(3, '123333', '2017/10/21 14:06 PM', 'asd'),
(6, '1444', '2017/10/21 20:18 PM', 'Setm  || welcome'),
(7, 's123', '2017/10/21 20:24 PM', 'dcbsd  || 2nd Online : tomorrow 1.30pm'),
(8, 'DB100', '2017/10/21 21:25 PM', 'DBMS  ||  Online exam : monday 1pm-3pm '),
(9, 'DB100', '2017/10/21 21:25 PM', 'DBMS  ||  2nd Online exam : friday 1pm-3pm '),
(10, 'DC100', '2017/10/21 21:26 PM', 'DCBSD  || exam  monday 3pm'),
(11, 'DC100', '2017/10/21 21:26 PM', 'DCBSD  || 2nd exam  monday 3pm'),
(12, 'M100', '2017/10/21 21:27 PM', 'MBL  || mid exam : tuesday 2pm-5pm');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `ID` varchar(15) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `Cname` varchar(30) DEFAULT NULL,
  `bday` varchar(10) NOT NULL,
  `password` varchar(18) NOT NULL,
  `Subjects` varchar(100) DEFAULT NULL,
  `subNames` varchar(300) DEFAULT NULL,
  `type` varchar(6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `Name`, `email`, `contact`, `Cname`, `bday`, `password`, `Subjects`, `subNames`, `type`) VALUES
('a', 'aaaa', 'aaaaa', '121221', NULL, '12121', '123', NULL, NULL, 'admin'),
('IT152000', 'Tharindu', 't@gmail.com', '1212', 'bsc in IT', '1998/4/4', '12', '', '', 'std'),
('IT15277046', 'D.M.R.S.Dissanayake', 'rshavinda@gmail.com', '0750999660', 'Bsc in IT', '1994/11/19', '12', '   DC100 DB100', '###DCBSD#DBMS', 'std');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE IF NOT EXISTS `subjects` (
  `sID` varchar(10) NOT NULL,
  `SName` varchar(20) NOT NULL,
  `Key` varchar(11) NOT NULL,
  `Des` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`sID`, `SName`, `Key`, `Des`) VALUES
('DB100', 'DBMS', 'dbms100', 'Database Management system'),
('DC100', 'DCBSD', 'dcbsd100', 'DCBSD'),
('M100', 'MBL', 'mbl100', 'Management and business law'),
('MI100', 'MIT', 'mit100', 'MIT');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
