package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
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
@RosettaDataRule("ReportableJurisdictionInformationCFTCReportingRegime")
@ImplementedBy(ReportableJurisdictionInformationCFTCReportingRegime.Default.class)
public interface ReportableJurisdictionInformationCFTCReportingRegime extends Validator<ReportableJurisdictionInformation> {
	
	String NAME = "ReportableJurisdictionInformationCFTCReportingRegime";
	String DEFINITION = "if supervisoryBody = CFTC then partyInformation -> cftcPartyInformation exists else partyInformation -> cftcPartyInformation is absent";
	
	class Default implements ReportableJurisdictionInformationCFTCReportingRegime {
	
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
				if (areEqual(MapperS.of(reportableJurisdictionInformation).<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(reportableJurisdictionInformation).<JurisdictionPartyInformation>mapC("getPartyInformation", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getPartyInformation()).<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()));
				}
				return notExists(MapperS.of(reportableJurisdictionInformation).<JurisdictionPartyInformation>mapC("getPartyInformation", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getPartyInformation()).<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportableJurisdictionInformationCFTCReportingRegime {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableJurisdictionInformation reportableJurisdictionInformation) {
			return Collections.emptyList();
		}
	}
}
