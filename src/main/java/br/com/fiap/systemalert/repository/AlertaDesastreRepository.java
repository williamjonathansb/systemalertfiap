package br.com.fiap.systemalert.repository;

import br.com.fiap.systemalert.model.AlertaDesastre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaDesastreRepository extends JpaRepository<AlertaDesastre, Long> {
}