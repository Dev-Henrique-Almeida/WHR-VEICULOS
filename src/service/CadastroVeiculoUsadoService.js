import http from "@/common/http";

class CadastroVeiculoUsadoService {
    getAll() {
        return http.get('/allVeiculoUsado');
    }
    create(data) {
        return http.post("/VeiculoUsado", data);
    }
    update(id, data) {
        return http.put(`/updateVeiculoUsado/${id}`, data);
    }
    deleteById(id) {
        return http.delete(`/deleteVeiculoUsado/${id}`);
    }
    delete(data) {
        return http.delete("/deleteVeiculoUsado", data);
    }
    findAllByVendidoVeiculoUsado(){
        return http.get('/AllVeiculoUsadoVendido');
    }
}

export default new CadastroVeiculoUsadoService();