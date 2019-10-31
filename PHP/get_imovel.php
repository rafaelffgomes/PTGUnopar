<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$ID = $_POST['ID'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "SELECT TIPO, QUARTOS, SUITES, BANHEIROS, VAGAS, AREA, PISCINA, CIDADE, ESTADO, BAIRRO, DESCRICAO, VALORSUGERIDO, VALORVENDA, TELEFONE, CELULAR, EMAIL FROM CAD_IMOVEIS WHERE ID = :ID";

    $Statement = $PDO->prepare($SQL_Select);
    $Statement->bindParam(':ID', $ID);
    $Statement->execute();

    while ($Linha = $Statement->fetch(PDO::FETCH_ASSOC)) {
        $Resposta = array(
            "TIPO" => "{$Linha['TIPO']}",
            "QUARTOS" => "{$Linha['QUARTOS']}",
            "SUITES" => "{$Linha['SUITES']}",
            "BANHEIROS" => "{$Linha['BANHEIROS']}",
            "VAGAS" => "{$Linha['VAGAS']}",
            "AREA" => "{$Linha['AREA']}",
            "PISCINA" => "{$Linha['PISCINA']}",
            "CIDADE" => "{$Linha['CIDADE']}",
            "ESTADO" => "{$Linha['ESTADO']}",
            "BAIRRO" => "{$Linha['BAIRRO']}",
            "DESCRICAO" => "{$Linha['DESCRICAO']}",
            "VALORSUGERIDO" => "{$Linha['VALORSUGERIDO']}",
            "VALORVENDA" => "{$Linha['VALORVENDA']}",
            "TELEFONE" => "{$Linha['TELEFONE']}",
            "CELULAR" => "{$Linha['CELULAR']}",
            "EMAIL" => "{$Linha['EMAIL']}"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>