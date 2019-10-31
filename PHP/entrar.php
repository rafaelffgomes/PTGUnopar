<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$CPF = $_POST['CPF'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "SELECT SENHA FROM CAD_USUARIOS WHERE CPF = :CPF";
    $Statement = $PDO->prepare($SQL_Select);
    $Statement->bindParam(':CPF', $CPF);
    $Statement->execute();

    if ($Statement->rowCount() > 0) {
        while ($Linha = $Statement->fetch(PDO::FETCH_ASSOC)) {
            $Resposta = array(
                "SENHA" => "{$Linha['SENHA']}"
            );
        }
    } else {
        $Resposta = array(
            "SENHA" => "CADASTROINEXISTENTE"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>