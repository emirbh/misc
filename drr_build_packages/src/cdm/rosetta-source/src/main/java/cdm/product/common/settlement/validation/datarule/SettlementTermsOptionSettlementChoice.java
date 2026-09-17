package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.CashSettlementTerms;
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
@RosettaDataRule("SettlementTermsOptionSettlementChoice")
@ImplementedBy(SettlementTermsOptionSettlementChoice.Default.class)
public interface SettlementTermsOptionSettlementChoice extends Validator<SettlementTerms> {
	
	String NAME = "SettlementTermsOptionSettlementChoice";
	String DEFINITION = "if cashSettlementTerms exists and physicalSettlementTerms exists then settlementType = SettlementTypeEnum -> Election or settlementType = SettlementTypeEnum -> CashOrPhysical";
	
	class Default implements SettlementTermsOptionSettlementChoice {
	
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
				if (exists(MapperS.of(settlementTerms).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms())).andNullSafe(exists(MapperS.of(settlementTerms).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()))).getOrDefault(false)) {
					return areEqual(MapperS.of(settlementTerms).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.ELECTION), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(settlementTerms).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH_OR_PHYSICAL), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementTermsOptionSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementTerms settlementTerms) {
			return Collections.emptyList();
		}
	}
}
