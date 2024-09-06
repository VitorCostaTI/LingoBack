import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Auditoria from 'App/Models/Auditoria'

export default class AuditoriasController {
    public async get({ response }: HttpContextContract) {
        try {
            response.status(200);
            return Auditoria.all();
        } catch (error) {
            return response.status(500).json({ msg: 'Não foi possivel requisitar auditoria', error })
        }
    }
}