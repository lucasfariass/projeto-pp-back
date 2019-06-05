package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Consulta;

public interface ConsultaRepository extends PagingAndSortingRepository<Consulta, Long> , JpaSpecificationExecutor<Consulta>{
	

}
