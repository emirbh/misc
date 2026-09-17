package cdm.observable.asset.validation.datarule;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceOperandEnum;
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
@RosettaDataRule("PriceCompositeArithmeticOperator")
@ImplementedBy(PriceCompositeArithmeticOperator.Default.class)
public interface PriceCompositeArithmeticOperator extends Validator<PriceComposite> {
	
	String NAME = "PriceCompositeArithmeticOperator";
	String DEFINITION = "if operandType = PriceOperandEnum -> ForwardPoint or operandType = PriceOperandEnum -> AccruedInterest then arithmeticOperator = ArithmeticOperationEnum -> Add or arithmeticOperator = ArithmeticOperationEnum -> Subtract";
	
	class Default implements PriceCompositeArithmeticOperator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceComposite priceComposite) {
			ComparisonResult result = executeDataRule(priceComposite);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceComposite", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceComposite", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PriceComposite priceComposite) {
			try {
				if (areEqual(MapperS.of(priceComposite).<PriceOperandEnum>map("getOperandType", _priceComposite -> _priceComposite.getOperandType()), MapperS.of(PriceOperandEnum.FORWARD_POINT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(priceComposite).<PriceOperandEnum>map("getOperandType", _priceComposite -> _priceComposite.getOperandType()), MapperS.of(PriceOperandEnum.ACCRUED_INTEREST), CardinalityOperator.All)).getOrDefault(false)) {
					return areEqual(MapperS.of(priceComposite).<ArithmeticOperationEnum>map("getArithmeticOperator", _priceComposite -> _priceComposite.getArithmeticOperator()), MapperS.of(ArithmeticOperationEnum.ADD), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(priceComposite).<ArithmeticOperationEnum>map("getArithmeticOperator", _priceComposite -> _priceComposite.getArithmeticOperator()), MapperS.of(ArithmeticOperationEnum.SUBTRACT), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceCompositeArithmeticOperator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceComposite priceComposite) {
			return Collections.emptyList();
		}
	}
}
