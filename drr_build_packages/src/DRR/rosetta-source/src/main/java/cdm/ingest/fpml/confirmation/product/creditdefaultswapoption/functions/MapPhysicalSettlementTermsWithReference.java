package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPhysicalSettlementTermsWithReference.MapPhysicalSettlementTermsWithReferenceDefault.class)
public abstract class MapPhysicalSettlementTermsWithReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @return physicalSettlementTerms 
	*/
	public PhysicalSettlementTerms evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption) {
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTermsBuilder = doEvaluate(fpmlCreditDefaultSwapOption);
		
		final PhysicalSettlementTerms physicalSettlementTerms;
		if (physicalSettlementTermsBuilder == null) {
			physicalSettlementTerms = null;
		} else {
			physicalSettlementTerms = physicalSettlementTermsBuilder.build();
			objectValidator.validate(PhysicalSettlementTerms.class, physicalSettlementTerms);
		}
		
		return physicalSettlementTerms;
	}

	protected abstract PhysicalSettlementTerms.PhysicalSettlementTermsBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption);

	public static class MapPhysicalSettlementTermsWithReferenceDefault extends MapPhysicalSettlementTermsWithReference {
		@Override
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption) {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms = PhysicalSettlementTerms.builder();
			return assignOutput(physicalSettlementTerms, fpmlCreditDefaultSwapOption);
		}
		
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder assignOutput(PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms, CreditDefaultSwapOption fpmlCreditDefaultSwapOption) {
			AncillaryRoleEnum ifThenElseResult = null;
			if (areEqual(MapperS.of(fpmlCreditDefaultSwapOption).<SwaptionPhysicalSettlement>map("getClearingInstructions", creditDefaultSwapOption -> creditDefaultSwapOption.getClearingInstructions()).<PartyReference>map("getPredeterminedClearingOrganizationPartyReference", swaptionPhysicalSettlement -> swaptionPhysicalSettlement.getPredeterminedClearingOrganizationPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()), MapperS.of("clearing-svc"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = AncillaryRoleEnum.PREDETERMINED_CLEARING_ORGANIZATION_PARTY;
			}
			physicalSettlementTerms = toBuilder(PhysicalSettlementTerms.builder()
				.setClearedPhysicalSettlement(MapperS.of(fpmlCreditDefaultSwapOption).<SwaptionPhysicalSettlement>map("getClearingInstructions", creditDefaultSwapOption -> creditDefaultSwapOption.getClearingInstructions()).<Boolean>map("getClearedPhysicalSettlement", swaptionPhysicalSettlement -> swaptionPhysicalSettlement.getClearedPhysicalSettlement()).get())
				.setPredeterminedClearingOrganizationParty(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(physicalSettlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
