package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.ingest.fpml.confirmation.datetime.functions.MapFxFixingDate;
import cdm.observable.asset.SettlementRateOptionEnum;
import cdm.observable.asset.ValuationMethod;
import cdm.observable.asset.ValuationSource;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.FxFixingDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.common.settlement.ValuationDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.ird.NonDeliverableSettlement;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.ird.SettlementProvision;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.SettlementRateOption;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSettlementProvisionToSettlementTerms.MapSettlementProvisionToSettlementTermsDefault.class)
public abstract class MapSettlementProvisionToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapFxFixingDate mapFxFixingDate;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlSettlementProvision 
	* @param fpmlPaymentDates 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(SettlementProvision fpmlSettlementProvision, PaymentDates fpmlPaymentDates) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlSettlementProvision, fpmlPaymentDates);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(SettlementProvision fpmlSettlementProvision, PaymentDates fpmlPaymentDates);

	protected abstract MapperS<SettlementTypeEnum> settlementType(SettlementProvision fpmlSettlementProvision, PaymentDates fpmlPaymentDates);

	public static class MapSettlementProvisionToSettlementTermsDefault extends MapSettlementProvisionToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(SettlementProvision fpmlSettlementProvision, PaymentDates fpmlPaymentDates) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlSettlementProvision, fpmlPaymentDates);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, SettlementProvision fpmlSettlementProvision, PaymentDates fpmlPaymentDates) {
			final FieldWithMetaString fieldWithMetaString = mapStringWithScheme.evaluate(MapperS.of(fpmlSettlementProvision).<NonDeliverableSettlement>map("getNonDeliverableSettlement", settlementProvision -> settlementProvision.getNonDeliverableSettlement()).<SettlementRateOption>map("getSettlementRateOption", nonDeliverableSettlement -> nonDeliverableSettlement.getSettlementRateOption()).<String>map("getValue", settlementRateOption -> settlementRateOption.getValue()).get(), MapperS.of(fpmlSettlementProvision).<NonDeliverableSettlement>map("getNonDeliverableSettlement", settlementProvision -> settlementProvision.getNonDeliverableSettlement()).<SettlementRateOption>map("getSettlementRateOption", nonDeliverableSettlement -> nonDeliverableSettlement.getSettlementRateOption()).<String>map("getSettlementRateOptionScheme", settlementRateOption -> settlementRateOption.getSettlementRateOptionScheme()).get());
			FxFixingDate ifThenElseResult = null;
			if (exists(MapperS.of(fpmlSettlementProvision).<NonDeliverableSettlement>map("getNonDeliverableSettlement", settlementProvision -> settlementProvision.getNonDeliverableSettlement()).<fpml.consolidated.ird.FxFixingDate>map("getFxFixingDate", nonDeliverableSettlement -> nonDeliverableSettlement.getFxFixingDate())).getOrDefault(false)) {
				ifThenElseResult = mapFxFixingDate.evaluate(MapperS.of(fpmlSettlementProvision).<NonDeliverableSettlement>map("getNonDeliverableSettlement", settlementProvision -> settlementProvision.getNonDeliverableSettlement()).<fpml.consolidated.ird.FxFixingDate>map("getFxFixingDate", nonDeliverableSettlement -> nonDeliverableSettlement.getFxFixingDate()).get(), fpmlPaymentDates);
			}
			final CashSettlementTerms cashSettlementTerms = CashSettlementTerms.builder()
				.setValuationMethod(ValuationMethod.builder()
					.setValuationSource(ValuationSource.builder()
						.setSettlementRateOption(cdm.observable.asset.SettlementRateOption.builder()
							.setSettlementRateOptionValue((fieldWithMetaString == null ? MapperS.<String>ofNull() : MapperS.of(fieldWithMetaString.getValue())).checkedMap("to-enum", SettlementRateOptionEnum::fromDisplayName, IllegalArgumentException.class).get())
							.build())
						.build())
					.build())
				.setValuationDate(ValuationDate.builder()
					.setFxFixingDate(ifThenElseResult)
					.build())
				.build();
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(settlementType(fpmlSettlementProvision, fpmlPaymentDates).get())
				.setSettlementCurrency(mapCurrency.evaluate(MapperS.of(fpmlSettlementProvision).<Currency>map("getSettlementCurrency", settlementProvision -> settlementProvision.getSettlementCurrency()).get()))
				.setCashSettlementTerms((cashSettlementTerms == null ? Collections.<CashSettlementTerms>emptyList() : Collections.singletonList(cashSettlementTerms)))
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<SettlementTypeEnum> settlementType(SettlementProvision fpmlSettlementProvision, PaymentDates fpmlPaymentDates) {
			if (exists(MapperS.of(fpmlSettlementProvision).<NonDeliverableSettlement>map("getNonDeliverableSettlement", settlementProvision -> settlementProvision.getNonDeliverableSettlement())).getOrDefault(false)) {
				return MapperS.of(SettlementTypeEnum.CASH);
			}
			return MapperS.<SettlementTypeEnum>ofNull();
		}
	}
}
