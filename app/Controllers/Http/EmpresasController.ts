import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Empresa from 'App/Models/Empresa';

export default class EmpresasController {
    public async post({request, response}: HttpContextContract){
        const body = request.body();

        await Empresa.create(body);

        response.status(201)
        return{
            msg: "Empresa criada com sucesso!",
            empresa: body
        }
    }

    public async get({response}: HttpContextContract){
        response.status(200);
        return Empresa.all();
    }

    public async getID({response, params}: HttpContextContract){
        response.status(200);
        return Empresa.findOrFail(params.id);
    }

    public async update({response, request, params}: HttpContextContract){
        const empresa = Empresa.findOrFail(params.id);
        const body = request.body();

        (await empresa).razao_social = body.razao_social;
        (await empresa).cnpj = body.cnpj;
        (await empresa).nome_fantasia = body.nome_fantasia;
        (await empresa).representante = body.representante;
        (await empresa).contato = body.contato;

        response.status(201);
        return{
            msg: "Empresa atualizada com sucesso!",
            empresa: body
        }
    }

    public async delete({response, params}: HttpContextContract){
        const empresa = Empresa.findOrFail(params.id);

        (await empresa).delete();

        response.status(201);

        return{
            msg: "Empresa Atualizada com sucesso",
            empresa
        }
    }
}
