<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$CPFLogado = $_POST['CPFLogado'];
$Tipo = $_POST['Tipo'];
$Titulo = $_POST['Titulo'];
$Quartos = $_POST['Quartos'];
$Suites = $_POST['Suites'];
$Banheiros = $_POST['Banheiros'];
$Vagas = $_POST['Vagas'];
$Area = $_POST['Area'];
$Piscina = $_POST['Piscina'];
$Cidade = $_POST['Cidade'];
$Estado = $_POST['Estado'];
$Bairro = $_POST['Bairro'];
$Descricao = $_POST['Descricao'];
$ValorSugerido = $_POST['ValorSugerido'];
$ValorVenda = $_POST['ValorVenda'];
$Telefone = $_POST['Telefone'];
$Celular = $_POST['Celular'];
$Email = $_POST['Email'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Insert = "INSERT INTO CAD_IMOVEIS (CPFLOGADO, TIPO, TITULO, QUARTOS, SUITES, BANHEIROS, VAGAS, AREA, PISCINA, CIDADE, ESTADO, BAIRRO, DESCRICAO, VALORSUGERIDO, VALORVENDA, TELEFONE, CELULAR, EMAIL) VALUES (:CPFLogado, :TIPO, :TITULO, :QUARTOS, :SUITES, :BANHEIROS, :VAGAS, :AREA, :PISCINA, :CIDADE, :ESTADO, :BAIRRO, :DESCRICAO, :VALORSUGERIDO, :VALORVENDA, :TELEFONE, :CELULAR, :EMAIL)";

    $Statement = $PDO->prepare($SQL_Insert);
    $Statement->bindParam(':CPFLogado', $CPFLogado);
    $Statement->bindParam(':TIPO', $Tipo);
    $Statement->bindParam(':TITULO', $Titulo);
    $Statement->bindParam(':QUARTOS', $Quartos);
    $Statement->bindParam(':SUITES', $Suites);
    $Statement->bindParam(':BANHEIROS', $Banheiros);
    $Statement->bindParam(':VAGAS', $Vagas);
    $Statement->bindParam(':AREA', $Area);
    $Statement->bindParam(':PISCINA', $Piscina);
    $Statement->bindParam(':CIDADE', $Cidade);
    $Statement->bindParam(':ESTADO', $Estado);
    $Statement->bindParam(':BAIRRO', $Bairro);
    $Statement->bindParam(':DESCRICAO', $Descricao);
    $Statement->bindParam(':VALORSUGERIDO', $ValorSugerido);
    $Statement->bindParam(':VALORVENDA', $ValorVenda);
    $Statement->bindParam(':TELEFONE', $Telefone);
    $Statement->bindParam(':CELULAR', $Celular);
    $Statement->bindParam(':EMAIL', $Email);

    if ($Statement->execute()) {
        $Resposta = array(
            "CADASTRO" => "SUCESSO"
        );
    } else {
        $Resposta = array(
            "CADASTRO" => "ERRO"
        );
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>