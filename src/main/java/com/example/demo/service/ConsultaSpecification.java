package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Consulta;

public class ConsultaSpecification {

	public static Specification<Consulta> byFilter(Long id, String data) {
		return new Specification<Consulta>() {

			@Override
			public Predicate toPredicate(Root<Consulta> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> parametros = new ArrayList<>();

				if (id != null) {
					parametros.add(cb.equal(root.get("medico").get("id"), id));
				}
				if (data != null && !data.isEmpty()) {
					parametros.add(cb.equal(root.get("data"), data));
				}
				return cb.and(parametros.toArray(new Predicate[parametros.size()]));
			}

		};
	}

}
