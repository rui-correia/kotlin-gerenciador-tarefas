package br.com.braz.rui.adapters.persistence.repository

import io.micronaut.data.annotation.Repository
import br.com.braz.rui.adapters.persistence.domain.Tarefa
import io.micronaut.data.repository.PageableRepository

@Repository
interface TarefaRepository: PageableRepository<Tarefa, String> {
}