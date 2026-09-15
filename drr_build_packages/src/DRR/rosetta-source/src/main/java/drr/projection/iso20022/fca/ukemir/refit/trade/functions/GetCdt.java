package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.SeniorityEnum;
import iso20022.auth030.fca.CreditDerivative4__1;
import iso20022.auth030.fca.DebtInstrumentSeniorityType2Code;
import iso20022.auth030.fca.DerivativePartyIdentification1Choice;
import iso20022.auth030.fca.NoReasonCode;
import iso20022.auth030.fca.Tranche3__1;
import iso20022.auth030.fca.TrancheIndicator3Choice__1;
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
	public CreditDerivative4__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
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

	protected abstract CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetCdtDefault extends GetCdt {
		@Override
		protected CreditDerivative4__1.CreditDerivative4__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			CreditDerivative4__1.CreditDerivative4__1Builder cdt = CreditDerivative4__1.builder();
			return assignOutput(cdt, drrReport);
		}
		
		protected CreditDerivative4__1.CreditDerivative4__1Builder assignOutput(CreditDerivative4__1.CreditDerivative4__1Builder cdt, FCAUKEMIRTransactionReport drrReport) {
			TrancheIndicator3Choice__1 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getTranche", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getTranche()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				Tranche3__1 ifThenElseResult0 = null;
				if (areEqual(MapperS.of(drrReport).<Boolean>map("getTranche", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getTranche()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult0 = Tranche3__1.builder()
						.setAttchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCdSIndexAttachmentPoint()).get())
						.setDtchmntPt(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCdSIndexDetachmentPoint()).get())
						.build();
				}
				NoReasonCode ifThenElseResult1 = null;
				if (areEqual(MapperS.of(drrReport).<Boolean>map("getTranche", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getTranche()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult1 = NoReasonCode.NORE;
				}
				ifThenElseResult2 = TrancheIndicator3Choice__1.builder()
					.setTrnchd(ifThenElseResult0)
					.setUtrnchd(ifThenElseResult1)
					.build();
			}
			cdt = toBuilder(CreditDerivative4__1.builder()
				.setSnrty(MapperS.of(drrReport).<SeniorityEnum>map("getSeniority", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSeniority()).checkedMap("to-enum", e -> DebtInstrumentSeniorityType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setRefPty(DerivativePartyIdentification1Choice.builder()
					.setLei(MapperS.of(drrReport).<String>map("getReferenceEntity", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getReferenceEntity()).get())
					.build())
				.setSrs(MapperS.of(drrReport).<Integer>map("getSeries", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSeries()).get())
				.setVrsn(MapperS.of(drrReport).<Integer>map("getSeriesVersion", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSeriesVersion()).get())
				.setIndxFctr(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getIndexFactor()).get())
				.setTrch(ifThenElseResult2)
				.build());
			
			return Optional.ofNullable(cdt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
