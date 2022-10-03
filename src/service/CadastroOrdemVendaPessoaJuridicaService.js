import http from "@/common/http";

class CadastroOrdemVendaPessoaJuridicaService{
    getAll() {
        return http.get('/allOrdemJuridica');
    }
    create(data) {
        return http.post("/ordemPessoaJuridica", data);
    }
    cancelarVenda(id) {
        return http.delete(`/cancelarVendaJuridica/${id}`);
    }
    deleteById(data) {
        return http.delete("/deleteOrdemJuridico", data);
    }
    findByIdOrdemJuridico(data) {
        return http.get("/idOrdemJuridico", data);
    }
    findByPagoOrdemFisica(data) {
        return http.get("/pagoOrdemJuridico", data);
    }
    
   
}

export default new CadastroOrdemVendaPessoaJuridicaService();