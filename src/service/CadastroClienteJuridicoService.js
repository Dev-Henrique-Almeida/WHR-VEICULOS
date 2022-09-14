import http from "@/common/http";

class CadastroClienteJuridicoService {
    getAll() {
        return http.get('/allClienteJuridico');
    }
    create(data) {
        return http.post("/clienteJuridico", data);
    }
    deleteBycnpj(data){
        return http.delete("/deleteClienteJuridico", data);
    }
    findByNomeFantasia(data){
        return http.get("/nomeClienteJuridico", data);
    }
    findByCnpj(data){
        return http.get("/cnpjClienteJuridico", data);
    }
}
export default new CadastroClienteJuridicoService();