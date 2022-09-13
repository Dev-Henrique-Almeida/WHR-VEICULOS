import http from "@/common/http";

class CadastroFuncionarioService {
    getAll() {
        return http.get('/allFuncionario');
    }
    create(data) {
        return http.post("/funcionario", data);
    }
}
export default new CadastroFuncionarioService();