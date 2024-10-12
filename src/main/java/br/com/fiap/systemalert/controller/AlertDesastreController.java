package br.com.fiap.systemalert.controller;

import br.com.fiap.systemalert.dto.AlertaDesastreCadastroDTO;
import br.com.fiap.systemalert.dto.AlertaDesatreExibicaoDTO;
import br.com.fiap.systemalert.service.AlertaDesastreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AlertDesastreController {

    @Autowired
    private AlertaDesastreService alertaDesastreService;

    @PostMapping("/alerta-desastres")
    @ResponseStatus(HttpStatus.CREATED)
    public AlertaDesatreExibicaoDTO salvar(
            @RequestBody AlertaDesastreCadastroDTO alertaDesastreDTO){
        return alertaDesastreService.salveAlertaDesastre(alertaDesastreDTO);
    }

    @GetMapping("/alerta-desastres/{alertaDesastresId}")
    public ResponseEntity<AlertaDesatreExibicaoDTO> buscarPorId(
            @PathVariable Long alertaDesastresId){
        try {
            return ResponseEntity
                    .ok(alertaDesastreService.buscarPorId(alertaDesastresId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/alerta-desastres/{alertaDesastresId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long alertaDesastresId){
        alertaDesastreService.excluir(alertaDesastresId);
    }

    @PutMapping("/alerta-desastres")
    public ResponseEntity<AlertaDesatreExibicaoDTO> atualizar(
            @RequestBody AlertaDesastreCadastroDTO alertaDesastreDTO){
        try {
            AlertaDesatreExibicaoDTO alertaDesatreExibicaoDTO =
                    alertaDesastreService.atualizar(alertaDesastreDTO);
            return ResponseEntity.ok(alertaDesatreExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/alerta-desastres")
    @ResponseStatus(HttpStatus.OK)
    public Page<AlertaDesatreExibicaoDTO> litarTodos(@PageableDefault(size = 2, page = 0) Pageable paginacao){
        return alertaDesastreService.listarTodos(paginacao);
    }
}