package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SECPartyInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportableJurisdictionInformationSECReportingRegime")
@ImplementedBy(ReportableJurisdictionInformationSECReportingRegime.Default.class)
public interface ReportableJurisdictionInformationSECReportingRegime extends Validator<ReportableJurisdictionInformation> {
	
	String NAME = "ReportableJurisdictionInformationSECReportingRegime";
	String DEFINITION = "if supervisoryBody = SEC then partyInformation -> secPartyInformation exists else partyInformation -> secPartyInformation is absent";
	
	class Default implements ReportableJurisdictionInformationSECReportingRegime {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableJurisdictionInformation reportableJurisdictionInformation) {
			ComparisonResult result = executeDataRule(reportableJurisdictionInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportableJurisdictionInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportableJurisdictionInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReportableJurisdictionInformation reportableJurisdictionInformation) {
			try {
				if (areEqual(MapperS.of(reportableJurisdictionInformation).<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.SEC), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(reportableJurisdictionInformation).<JurisdictionPartyInformation>mapC("getPartyInformation", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getPartyInformation()).<SECPartyInformation>map("getSecPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getSecPartyInformation()));
				}
				return notExists(MapperS.of(reportableJurisdictionInformation).<JurisdictionPartyInformation>mapC("getPartyInformation", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getPartyInformation()).<SECPartyInformation>map("getSecPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getSecPartyInformation()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportableJurisdictionInformationSECReportingRegime {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableJurisdictionInformation reportableJurisdictionInformation) {
			return Collections.emptyList();
		}
	}
}
