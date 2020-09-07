<?php 
    $con = mysqli_connect("localhost", "covid19helper", "tj102938^^", "covid19helper");
    mysqli_query($con,'SET NAMES utf8');
    

    $userName = $_POST["userName"];
    $userYYMMDD = $_POST["userYYMMDD"];
    $userSchool = $_POST["userSchool"];
    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];

    $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "sssss", $userName, $userYYMMDD, $userSchool, $userID, $userPassword);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>