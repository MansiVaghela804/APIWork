<?php
include_once 'lib_include.php';
include_once 'common_model.php';
$response = array();
extract($_POST);
$category_id=$_POST['category_id'];
 $m->set_data("$category_id",$category_id);
 $m->get_data($category_id);
// get all users
if(isset($getUsers)) {

	$q = $d->select("sub_model_list_1","sub_id='$category_id'","");
	if (mysqli_num_rows($q)>0) {
		$response["sub_model_list_1"] = array();

		while ($data=mysqli_fetch_array($q)) 
		{
		   
			$sub_model_list_1["sub_id"]=$Sub_Base_url."Furniture/".$data['sub_id'];
			$sub_model_list_1["sub_image"]=$data['sub_image'];
			$sub_model_list_1["sub_name"]=$data['sub_name'];
			
			array_push($response["sub_model_list_1"], $sub_model_list_1);
			
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

