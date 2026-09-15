package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedOrRelativeDate;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFixedLegSettlementTerms.MapFixedLegSettlementTermsDefault.class)
public abstract class MapFixedLegSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlFixedPaymentLeg 
	* @param fpmlSettlementType 
	* @param fpmlSettlementCurrency 
	* @param fpmlRelativeDateOffset 
	* @param fpmlUnadjustedDate 
	* @param fpmlAdjustableDate 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(FixedPaymentLeg fpmlFixedPaymentLeg, SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, RelativeDateOffset fpmlRelativeDateOffset, Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlFixedPaymentLeg, fpmlSettlementType, fpmlSettlementCurrency, fpmlRelativeDateOffset, fpmlUnadjustedDate, fpmlAdjustableDate);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(FixedPaymentLeg fpmlFixedPaymentLeg, SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, RelativeDateOffset fpmlRelativeDateOffset, Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate);

	public static class MapFixedLegSettlementTermsDefault extends MapFixedLegSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(FixedPaymentLeg fpmlFixedPaymentLeg, SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, RelativeDateOffset fpmlRelativeDateOffset, Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlFixedPaymentLeg, fpmlSettlementType, fpmlSettlementCurrency, fpmlRelativeDateOffset, fpmlUnadjustedDate, fpmlAdjustableDate);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, FixedPaymentLeg fpmlFixedPaymentLeg, SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, RelativeDateOffset fpmlRelativeDateOffset, Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate) {
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(MapperS.of(fpmlSettlementType).checkedMap("to-enum", e -> cdm.product.common.settlement.SettlementTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setSettlementCurrency(mapCurrency.evaluate(fpmlSettlementCurrency))
				.setSettlementDate(SettlementDate.builder()
					.setAdjustableOrRelativeDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(fpmlUnadjustedDate, fpmlAdjustableDate, fpmlRelativeDateOffset))
					.build())
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
