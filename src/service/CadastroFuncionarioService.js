import http from "@/common/http";

class CadastroFuncionarioService {
    getAll() {
        return http.get('/allFuncionario');
    }
    create(data) {
       
        return http.post("/funcionario", data);
    }
    update(id, data) {
        return http.put(`/updateFuncionario/${id}`, data);
    }
    deleteById(id) {
        return http.delete(`/deleteFuncionario/${id}`);
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