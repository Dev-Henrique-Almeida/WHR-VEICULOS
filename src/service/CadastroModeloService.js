import http from "@/common/http";

class CadastroModeloService {
    getAll() {
        return http.get('/allModelo');
    }
    create(data) {
        return http.post("/modelo", data);
    }
    update(id, data) {
        return http.put(`/updateModelo/${id}`, data);
    }
    deleteById(id) {
        return http.delete(`/deleteModelo/${id}`);
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