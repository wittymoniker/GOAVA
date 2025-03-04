<?php
$min  = 1;
$max  = 500;
$num1 = rand( $min, $max );
$num2 = rand( $min, $max );

    
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






if(isset($_POST["submit"]))
            {
                $test=$_POST["test"];
                $number1=$_POST["no1"];
                $number2=$_POST["no2"];
                $total=$number1+$number2;
                if ($total==$test)
                {









if (!isset($_POST['username'], $_POST['password'], $_POST['email'])) {
		exit('Please complete the registration form!');
}
if (empty($_POST['username']) || empty($_POST['password']) || empty($_POST['email'])) {
		exit('Please complete the registration form');
}

     				if ($stmt = $con->prepare('SELECT id, password FROM accounts WHERE username = ?')) {
	$stmt->bind_param('s', $_POST['username']);
	$stmt->execute();
	$stmt->store_result();
		if ($stmt->num_rows > 0) {
				echo 'Name exists, please choose another!';
	} else {
		if ($stmt = $con->prepare('INSERT INTO accounts (username, password, email) VALUES (?, ?, ?)')) {
				$password = password_hash($_POST['password'], PASSWORD_DEFAULT);
			$stmt->bind_param('sss', $_POST['username'], $password, $_POST['email']);
	$stmt->execute();
			
header('Location: index.php');
			} else {
				echo 'Could not prepare statement!';
			}
	}
	$stmt->close();
} else {
		echo 'Could not prepare statement!';
}
$con->close();












header('Location: login.php');

usleep(5000000000000000000);
                   exit();
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
