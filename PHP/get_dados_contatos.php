<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$CPFLogado = $_POST['CPFLogado'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "SELECT EMAIL, TELEFONE, CELULAR FROM CAD_USUARIOS WHERE CPF = :CPF";

    $Statement = $PDO->prepare($SQL_Select);
    $Statement->bindParam(':CPF', $CPFLogado);
    $Statement->execute();

    while ($Linha = $Statement->fetch(PDO::FETCH_ASSOC)) {
        $Resposta = array(
            "EMAIL" => "{$Linha['EMAIL']}",
            "TELEFONE" => "{$Linha['TELEFONE']}",
            "CELULAR" => "{$Linha['CELULAR']}"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>