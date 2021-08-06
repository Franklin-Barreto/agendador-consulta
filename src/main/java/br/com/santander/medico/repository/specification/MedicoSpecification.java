package br.com.santander.medico.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.santander.medico.model.Medico;

public class MedicoSpecification {

	public static Specification<Medico> porNome(String nome) {
		return (root, query, builder) -> nome != null ? builder.like(root.get("nome"), "%" + nome + "%") : null;
	}

	public static Specification<Medico> porCrm(String crm) {
		return (root, query, builder) -> crm != null ? builder.equal(root.get("crm"), crm) : null;
	}

	public static Specification<Medico> porNumero(String numero) {
		return (root, query, builder) -> numero != null
				? builder.equal(
						root
						.join("contato")
						.join("telefone")
						.get("numero"), numero)
				: null;
	}

}
