import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Auditoria from 'App/Models/Auditoria';
import Cliente from 'App/Models/Cliente';

export default class ClientesController {
    public async post({ request, response, auth }: HttpContextContract) {
        const body = request.body();

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Cadastrou cliente: ${body.cliente}`,
        };

        await Auditoria.create(auditoria);

        await Cliente.create(body);

        response.status(201);
        return {
            msg: "Cliente cadastrado com sucesso!",
            cliente: body
        }
    }

    public async get({ response, auth }: HttpContextContract) {

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: 'Acesso Clientes',
        };

        await Auditoria.create(auditoria);

        response.status(200);
        return Cliente.all();
    }

    public async getID({ params, response, auth }: HttpContextContract) {
        const cliente = Cliente.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Acesso Cliente: ${(await cliente).cliente}`,
        };

        await Auditoria.create(auditoria);

        response.status(200);
        return cliente
    }

    public async update({ params, request, response, auth }: HttpContextContract) {
        const cliente = Cliente.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Atualizou Cliente: ${(await cliente).cliente}`,
        };

        await Auditoria.create(auditoria);

        const body = request.body();

        (await cliente).cliente = body.cliente;
        (await cliente).cpf = body.cpf;
        (await cliente).email = body.email;
        (await cliente).telefone1 = body.telefone1;
        (await cliente).telefone2 = body.telefone2;
        (await cliente).cep = body.cep;
        (await cliente).logradouro = body.logradouro;
        (await cliente).bairro = body.bairro;
        (await cliente).cidade = body.cidade;
        (await cliente).estado = body.estado;
        (await cliente).complemento = body.complemento;

        (await cliente).save();

        response.status(201);

        return {
            msg: "Cliente atualizado com sucesso!",
            cliente: body
        }
    }

    public async delete({ params, response, auth }: HttpContextContract) {
        const cliente = Cliente.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Deletou Cliente: ${(await cliente).cliente}`,
        };

        await Auditoria.create(auditoria);
        (await cliente).delete();

        response.status(201);
        return {
            msg: "Cliente deletado com sucesso!",
            cliente
        }
    }
}