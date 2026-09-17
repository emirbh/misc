package cdm.event.common.validation.datarule;

import cdm.event.common.MarginCallBase;
import cdm.event.common.RegIMRoleEnum;
import cdm.event.common.RegMarginTypeEnum;
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
@RosettaDataRule("MarginCallBaseRegIMRoleIMOnly")
@ImplementedBy(MarginCallBaseRegIMRoleIMOnly.Default.class)
public interface MarginCallBaseRegIMRoleIMOnly extends Validator<MarginCallBase> {
	
	String NAME = "MarginCallBaseRegIMRoleIMOnly";
	String DEFINITION = "if regIMRole exists then regMarginType = RegMarginTypeEnum -> RegIM";
	
	class Default implements MarginCallBaseRegIMRoleIMOnly {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCallBase marginCallBase) {
			ComparisonResult result = executeDataRule(marginCallBase);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MarginCallBase", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MarginCallBase", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MarginCallBase marginCallBase) {
			try {
				if (exists(MapperS.of(marginCallBase).<RegIMRoleEnum>map("getRegIMRole", _marginCallBase -> _marginCallBase.getRegIMRole())).getOrDefault(false)) {
					return areEqual(MapperS.of(marginCallBase).<RegMarginTypeEnum>map("getRegMarginType", _marginCallBase -> _marginCallBase.getRegMarginType()), MapperS.of(RegMarginTypeEnum.REG_IM), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MarginCallBaseRegIMRoleIMOnly {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCallBase marginCallBase) {
			return Collections.emptyList();
		}
	}
}
