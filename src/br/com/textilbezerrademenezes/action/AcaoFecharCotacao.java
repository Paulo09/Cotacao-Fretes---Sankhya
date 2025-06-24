package br.com.textilbezerrademenezes.action;

import java.math.BigDecimal;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.extensions.actionbutton.QueryExecutor;
import br.com.sankhya.extensions.actionbutton.Registro;

public class AcaoFecharCotacao implements AcaoRotinaJava {
	@Override
	public void doAction(ContextoAcao contexto) throws Exception {
		String usuLogado = contexto.getUsuarioLogado().toString();
		Registro[] linhas = contexto.getLinhas();

	   for (Registro registro : linhas) {
	   try {
		   BigDecimal nuCotacao = (BigDecimal) registro.getCampo("IDCOTACAO");
		    
		   if (contexto.getLinhas() != null && !contexto.getLinhas().toString().isEmpty() ) {
				
				QueryExecutor query = contexto.getQuery();
				 query.update("UPDATE AD_COTACAOFRETE "
				 		     +" SET STATUSCOTACAO = 'FECHADA'"
				 		     +"where IDCOTACAO ="+nuCotacao);
				 contexto.setMensagemRetorno("Cotação, Número:"+nuCotacao+" Aprovada com Sucesso!!!");
			}else{
				contexto.setMensagemRetorno("Sem cotação a serem Aprovadas!!!");
			}
		   
	} catch (Exception e) {
		contexto.setMensagemRetorno("Erro!: "+e.getMessage());
	}finally{
	}
		
		
	}
  }
}
