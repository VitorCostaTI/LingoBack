import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Auditoria from 'App/Models/Auditoria';
import Cliente from 'App/Models/Cliente';
import ClienteValidator from 'App/Validators/ClienteValidator';

export default class ClientesController {
    public async post({ request, response, auth }: HttpContextContract) {
        try {
            const body = request.body();

            const cliente_validator = await request.validate(ClienteValidator);

            const auditoria = {
                colaborador: `${auth.user!.colaborador}`,
                setor: `${auth.user!.setor}`,
                atividade: `Realizou cadastro do cliente: ${cliente_validator.cliente}`,
            };

            await Auditoria.create(auditoria);

            await Cliente.create(body);

            response.status(201);
            return {
                msg: "Cliente cadastrado com sucesso!",
                cliente_validator
            }
        } catch (error) {
            response.status(500).json({ msg: 'Não foi possivel cadastrar cliente', err: error.messages || error })
        }
    }

    public async get({ response, auth }: HttpContextContract) {
        try {
            const auditoria = {
                colaborador: `${auth.user!.colaborador}`,
                setor: `${auth.user!.setor}`,
                atividade: 'Buscou por clientes',
            };

            await Auditoria.create(auditoria);

            response.status(200);
            return Cliente.all();
        } catch (error) {
            response.status(500).json({ msg: 'Não foi possivel buscar os clientes', err: error.message || error })
        }
    }

    public async getID({ params, response, auth }: HttpContextContract) {
        try {
            const cliente = Cliente.findOrFail(params.id);

            const auditoria = {
                colaborador: `${auth.user!.colaborador}`,
                setor: `${auth.user!.setor}`,
                atividade: `Buscou pelo cliente: ${(await cliente).cliente}`,
            };

            await Auditoria.create(auditoria);

            response.status(200);
            return cliente
        } catch (error) {
            response.status(500).json({ msg: 'Não foi possivel buscar o cliente', err: error.message || error })
        }
    }

    public async update({ params, request, response, auth }: HttpContextContract) {
        try {
            const cliente = Cliente.findOrFail(params.id);

            const cliente_validator = await request.validate(ClienteValidator);

            const auditoria = {
                colaborador: `${auth.user!.colaborador}`,
                setor: `${auth.user!.setor}`,
                atividade: `Atualizou o cliente: ${(await cliente).cliente}`,
            };

            await Auditoria.create(auditoria);

            (await cliente).merge(cliente_validator);

            response.status(201);

            return {
                msg: "Cliente atualizado com sucesso!",
                cliente
            }
        } catch (error) {
            response.status(500).json({ msg: 'Não foi possivel atualizar o cliente', err: error.message || error })
        }
    }

    public async delete({ params, response, auth }: HttpContextContract) {
        try {
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
        } catch (error) {
            response.status(500).json({ msg: 'Não foi possivel deletar o cliente', err: error.message || error })

        }
    }
}