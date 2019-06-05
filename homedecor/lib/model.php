<?php

class model
{
    private $ary;
    function set_data($name, $value)
    {
        $this->ary[$name]=$value;
    }
    function get_data($name)
    {
        return $this->ary[$name];
    }
}
//for filter data
 function test_input($data)
{
    $data = trim($data);
    $data = stripslashes($data);
     $data = strip_tags($data);
     $data = htmlspecialchars($data);
     return $data;

}
function custom_echo($x, $length)
{
  if(strlen($x)<=$length)
  {
    echo $x;
  }
  else
  {
    $y=substr($x,0,$length) . '...';
    echo $y;
  }
}
?>