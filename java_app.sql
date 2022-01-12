-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 10, 2022 at 05:18 PM
-- Server version: 5.7.33
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `kostumer`
--

CREATE TABLE `kostumer` (
  `id_kostumer` int(255) NOT NULL,
  `nama_kostumer` varchar(255) NOT NULL,
  `nik_kostumer` int(255) NOT NULL,
  `umur_kostumer` int(255) NOT NULL,
  `no_kostumer` int(255) NOT NULL,
  `alamat_kostumer` varchar(255) NOT NULL,
  `jk_kostumer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kostumer`
--

INSERT INTO `kostumer` (`id_kostumer`, `nama_kostumer`, `nik_kostumer`, `umur_kostumer`, `no_kostumer`, `alamat_kostumer`, `jk_kostumer`) VALUES
(1, 'yudistira', 123123, 19, 855123123, 'jalan kapten kapten', 'Laki Laki');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `email`, `password`) VALUES
('', 'chandra', 'chandra123'),
('1', 'chandrayudistira992@gmail.com', 'testingpassword'),
('2', 'chandrayudistira909@gmail.com', 'chandra4545'),
('chandra', 'chandrayudistira123@gmail.com', 'chandra123'),
('chandra123', 'chandrayudistira@gmail.com', 'chandra123');

-- --------------------------------------------------------

--
-- Table structure for table `rute`
--

CREATE TABLE `rute` (
  `id_rute` varchar(255) NOT NULL,
  `maskapai` varchar(255) NOT NULL,
  `asal` varchar(255) NOT NULL,
  `tujuan` varchar(255) NOT NULL,
  `jlhKursi` int(25) NOT NULL,
  `harga` bigint(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rute`
--

INSERT INTO `rute` (`id_rute`, `maskapai`, `asal`, `tujuan`, `jlhKursi`, `harga`) VALUES
('01', 'PT. SINAR JAYA MEGAH LANGGENG', 'kendari', 'balikpapan', 20, 5000000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` varchar(255) NOT NULL,
  `namaTransaksi` varchar(255) NOT NULL,
  `nikTransaksi` bigint(255) NOT NULL,
  `umurTransaksi` bigint(255) NOT NULL,
  `hpTransaksi` bigint(255) NOT NULL,
  `alamatTransaksi` varchar(255) NOT NULL,
  `maskapaiTransaksi` varchar(255) NOT NULL,
  `asalTransaksi` varchar(255) NOT NULL,
  `tujuanTransaksi` varchar(255) NOT NULL,
  `hargaTransaksi` bigint(255) NOT NULL,
  `tanggalTransaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `namaTransaksi`, `nikTransaksi`, `umurTransaksi`, `hpTransaksi`, `alamatTransaksi`, `maskapaiTransaksi`, `asalTransaksi`, `tujuanTransaksi`, `hargaTransaksi`, `tanggalTransaksi`) VALUES
('ID0', 'yudistira', 123123, 19, 855123123, 'jalan kapten kapten', 'PT. SINAR JAYA MEGAH LANGGENG', 'kendari', 'balikpapan', 5000000, '2022-01-11'),
('ID01', 'chandra pride', 1202919, 19, 855555555, 'jalan chandra', 'PT. SINAR JAYA MEGAH LANGGENG', 'kendari', 'balikpapan', 5000000, '2022-01-14'),
('ID03', 'chandra pride', 1202919, 19, 855555555, 'jalan chandra', 'PT. SINAR JAYA MEGAH LANGGENG', 'kendari', 'balikpapan', 5000000, '2022-01-27'),
('ID09', 'yudistira', 123123, 19, 855123123, 'jalan kapten kapten', 'PT. SINAR JAYA MEGAH LANGGENG', 'kendari', 'balikpapan', 5000000, '2022-01-31');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kostumer`
--
ALTER TABLE `kostumer`
  ADD PRIMARY KEY (`id_kostumer`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rute`
--
ALTER TABLE `rute`
  ADD PRIMARY KEY (`id_rute`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
