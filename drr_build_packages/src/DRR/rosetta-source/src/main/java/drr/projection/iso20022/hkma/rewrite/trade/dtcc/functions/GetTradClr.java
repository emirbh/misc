package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.ClearedEnum;
import iso20022.auth030.hkma.dtcc.Cleared23Choice__1;
import iso20022.auth030.hkma.dtcc.ClearingExceptionOrExemption3Choice__1;
import iso20022.auth030.hkma.dtcc.ClearingPartyAndTime21Choice__1;
import iso20022.auth030.hkma.dtcc.ClearingPartyAndTime22Choice__1;
import iso20022.auth030.hkma.dtcc.ClearingPartyAndTime22__1;
import iso20022.auth030.hkma.dtcc.ClearingPartyAndTime23__1;
import iso20022.auth030.hkma.dtcc.GenericIdentification175__2;
import iso20022.auth030.hkma.dtcc.NoReasonCode;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__3;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__7;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification38__2;
import iso20022.auth030.hkma.dtcc.TradeClearing11__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTradClr.GetTradClrDefault.class)
public abstract class GetTradClr implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__3 create_OrganisationIdentification15Choice__3;

	/**
	* @param drrReport 
	* @return tradClr 
	*/
	public TradeClearing11__1 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract TradeClearing11__1.TradeClearing11__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetTradClrDefault extends GetTradClr {
		@Override
		protected TradeClearing11__1.TradeClearing11__1Builder doEvaluate(HKMATransactionReport drrReport) {
			TradeClearing11__1.TradeClearing11__1Builder tradClr = TradeClearing11__1.builder();
			return assignOutput(tradClr, drrReport);
		}
		
		protected TradeClearing11__1.TradeClearing11__1Builder assignOutput(TradeClearing11__1.TradeClearing11__1Builder tradClr, HKMATransactionReport drrReport) {
			ClearingPartyAndTime21Choice__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", hKMATransactionReport -> hKMATransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				OrganisationIdentification15Choice__3 ifThenElseResult0 = null;
				if (notEqual(MapperS.of(drrReport).<HKTRPartyScheme>map("getCentralCounterpartySchemeName", hKMATransactionReport -> hKMATransactionReport.getCentralCounterpartySchemeName()), MapperS.of(HKTRPartyScheme.TRID), CardinalityOperator.Any).getOrDefault(false)) {
					ifThenElseResult0 = create_OrganisationIdentification15Choice__3.evaluate(MapperS.of(drrReport).<PartyIdentifierFormat2Enum>map("getCentralCounterpartyIdentifierFormat", hKMATransactionReport -> hKMATransactionReport.getCentralCounterpartyIdentifierFormat()).get(), MapperS.of(drrReport).<String>map("getCentralCounterparty", hKMATransactionReport -> hKMATransactionReport.getCentralCounterparty()).get(), MapperS.of(drrReport).<HKTRPartyScheme>map("getCentralCounterpartySchemeName", hKMATransactionReport -> hKMATransactionReport.getCentralCounterpartySchemeName()).get());
				}
				ifThenElseResult1 = ClearingPartyAndTime21Choice__1.builder()
					.setDtls(ClearingPartyAndTime22__1.builder()
						.setCcp(ifThenElseResult0)
						.setClrDtTm(MapperS.of(drrReport).<ZonedDateTime>map("getClearingTimestamp", hKMATransactionReport -> hKMATransactionReport.getClearingTimestamp()).get())
						.build())
					.build();
			}
			ClearingPartyAndTime22Choice__1 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", hKMATransactionReport -> hKMATransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = ClearingPartyAndTime22Choice__1.builder()
					.setDtls(ClearingPartyAndTime23__1.builder()
						.setCcp(OrganisationIdentification15Choice__7.builder()
							.setLei(MapperS.of(drrReport).<String>map("getCentralCounterparty", hKMATransactionReport -> hKMATransactionReport.getCentralCounterparty()).get())
							.setOthr(OrganisationIdentification38__2.builder()
								.setId(GenericIdentification175__2.builder()
									.setId(MapperS.of(drrReport).<String>map("getCentralCounterparty", hKMATransactionReport -> hKMATransactionReport.getCentralCounterparty()).get())
									.setSchmeNm(MapperS.of(drrReport).<HKTRPartyScheme>map("getCentralCounterpartySchemeName", hKMATransactionReport -> hKMATransactionReport.getCentralCounterpartySchemeName()).checkedMap("to-enum", e -> iso20022.auth030.hkma.dtcc.HKTRPartyScheme.valueOf(e.name()), IllegalArgumentException.class).get())
									.build())
								.build())
							.build())
						.build())
					.build();
			}
			ClearingExceptionOrExemption3Choice__1 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", hKMATransactionReport -> hKMATransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = ClearingExceptionOrExemption3Choice__1.builder()
					.setRsn(NoReasonCode.NORE)
					.build();
			}
			tradClr = toBuilder(TradeClearing11__1.builder()
				.setClrSts(Cleared23Choice__1.builder()
					.setClrd(ifThenElseResult1)
					.setIntndToClear(ifThenElseResult2)
					.setNonClrd(ifThenElseResult3)
					.build())
				.setIntraGrp(MapperS.of(drrReport).<Boolean>map("getIntragroup", hKMATransactionReport -> hKMATransactionReport.getIntragroup()).get())
				.build());
			
			return Optional.ofNullable(tradClr)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
