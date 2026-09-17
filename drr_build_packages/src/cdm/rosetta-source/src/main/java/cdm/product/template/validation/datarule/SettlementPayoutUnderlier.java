package cdm.product.template.validation.datarule;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("SettlementPayoutUnderlier")
@ImplementedBy(SettlementPayoutUnderlier.Default.class)
public interface SettlementPayoutUnderlier extends Validator<SettlementPayout> {
	
	String NAME = "SettlementPayoutUnderlier";
	String DEFINITION = "underlier -> Product -> NonTransferableProduct is absent";
	
	class Default implements SettlementPayoutUnderlier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPayout settlementPayout) {
			ComparisonResult result = executeDataRule(settlementPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementPayout settlementPayout) {
			try {
				return notExists(MapperS.of(settlementPayout).<Underlier>map("getUnderlier", _settlementPayout -> _settlementPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPayoutUnderlier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPayout settlementPayout) {
			return Collections.emptyList();
		}
	}
}
