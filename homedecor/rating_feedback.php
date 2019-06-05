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

	$m->set_data("name",$name);
	$m->set_data("email",$email);
	$m->set_data("contact_no",$contact_no);
	$m->set_data("message",$message);

		$arrayname=array("name"=>$m->get_data("name"),
						 "email"=>$m->get_data("email"),
		                 "contact_no"=>$m->get_data("contact_no"),
		                 "message"=>$m->get_data("message"));
		$result=$d->insert("rating_feedback",$arrayname);

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
?>