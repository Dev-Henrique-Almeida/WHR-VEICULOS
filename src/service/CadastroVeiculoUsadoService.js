import http from "@/common/http";

class CadastroVeiculoUsadoService {
    getAll() {
        return http.get('/allVeiculoUsado');
    }
    create(data) {
        return http.post("/VeiculoUsado", data);
    }
    delete(data) {
        return http.delete("/deleteVeiculoUsado", data);
    }
}

export default new CadastroVeiculoUsadoService();