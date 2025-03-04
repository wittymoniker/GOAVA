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
       








        $sql= "INSERT INTO accounts (username, messages, votes, files, friends) 
        VALUES ('$posttarget', '$postinfo', '$postrecipients', '$postmedia', '$postauthor') WHERE username == '$posttarget'";
     $i=$i+1;
       
          $con->query($sql);if(1==1){
            echo "New record INSERT INTOd successfully";
          } else {
            echo "Error: " . $sql . "<br>" . $con->error;
          }
          
    }

  

    $sql=("INSERT INTO accounts(messages, id)  VALUES ($postcontent) WHERE id == '$id' " );
   
    $con->query($sql);if(1==1){         echo "New record INSERT INTOd successfully";
       } else {
         echo "Error: " . $sql . "<br>" . $con->error;
       }
     
 
   $i=0;
   $stmt->close();
   $con->close();
    echo '.';
    $con->free();
    
}
  
if ($posttype == "media"){
    $i=0;
    foreach  ($posttaglets as &$posttaglet){
        $sql= "INSERT INTO forums (tag, about, groups, posts, events) 
        VALUES ($posttaglet, $posttags, $postrecipients, $postinfo, $postrecipients) WHERE tag == '$posttaglet'";
        
     $i=$i+1;
     $con->query($sql);if(1==1){            echo "New record INSERT INTOd successfully";
          } else {
            echo "Error: " . $sql . "<br>" . $con->error;
          }
    }
   
  
    $i=0;
    $sql= "INSERT INTO posts (content, title,  file, tags, name, dt, scope, type, recipients) VALUES ($postcontent, $posttitle, $postmedia, $posttags, $postauthor, $posttime, $postscope, $posttype, $postrecipients) WHERE (title,posts(file)) == ('$posttitle', '$postmedia')'";

    $con->query($sql);if(1==1){        echo "New record INSERT INTOd successfully";
      } else {
        echo "Error: " . $sql . "<br>" . $con->error;
      }
    $con->close();
     echo '.';
    $con->free();
}
if ($posttype == "comment"){
  $i=0;
  foreach  ($posttargets as &$posttarget){
      $sql= "INSERT INTO posts (comments) WHERE  posts(title, name) =($posttitle, $posttarget) 
      VALUES ($postinfo)";
 
   $i=$i+1;
   $con->query($sql);if(1==1){          
    echo "New record INSERT INTOd successfully";
        } else {
          echo "Error: " . $sql . "<br>" . $con->error;
        }
  }
 
  $i=0;
  $sql= "INSERT INTO accounts(posts,id)   VALUES ($postcontent) WHERE id ==' $id '";
  

  $con->query($sql);if(1==1){          echo "New record INSERT INTOd successfully";
        } else {
          echo "Error: " . $sql . "<br>" . $con->error;
        }
      
        
    $con->close();
     echo '.';
    $con->free();

}
if ($posttype == "post"){

    $sql= "INSERT INTO posts (content, title,  file, tags, name, dt, scope, type, recipients) VALUES ($postcontent, $posttitle, $postmedia, $posttags, $postauthor, $posttime, $postscope, $posttype, $postrecipients) WHERE (name, file) = ('$uname', '$postfile')";
    
    $con->query($sql);if(1==1){
              echo "New record INSERT INTOd successfully";
      } else {
        echo "Error: " . $sql . "<br>" . $con->error;
      }
  
 
    $i=0;
    foreach  ($posttaglets as &$posttaglet){

        $sql= "INSERT INTO tags (posts, groups, events, forums) 
        VALUES ($postinfo, $postrecipients, $postrecipients, $posttags) WHERE tags(value) == '$posttaglet'";
  
     $i=$i+1;
     $con->query($sql);if(1==1){
                  echo "New record INSERT INTOd successfully";
          } else {
            echo "Error: " . $sql . "<br>" . $con->error;
          }
    }
  
    $i=0;
    
    $con->close();
     echo '.';
    $con->free();
} 
    if ($posttype == "profile"){

      $sql= "INSERT INTO accounts (aboutcontent) 
          VALUE ($postinfo) WHERE  accounts(id, username) == ('$id', '$uname') ";

    
$con->query($sql);if(1==1){
            echo "New record INSERT INTOd successfully";
        } else {
          echo "Error: " . $sql . "<br>" . $con->error;
        }
        
    $con->close();
     echo '.';
    $con->free();



      }
  
