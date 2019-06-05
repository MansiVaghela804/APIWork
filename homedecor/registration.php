<?php
header('Access-Control-Allow-Origin: *');  //I have also tried the * wildcard and get the same response
header("Access-Control-Allow-Credentials: true");
header('Access-Control-Allow-Methods: GET, PUT, POST, DELETE, OPTIONS');
header('Access-Control-Max-Age: 1000');
header('content-type: application/json; charset=utf-8');
header('Access-Control-Allow-Headers: Content-Type, Content-Range, Content-Disposition, Content-Description');

include "lib/model.php";
include "lib/dao.php";

$m=new model();
$d=new dao();

extract($_POST);
$success = array();
if ($_POST != null) {

$update=$d->selectColumnWise("registration","user_email","user_email = '$email'");

$data = mysqli_fetch_array($update);
	if($data > 0){
     			$success["success"] = 0;
                $success["message"] = "already existed";
                echo json_encode($success);
     
	}
	else{
	$m->set_data("first_name",$first_name);
	$m->set_data("last_name",$last_name);
	$m->set_data("email",$email);
	$m->set_data("contact_no",$contact_no);
	$m->set_data("password",$password);
	$m->set_data("confirm_password",$confirm_password);
	

		$arrayname=array("user_first_name"=>$m->get_data("first_name"),
						 "user_last_name"=>$m->get_data("last_name"),
		                 "user_email"=>$m->get_data("email"),
		                 "user_contact_no"=>$m->get_data("contact_no"),
		                 "user_password"=>$m->get_data("password"),
		                 "user_confirm_password"=>$m->get_data("confirm_password"));
		$result=$d->insert("registration",$arrayname);

		if($result>0){
			$success["success"] = 1;
			$success["msg"]="Submitted Successfully";
		echo json_encode($success);
		}else{
			$success["success"] = 0;
			$success["msg"]="Something went wrong !";
		echo json_encode($success);
		}
}
}
?>