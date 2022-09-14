import http from "@/common/http";

class CadastroFuncionarioService {
    getAll() {
        return http.get('/allFuncionario');
    }
    create(data) {
       
        return http.post("/funcionario", data);
    }
    deleteByCpf(data) {
        return http.delete("/deleteFuncionario", data);
    }
    findByNomeFuncionario(data) {
        return http.get("/nomeFuncionario", data);
    }
    findByCpfFuncionario(data) {
        return http.get("/cpfFuncionario", data);
    }

}
export default new CadastroFuncionarioService();