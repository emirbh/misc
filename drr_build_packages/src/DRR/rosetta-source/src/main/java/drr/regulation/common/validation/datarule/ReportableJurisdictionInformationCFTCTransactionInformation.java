package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportableJurisdictionInformationCFTCTransactionInformation")
@ImplementedBy(ReportableJurisdictionInformationCFTCTransactionInformation.Default.class)
public interface ReportableJurisdictionInformationCFTCTransactionInformation extends Validator<ReportableJurisdictionInformation> {
	
	String NAME = "ReportableJurisdictionInformationCFTCTransactionInformation";
	String DEFINITION = "if regimeName <> DoddFrankAct and supervisoryBody <> CFTC then transactionInformation -> largeSizeTrade is absent";
	
	class Default implements ReportableJurisdictionInformationCFTCTransactionInformation {
	
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
				if (notEqual(MapperS.of(reportableJurisdictionInformation).<FieldWithMetaRegimeNameEnum>map("getRegimeName", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(RegimeNameEnum.DODD_FRANK_ACT), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(reportableJurisdictionInformation).<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.Any)).getOrDefault(false)) {
					return notExists(MapperS.of(reportableJurisdictionInformation).<TransactionInformation>map("getTransactionInformation", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getTransactionInformation()).<Boolean>map("getLargeSizeTrade", transactionInformation -> transactionInformation.getLargeSizeTrade()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportableJurisdictionInformationCFTCTransactionInformation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableJurisdictionInformation reportableJurisdictionInformation) {
			return Collections.emptyList();
		}
	}
}
