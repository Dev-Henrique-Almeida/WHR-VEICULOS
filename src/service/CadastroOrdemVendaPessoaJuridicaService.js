import http from "@/common/http";

class CadastroOrdemVendaPessoaJuridicaService{
    getAll() {
        return http.get('/allOrdemJuridico');
    }
    create(data) {
        return http.post("/ordemPessoaJuridica", data);
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