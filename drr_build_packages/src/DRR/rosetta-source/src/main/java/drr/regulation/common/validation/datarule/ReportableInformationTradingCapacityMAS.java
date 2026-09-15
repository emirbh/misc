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
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.ReportingRoleEnum;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportableInformationTradingCapacityMAS")
@ImplementedBy(ReportableInformationTradingCapacityMAS.Default.class)
public interface ReportableInformationTradingCapacityMAS extends Validator<ReportableInformation> {
	
	String NAME = "ReportableInformationTradingCapacityMAS";
	String DEFINITION = "jurisdictionInformation then filter regimeName = MAS then if partyInformation -> reportingRole all = ReportingParty then partyInformation -> tradingCapacity any = Agent or partyInformation -> tradingCapacity any = Principal";
	
	class Default implements ReportableInformationTradingCapacityMAS {
	
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
					.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(RegimeNameEnum.MAS), CardinalityOperator.All).get());
				final MapperS<Boolean> ifThenElseResult;
				if (areEqual(thenArg1.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ReportingRoleEnum>map("getReportingRole", jurisdictionPartyInformation -> jurisdictionPartyInformation.getReportingRole()), MapperS.of(ReportingRoleEnum.REPORTING_PARTY), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult = areEqual(thenArg1.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ReportingRoleEnum>map("getTradingCapacity", jurisdictionPartyInformation -> jurisdictionPartyInformation.getTradingCapacity()), MapperS.of(ReportingRoleEnum.AGENT), CardinalityOperator.Any).orNullSafe(areEqual(thenArg1.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ReportingRoleEnum>map("getTradingCapacity", jurisdictionPartyInformation -> jurisdictionPartyInformation.getTradingCapacity()), MapperS.of(ReportingRoleEnum.PRINCIPAL), CardinalityOperator.Any)).asMapper();
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
	class NoOp implements ReportableInformationTradingCapacityMAS {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableInformation reportableInformation) {
			return Collections.emptyList();
		}
	}
}
