<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$Bairro = $_POST['Bairro'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "SELECT ID FROM BAIRROS_IMOVEIS WHERE BAIRRO = :BAIRRO";

    $Statement = $PDO->prepare($SQL_Select);
    $Statement->bindParam(':BAIRRO', $Bairro);
    $Statement->execute();

    if ($Statement->rowCount() > 0) {
        while ($Linha = $Statement->fetch(PDO::FETCH_ASSOC)) {
            $Resposta = array(
                "ID" => "{$Linha['ID']}"
            );
        }
    } else {
        $Resposta = array(
            "ID" => "0"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>