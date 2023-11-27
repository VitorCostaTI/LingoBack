import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Usuario from 'App/Models/Usuario';

export default class UsuariosController {
    public async post({request, response}: HttpContextContract){
        const body = request.body();

        await Usuario.create(body);

        response.status(201);

        return{
            msg: "Usuario adicionado com sucesso",
            produto: body
        }
    }
}
