<?php
    $con = mysqli_connect("localhost", "covid19helper", "tj102938^^", "covid19helper");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userPassword = ?");
    mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
    mysqli_stmt_execute($statement);


    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $userPassword, $userName, $userAge);

    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["userName"] = $userName;
        $response["userYYMMDD"] = $userYYMMDD;
        $response["userSchool"] = $userSchool;
        $response["userID"] = $userID;
        $response["userPassword"] = $userPassword;        
    }

    echo json_encode($response);



?>