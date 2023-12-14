import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Auditoria from 'App/Models/Auditoria'

export default class AuditoriasController {
    public async get({response}: HttpContextContract){
        response.status(200);
        return Auditoria.all();
    }
}
