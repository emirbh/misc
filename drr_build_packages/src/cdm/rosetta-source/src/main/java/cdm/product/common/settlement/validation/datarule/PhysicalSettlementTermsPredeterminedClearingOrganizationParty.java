package cdm.product.common.settlement.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PhysicalSettlementTermsPredeterminedClearingOrganizationParty")
@ImplementedBy(PhysicalSettlementTermsPredeterminedClearingOrganizationParty.Default.class)
public interface PhysicalSettlementTermsPredeterminedClearingOrganizationParty extends Validator<PhysicalSettlementTerms> {
	
	String NAME = "PhysicalSettlementTermsPredeterminedClearingOrganizationParty";
	String DEFINITION = "if predeterminedClearingOrganizationParty exists then predeterminedClearingOrganizationParty = AncillaryRoleEnum -> PredeterminedClearingOrganizationParty";
	
	class Default implements PhysicalSettlementTermsPredeterminedClearingOrganizationParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementTerms physicalSettlementTerms) {
			ComparisonResult result = executeDataRule(physicalSettlementTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PhysicalSettlementTerms physicalSettlementTerms) {
			try {
				if (exists(MapperS.of(physicalSettlementTerms).<AncillaryRoleEnum>map("getPredeterminedClearingOrganizationParty", _physicalSettlementTerms -> _physicalSettlementTerms.getPredeterminedClearingOrganizationParty())).getOrDefault(false)) {
					return areEqual(MapperS.of(physicalSettlementTerms).<AncillaryRoleEnum>map("getPredeterminedClearingOrganizationParty", _physicalSettlementTerms -> _physicalSettlementTerms.getPredeterminedClearingOrganizationParty()), MapperS.of(AncillaryRoleEnum.PREDETERMINED_CLEARING_ORGANIZATION_PARTY), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PhysicalSettlementTermsPredeterminedClearingOrganizationParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementTerms physicalSettlementTerms) {
			return Collections.emptyList();
		}
	}
}
