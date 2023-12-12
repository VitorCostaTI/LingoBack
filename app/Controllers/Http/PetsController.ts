import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Pet from 'App/Models/Pet';

export default class PetsController {
    public async post({request, response}: HttpContextContract){
        const body = request.body();

        Pet.create(body);

        response.status(201);
        return{
            msg: "PET criado com sucesso!",
            Pet
        };
    }

    public async get({response}: HttpContextContract){
        response.status(200);
        return Pet.all;
    }

    public async getID({params, response}){        
        response.status(200);
        return Pet.findOrFail(params.id);
    }

    public async update({params, response, request}){        
        const pet = Pet.findOrFail(params.id);
        const body = request.body();

        (await pet).pet = body.pet
        (await pet).especie = body.especie
        (await pet).raca = body.raca
        
        response.status(201);
        (await pet).save();
    }

    public async delete({response, params}: HttpContextContract){
        const pet = Pet.findOrFail(params.id);

        response.status(201)
        return{
            msg: "Pet deletado com sucesso!",
            pet
        }
    }
}
