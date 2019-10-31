<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$CPFLogado = $_POST['CPFLogado'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "SELECT ID, TIPO, TITULO FROM CAD_IMOVEIS WHERE CPFLOGADO = $CPFLogado";

    $Statement = $PDO->query($SQL_Select);

    while ($Linha = $Statement->fetch(PDO::FETCH_OBJ)) {
        $Resposta[] = array(
            "ID" => $Linha->ID,
            "TIPO" => $Linha->TIPO,
            "TITULO" => $Linha->TITULO
        );
    }

    if (count($Resposta) == 0) {
        $Resposta[] = array(
            "ID" => "SEMREGISTROS"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>