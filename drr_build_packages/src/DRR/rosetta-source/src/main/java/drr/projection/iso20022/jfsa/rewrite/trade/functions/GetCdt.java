package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.SeniorityEnum;
import iso20022.auth030.jfsa.CreditDerivative4__1;
import iso20022.auth030.jfsa.DebtInstrumentSeniorityType2Code;
import iso20022.auth030.jfsa.DerivativePartyIdentification1Choice;
import iso20022.auth030.jfsa.Tranche3;
import iso20022.auth030.jfsa.TrancheIndicator3Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetCdt.GetCdtDefault.class)
public abstract class GetCdt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return cdt 
	*/
	public CreditDerivative4__1 evaluate(JFSATransactionReport drrReport) {
		CreditDerivative4__1.CreditDerivative4__1Builder cdtBuilder = doEvaluate(drrReport);
		
		final CreditDerivative4__1 cdt;
		if (cdtBuilder == null) {
			cdt = null;
		} else {
			cdt = cdtBuilder.build();
			objectValidator.validate(CreditDerivative4__1.class, cdt);
		}
		
		return cdt;
	}

	protected abstract CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetCdtDefault extends GetCdt {
		@Override
		protected CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(JFSATransactionReport drrReport) {
			CreditDerivative4__1.CreditDerivative4__1Builder cdt = CreditDerivative4__1.builder();
			return assignOutput(cdt, drrReport);
		}
		
		protected CreditDerivative4__1.CreditDerivative4__1Builder assignOutput(CreditDerivative4__1.CreditDerivative4__1Builder cdt, JFSATransactionReport drrReport) {
			cdt = toBuilder(CreditDerivative4__1.builder()
				.setSnrty(MapperS.of(drrReport).<SeniorityEnum>map("getSeniority", jFSATransactionReport -> jFSATransactionReport.getSeniority()).checkedMap("to-enum", e -> DebtInstrumentSeniorityType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setRefPty(DerivativePartyIdentification1Choice.builder()
					.setLei(MapperS.of(drrReport).<String>map("getReferenceEntity", jFSATransactionReport -> jFSATransactionReport.getReferenceEntity()).get())
					.build())
				.setSrs(MapperS.of(drrReport).<Integer>map("getSeries", jFSATransactionReport -> jFSATransactionReport.getSeries()).get())
				.setVrsn(MapperS.of(drrReport).<Integer>map("getSeriesVersion", jFSATransactionReport -> jFSATransactionReport.getSeriesVersion()).get())
				.setIndxFctr(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", jFSATransactionReport -> jFSATransactionReport.getIndexFactor()).get())
				.setTrch(TrancheIndicator3Choice__1.builder()
					.setTrnchd(Tranche3.builder()
						.setAttchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", jFSATransactionReport -> jFSATransactionReport.getCdSIndexAttachmentPoint()).get())
						.setDtchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", jFSATransactionReport -> jFSATransactionReport.getCdSIndexDetachmentPoint()).get())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(cdt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
