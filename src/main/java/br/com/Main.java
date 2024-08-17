package br.com;

import br.com.dto.EnderecoDTO;
import br.com.service.ApiService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ApiService api = new ApiService();
        EnderecoDTO end;

        try {
            end = api.getEndereco("68515000");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(end.getCity());
    }
}