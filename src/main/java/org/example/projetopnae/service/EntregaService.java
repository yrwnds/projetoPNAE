package org.example.projetopnae.service;

import org.example.projetopnae.model.entrega.Entrega;
import org.example.projetopnae.model.entrega.EntregaRepository;
import org.example.projetopnae.model.usuario.Usuario;
import org.example.projetopnae.model.usuario.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class EntregaService {
    private final EntregaRepository EntregaRepository;
    private final UsuarioRepository usuarioRepository;

    public EntregaService(EntregaRepository EntregaRepository, UsuarioRepository usuarioRepository) {
        this.EntregaRepository = EntregaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Entrega entrega) {
        String usuemail = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Usuario usulogado = this.usuarioRepository.findByEmail(usuemail);
        entrega.setUsuario(usulogado);
        this.EntregaRepository.save(entrega);
    }

    public List<Entrega> findAll() {
        return this.EntregaRepository.findAll();
    }

    public Entrega getEntrega(Long id) {
        return this.EntregaRepository.findById(id).get();
    }

    public List<Entrega> getDataAsc(){
        return this.EntregaRepository.findAllByOrderByDataentregaAsc();
    }

    public List<Entrega> getDataDesc(){
        return this.EntregaRepository.findAllByOrderByDataentregaDesc();
    }

    public List<Entrega> findByDataBetween(String start, String end){

        start += " 00:00:00.0";
        end += " 23:59:59.0";

        Timestamp timestampStart = Timestamp.valueOf(start);
        Timestamp timestampEnd = Timestamp.valueOf(end);

        return this.EntregaRepository.findByDataentregaBetween(timestampStart, timestampEnd);
    }

    public List<Entrega> findByData(String data){
        data += " 00:00:00.0";
        Timestamp dataTs = Timestamp.valueOf(data);
        return this.EntregaRepository.findByDataentrega(dataTs);
    }

    public void delete(Long id) {
        this.EntregaRepository.deleteById(id);
    }

    public void update(Entrega entrega) {
        Entrega t = this.EntregaRepository.getReferenceById(entrega.getId());
        t.setDataentrega(entrega.getDataentrega());
        t.setEdital(entrega.getEdital());
        this.EntregaRepository.save(t);
    }
}
