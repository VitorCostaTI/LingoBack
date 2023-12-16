import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Auditoria from 'App/Models/Auditoria';
import Produto from 'App/Models/Produto';

export default class ProdutosController {
    public async post({ request, response, auth }: HttpContextContract) {
        const body = request.body();

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Cadastrou produto: ${body.produto}`,
        };

        await Auditoria.create(auditoria);

        await Produto.create(body);

        response.status(201);
        return {
            msg: "Produto cadastrado com sucesso!",
            produto: body
        }
    }

    public async get({ response, auth }: HttpContextContract) {
        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: 'Acesso Produtos',
        };

        await Auditoria.create(auditoria);
        response.status(200);
        return Produto.all();
    }

    public async getID({ response, params, auth }: HttpContextContract) {
        const produto = Produto.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Acessou Produto: ${(await produto).produto}`,
        };

        await Auditoria.create(auditoria);

        response.status(200);
        return Produto.findOrFail(params.id);
    }

    public async update({ response, params, request, auth }: HttpContextContract) {
        const produto = Produto.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Acessou Produto: ${(await produto).produto}`,
        };

        await Auditoria.create(auditoria);

        const body = request.body();

        (await produto).produto = body.produto;
        (await produto).categoria = body.categoria;
        (await produto).fornecedor = body.fornecedor;
        (await produto).preco = body.preco;
        (await produto).investimento = body.investimento;
        (await produto).quantidade = body.quantidade;
        (await produto).codigo_produto = body.codigo_produto;

        response.status(201);

        return {
            msg: "Produto cadastrado com sucesso",
            produto: body
        }
    }

    public async delete({ response, params, auth }: HttpContextContract) {
        const produto = Produto.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Acessou Produto: ${(await produto).produto}`,
        };

        await Auditoria.create(auditoria);

        (await produto).delete();

        response.status(201);

        return {
            msg: "Produto deletado com sucesso!",
            produto
        }
    }
}
