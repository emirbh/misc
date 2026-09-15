package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CommodityTimeUnitEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportableJurisdictionInformationESMATransactionInformation")
@ImplementedBy(ReportableJurisdictionInformationESMATransactionInformation.Default.class)
public interface ReportableJurisdictionInformationESMATransactionInformation extends Validator<ReportableJurisdictionInformation> {
	
	String NAME = "ReportableJurisdictionInformationESMATransactionInformation";
	String DEFINITION = "if regimeName <> EMIR then transactionInformation -> duration is absent";
	
	class Default implements ReportableJurisdictionInformationESMATransactionInformation {
	
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
				if (notEqual(MapperS.of(reportableJurisdictionInformation).<FieldWithMetaRegimeNameEnum>map("getRegimeName", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(RegimeNameEnum.EMIR), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(reportableJurisdictionInformation).<TransactionInformation>map("getTransactionInformation", _reportableJurisdictionInformation -> _reportableJurisdictionInformation.getTransactionInformation()).<CommodityTimeUnitEnum>map("getDuration", transactionInformation -> transactionInformation.getDuration()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportableJurisdictionInformationESMATransactionInformation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableJurisdictionInformation reportableJurisdictionInformation) {
			return Collections.emptyList();
		}
	}
}
