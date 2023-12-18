import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext';

import Auditoria from 'App/Models/Auditoria';
import Estoque   from 'App/Models/Estoque';

export default class EstoquesController {
    public async get({response}: HttpContextContract){
        response.status(200);
        return await Estoque.all();
    }

    public async post({request, response, auth}: HttpContextContract){
        const body = request.body();
        
        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Registrou estoque: ${body.produto}`,
        };
        
        await Auditoria.create(auditoria);

        await Estoque.create(body);
        
        response.status(201);
        return{
            msg: "Estoque registrado com sucesso",
            body
        }
    }
}
