<?php

$hostname =     'localhost';
$username =     'root';
$password =     '';
$database =     'db_login';

$connect = mysqli_connect($hostname, $username, $password, $database);
if (mysqli_connect_errno()){
    echo "Gagakl Koneksi Database.";
    die();
} else {
    //echo "Success connect to mysql";
}
