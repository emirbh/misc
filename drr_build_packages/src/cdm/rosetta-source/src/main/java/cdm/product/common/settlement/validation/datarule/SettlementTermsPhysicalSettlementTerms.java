package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
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
@RosettaDataRule("SettlementTermsPhysicalSettlementTerms")
@ImplementedBy(SettlementTermsPhysicalSettlementTerms.Default.class)
public interface SettlementTermsPhysicalSettlementTerms extends Validator<SettlementTerms> {
	
	String NAME = "SettlementTermsPhysicalSettlementTerms";
	String DEFINITION = "if physicalSettlementTerms exists then settlementType <> SettlementTypeEnum -> Cash";
	
	class Default implements SettlementTermsPhysicalSettlementTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementTerms settlementTerms) {
			ComparisonResult result = executeDataRule(settlementTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementTerms settlementTerms) {
			try {
				if (exists(MapperS.of(settlementTerms).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).getOrDefault(false)) {
					return notEqual(MapperS.of(settlementTerms).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.Any);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementTermsPhysicalSettlementTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementTerms settlementTerms) {
			return Collections.emptyList();
		}
	}
}
