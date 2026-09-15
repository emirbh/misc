package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedOrRelativeDate;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEquityExerciseValuationSettlementToSettlementTerms.MapEquityExerciseValuationSettlementToSettlementTermsDefault.class)
public abstract class MapEquityExerciseValuationSettlementToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;

	/**
	* @param fpmlEquityExerciseValuationSettlement 
	* @param fpmlClearingInstructions 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(EquityExerciseValuationSettlement fpmlEquityExerciseValuationSettlement, SwaptionPhysicalSettlement fpmlClearingInstructions) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlEquityExerciseValuationSettlement, fpmlClearingInstructions);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(EquityExerciseValuationSettlement fpmlEquityExerciseValuationSettlement, SwaptionPhysicalSettlement fpmlClearingInstructions);

	public static class MapEquityExerciseValuationSettlementToSettlementTermsDefault extends MapEquityExerciseValuationSettlementToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(EquityExerciseValuationSettlement fpmlEquityExerciseValuationSettlement, SwaptionPhysicalSettlement fpmlClearingInstructions) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlEquityExerciseValuationSettlement, fpmlClearingInstructions);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, EquityExerciseValuationSettlement fpmlEquityExerciseValuationSettlement, SwaptionPhysicalSettlement fpmlClearingInstructions) {
			AncillaryRoleEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlClearingInstructions).<PartyReference>map("getPredeterminedClearingOrganizationPartyReference", swaptionPhysicalSettlement -> swaptionPhysicalSettlement.getPredeterminedClearingOrganizationPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref())).getOrDefault(false)) {
				ifThenElseResult = AncillaryRoleEnum.PREDETERMINED_CLEARING_ORGANIZATION_PARTY;
			}
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(MapperS.of(fpmlEquityExerciseValuationSettlement).<SettlementTypeEnum>map("getSettlementType", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getSettlementType()).checkedMap("to-enum", e -> cdm.product.common.settlement.SettlementTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setSettlementDate(MapperS.of(fpmlEquityExerciseValuationSettlement).<AdjustableOrRelativeDate>map("getSettlementDate", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getSettlementDate())
					.mapSingleToItem(item -> MapperS.of(SettlementDate.builder()
						.setAdjustableOrRelativeDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(item.<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), item.<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), item.<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.build())).get())
				.setSettlementCurrencyValue(MapperS.of(fpmlEquityExerciseValuationSettlement).<Currency>map("getSettlementCurrency", equityExerciseValuationSettlement -> equityExerciseValuationSettlement.getSettlementCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
				.setPhysicalSettlementTerms(PhysicalSettlementTerms.builder()
					.setClearedPhysicalSettlement(MapperS.of(fpmlClearingInstructions).<Boolean>map("getClearedPhysicalSettlement", swaptionPhysicalSettlement -> swaptionPhysicalSettlement.getClearedPhysicalSettlement()).get())
					.setPredeterminedClearingOrganizationParty(ifThenElseResult)
					.build())
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
