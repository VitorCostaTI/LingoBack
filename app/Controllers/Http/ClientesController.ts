import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Cliente from 'App/Models/Cliente';

export default class ClientesController {
    public async post({request, response}: HttpContextContract){
        const body = request.body();

        await Cliente.create(body);

        response.status(201);
        return{
            msg: "Cliente cadastrado com sucesso!",
            Cliente
        }
    }

    public async get({response}: HttpContextContract){
        response.status(200);
        return Cliente.all;
    }

    public async getID({params, response}: HttpContextContract){
        const cliente =  Cliente.findOrFail(params.id);

        response.status(200);
        return cliente
    }

    public async update({params, request, response}: HttpContextContract){
        const cliente =  Cliente.findOrFail(params.id);
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
    }

    public async delete({request, params, response}: HttpContextContract){
        const cliente = Cliente.findOrFail(params.id);

        (await cliente).delete();

        return{
            msg: "Cliente deletado com sucesso!",
            cliente
        }
    }
}