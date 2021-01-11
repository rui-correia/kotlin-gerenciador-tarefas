package br.com.braz.rui.grpc.endpoint

import br.com.braz.rui.*
import br.com.braz.rui.application.service.TarefaService
import javax.inject.Singleton

@Singleton
class TarefaEndpoint(val tarefaService: TarefaService) : NovaTarefaGrpcKt.NovaTarefaCoroutineImplBase() {

    override suspend fun send(request: NovaTarefaRequest): NovaTarefaResponse {
        val tarefa = tarefaService.criarTarefa(request)
        return tarefa.toResponse()
    }
}