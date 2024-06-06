import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Auditoria from 'App/Models/Auditoria';
import Empresa from 'App/Models/Empresa';

export default class EmpresasController {
    public async post({ request, response, auth }: HttpContextContract) {
        const body = request.body();

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Cadastrou Empresa: ${body.razao_social}`,
        };

        await Auditoria.create(auditoria);

        await Empresa.create(body);

        response.status(201)
        return {
            msg: "Empresa criada com sucesso!",
            empresa: body
        }
    }

    public async get({ response, auth }: HttpContextContract) {

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: 'Acesso Empresas',
        };

        await Auditoria.create(auditoria);

        response.status(200);
        return Empresa.all();
    }

    public async getID({ response, params, auth }: HttpContextContract) {
        const empresa = Empresa.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Acesso Empresa: ${(await empresa).razao_social}`,
        };

        await Auditoria.create(auditoria);

        response.status(200);
        return empresa;
    }

    public async update({ response, request, params, auth }: HttpContextContract) {
        const empresa = Empresa.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Atualizou Empresa: ${(await empresa).razao_social}`,
        };

        await Auditoria.create(auditoria);

        const body = request.body();

        (await empresa).razao_social = body.razao_social;
        (await empresa).cnpj = body.cnpj;
        (await empresa).nome_fantasia = body.nome_fantasia;
        (await empresa).representante = body.representante;
        (await empresa).contato = body.contato;

        response.status(201);
        return {
            msg: "Empresa atualizada com sucesso!",
            empresa: body
        }
    }

    public async delete({ response, params, auth }: HttpContextContract) {
        const empresa = Empresa.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Deletou Empresa: ${(await empresa).razao_social}`,
        };

        await Auditoria.create(auditoria);

        (await empresa).delete();

        response.status(201);

        return {
            msg: "Empresa deletada com sucesso!",
            empresa
        }
    }
}