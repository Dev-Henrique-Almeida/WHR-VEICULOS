import http from "@/common/http";

class CadastroClienteService {
    getAll() {
        return http.get('/allClienteFisico');
    }
    create(data) {
        return http.post("/clienteFisico", data);
    }
}
export default new CadastroClienteService();