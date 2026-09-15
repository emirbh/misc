package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.MandatorilyClearableEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportableInformationMandatorilyClearableConditionFCA")
@ImplementedBy(ReportableInformationMandatorilyClearableConditionFCA.Default.class)
public interface ReportableInformationMandatorilyClearableConditionFCA extends Validator<ReportableInformation> {
	
	String NAME = "ReportableInformationMandatorilyClearableConditionFCA";
	String DEFINITION = "jurisdictionInformation then filter supervisoryBody = FCA then if partyInformation -> mandatorilyClearable exists then partyInformation -> mandatorilyClearable distinct count = 1";
	
	class Default implements ReportableInformationMandatorilyClearableConditionFCA {
	
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
				final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation());
				final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
					.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.FCA), CardinalityOperator.All).get());
				final MapperS<Boolean> ifThenElseResult;
				if (exists(thenArg1.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<MandatorilyClearableEnum>map("getMandatorilyClearable", jurisdictionPartyInformation -> jurisdictionPartyInformation.getMandatorilyClearable())).getOrDefault(false)) {
					ifThenElseResult = areEqual(MapperS.of(distinctIgnoringPrecision(thenArg1.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<MandatorilyClearableEnum>map("getMandatorilyClearable", jurisdictionPartyInformation -> jurisdictionPartyInformation.getMandatorilyClearable())).resultCount()), MapperS.of(1), CardinalityOperator.All).asMapper();
				} else {
					ifThenElseResult = MapperS.<Boolean>ofNull();
				}
				return ComparisonResult.ofNullSafe(ifThenElseResult);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportableInformationMandatorilyClearableConditionFCA {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableInformation reportableInformation) {
			return Collections.emptyList();
		}
	}
}
