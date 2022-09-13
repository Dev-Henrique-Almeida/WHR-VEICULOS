import http from "@/common/http";

class CadastroClienteJuridicoService {
    getAll() {
        return http.get('/allClienteJuridico');
    }
    create(data) {
        return http.post("/clienteJuridico", data);
    }
}
export default new CadastroClienteJuridicoService();