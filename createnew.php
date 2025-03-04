<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
session_start();


    
// Change this to your connection info.
$DATABASE_HOST = 'localhost';
$DATABASE_USER = 'root';
$DATABASE_PASS = '';
$DATABASE_NAME = 'tabletime';
// Try and connect using the info above.
$mysqli =  new mysqli($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
$con =  $mysqli;
if (mysqli_connect_errno()) {
	// If there is an error with the connection, stop the script and display the error.
	exit('Failed to connect to MySQL: ' . mysqli_connect_error());
}



$stmt = $con->prepare('SELECT password, email, username, votes, id FROM accounts WHERE id = ?');

$stmt->bind_param('i', $_SESSION['id']);
$stmt->execute();
$stmt->bind_result($password, $email, $username, $votelist, $id);
$stmt->fetch();


$authorid = $_SESSION['id'];
$author = $username;
$uname = $username;
$_SESSION['$uname'] = $uname;
$id = $_SESSION['id'];
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
if(isset($_POST["enter"]))
            {
                $test=$_POST["test"];
                $number1=$_SESSION['num1'];
                $number2=$_SESSION['num2'];;
                $total=$number1+$number2;
                if ($total==$test)
                {






                  $uniqueFolder = "file_" . uniqid();
$target_dir = "files/" . $uniqueFolder . "/";
$target_file = $target_dir . basename($_FILES["file"]["name"]);
                  
                  $uploadOk = 1;
                  $fileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
                  if (!is_dir($target_dir)) {
                    mkdir($target_dir, 0777, true);
                }
                $fileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
                  // Check if file already exists
                  if (file_exists($target_file)) {
                      echo "Sorry, file already exists.";
                      $uploadOk = 0;
                  }
              
                  // Check file size (limit to 5MB)
                  if ($_FILES["file"]["size"] > 5000000) {
                      echo "Sorry, your file is too large.";
                      $uploadOk = 0;
                  }
              
                  // Allow certain file formats
           
                  move_uploaded_file($_FILES["file"]["name"], $target_file);
                  // Check if $uploadOk is set to 0 by an error
                  if ($uploadOk = 0) {
                      echo "Sorry, your file was not uploaded.";
                  }
                  
$baseDir = $target_dir;
$file = (string)($target_file) ;






$postfile = $file;
				$postcontent = $_POST['content'];
				$posttitle = $_POST['title'];
				$posttags = $_POST['tags'];
				$postmedia = $file;
				$postauthor = $author;
				$posttime = date('Y-m-d H:i:s');
				$postscope = $_POST['scope'];
                $posttype = $_POST['type'];
                $postrecipients = $_POST['recipients'];


$posttargets = explode(";", $_POST['recipients']);
$posttaglets = explode(";", $_POST['tags']);
$postinfo = implode(" : ", [$posttitle, $postcontent, $postmedia, $posttags, $postauthor, $posttime, $postscope, $posttype, $postrecipients]);
$tags = explode(";", $_POST['tags']);
/*<option value ="message">message</option>
<option value ="media">media</option>
<option value ="post">post</option>
<option value ="event">event</option>
<option value ="group">group</option>
<option value ="forum">forum</option>*/
 
if ($posttype == "message"){
    $i=0;
    foreach  ($posttargets as &$posttarget){
       








        $stmt= $con->prepare( $con->prepare("INSERT INTO accounts(username, messages, votes, files, friends, username)  VALUES 
        (?,?,?,?,?,?)"));
        
	$stmt->bind_param('ssssss', '$posttarget', '$postinfo', '$postrecipients', '$postmedia', '$postauthor','$posttarget');
  $stmt->execute(); 
  $stmt->fetch();
          $i=$i+1;
    }

  

    $stmt= $con->prepare(("INSERT INTO accounts(id, messages)  VALUES (?,?)" ));
    $stmt->bind_param('is', '$id','$postcontent');
   $stmt->execute(); 
    
    
     
 
   $i=0;

    echo '.';
      
    
}
  
if ($posttype == "media"){
    $i=0;
    foreach  ($posttaglets as &$posttaglet){
        $stmt= $con->prepare( "INSERT INTO forums (tag, about, groups, posts, events) 
        VALUES (?,?,?,?,?) ");
         
        $stmt->bind_param('sssss','$posttaglet', '$posttags', '$postrecipients', '$postinfo', '$postrecipients');
        $stmt->execute(); 
     $i=$i+1;
    
    }
   
  
    $i=0;
    $stmt= $con->prepare( "INSERT INTO posts (content,    tags,  dt, scope, type, recipients,name, title, file) VALUES (?,?,?,?) ");
         
        $stmt->bind_param('sssssssss','$postcontent',  '$posttags', '$posttime', '$postscope', '$posttype', '$postrecipients', '$uname', '$posttitle', '$postmedia' );
        $stmt->execute(); 
 
     echo '.';
      
}
if ($posttype == "comment"){
  $i=0;
  foreach  ($posttargets as &$posttarget){
      $stmt= $con->prepare( "INSERT INTO posts (comments, title, name) ) 
      VALUES (?,?,?)");

 $stmt->bind_param('sss',  '$postinfo','$posttitle', '$posttarget');
        $stmt->execute(); 
   $i=$i+1;

     
  }
 
  $i=0;
  $stmt= $con->prepare( "INSERT INTO accounts(posts,id)  VALUES (?,?)");

 $stmt->bind_param('si',  '$postcontent','$id');
        $stmt->execute(); 
      
        

     echo '.';
      

}
if ($posttype == "post"){

    $stmt= $con->prepare( "INSERT INTO posts (content, title,   tags, dt, scope, type, recipients, name, file) VALUES (?,?,?,?,?,?,?,?,?) ");
    $stmt->bind_param('sssssssss','$postcontent', '$posttitle', '$posttags', '$posttime', '$postscope', '$posttype', '$postrecipients', '$uname', '$posttitle', '$postmedia' );
        $stmt->execute(); 
      
 
    $i=0;
    foreach  ($posttaglets as &$posttaglet){

        $stmt= $con->prepare( "INSERT INTO tags (posts, groups, events, forums, value); 

        VALUES (?,?,?,?,?) ");
  $stmt->bind_param('sssssssss','$postcontent', '$posttitle', '$posttags', '$posttime', '$postscope', '$posttype', '$postrecipients', '$uname', '$posttitle', '$postmedia' );
  $stmt->execute(); 
     $i=$i+1;
    }
    }
  
    $i=0;
    

     echo '.';
      
} 
    if ($posttype == "profile"){

      $stmt= $con->prepare( "INSERT INTO accounts (aboutcontent, id, username) 
          VALUES (?,?,?)");

 $stmt->bind_param('sis',  '$postinfo','$id', '$uname');
        $stmt->execute(); 

     echo '.';
      



      }
  
if ($posttype == "event"){


    $stmt= $con->prepare( "INSERT INTO events (title, type, about, groups,  posts, tags, title, members, file) 
    VALUES (?,?,?,?,?,?,?,?,?) ");
$stmt->bind_param('sssssssss', '$posttitle', '$posttype','$postinfo', '$postrecipients', '$postcontent', '$posttags', '$posttitle', '$uname', '$postmedia' );
    $stmt->execute(); 


$stmt= $con->prepare( "INSERT INTO posts (content, title,   tags, dt, scope, type, recipients, name, file) VALUES (?,?,?,?,?,?,?,?,?) ");
$stmt->bind_param('sssssssss','$postcontent', '$posttitle', '$posttags', '$posttime', '$postscope', '$posttype', '$postrecipients', '$uname', '$posttitle', '$postmedia' );
    $stmt->execute(); 
   
   
     echo '.';
      

}
if ($posttype == "group"){


  $stmt= $con->prepare( "INSERT INTO groups (title, type, about, events,  posts, tags, title, members, file) 
  VALUES (?,?,?,?,?,?,?,?,?) ");
$stmt->bind_param('sssssssss', '$posttitle', '$posttype','$postinfo', '$postrecipients', '$postcontent', '$posttags', '$posttitle', '$uname', '$postmedia' );
  $stmt->execute(); 


$stmt= $con->prepare( "INSERT INTO posts (content, title,   tags, dt, scope, type, recipients, name, file) VALUES (?,?,?,?,?,?,?,?,?) ");
$stmt->bind_param('sssssssss','$postcontent', '$posttitle', '$posttags', '$posttime', '$postscope', '$posttype', '$postrecipients', '$uname', '$posttitle', '$postmedia' );
  $stmt->execute(); 
 
   echo '.';
    

      
}
if ($posttype == "forum"){
    $i=0;
    foreach ($posttaglets as &$posttaglet){
        $stmt= $con->prepare( "INSERT INTO forums (about, groups, posts, events, tag) 
        VALUES (?,?,?,?,?)");

     $i=$i+1;
     $stmt->bind_param('sssss','$posttags', '$postrecipients', '$postinfo', '$postrecipients','$posttaglet');
      $stmt->execute(); 
       
    }


    $i=0;

    $stmt= $con->prepare( "INSERT INTO posts (content, title,   tags, dt, scope, type, recipients, name, file) VALUES (?,?,?,?,?,?,?,?,?) ");
    $stmt->bind_param('sssssssss','$postcontent', '$posttitle', '$posttags', '$posttime', '$postscope', '$posttype', '$postrecipients', '$uname', '$posttitle', '$postmedia' );
      $stmt->execute(); 
     
      $con->close();


      
    }

   

$stmt= $con->prepare( "INSERT INTO accounts(groups, events, files, forums, friends,  messages, posts, tags, username, id)  
VALUES (?,?,?,?,?,?,?,?,?,?)");
$stmt->bind_param('sssssssssi', '$posttitle', '$posttitle',  '$postmedia', '$posttags', '$postrecipients', '$postinfo','$postinfo', '$posttags', '$uname', '$id');  
 $stmt->execute(); 


     echo '.';
      




header('Location: home.php');
sleep(6000 + 6000 * ((array_sum(explode(";",$votelist))/(count(explode(";",$votelist))))));
echo "Post INSERTd. Wait 10min for next post: ";
echo "<a href='home.php'>Return to home</a>";


                   
               }
                else {
                    echo "<p>
                                <font color=red 
                                    font face='arial' 
                                    size='5pt'>
                                Invalid captcha entered !
                                </font>
                            </p>";
                }
}
      
?>




