-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2024 at 08:18 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `museumdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `itemid` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `date` varchar(20) NOT NULL,
  `source` varchar(45) NOT NULL,
  `describtion` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`itemid`, `itemName`, `category`, `date`, `source`, `describtion`) VALUES
('1001', 'Ancient Vase', 'Paintings and Artwork', '2022-05-15', 'Dr. Smith', 'Hand-painted ceramic vase from the Ming Dynasty'),
('1002', 'Egyptian Scarab', 'Archaeological', '2023-01-10', 'Archaeological Society', 'Carved stone scarab beetle amulet'),
('1003', 'Samurai Armor', 'Weapons and Armor', '2021-09-20', 'Private Collector', 'Authentic Edo-period samurai armor set'),
('1011', 'Abyssinian Sword', 'Weapons and Armor', '1986-06-10', 'Various regions in Ethiopia', 'Traditional curved sword used by warriors in the Abyssinian region.'),
('1012', 'Gondar Royal Crown', 'Paintings and Artwork', '2006-06-07', 'Gondar, Ethiopia', 'Elaborate crown worn by Ethiopian emperors during the Gondar period.'),
('1013', 'Amharic Manuscript', 'Historical Documents', '2006-06-12', ' Ethiopian monasteries.', 'Handwritten scroll containing religious texts in the Amharic language.'),
('1014', 'Sidama Pottery Bowl', 'Ethnographic Objects', '2006-06-06', 'Sidama region', 'Handcrafted clay bowl with geometric patterns, made by the Sidama people'),
('1015', 'Rosetta Stone', 'Archaeological', '2006-06-11', 'Discovered in Rosetta, Egypt', 'Key to deciphering hieroglyphs'),
('1016', 'Terracotta Army', 'Sculpture', '2006-06-06', 'Xi\'an, China', 'Thousands of clay soldiers and horses'),
('1017', 'Mona Lisa', 'Paintings and Artwork', '2000-06-15', 'Paris, France', 'Iconic portrait by Leonardo da Vinci'),
('1018', 'Great Sphinx of Giza', 'Archaeological', '1996-06-19', 'Giza, Egypt', 'Lion-bodied pharaoh statue'),
('1019', 'Parthenon Marbles', 'Ethnographic Objects', '2006-06-06', 'London, UK', 'Classical Greek sculptures from the Parthenon'),
('1020', 'Danakil Salt Lamp', 'Paintings and Artwork', '2014-06-21', 'Danakil region', 'Sculpted salt lamp made from salt blocks');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `user` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

CREATE TABLE `staffs` (
  `stuffid` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`stuffid`, `fname`, `lname`, `sex`, `phone`, `address`, `email`) VALUES
('1', 'Tekleeyesus', 'Munye', 'Male', '09304822--', 'poly campus', 'tmunye990@gmail.com'),
('2', 'wendosen', 'getneh', 'Male', '0945------', 'bahir dar', 'wende@gmail.com'),
('3', 'Wubamlak', 'girum', 'Female', '0970776----', 'selam campus', 'wubu@gmail.com'),
('4', 'Yosephe', 'Birhanu', 'Male', '0945454---', 'peda', 'yosephe@gmial.com'),
('5', 'Zelalem', 'Fiseha', 'Male', '09888899--', 'bdu', 'zele@gmail.com'),
('6', 'Mulugeta', 'Agafari', 'Male', '0909099--', 'poly campus', 'mulug@gmail.com'),
('7', 'Temesgen', 'Birhanu', 'Female', '09776-------', 'yebab campus', 'teme@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(10) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `fname`, `lname`, `email`, `username`, `password`) VALUES
(1, 'TEKLE', 'MUNYE', 'tekle@gmail.com', 'admin', 'admin'),
(4, 'tomy', 'jackson', 'tomy@gmail.com', 'tomy', 'tomy');

-- --------------------------------------------------------

--
-- Table structure for table `visitors`
--

CREATE TABLE `visitors` (
  `visitorid` int(11) NOT NULL,
  `fname` varchar(34) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `date` varchar(34) NOT NULL,
  `payment` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `visitors`
--

INSERT INTO `visitors` (`visitorid`, `fname`, `lname`, `sex`, `phone`, `email`, `date`, `payment`) VALUES
(10, 'alemu', 'gebeyrhu', 'Female', '097575755', 'alemu@gmail.com', '2024-06-11', '50.0'),
(11, 'birh', 'nega', 'Male', '0988766', 'nega**.com', '2024-06-04', '100.0'),
(12, 'samson', 'getahun', 'Male', '098989----', 'sami@gmail.com', '2024-07-08', '50.0'),
(13, 'Alice', 'Bob', 'Female', '09121212--', 'alice@gmail.com', '2024-07-01', '25.0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`itemid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `visitors`
--
ALTER TABLE `visitors`
  ADD PRIMARY KEY (`visitorid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `visitors`
--
ALTER TABLE `visitors`
  MODIFY `visitorid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
