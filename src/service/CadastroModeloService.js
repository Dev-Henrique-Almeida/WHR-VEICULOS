import http from "@/common/http";

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
    findById(id) {
        return http.get(`/idModelo/${id}`);
    }
    findByAnoFabricado(data) {
        return http.get("/anoModelo", data);
    }


   
    
   
}

export default new CadastroModeloService();