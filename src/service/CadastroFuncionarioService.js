import http from "@/common/http";

class CadastroFuncionarioService {
    getAll() {
        return http.get('/allClienteFuncionario');
    }
    create(data) {
        return http.post("/funcionario", data);
    }
}
export default new CadastroFuncionarioService();