import http from "@/common/http";

class CadastroClienteService {
    getAll() {
        return http.get('/pegaCliente');
    }
    create(data) {
        return http.post("/CadastroCliente", data);
    }
}
export default new CadastroClienteService();