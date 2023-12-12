import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Produto from 'App/Models/Produto';

export default class ProdutosController {
    public async post({ request, response }: HttpContextContract) {
        const body = request.body();

        await Produto.create(body);

        response.status(201);
        return {
            msg: "Produto cadastrado com sucesso!",
            produto: body
        }
    }

    public async get({ response }: HttpContextContract) {
        response.status(200);
        return Produto.all();
    }

    public async getID({ response, params }: HttpContextContract) {
        response.status(200);
        return Produto.findOrFail(params.id);
    }

    public async update({ response, params, request }: HttpContextContract) {
        const produto = Produto.findOrFail(params.id);
        const body = request.body();

        (await produto).produto = body.produto;
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

    public async delete({ response, params }: HttpContextContract) {
        const produto = Produto.findOrFail(params.id);

        (await produto).delete();

        response.status(201);

        return {
            msg: "Produto deletado com sucesso!",
            produto
        }
    }
}
