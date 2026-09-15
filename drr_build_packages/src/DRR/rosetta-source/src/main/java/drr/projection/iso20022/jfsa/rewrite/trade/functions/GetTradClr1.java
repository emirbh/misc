package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ClearedEnum;
import iso20022.auth030.jfsa.Cleared23Choice__1;
import iso20022.auth030.jfsa.ClearingAccountType4Code;
import iso20022.auth030.jfsa.ClearingExceptionOrExemption3Choice__1;
import iso20022.auth030.jfsa.ClearingPartyAndTime21Choice__1;
import iso20022.auth030.jfsa.ClearingPartyAndTime22Choice__1;
import iso20022.auth030.jfsa.ClearingPartyAndTime22__1;
import iso20022.auth030.jfsa.ClearingPartyAndTime23__1;
import iso20022.auth030.jfsa.GenericIdentification175__1;
import iso20022.auth030.jfsa.GenericIdentification179__1;
import iso20022.auth030.jfsa.NoReasonCode;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__1;
import iso20022.auth030.jfsa.TradeClearing11__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier1Choice__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTradClr1.GetTradClr1Default.class)
public abstract class GetTradClr1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;

	/**
	* @param drrReport 
	* @return tradClr 
	*/
	public TradeClearing11__1 evaluate(JFSATransactionReport drrReport) {
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

	protected abstract TradeClearing11__1.TradeClearing11__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetTradClr1Default extends GetTradClr1 {
		@Override
		protected TradeClearing11__1.TradeClearing11__1Builder doEvaluate(JFSATransactionReport drrReport) {
			TradeClearing11__1.TradeClearing11__1Builder tradClr = TradeClearing11__1.builder();
			return assignOutput(tradClr, drrReport);
		}
		
		protected TradeClearing11__1.TradeClearing11__1Builder assignOutput(TradeClearing11__1.TradeClearing11__1Builder tradClr, JFSATransactionReport drrReport) {
			ClearingPartyAndTime21Choice__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", jFSATransactionReport -> jFSATransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = ClearingPartyAndTime21Choice__1.builder()
					.setDtls(ClearingPartyAndTime22__1.builder()
						.setCcp(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCentralCounterparty", jFSATransactionReport -> jFSATransactionReport.getCentralCounterparty()).get()))
						.setClrRctDtTm(MapperS.of(drrReport).<ZonedDateTime>map("getClearingReceiptTimestamp", jFSATransactionReport -> jFSATransactionReport.getClearingReceiptTimestamp()).get())
						.setOrgnlIdr(UniqueTransactionIdentifier2Choice__1.builder()
							.setUnqTxIdr(MapperS.of(drrReport).<String>map("getOriginalSwapUTI", jFSATransactionReport -> jFSATransactionReport.getOriginalSwapUTI()).get())
							.setPrtry(GenericIdentification175__1.builder()
								.setId(MapperS.of(drrReport).<String>map("getOriginalSwapUTIProprietary", jFSATransactionReport -> jFSATransactionReport.getOriginalSwapUTIProprietary()).get())
								.build())
							.build())
						.setOrgnlTradRpstryIdr(OrganisationIdentification15Choice__1.builder()
							.setLei(MapperS.of(drrReport).<String>map("getOriginalSwapSDRIdentifier", jFSATransactionReport -> jFSATransactionReport.getOriginalSwapSDRIdentifier()).get())
							.build())
						.setClrAcctOrgn(MapperS.of(drrReport).<ClearingAccountOriginEnum>map("getClearingAccountOrigin", jFSATransactionReport -> jFSATransactionReport.getClearingAccountOrigin()).checkedMap("to-enum", e -> ClearingAccountType4Code.valueOf(e.name()), IllegalArgumentException.class).get())
						.build())
					.build();
			}
			ClearingPartyAndTime22Choice__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", jFSATransactionReport -> jFSATransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = ClearingPartyAndTime22Choice__1.builder()
					.setDtls(ClearingPartyAndTime23__1.builder()
						.setCcp(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCentralCounterparty", jFSATransactionReport -> jFSATransactionReport.getCentralCounterparty()).get()))
						.setClrRctDtTm(MapperS.of(drrReport).<ZonedDateTime>map("getClearingReceiptTimestamp", jFSATransactionReport -> jFSATransactionReport.getClearingReceiptTimestamp()).get())
						.setOrgnlIdr(UniqueTransactionIdentifier1Choice__1.builder()
							.setUnqTxIdr(MapperS.of(drrReport).<String>map("getOriginalSwapUTI", jFSATransactionReport -> jFSATransactionReport.getOriginalSwapUTI()).get())
							.setPrtry(GenericIdentification179__1.builder()
								.setId(MapperS.of(drrReport).<String>map("getOriginalSwapUTIProprietary", jFSATransactionReport -> jFSATransactionReport.getOriginalSwapUTIProprietary()).get())
								.build())
							.build())
						.setOrgnlTradRpstryIdr(OrganisationIdentification15Choice__1.builder()
							.setLei(MapperS.of(drrReport).<String>map("getOriginalSwapSDRIdentifier", jFSATransactionReport -> jFSATransactionReport.getOriginalSwapSDRIdentifier()).get())
							.build())
						.build())
					.build();
			}
			ClearingExceptionOrExemption3Choice__1 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", jFSATransactionReport -> jFSATransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = ClearingExceptionOrExemption3Choice__1.builder()
					.setRsn(NoReasonCode.NORE)
					.build();
			}
			tradClr = toBuilder(TradeClearing11__1.builder()
				.setClrSts(Cleared23Choice__1.builder()
					.setClrd(ifThenElseResult0)
					.setIntndToClear(ifThenElseResult1)
					.setNonClrd(ifThenElseResult2)
					.build())
				.build());
			
			return Optional.ofNullable(tradClr)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
