package com.example.algamoney.api.event.listener;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent){

        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();

        //Pegar a URI da requisição atual, adicionar o código e adicionar o código na URI.
        adicionarHeaderLocation(response, codigo);
    }

    //Header Location
    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo).toUri();
        response.setHeader("Location:",uri.toASCIIString());
    }
}
