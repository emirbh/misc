package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.SeniorityEnum;
import iso20022.auth030.esma.CreditDerivative4__1;
import iso20022.auth030.esma.DebtInstrumentSeniorityType2Code;
import iso20022.auth030.esma.DerivativePartyIdentification1Choice;
import iso20022.auth030.esma.Tranche3;
import iso20022.auth030.esma.TrancheIndicator3Choice;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCdt.GetCdtDefault.class)
public abstract class GetCdt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return cdt 
	*/
	public CreditDerivative4__1 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetCdtDefault extends GetCdt {
		@Override
		protected CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			CreditDerivative4__1.CreditDerivative4__1Builder cdt = CreditDerivative4__1.builder();
			return assignOutput(cdt, drrReport);
		}
		
		protected CreditDerivative4__1.CreditDerivative4__1Builder assignOutput(CreditDerivative4__1.CreditDerivative4__1Builder cdt, ESMAEMIRTransactionReport drrReport) {
			TrancheIndicator3Choice ifThenElseResult = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getTranche", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getTranche()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = TrancheIndicator3Choice.builder()
					.setTrnchd(Tranche3.builder()
						.setAttchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCdSIndexAttachmentPoint()).get())
						.setDtchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCdSIndexDetachmentPoint()).get())
						.build())
					.build();
			}
			cdt = toBuilder(CreditDerivative4__1.builder()
				.setSnrty(MapperS.of(drrReport).<SeniorityEnum>map("getSeniority", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSeniority()).checkedMap("to-enum", e -> DebtInstrumentSeniorityType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setRefPty(DerivativePartyIdentification1Choice.builder()
					.setLei(MapperS.of(drrReport).<String>map("getReferenceEntity", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getReferenceEntity()).get())
					.build())
				.setSrs(MapperS.of(drrReport).<Integer>map("getSeries", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSeries()).get())
				.setVrsn(MapperS.of(drrReport).<Integer>map("getSeriesVersion", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getSeriesVersion()).get())
				.setIndxFctr(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getIndexFactor()).get())
				.setTrch(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(cdt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
