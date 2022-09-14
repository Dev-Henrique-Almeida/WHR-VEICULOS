import http from "@/common/http";

class CadastroClienteFisicoService {
    getAll() {
        return http.get('/allClienteFisico');
    }
    update() {
        return http.update('/clienteFisico');
    }
    create(data) {
        return http.post("/clienteFisico", data);
    }
    deleteByCpf(data) {
        return http.delete("/deleteClienteFisico", data);
    }
    findByCpf(data) {
        return http.get("/cpfClienteFisico", data);
    }
    findByNome(data) {
        return http.get("/nomeClienteFisico", data);
    }
   
}

export default new CadastroClienteFisicoService();