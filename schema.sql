CREATE DATABASE `tmingDB`;

CREATE TABLE `tb_file` (
                           `file_seq` int(11) NOT NULL AUTO_INCREMENT,
                           `file_name` varchar(100) DEFAULT NULL,
                           `file_url` varchar(100) DEFAULT NULL,
                           `file_path` varchar(100) DEFAULT NULL,
                           `create_date` timestamp NULL DEFAULT current_timestamp(),
                           PRIMARY KEY (`file_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

CREATE TABLE `tb_user` (
                           `user_seq` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(50) DEFAULT NULL,
                           `id` varchar(50) NOT NULL,
                           `password` varchar(50) NOT NULL,
                           `email` varchar(100) DEFAULT NULL,
                           `gender` varchar(2) DEFAULT NULL,
                           `age` int(11) DEFAULT NULL,
                           `phone` varchar(50) DEFAULT NULL,
                           `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
                           `update_date` timestamp NULL DEFAULT NULL,
                           PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;