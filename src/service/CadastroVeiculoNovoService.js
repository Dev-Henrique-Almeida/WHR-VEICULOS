import http from "@/common/http";

class CadastroVeiculoNovoService {
    getAll() {
        return http.get('/allVeiculoNovo');
    }
    create(data) {
        return http.post("/veiculoNovo", data);
    }
    update(id, data) {
        return http.put(`/updateVeiculoNovo/${id}`, data);
    }
    deleteById(id) {
        return http.delete(`/deleteVeiculoNovo/${id}`);
    }
    delete(data) {
        return http.delete("/deleteVeiculoNovo", data);
    }
    findByGarantiaFabricaVeiculoNovo(data) {
        return http.get("/garantiaVeiculoNovo", data);
    } 
    findAllByVendidoVeiculoNovo(){
        return http.get('/AllVeiculoNovoVendido');
    }
}

export default new CadastroVeiculoNovoService();