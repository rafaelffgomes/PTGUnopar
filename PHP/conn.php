<?php
$dsn = "mysql:host=localhost;dbname=bancoptg;charset=utf8";
$usuario = "ptgunopar";
$senha = "ptgunopar";

try {
    $PDO = new PDO($dsn, $usuario, $senha);
} catch (PDOException $ex) {
    echo "Ocorreu um erro ao tentar acessar o banco de dados.";
}
?>