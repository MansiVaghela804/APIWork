<?php

$response = array();
extract($_POST);
include_once 'lib_include.php';
// get all users
if(isset($getUsers)) {

	$q = $d->select("model_list","","");
	if (mysqli_num_rows($q)>0) {
		$response["model_list"] = array();

		while ($data=mysqli_fetch_array($q)) 
		{
		    $model_list["category_id"]=$data['category_id'];
			$model_list["image"]="image/".$data['image'];
			$model_list["category_name"]=$data['category_name'];
						
			array_push($response["model_list"], $model_list);
			
		}
		$response["success"] = "200";
		$response["massage"] = "Photos found";
		echo json_encode($response);
	}else
	{
		$response["success"] = "201";
		$response["massage"] = "No Photos Available";
		echo json_encode($response);

	}
}
?>