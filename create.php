<?php

session_start();

if (!isset($_SESSION['loggedin'])) {
	header('Location: home.php');
	exit;
}


$DATABASE_HOST = 'localhost';
$DATABASE_USER = 'root';
$DATABASE_PASS = '';
$DATABASE_NAME = 'tabletime';
$mysqli =  new mysqli($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
$con =  $mysqli;
if (mysqli_connect_errno()) {
	exit('Failed to connect to MySQL: ' . mysqli_connect_error());
}

$min  = 1;
$max  = 500;
$num1 = rand( $min, $max );
$num2 = rand( $min, $max );
$_SESSION['num1'] =$num1;
$_SESSION['num2'] =$num2;


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


<html class = "tabletime">
<meta name="viewport" content="width=device-width">
		<meta charset="utf-8">

<link href="style.php" rel="stylesheet" type="text/css">
<head class = "html">
		<title>tabletime</title>


<body class = "content">  
<nav class = "navtop">
		<div class = "tabletime">		

		
<br>
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

<?php include 'createnew.php'; ?>

<p> <?php echo $username; ?>'s post. </p><br>
<form method="POST" action = "createnew.php" enctype="multipart/form-data" autocomplete="off">					<br>				
<label for="type">
post type:			</label> 
<select name = "type" id = "type" value = "type">
<option value ="message">message</option>
<option value ="comment">comment</option>
<option value ="media">media</option>
<option value ="post">post</option>
<option value ="event">event</option>
<option value ="group">group</option>
<option value ="forum">forum</option>
<option value ="profile">update your description</option>
</select>
<label for="scope">
			post scope:			</label>
<select name = "scope" id = "scope">
<option value ="private">private</option>
<option value ="public ">public</option>
<option value ="global">global</option>
</select>
<label for="file">
			file:			</label>
<input method ="POST" type="file" name="file"  placeholder="file directory..." id="file" required> <br>

	<label for="title">
			title:
			</label>     
<input method ="POST" type="text" name="title" placeholder="title (required)" id="title" required> <br>



	<label for="content">
			content:</label>  
            <input type="text" style="height:500px;width:500px;" name="content" placeholder="contents / description (required)" id="content" required><br>

			


	<label for="tags">
			tags:
			</label>
<input method ="POST" type="text" name="tags" placeholder="tags (separate by semicolon;)" id="tags" required>

 <br><label for="recipients">
			send to:
			</label>
<input method ="POST" type="text" name="recipients" placeholder="recipients (separate by semicolon;)" id="recipients" required>

 <br>


<br><br>


<div class="col-12">
                <div class="row">
                    <div class="col-md-6">
                        <div class="row">
                            <label for="quiz" 
                                   class="col-sm-3 col-form-label">
                                <?php echo $num1 . '+' . $num2; ?>
                            </label>
                            <div>
                                <input method ="POST" type="hidden" 
                                       name="no1" 
                                       value="<?php echo $num1 ?>">
                                <input method ="POST" type="hidden"
                                       name="no2" 
                                       value="<?php echo $num2 ?>">
                                <input method ="POST" type="text" 
                                       name="test"
                                       class="form-control quiz-control" 
                                       autocomplete="off"
                                       id="test" required>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


<br><br><br>


<input method ="POST" type = "submit" name= "enter" value = "enter" >
 <br>

 
	</form>

</div>

</body>
</head>
</html>
