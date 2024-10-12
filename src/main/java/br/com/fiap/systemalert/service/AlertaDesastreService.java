package br.com.fiap.systemalert.service;

import br.com.fiap.systemalert.dto.AlertaDesastreCadastroDTO;
import br.com.fiap.systemalert.dto.AlertaDesatreExibicaoDTO;
import br.com.fiap.systemalert.model.AlertaDesastre;
import br.com.fiap.systemalert.repository.AlertaDesastreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AlertaDesastreService {

    @Autowired
    private AlertaDesastreRepository alertaDesastreRepository;

    public AlertaDesatreExibicaoDTO salveAlertaDesastre(AlertaDesastreCadastroDTO alertaDesastreDTO){
        AlertaDesastre alertaDesastre = new AlertaDesastre();
        BeanUtils.copyProperties(alertaDesastreDTO, alertaDesastre);

        alertaDesastre.setData(new Date());

        AlertaDesastre alertaDesastreSalvo = alertaDesastreRepository.save(alertaDesastre);
        return new AlertaDesatreExibicaoDTO(alertaDesastreSalvo);

    }

    public AlertaDesatreExibicaoDTO buscarPorId(Long id){
        Optional<AlertaDesastre> alertaDesastreOptional =
                alertaDesastreRepository.findById(id);

        if (alertaDesastreOptional.isPresent()){
            return new AlertaDesatreExibicaoDTO(alertaDesastreOptional.get());
        } else {
            throw new RuntimeException("AlertaDesastre não existe!");
        }
    }


    public void excluir(Long id){
        Optional<AlertaDesastre> alertaDesastreOptional =
                alertaDesastreRepository.findById(id);

        if (alertaDesastreOptional.isPresent()){
            alertaDesastreRepository.delete(alertaDesastreOptional.get());
        } else {
            throw new RuntimeException("AlertaDesastre não encontrado!");
        }
    }

    public AlertaDesatreExibicaoDTO atualizar(AlertaDesastreCadastroDTO alertaDesastreDTO){
        Optional<AlertaDesastre> alertaDesastreOptional =
                alertaDesastreRepository.findById(alertaDesastreDTO.alertaDesastreId());

        if (alertaDesastreOptional.isPresent()){
            AlertaDesastre alertaDesastre = new AlertaDesastre();
            BeanUtils.copyProperties(alertaDesastreDTO, alertaDesastre);

            return new AlertaDesatreExibicaoDTO(alertaDesastreRepository.save(alertaDesastre));
        } else {
            throw new RuntimeException("AlertaDesastre não encontrado!");
        }
    }

    public Page<AlertaDesatreExibicaoDTO> listarTodos(Pageable paginacao){
        return alertaDesastreRepository
                .findAll(paginacao)
                .map(AlertaDesatreExibicaoDTO::new);
    }

}