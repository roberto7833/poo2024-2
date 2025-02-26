package br.ufpb.roberto.sistemaAmigo;

import java.util.List;
import java.util.ArrayList;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    public void cadastrarAmigo(String nomeAmigo, String emailAmigo){
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(amigo);
    }
    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> anonimas = new ArrayList<>();
        for(Mensagem m: this.mensagens){
            if(m.ehAnonima()){
                anonimas.add(m);
            }
        }
        return anonimas;
    }
    public void configuraAmigoSecretoDe(String emailPessoa, String emailSorteado) throws AmigoInexistenteException{
        Amigo a = pesquisaAmigo(emailPessoa);
        if(a==null){
            throw new AmigoInexistenteException("Amigo não encontrado "+emailPessoa);
        }
        Amigo amigoSorteado = pesquisaAmigo(emailSorteado);
        if(amigoSorteado==null){
            throw new AmigoInexistenteException("Amigo sorteado não encontrado: "+emailSorteado);
        }
        a.setEmailAmigoSorteado(emailSorteado);
    }

    public Amigo pesquisaAmigo(String email){
        for(Amigo a: this.amigos){
            if(a.getEmail().equals(email)){
                return a;
            }
        }
        return null;
    }
    public String pesquisaAmigoSecretoDe(String emailPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        Amigo a = pesquisaAmigo(emailPessoa);
        if(a==null){
            throw new AmigoInexistenteException("Amigo não encontrado "+emailPessoa);
        }else{
            throw new AmigoNaoSorteadoException("Amigo secreto não sorteado para "+emailPessoa);
        }
    }
}
