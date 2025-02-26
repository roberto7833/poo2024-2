package br.ufpb.roberto.sistemaAmigo;

import java.util.HashMap;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap(){
        this.mensagens = new HashMap<>();
        this.amigos = new HashMap<>();
    }
    public void cadastrarAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        if(this.amigos.containsKey(nomeAmigo)){
            throw new AmigoJaExisteException("essa pessoa já esta cadastrada");
        }else{
            this.amigos.put(nomeAmigo, new Amigo(nomeAmigo,emailAmigo));
        }
    }
}
