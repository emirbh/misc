package cdm.product.template.validation.datarule;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Product;
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
@RosettaDataRule("OptionPayoutOptionTypePresent")
@ImplementedBy(OptionPayoutOptionTypePresent.Default.class)
public interface OptionPayoutOptionTypePresent extends Validator<OptionPayout> {
	
	String NAME = "OptionPayoutOptionTypePresent";
	String DEFINITION = "if underlier -> Product -> NonTransferableProduct is absent then optionType exists";
	
	class Default implements OptionPayoutOptionTypePresent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionPayout optionPayout) {
			ComparisonResult result = executeDataRule(optionPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionPayout optionPayout) {
			try {
				if (notExists(MapperS.of(optionPayout).<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct())).getOrDefault(false)) {
					return exists(MapperS.of(optionPayout).<OptionTypeEnum>map("getOptionType", _optionPayout -> _optionPayout.getOptionType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionPayoutOptionTypePresent {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionPayout optionPayout) {
			return Collections.emptyList();
		}
	}
}
