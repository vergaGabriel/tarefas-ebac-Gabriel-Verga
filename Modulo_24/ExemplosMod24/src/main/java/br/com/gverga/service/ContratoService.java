package br.com.gverga.service;

import br.com.gverga.dao.IContratoDao;
import br.com.gverga.service.IContratoService;

public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Sucesso";
    }
}
