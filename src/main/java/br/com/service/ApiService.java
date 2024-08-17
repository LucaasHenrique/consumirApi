package br.com.service;

import br.com.dto.EnderecoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    EnderecoDTO enderecoDTO;

    public EnderecoDTO getEndereco(String cep) throws IOException, InterruptedException {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://brasilapi.com.br/api/cep/v1/" + cep)).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            enderecoDTO = mapper.readValue(response.body(), EnderecoDTO.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return enderecoDTO;
    }
}
