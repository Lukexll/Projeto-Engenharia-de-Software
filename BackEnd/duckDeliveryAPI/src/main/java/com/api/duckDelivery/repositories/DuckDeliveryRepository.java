package com.api.duckDelivery.repositories;

import com.api.duckDelivery.models.DuckDeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
//Jpa, possui metodos prontos para transação com o banco de dados.(Ex: exist...)
//Nessa interface, pode ser utilizada para colocar funções que serão implementadas
// para acessar alguma informação do banco. como verificar se alguma loja ja tem cadastro.
@Repository
public interface DuckDeliveryRepository extends JpaRepository<DuckDeliveryModel, UUID> {
}
