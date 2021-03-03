package br.com.braz.rui.application.service

import br.com.braz.rui.NovaTarefaRequest
import br.com.braz.rui.adapters.persistence.domain.Tarefa
import br.com.braz.rui.adapters.persistence.repository.TarefaRepository
import io.grpc.Status
import javax.inject.Singleton

const val ERRO_TAREFA_SEM_NOME = "Nome da tarefa não pode ficar em branco."
const val ERRO_DESCONHECIDO = "Erro desconhecido."

@Singleton
class TarefaService(private val tarefaRepository: TarefaRepository) {

    fun criarTarefa(request: NovaTarefaRequest): Tarefa {
        val tarefa = Tarefa(request)

        if (tarefa.nome.isBlank()){
            throw buildError("Nome não pode ser branco.")
        }

        return tarefaRepository.save(tarefa)
    }

    private fun buildError(error: String) = when (error) {
        ERRO_TAREFA_SEM_NOME -> Status.FAILED_PRECONDITION
                .withDescription(ERRO_TAREFA_SEM_NOME)
                .asException()

        else -> Status.UNKNOWN
                .withDescription(ERRO_DESCONHECIDO)
                .asException()
    }
}