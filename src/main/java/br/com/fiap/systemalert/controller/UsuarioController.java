package br.com.fiap.systemalert.controller;

import br.com.fiap.systemalert.dto.UsuarioCadastroDTO;
import br.com.fiap.systemalert.dto.UsuarioExibicaoDTO;
import br.com.fiap.systemalert.model.Usuario;
import br.com.fiap.systemalert.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioExibicaoDTO> salvar(@Valid  @RequestBody UsuarioCadastroDTO usuario){
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorId(@PathVariable Long usuarioId){
        return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId){
        usuarioService.excluir(usuarioId);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }

    @RequestMapping(value = "/usuarios", params = "email")
    @ResponseStatus(HttpStatus.OK)
    public UserDetails buscarPorEmail(@RequestParam String email){
        return usuarioService.buscarPorEmail(email);
    }
}