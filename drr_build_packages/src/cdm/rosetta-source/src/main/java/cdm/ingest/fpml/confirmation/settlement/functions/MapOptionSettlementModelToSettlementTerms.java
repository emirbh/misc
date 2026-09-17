package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedOrRelativeDate;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionSettlementModelToSettlementTerms.MapOptionSettlementModelToSettlementTermsDefault.class)
public abstract class MapOptionSettlementModelToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlSettlementType 
	* @param fpmlSettlementCurrency 
	* @param fpmlSettlementDate 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlSettlementDate) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlSettlementType, fpmlSettlementCurrency, fpmlSettlementDate);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlSettlementDate);

	public static class MapOptionSettlementModelToSettlementTermsDefault extends MapOptionSettlementModelToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlSettlementDate) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlSettlementType, fpmlSettlementCurrency, fpmlSettlementDate);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, SettlementTypeEnum fpmlSettlementType, Currency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlSettlementDate) {
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(MapperS.of(fpmlSettlementType).checkedMap("to-enum", e -> cdm.product.common.settlement.SettlementTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setSettlementCurrency(mapCurrency.evaluate(fpmlSettlementCurrency))
				.setSettlementDate(MapperS.of(fpmlSettlementDate)
					.mapSingleToItem(item -> MapperS.of(SettlementDate.builder()
						.setAdjustableOrRelativeDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(item.<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), item.<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), item.<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.build())).get())
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
