package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ClearingObligationEnum;
import iso20022.auth030.esma.Cleared23Choice__1;
import iso20022.auth030.esma.ClearingExceptionOrExemption3Choice__1;
import iso20022.auth030.esma.ClearingObligationType1Code;
import iso20022.auth030.esma.ClearingPartyAndTime21Choice__1;
import iso20022.auth030.esma.ClearingPartyAndTime22__1;
import iso20022.auth030.esma.NoReasonCode;
import iso20022.auth030.esma.TradeClearing11__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTradClr.GetTradClrDefault.class)
public abstract class GetTradClr implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;

	/**
	* @param drrReport 
	* @return tradClr 
	*/
	public TradeClearing11__1 evaluate(ESMAEMIRTransactionReport drrReport) {
		TradeClearing11__1.TradeClearing11__1Builder tradClrBuilder = doEvaluate(drrReport);
		
		final TradeClearing11__1 tradClr;
		if (tradClrBuilder == null) {
			tradClr = null;
		} else {
			tradClr = tradClrBuilder.build();
			objectValidator.validate(TradeClearing11__1.class, tradClr);
		}
		
		return tradClr;
	}

	protected abstract TradeClearing11__1.TradeClearing11__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetTradClrDefault extends GetTradClr {
		@Override
		protected TradeClearing11__1.TradeClearing11__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			TradeClearing11__1.TradeClearing11__1Builder tradClr = TradeClearing11__1.builder();
			return assignOutput(tradClr, drrReport);
		}
		
		protected TradeClearing11__1.TradeClearing11__1Builder assignOutput(TradeClearing11__1.TradeClearing11__1Builder tradClr, ESMAEMIRTransactionReport drrReport) {
			ClearingPartyAndTime21Choice__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = ClearingPartyAndTime21Choice__1.builder()
					.setDtls(ClearingPartyAndTime22__1.builder()
						.setCcp(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCentralCounterparty", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCentralCounterparty()).get()))
						.setClrDtTm(MapperS.of(drrReport).<ZonedDateTime>map("getClearingTimestamp", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getClearingTimestamp()).get())
						.build())
					.build();
			}
			ClearingExceptionOrExemption3Choice__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = ClearingExceptionOrExemption3Choice__1.builder()
					.setRsn(NoReasonCode.NORE)
					.build();
			}
			tradClr = toBuilder(TradeClearing11__1.builder()
				.setClrOblgtn(MapperS.of(drrReport).<ClearingObligationEnum>map("getClearingObligation", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getClearingObligation()).checkedMap("to-enum", e -> ClearingObligationType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setClrSts(Cleared23Choice__1.builder()
					.setClrd(ifThenElseResult0)
					.setNonClrd(ifThenElseResult1)
					.build())
				.setIntraGrp(MapperS.of(drrReport).<Boolean>map("getIntragroup", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getIntragroup()).get())
				.build());
			
			return Optional.ofNullable(tradClr)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
