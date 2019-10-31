package ptgunopar.dynu.net.dados;

public class DadosGlobais {

    private static String CPF;
    private static String Nome;
    private static String SobreNome;
    private static String Nascimento;
    private static String Telefone;
    private static String Celular;
    private static String Email;
    private static String CPFLogado;
    private static String Tipo;
    private static Boolean PrimeiraExecucao = true;
    private static String Cidade;
    private static String Estado;
    private static String Bairro;
    private static Integer Quartos;
    private static Integer Vagas;
    private static Integer Suites;
    private static Integer Banheiros;
    private static String Piscina;
    private static Integer Area;
    private static String Titulo;
    private static String Descricao;
    private static String ValorSugerido;
    private static String ValorVenda;
    private static String ID;
    private static String SenhaAcesso = "abc123def345ghi678";

    public static String getSenhaAcesso() {
        return SenhaAcesso;
    }

    public static void setSenhaAcesso(String senhaAcesso) {
        SenhaAcesso = senhaAcesso;
    }

    public static Integer getSuites() {
        return Suites;
    }

    public static void setSuites(Integer suites) {
        Suites = suites;
    }

    public static Integer getBanheiros() {
        return Banheiros;
    }

    public static void setBanheiros(Integer banheiros) {
        Banheiros = banheiros;
    }

    public static String getPiscina() {
        return Piscina;
    }

    public static void setPiscina(String piscina) {
        Piscina = piscina;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        DadosGlobais.ID = ID;
    }

    public static Boolean getPrimeiraExecucao() {
        return PrimeiraExecucao;
    }

    public static void setPrimeiraExecucao(Boolean primeiraExecucao) {
        PrimeiraExecucao = primeiraExecucao;
    }

    public static String getCidade() {
        return Cidade;
    }

    public static void setCidade(String cidade) {
        Cidade = cidade;
    }

    public static String getEstado() {
        return Estado;
    }

    public static void setEstado(String estado) {
        Estado = estado;
    }

    public static String getBairro() {
        return Bairro;
    }

    public static void setBairro(String bairro) {
        Bairro = bairro;
    }

    public static Integer getQuartos() {
        return Quartos;
    }

    public static void setQuartos(Integer quartos) {
        Quartos = quartos;
    }

    public static Integer getVagas() {
        return Vagas;
    }

    public static void setVagas(Integer vagas) {
        Vagas = vagas;
    }

    public static Integer getArea() {
        return Area;
    }

    public static void setArea(Integer tamanho) {
        Area = tamanho;
    }

    public static String getTitulo() {
        return Titulo;
    }

    public static void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public static String getDescricao() {
        return Descricao;
    }

    public static void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public static String getValorSugerido() {
        return ValorSugerido;
    }

    public static void setValorSugerido(String valorSugerido) {
        ValorSugerido = valorSugerido;
    }

    public static String getValorVenda() {
        return ValorVenda;
    }

    public static void setValorVenda(String valorVenda) {
        ValorVenda = valorVenda;
    }

    public static String getTipo() {
        return Tipo;
    }

    public static void setTipo(String tipo) {
        Tipo = tipo;
    }

    public static String getCPFLogado() {
        return CPFLogado;
    }

    public static void setCPFLogado(String cpflogado) {
        CPFLogado = cpflogado;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) {
        this.CPF = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobreNome() {
        return SobreNome;
    }

    public void setSobreNome(String sobrenome) {
        SobreNome = sobrenome;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public void setNascimento(String nascimento) {
        Nascimento = nascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }
}
