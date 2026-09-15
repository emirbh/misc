package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.CreditDerivative4__1;
import iso20022.auth030.asic.Tranche3;
import iso20022.auth030.asic.TrancheIndicator3Choice__1;
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
	public CreditDerivative4__1 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetCdtDefault extends GetCdt {
		@Override
		protected CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(ASICTransactionReport drrReport) {
			CreditDerivative4__1.CreditDerivative4__1Builder cdt = CreditDerivative4__1.builder();
			return assignOutput(cdt, drrReport);
		}
		
		protected CreditDerivative4__1.CreditDerivative4__1Builder assignOutput(CreditDerivative4__1.CreditDerivative4__1Builder cdt, ASICTransactionReport drrReport) {
			cdt = toBuilder(CreditDerivative4__1.builder()
				.setIndxFctr(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", aSICTransactionReport -> aSICTransactionReport.getIndexFactor()).get())
				.setTrch(TrancheIndicator3Choice__1.builder()
					.setTrnchd(Tranche3.builder()
						.setAttchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", aSICTransactionReport -> aSICTransactionReport.getCdSIndexAttachmentPoint()).get())
						.setDtchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", aSICTransactionReport -> aSICTransactionReport.getCdSIndexDetachmentPoint()).get())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(cdt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
