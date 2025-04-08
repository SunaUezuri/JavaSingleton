package br.com.fiap.suna.tranquilo.exception;

public class CommitException extends Exception {

    public CommitException() {
        super("Erro ao realizar o commit");
    }

    public CommitException(String msg) {
        super(msg);
    }

}
