<?php

$name = '';
if (isset($_POST['name']) && $_POST['name']) {
	$name = $_POST['name'];
}


$age = 0;
if (isset($_POST['age']) && $_POST['age']) {
	$age = intval($_POST['age']);
}


$about = '';
if (isset($_POST['about']) && $_POST['about']) {
	$about = $_POST['about'];
}


$json_body = file_get_contents('php://input');
$json_obj = NULL;
try {
	if ($json_body != '') {
		$json_obj = json_decode($json_body);

		if (isset($json_obj->name)) {
			$name = $json_obj->name;
		}

		if (isset($json_obj->age)) {
			$age = intval($json_obj->age);
		}
		
		if (isset($json_obj->about)) {
			$about = $json_obj->about;
		}
	}

} catch (Exception $e) {
	// do nothing
}


$greeting = '';
if ($name) {
	$greeting = 'Hello, '.$name.'. howdy ?!';
}


header('Content-Type: application/json');
echo json_encode([
	'name' => $name,
	'greeting' => $greeting,
	'age' => $age,
	'about' => $about,
	'json_body' => $json_obj,
]);

?>