import http from "@/common/http";

class CadastroClienteJuridicoService {
    getAll() {
        return http.get('/allClienteJuridico');
    }
    create(data) {
        return http.post("/clienteJuridico", data);
    }

    update(id, data) {
        return http.put(`/updateClienteJuridico/${id}`, data);
    }
    deleteById(id) {
        return http.delete(`/deleteClienteJuridico/${id}`);
    }

    findByNomeFantasia(data){
        return http.get("/nomeClienteJuridico", data);
    }
    findByCnpj(data){
        return http.get("/cnpjClienteJuridico", data);
    }
}
export default new CadastroClienteJuridicoService();