import { test } from '@japa/runner';
import supertest from 'supertest';

const BASE_URL_LOGIN = `http://${process.env.HOST}:${process.env.PORT}`;
const BASE_URL = `http://${process.env.HOST}:${process.env.PORT}/api`;

let authToken = '';

test.group('Empresas CRUD', (group) => {
    group.setup(async () => {
        // Autenticar usuário e obter token
        const authResponse = await supertest(BASE_URL_LOGIN).post('/login').send({
            email: 'vitortecnologia62@gmail.com',
            password: 'vitorcosta'
        });

        authToken = authResponse.body.token;  // Supondo que o token é retornado no campo 'token'
    });

    const empresa = {
        id: 0,
        razao_social: 'VetePet LTDA',
        nome_fantasia: 'VetePet',
        cnpj: '28.321.614/0001-94',
        representante: 'Daniel',
        contato: '(86) 99634-7814'
    };

    test('Empresa POST', async ({ assert }) => {
        try {
            const response = await supertest(BASE_URL)
                .post('/empresas')
                .set('Authorization', `Bearer ${authToken}`)
                .send(empresa);
            assert.equal(response.status, 201);
        } catch (error) {
            assert.fail("Não foi possivel cadastrar empresa: " + error);
        }
    });

    test('Empresas', async ({ assert }) => {
        try {
            const response = await supertest(BASE_URL)
                .get('/empresas')
                .set('Authorization', `Bearer ${authToken}`);
            assert.equal(response.status, 200);
        } catch (error) {
            assert.fail("Não foi possivel buscar empresas: " + error);
        }
    });

    test('Empresa Id', async ({ assert }) => {
        try {
            const response = await supertest(BASE_URL)
                .get('/empresas/0')
                .set('Authorization', `Bearer ${authToken}`);
            assert.equal(response.status, 200);
        } catch (error) {
            assert.fail("Não foi possivel encontrar o cadastro do empresa: " + error);
        }
    });

    test('Empresa PUT', async ({ assert }) => {
        try {
            const response = await supertest(BASE_URL)
                .put('/empresas/0')
                .set('Authorization', `Bearer ${authToken}`)
                .send({ empresa: "VetPet LTDA" });
            assert.equal(response.status, 201);
        } catch (error) {
            assert.fail("Não foi possivel cadastrar empresa: " + error);
        }
    });

    test('Delete empresa Id', async ({ assert }) => {
        try {
            const response = await supertest(BASE_URL)
                .delete('/empresas/0')
                .set('Authorization', `Bearer ${authToken}`);
            assert.equal(response.status, 201);
        } catch (error) {
            assert.fail("Não foi possivel deletar empresa: " + error);
        }
    });
});