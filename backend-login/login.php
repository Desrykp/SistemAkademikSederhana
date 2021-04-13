<?php

require_once('koneksi.php');

// Deklarasi array kosong
$data = (object) array();

// cek username dan password
if(!empty($_POST['email']) || !empty($_POST['password'])) {
    $email = $_POST['email'];
    $password = $_POST['password'];

    $query = "SELECT * FROM tb_login WHERE email='$email' and password='$password'";

    $execute = mysqli_query($connect, $query);
    $check_rows = mysqli_num_rows($execute);

    if ($check_rows > 0){
        while ($row = mysqli_fetch_assoc($execute)) {
            $data = $row;
        }
        set_response(true, "Berhasil Login", $data);
    } else {
        set_response(false, "email atau password salah", $data);
    }
} else {
    set_response(false, "email dan password tidak boleh kosong", $data);
}

// function set response
function set_response($is_success, $message, $data){
    $result = array(
        'is_success' => $is_success,
        'message'   => $message,
        'data'      => $data
    );

    echo json_encode($result);
}
