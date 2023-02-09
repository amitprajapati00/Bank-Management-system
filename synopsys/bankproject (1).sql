-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 02, 2022 at 07:56 AM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bankproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountdetail`
--

CREATE TABLE IF NOT EXISTS `accountdetail` (
  `account_name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `rate_of_intrest` varchar(20) NOT NULL,
  `country` varchar(15) NOT NULL,
  PRIMARY KEY (`account_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountdetail`
--

INSERT INTO `accountdetail` (`account_name`, `description`, `rate_of_intrest`, `country`) VALUES
('Current Account', 'saving ', '0.5%', 'india'),
('Saving Account', 'money saving', '1%', 'India'),
('Demate Account', 'For Trading markeeting ', '2.5%', 'India ');

-- --------------------------------------------------------

--
-- Table structure for table `customerloan`
--

CREATE TABLE IF NOT EXISTS `customerloan` (
  `account_number` varchar(20) NOT NULL,
  `loan_type` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `rate_of_intrest` varchar(10) NOT NULL,
  `loan_amount` varchar(20) NOT NULL,
  `time_period` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerloan`
--

INSERT INTO `customerloan` (`account_number`, `loan_type`, `customer_name`, `rate_of_intrest`, `loan_amount`, `time_period`, `description`, `date`) VALUES
('225571', 'Business Loan', 'Amit Kumar', '11.20%', '50789', '1 year', 'business', '2022-09-30');

-- --------------------------------------------------------

--
-- Table structure for table `customerpolicy`
--

CREATE TABLE IF NOT EXISTS `customerpolicy` (
  `account_no` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `policy_name` varchar(20) NOT NULL,
  `benefits` varchar(50) NOT NULL,
  `time_period` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `amount` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerpolicy`
--

INSERT INTO `customerpolicy` (`account_no`, `customer_name`, `policy_name`, `benefits`, `time_period`, `date`, `amount`) VALUES
('14', 'Amit Kumar', 'Credit Card Policy', 'emergency money', '3 months', '2022-10-02', '38000');

-- --------------------------------------------------------

--
-- Table structure for table `deposite`
--

CREATE TABLE IF NOT EXISTS `deposite` (
  `account_number` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `amount` varchar(20) DEFAULT NULL,
  `mode` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deposite`
--

INSERT INTO `deposite` (`account_number`, `customer_name`, `date`, `amount`, `mode`) VALUES
('15', 'Amit Kumar', '2022-10-02', '5000', 'Cash');

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE IF NOT EXISTS `loan` (
  `loan_type` varchar(20) NOT NULL,
  `rate_of_intrest` varchar(10) NOT NULL,
  `terms_or_condition` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`loan_type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`loan_type`, `rate_of_intrest`, `terms_or_condition`, `description`) VALUES
('Home Loan', '7.05%', 'House paper for proof', 'I dont know'),
('Education Loan', '11%', 'only for student education', 'student '),
('Business Loan', '11.20%', 'insatallment pay ', 'New business startup '),
('Personal Loan', '9.60%', 'after time period pay in easy installment ', 'For personal reqirement money');

-- --------------------------------------------------------

--
-- Table structure for table `loandeposite`
--

CREATE TABLE IF NOT EXISTS `loandeposite` (
  `loan_account_no` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `total_amount_deposite` varchar(20) NOT NULL,
  `mode` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loandeposite`
--


-- --------------------------------------------------------

--
-- Table structure for table `loanwidhdraw`
--

CREATE TABLE IF NOT EXISTS `loanwidhdraw` (
  `loan_account_no` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `amout_widhdraw` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loanwidhdraw`
--


-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('amit', 'Amit007');

-- --------------------------------------------------------

--
-- Table structure for table `openaccount`
--

CREATE TABLE IF NOT EXISTS `openaccount` (
  `account_number` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `date` date DEFAULT NULL,
  `gender` varchar(20) NOT NULL,
  `nationality` varchar(20) NOT NULL,
  `mobile_number` varchar(10) NOT NULL,
  `aadhar_number` varchar(20) DEFAULT NULL,
  `account_type` varchar(20) NOT NULL,
  `email_id` varchar(40) NOT NULL,
  `pan_card_number` varchar(20) NOT NULL,
  `inistiat_balance` varchar(20) NOT NULL,
  `ifsc_code` varchar(20) NOT NULL,
  PRIMARY KEY (`account_number`),
  UNIQUE KEY `email_id` (`email_id`),
  UNIQUE KEY `pan_card_number` (`pan_card_number`),
  UNIQUE KEY `aadhar_number` (`aadhar_number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `openaccount`
--

INSERT INTO `openaccount` (`account_number`, `customer_name`, `address`, `date`, `gender`, `nationality`, `mobile_number`, `aadhar_number`, `account_type`, `email_id`, `pan_card_number`, `inistiat_balance`, `ifsc_code`) VALUES
('14', 'amit', 'Delhi I-Shiv vihar', '2022-09-10', 'Male', 'india', '7248895180', '814100899863', 'Current Account', 'amitparjapati@gmail.com', 'JAC5001E', '1000', 'SAP2007'),
('16', 'Abhishek', 'Aktyarpur Daurala,\nDehat', '2022-10-02', 'Male', 'India', '8586857693', '724889518050', 'Demate Account', 'abhishek456@gmail.com', 'ABHI005S', '1000', 'SAB0078'),
('15', 'Ankit', 'Daural, Aktyarpur, B-201', '2022-09-11', 'Female', 'india', '7248895180', '895551807455', 'Saving Account', 'ankit123@gmail.com', 'KJI5220H', '1000', 'SAP51007');

-- --------------------------------------------------------

--
-- Table structure for table `policy`
--

CREATE TABLE IF NOT EXISTS `policy` (
  `policy_name` varchar(20) NOT NULL,
  `eligeblety` varchar(20) NOT NULL,
  `terms_and_condition` varchar(20) NOT NULL,
  `policy_profit` varchar(20) NOT NULL,
  PRIMARY KEY (`policy_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `policy`
--

INSERT INTO `policy` (`policy_name`, `eligeblety`, `terms_and_condition`, `policy_profit`) VALUES
('Credit Card Policy', 'all', 'money', 'without balan ');

-- --------------------------------------------------------

--
-- Table structure for table `policydeposite`
--

CREATE TABLE IF NOT EXISTS `policydeposite` (
  `account_no` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `amount_deposite` varchar(30) NOT NULL,
  `mode` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `policydeposite`
--


-- --------------------------------------------------------

--
-- Table structure for table `policywidhdraw`
--

CREATE TABLE IF NOT EXISTS `policywidhdraw` (
  `account_no` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `amout_widhdraw` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `policywidhdraw`
--


-- --------------------------------------------------------

--
-- Table structure for table `widhdraw`
--

CREATE TABLE IF NOT EXISTS `widhdraw` (
  `account_number` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `total_ammount_Widhdraw` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `widhdraw`
--

INSERT INTO `widhdraw` (`account_number`, `customer_name`, `date`, `total_ammount_Widhdraw`) VALUES
('14', 'amit', '2022-09-11', '500');
