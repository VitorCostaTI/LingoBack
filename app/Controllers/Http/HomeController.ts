import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'

export default class HomeController {
  public async index({ view }: HttpContextContract) {
    const uptimeSeconds = Math.floor(process.uptime());
    return view.render('home', { uptimeSeconds });
  }
}
