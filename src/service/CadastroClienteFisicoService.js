import http from "@/common/http";

class CadastroClienteFisicoService {
    getAll() {
        return http.get('/allClienteFisico');
    }
    update(id, data) {
        return http.put(`/updateClienteFisico/${id}`, data);
    }
    create(data) {
        return http.post("/clienteFisico", data);
    }
    deleteById(id) {
        return http.delete(`/deleteClienteFisico/${id}`);
    }
    
    findByCpf(data) {
        return http.get("/cpfClienteFisico", data);
    }
    findByNome(data) {
        return http.get("/nomeClienteFisico", data);
    }
   
}

export default new CadastroClienteFisicoService();