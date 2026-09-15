package drr.regulation.hkma.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMATransactionReportSRI0001")
@ImplementedBy(HKMATransactionReportSRI0001.Default.class)
public interface HKMATransactionReportSRI0001 extends Validator<HKMATransactionReport> {
	
	String NAME = "HKMATransactionReportSRI0001";
	String DEFINITION = "if underlyingIdOtherSource exists then underlyingAssetTradingPlatformIdentifier exists";
	
	class Default implements HKMATransactionReportSRI0001 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			ComparisonResult result = executeDataRule(hKMATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMATransactionReport hKMATransactionReport) {
			try {
				if (exists(MapperS.of(hKMATransactionReport).<AssetIdTypeEnum>map("getUnderlyingIdOtherSource", _hKMATransactionReport -> _hKMATransactionReport.getUnderlyingIdOtherSource())).getOrDefault(false)) {
					return exists(MapperS.of(hKMATransactionReport).<String>map("getUnderlyingAssetTradingPlatformIdentifier", _hKMATransactionReport -> _hKMATransactionReport.getUnderlyingAssetTradingPlatformIdentifier()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMATransactionReportSRI0001 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			return Collections.emptyList();
		}
	}
}
