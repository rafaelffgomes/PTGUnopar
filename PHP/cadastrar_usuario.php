<?php
include "conn.php";

$SenhaAcesso = $_POST['SenhaAcesso'];
$CPF = $_POST['CPF'];
$Senha = $_POST['Senha'];
$Nome = $_POST['Nome'];
$SobreNome = $_POST['SobreNome'];
$Nascimento = $_POST['Nascimento'];
$Email = $_POST['Email'];
$Telefone = $_POST['Telefone'];
$Celular = $_POST['Celular'];

$Resposta = null;

if ($SenhaAcesso == "abc123def345ghi678") {
    $SQL_Select = "SELECT SENHA FROM CAD_USUARIOS WHERE CPF = :CPF";
    $Statement = $PDO->prepare($SQL_Select);
    $Statement->bindParam(':CPF', $CPF);
    $Statement->execute();

    if ($Statement->rowCount() > 0) {
        $Resposta = array(
            "CADASTRO" => "CADASTROEXISTENTE"
        );
    } else {
        $SQL_Insert = "INSERT INTO CAD_USUARIOS (CPF, SENHA, NOME, SOBRENOME, NASCIMENTO, EMAIL, TELEFONE, CELULAR) VALUES (:CPF, :SENHA, :NOME, :SOBRENOME, :NASCIMENTO, :EMAIL, :TELEFONE, :CELULAR)";

        $Statement = $PDO->prepare($SQL_Insert);
        $Statement->bindParam(':CPF', $CPF);
        $Statement->bindParam(':SENHA', $Senha);
        $Statement->bindParam(':NOME', $Nome);
        $Statement->bindParam(':SOBRENOME', $SobreNome);
        $Statement->bindParam(':NASCIMENTO', $Nascimento);
        $Statement->bindParam(':EMAIL', $Email);
        $Statement->bindParam(':TELEFONE', $Telefone);
        $Statement->bindParam(':CELULAR', $Celular);

        if ($Statement->execute()) {
            $Resposta = array(
                "CADASTRO" => "SUCESSO"
            );
        } else {
            $Resposta = array(
                "CADASTRO" => "ERRO"
            );
        }
    }
} else {
    $Resposta = array(
        "ACESSO" => "NEGADO"
    );
}

echo json_encode($Resposta);
?>