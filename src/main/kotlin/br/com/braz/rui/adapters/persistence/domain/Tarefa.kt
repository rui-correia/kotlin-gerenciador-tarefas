package br.com.braz.rui.adapters.persistence.domain

import br.com.braz.rui.NovaTarefaRequest
import br.com.braz.rui.NovaTarefaResponse
import br.com.braz.rui.TarefaStatus
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "t_tarefa")
data class Tarefa(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        var id: String?,
        var nome: String,
        var descricao: String,
        var tempo: String,
        var dataInicio: String,
        var status: TarefaStatus = TarefaStatus.TODO
) {
        constructor(): this(null, String(),String(),String(),String())

        constructor(tarefaRequest: NovaTarefaRequest) :
                this(null, tarefaRequest.nome, tarefaRequest.descricao, tarefaRequest.tempo, tarefaRequest.dataInicio)



        //TODO - Melhorar depois
        fun toResponse() : NovaTarefaResponse {
                return NovaTarefaResponse.newBuilder()
                        .setId(this.id!!)
                        .setNome(this.nome)
                        .build()
        }
}
