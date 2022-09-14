class CadastroModeloService {
    getAll() {
        return http.get('/allModelo');
    }
    create(data) {
        return http.post("/modelo", data);
    }
    delete(data) {
        return http.delete("/deleteModelo", data);
    }
    findByNomeModelo(data) {
        return http.get("/nomeModelo", data);
    }
    findByAnoFabricado(data) {
        return http.get("/anoModelo", data);
    }
    
   
}

export default new CadastroModeloService();