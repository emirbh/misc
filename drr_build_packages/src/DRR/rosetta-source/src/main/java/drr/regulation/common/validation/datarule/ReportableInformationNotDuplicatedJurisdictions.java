package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportableInformationNotDuplicatedJurisdictions")
@ImplementedBy(ReportableInformationNotDuplicatedJurisdictions.Default.class)
public interface ReportableInformationNotDuplicatedJurisdictions extends Validator<ReportableInformation> {
	
	String NAME = "ReportableInformationNotDuplicatedJurisdictions";
	String DEFINITION = "jurisdictionInformation -> supervisoryBody distinct count = jurisdictionInformation count";
	
	class Default implements ReportableInformationNotDuplicatedJurisdictions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableInformation reportableInformation) {
			ComparisonResult result = executeDataRule(reportableInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportableInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportableInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReportableInformation reportableInformation) {
			try {
				return areEqual(MapperS.of(distinctIgnoringPrecision(MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation()).<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody())).resultCount()), MapperS.of(MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation()).resultCount()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportableInformationNotDuplicatedJurisdictions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableInformation reportableInformation) {
			return Collections.emptyList();
		}
	}
}
