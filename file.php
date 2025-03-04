<?php
// We need to use sessions, so you should always start sessions using the below password.
session_start();
// If the user is not logged in redirect to the login page...
if (!isset($_SESSION['loggedin'])) {
	header('Location: index.html');
	exit;
}
$DATABASE_HOST = 'localhost';
$DATABASE_USER = 'root';
$DATABASE_PASS = '';
$DATABASE_NAME = 'tabletime';
$con =  new mysqli($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
if (mysqli_connect_errno()) {
	exit('Failed to connect to MySQL: ' . mysqli_connect_error());
}


$stmt = $con->prepare('SELECT username, files FROM accounts WHERE id = ?');

$stmt->bind_param('i', $_SESSION['id']);
$stmt->execute();
$stmt->bind_result($username, $files);
$stmt->fetch();
$stmt->close();
$id = $_SESSION['id'];
$color;
$stmt = $con->prepare('SELECT colors FROM accounts WHERE id =?');

$stmt->bind_param('i', $id);
$stmt->execute();
$stmt->bind_result($color);
$stmt->fetch();
$stmt->close();
if ($color != NULL){
	$color = explode(";", $color);
	$colora= color[0];
	$colorb= color[1];
	$colorc= color[2];
	$colord= color[3];
	$colore= color[4];
	$colorf= color[5];
	
	$colora2= color[6];
	$colorb2= color[7];
	$colorc2= color[8];
	$colord2= color[9];
	$colore2= color[10];
	$colorf2= color[11];
	
	$colora3= color[12];
	$colorb3= color[13];
	$colorc3= color[14];
	$colord3= color[15];
	$colore3= color[16];
	$colorf3= color[17];
	
	$colort = color[18];
	$fontSize = [19];
	
}
else{
	$colora= "#ababab";
$colorb= "#bcbcbc";
$colorc= "#cdcdcd";
$colord= "#dcdcdc";
$colore= "#ededed";
$colorf= "#dfdfdf";

$colora2= "#0a0a0a";
$colorb2= "#1b1b1b";
$colorc2= "#2c2c2c";
$colord2= "#3d3d3d";
$colore2= "#4e4e4e";
$colorf2= "#5f5f5f";

$colora3= "#a3a3a3";
$colorb3= "#b2b2b2";
$colorc3= "#c1c1c1";
$colord3= "#d1d1d1";
$colore3= "#e2e2e2";
$colorf3= "#f3f3f3";



$colort = "#000000";
$fontSize = "14";
}

?>







<?php


if (mysqli_connect_errno()) {
	exit('Failed to connect to MySQL: ' . mysqli_connect_error());
}





$stmt = $con->prepare('SELECT username FROM accounts WHERE id = ?');
$stmt->bind_param('i', $_SESSION['id']);
$stmt->execute();
$stmt->bind_result($username);
$stmt->fetch();
$stmt->close();


$initial_directory = 'files/';
// The current directory path
$current_directory = $initial_directory;
if (isset($_GET['file'])) {
    // If the file is a directory
    if (is_dir($_GET['file'])) {
        // Update the current directory
        $current_directory = $_GET['file'] . '/';
    } else {
        // Download file
        header('Content-Description: File Transfer'); 
        header('Content-Type: application/octet-stream'); 
        header('Content-Disposition: attachment; filename="' . basename($_GET['file']) . '"'); 
        readfile($_GET['file']);
        exit; 
    }
}
// Retrieve all files and directories
$results = glob(str_replace(['[',']',"\f[","\f]"], ["\f[","\f]",'[[]','[]]'], ($current_directory ? $current_directory : $initial_directory)) . '*');
// If true, directories will appear first in the populated file list
$directory_first = true; 
// Sort files
if ($directory_first) {
    usort($results, function($a, $b){
        $a_is_dir = is_dir($a);
        $b_is_dir = is_dir($b);
        if ($a_is_dir === $b_is_dir) {
            return strnatcasecmp($a, $b);
        } else if ($a_is_dir && !$b_is_dir) {
            return -1;
        } else if (!$a_is_dir && $b_is_dir) {
            return 1;
        }
    });
}
function convert_filesize($bytes, $precision = 2) {
    $units = ['Bytes', 'KB', 'MB', 'GB', 'TB']; 
    $bytes = max($bytes, 0); 
    $pow = floor(($bytes ? log($bytes) : 0) / log(1024)); 
    $pow = min($pow, count($units) - 1); 
    $bytes /= pow(1024, $pow);
    return round($bytes, $precision) . ' ' . $units[$pow]; 
}
// Determine the file type icon
function get_filetype_icon($filetype) {
    if (is_dir($filetype)) {
        return '<i class="fa-solid fa-folder"></i>';
    } else if (preg_match('/image\/*/', mime_content_type($filetype))) {
        return '<i class="fa-solid fa-file-image"></i>';
    } else if (preg_match('/video\/*/', mime_content_type($filetype))) {
        return '<i class="fa-solid fa-file-video"></i>';
    } else if (preg_match('/audio\/*/', mime_content_type($filetype))) {
        return '<i class="fa-solid fa-file-audio"></i>';
    } else if (preg_match('/audio\/*/', mime_content_type($filetype))) {
        return '<i class="fa-solid fa-file-audio"></i>';
    }
    return '<i class="fa-solid fa-file"></i>';
}





?>





<html class = "tabletime">
		<link href="style.php" rel="stylesheet" type="text/css">
	
		<meta charset="utf-8">
		<title>tabletime</title>
  <meta name="viewport" content="width=device-width,minimum-scale=1">
		<title>File Management System</title>



		
	<body class="content">
<head class = "html">

    <nav class = "navtop">
		<div class = "tabletime">		
		

		<h1><b><a href="home.php">TABLETIME</a></b></h1>
<p>
<a href="messages.php"><i class="fas fa-user-circle"></i>Messages</a>
<a href="event.php"><i class="fas fa-user-circle"></i>Events</a>
<a href="forum.php"><i class="fas fa-user-circle"></i>Forums</a>
<a href="post.php"><i class="fas fa-user-circle"></i>Posts</a><br>
<a href="group.php"><i class="fas fa-user-circle"></i>Groups</a>
<a href="statsmap.php"><i class="fas fa-user-circle"></i>Stats/Map</a><br>
<a href="profile.php"><i class="fas fa-user-circle"></i>Profile</a>
<a href="file.php"><i class="fas fa-user-circle"></i>Files</a>
<a href="create.php"><i class="fas fa-user-circle"></i>Create</a></p>




			</div>
</nav>






<form method ="POST">
<label name ="fileindex"> <br>file: </label><br>
<input method = "POST" type = "text" id = "filei" default = "file/: index key"><br>
<input method ="POST" type = "submit" name= "enter" value = "enter" >
<br>
</form><?php
$fileID="";
$current_directory = 'files/' . (string)($fileID);
if(isset($_POST['submit'])){
    $fileID = $_POST['filei'];
    $id = $_SESSION['id'];
    $current_directory = 'files/' . (string)($fileID);


}


?>


<div class = "html">
                <a href="createUI.php?directory=<?=$fileID?>"><i class="fa-solid fa-plus"></i></a>


            <table >
                <th>
                    <tr>
                        <td >Name<i ></i></td>
                        <td>Size</td>
                        <td>Modified</td>
                        <td>Actions</td>
                    </tr>
                </th>
                <tbody>
                    <?php if (isset($_GET['file']) && realpath($current_directory) != realpath($initial_directory)): ?>
                    <tr>
                        <td colspan="10" ><i ></i><a href="?file=<?=urlencode($_GET['filei']) . '/..'?>">...</a></td>
                    </tr>
                    <?php endif; ?>
                    <?php foreach ($results as $result): ?>
                    <tr >
                        <td ><?=get_filetype_icon($result)?><a href="?file=<?=urlencode($result)?>" <?=(string)($result)?></a></td>
                        <td><?=is_dir($result) ? 'Folder' : convert_filesize(filesize($result))?></td>
                        <td><?=str_replace(date('F j, Y'), 'Today,', date('F j, Y H:ia', filemtime($result)))?></td>
                        <td >
                            <?php if (!is_dir($result)): ?>
                            <a href="?file=<?=urlencode($result)?>" ><i c></i></a>
                            <?php endif; ?>
                        </td>
                    </tr>
                    <?php endforeach; ?>
                </tbody>
                </table>
                            </div>
        </div>
        </div>  
                
        <form>
<label name ="rate"> <br>leave rating (-/+) karma/moksha (type username or tag into index bar): </label>"
<input method = "POST" type = "range" id = "perspective" name = "rate" min = "-256" max = "256">
</form><?php
if(isset($_POST['submit'])){
    $votetarget = $_POST['filei'];
    $id = $_SESSION['id'];
    $vote = ( (string)(float)((256+$_POST['perspective'])/255) . ";" );
    if(isset($_POST['perspective'])){
        $sql = "UPDATE posts ADD $vote TO votes WHERE id == $feature[10]";
        $result = $mysqli->query($sql);

    }
}
if(isset($_POST['submit'])){
    $votetarget = $_POST['filei'];
    $id = $_SESSION['id'];
    $vote = ( (string)(float)((256+$_POST['perspective'])/255) . ";" );
    if(isset($_POST['perspective'])){
        $sql = "UPDATE accounts ADD $vote TO votes WHERE username == $votetarget";
        $result = $mysqli->query($sql);

    }
}
?>    </head>      
                                       
</body>

</html>
