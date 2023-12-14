import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Auditoria from 'App/Models/Auditoria';
import Pet from 'App/Models/Pet';

export default class PetsController {
    public async post({ request, response, auth }: HttpContextContract) {
        const body = request.body();

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Cadastrou Pet: ${body.pet}`,
        };

        await Auditoria.create(auditoria);

        Pet.create(body);

        response.status(201);
        return {
            msg: "PET criado com sucesso!",
            Pet
        };
    }

    public async get({ response, auth }: HttpContextContract) {

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: 'Acesso Pets',
        };

        await Auditoria.create(auditoria);
        response.status(200);
        return Pet.all();
    }

    public async getID({ params, response, auth }) {
        const pet = Pet.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Acessou Pet: ${(await pet).pet}`,
        };

        await Auditoria.create(auditoria);

        response.status(200);
        return pet;
    }

    public async update({ params, response, request, auth }) {
        const pet = Pet.findOrFail(params.id);


        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Atualizou Pet: ${(await pet).pet}`,
        };

        await Auditoria.create(auditoria);

        const body = request.body();

        (await pet).pet = body.pet
            (await pet).especie = body.especie
                (await pet).raca = body.raca

        response.status(201);
        (await pet).save();
    }

    public async delete({ response, params, auth }: HttpContextContract) {
        const pet = Pet.findOrFail(params.id);

        const auditoria = {
            colaborador: `${auth.user!.colaborador}`,
            setor: `${auth.user!.setor}`,
            atividade: `Deletou Pet: ${(await pet).pet}`,
        };

        await Auditoria.create(auditoria);

        response.status(201)
        return {
            msg: "Pet deletado com sucesso!",
            pet
        }
    }
}