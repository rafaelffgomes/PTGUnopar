<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$ID = $_POST['ID'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "DELETE FROM CAD_IMOVEIS WHERE ID = :ID";

    $Statement = $PDO->prepare($SQL_Select);
    $Statement->bindParam(':ID', $ID);

    if ($Statement->execute()) {
        $Resposta = array(
            "EXCLUI" => "SUCESSO"
        );
    } else {
        $Resposta = array(
            "EXCLUI" => "ERRO"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>