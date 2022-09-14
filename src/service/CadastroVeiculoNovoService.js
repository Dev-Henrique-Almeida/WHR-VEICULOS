class CadastroVeiculoNovoService {
    getAll() {
        return http.get('/allVeiculoNovo');
    }
    create(data) {
        return http.post("/veiculoNovo", data);
    }
    delete(data) {
        return http.delete("/deleteVeiculoNovo", data);
    }
    findByGarantiaFabricaVeiculoNovo(data) {
        return http.get("/garantiaVeiculoNovo", data);
    } 
}

export default new CadastroVeiculoNovoService();