import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext';

import Auditoria from 'App/Models/Auditoria';
import Estoque from 'App/Models/Estoque';

export default class EstoquesController {
    public async get({ response }: HttpContextContract) {
        try {
            // Obtenha os registros brutos antes do preload
            const estoques = await Estoque.query()

            // Adicione este log para depurar
            console.log('Estoques antes do preload:', estoques)

            // Realize o preload para cada instância na coleção
            const estoquesComUsuario = await Promise.all(
                estoques.map(async (estoque) => {
                    await estoque.load('usuario')
                    return estoque
                })
            )

            // Adicione este log para depurar   
            console.log('Estoques após o preload:', estoquesComUsuario)

            // Retorne os resultados
            return response.json(estoquesComUsuario)
        } catch (error) {
            // Adicione este log para depurar em caso de erro
            console.error('Erro ao buscar estoques:', error.message)
            return response.status(500).json({ error: 'Erro interno do servidor' })
        }
    }

    public async post({ request, response, auth }: HttpContextContract) {
        const body = request.body();

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Registrou estoque: ${body.produto}`,
        };

        await Auditoria.create(auditoria);

        await Estoque.create(body);

        response.status(201);
        return {
            msg: "Estoque registrado com sucesso",
            // body
        }
    }
}
