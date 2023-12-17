import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Estoque from 'App/Models/Estoque'

export default class EstoquesController {
    public async get({response}: HttpContextContract){
        response.status(200);
        return await Estoque.all();
    }
}