if ($posttype == "event"){


    $sql= "INSERT INTO events (title, type, about, groups, members, posts, tags) 
    VALUES ($posttitle, $posttype, $postcontent, $postrecipients, $postauthor, $postinfo, $posttags) WHERE (title) == ('$posttitle')";

$con->query($sql);if(1==1){
          echo "New record INSERT INTOd successfully";
      } else {
        echo "Error: " . $sql . "<br>" . $con->error;
      }
  


      $sql= "INSERT INTO posts (content, title,  file, tags, name, dt, scope, type, recipients) VALUES ($postcontent, $posttitle, $postmedia, $posttags, $postauthor, $posttime, $postscope, $posttype, $postrecipients) WHERE (name, id, file) == ('$uname', '$id', '$postmedia')";

      $con->query($sql);if(1==1){
                  echo "New record INSERT INTOd successfully";
        } else {
          echo "Error: " . $sql . "<br>" . $con->error;
        }
      
   
    $con->close();
     echo '.';
    $con->free();

}
if ($posttype == "group"){


    $sql= "INSERT INTO groups (title, about, members, posts, tags, forums, tags) 
    VALUES ($posttitle, $posttype, $postauthor, $postinfo, $postrecipients, $posttags, $posttags) WHERE (title) == ('$posttitle')";

$con->query($sql);if(1==1){
          echo "New record INSERT INTOd successfully";
      } else {
        echo "Error: " . $sql . "<br>" . $con->error;
      }
    
 

      $sql= "INSERT INTO posts (content, title,  file, tags, name, dt, scope, type, recipients) VALUES ($postcontent, $posttitle, $postmedia, $posttags, $postauthor, $posttime, $postscope, $posttype, $postrecipients) WHERE (name, id) == ('$uname', '$id')";
 
      $con->query($sql);if(1==1){
                  echo "New record INSERT INTOd successfully";
        } else {
          echo "Error: " . $sql . "<br>" . $con->error;
        }
    
    
    $con->close();
     echo '.';
    $con->free();
}
if ($posttype == "forum"){
    $i=0;
    foreach ($posttaglets as &$posttaglet){
        $sql= "INSERT INTO forums (tag, about, groups, posts, events) 
        VALUES ($posttaglets, $posttags, $postrecipients, $postinfo, $postrecipients) WHERE tag == '$posttaglet'";

     $i=$i+1;
     $con->query($sql);if(1==1){
                  echo "New record INSERT INTOd successfully";
          } else {
            echo "Error: " . $sql . "<br>" . $con->error;
          }
    }
  }

    $i=0;

    $sql= "INSERT INTO posts (content, title,  file, tags, name, dt, scope, type, recipients) VALUES ($postcontent, $posttitle, $postmedia, $posttags, $postauthor, $posttime, $postscope, $posttype, $postrecipients) WHERE (name, id, file) == ('$uname', '$id', '$postmedia')";

    $con->query($sql);if(1==1){
        echo "New record INSERT INTOd successfully";
      } else {
        echo "Error: " . $sql . "<br>" . $con->error;
      }
    
    }

   

$sql= "INSERT INTO accounts(groups, events, files, forums, friends,  messages, posts, tags, votes)  
VALUES ($postinfo, $postinfo, $postmedia, $posttags, $postrecipients, $postinfo, $postinfo, $postinfo, $postinfo) WHERE accounts(username, id) == ($postauthor, $authorid)";  ;

$con->query($sql);if(1==1){      echo "New record INSERT INTOd successfully";
    } else {
      echo "Error: " . $sql . "<br>" . $con->error;
    }
    $con->close();
     echo '.';
    $con->free();




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




