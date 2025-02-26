package br.ufpb.roberto.sistemaAmigo;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinario;


    public MensagemParaAlguem(String texto, String emailRemetente, boolean anonima, String emailDestinario){
        super(texto, emailRemetente, anonima);
        this.emailDestinario = emailDestinario;
    }

    public String getEmailDestinario(){
        return this.emailDestinario;
    }
    public void setEmailDestinario(String emailDestinario){
        this.emailDestinario = emailDestinario;
    }
    public String getTextoCompletoAExibir(){
        if(ehAnonima()){
            return "Mensagem para " +emailDestinario+ ", texto "+getTexto();
        }else{
            return "Mensagem de "+getEmailRemetente()+ " para "+emailDestinario+" texto "+getTexto();
        }
    }
}
