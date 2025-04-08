package br.com.fiap.suna.tranquilo.singleton;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {

    // 1- Atributo estatico que armazena a unica instancia
    private static EntityManagerFactory unico;

    // 2-Constructor privado
    private EntityManagerFactorySingleton() {}

    // 3-Metodo estático que cira e retorna uma instância do banco de dados
    public static EntityManagerFactory getInstance() {
        if (unico == null)
            unico = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        return unico;
    }
}
