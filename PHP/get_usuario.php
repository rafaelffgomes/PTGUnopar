<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$CPFLogado = $_POST['CPFLogado'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "SELECT NOME FROM CAD_USUARIOS WHERE CPF = :CPFLogado";

    $Statement = $PDO->prepare($SQL_Select);
    $Statement->bindParam(':CPFLogado', $CPFLogado);
    $Statement->execute();

    if ($Statement->rowCount() > 0) {
        while ($Linha = $Statement->fetch(PDO::FETCH_ASSOC)) {
            $Resposta = array(
                "NOME" => "{$Linha['NOME']}"
            );
        }
    } else {
        $Resposta = array(
            "NOME" => "Desconhecido"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>