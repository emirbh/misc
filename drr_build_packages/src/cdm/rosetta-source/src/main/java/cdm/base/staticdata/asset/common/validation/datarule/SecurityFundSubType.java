package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
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
@RosettaDataRule("SecurityFundSubType")
@ImplementedBy(SecurityFundSubType.Default.class)
public interface SecurityFundSubType extends Validator<Security> {
	
	String NAME = "SecurityFundSubType";
	String DEFINITION = "if instrumentType <> InstrumentTypeEnum -> Fund then fundType is absent";
	
	class Default implements SecurityFundSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Security security) {
			ComparisonResult result = executeDataRule(security);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Security", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Security", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Security security) {
			try {
				if (notEqual(MapperS.of(security).<InstrumentTypeEnum>map("getInstrumentType", _security -> _security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.FUND), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(security).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecurityFundSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Security security) {
			return Collections.emptyList();
		}
	}
}
