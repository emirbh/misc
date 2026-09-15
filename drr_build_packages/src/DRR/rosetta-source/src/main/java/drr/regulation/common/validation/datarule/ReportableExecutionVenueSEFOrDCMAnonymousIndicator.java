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
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.common.ReportableExecutionVenue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ReportableExecutionVenueSEFOrDCMAnonymousIndicator")
@ImplementedBy(ReportableExecutionVenueSEFOrDCMAnonymousIndicator.Default.class)
public interface ReportableExecutionVenueSEFOrDCMAnonymousIndicator extends Validator<ReportableExecutionVenue> {
	
	String NAME = "ReportableExecutionVenueSEFOrDCMAnonymousIndicator";
	String DEFINITION = "if [ExecutionVenueTypeEnum -> SEF, ExecutionVenueTypeEnum -> DCM] all <> executionVenueType then sefOrDcmAnonymousIndicator is absent";
	
	class Default implements ReportableExecutionVenueSEFOrDCMAnonymousIndicator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableExecutionVenue reportableExecutionVenue) {
			ComparisonResult result = executeDataRule(reportableExecutionVenue);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportableExecutionVenue", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportableExecutionVenue", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReportableExecutionVenue reportableExecutionVenue) {
			try {
				if (notEqual(MapperC.<ExecutionVenueTypeEnum>of(MapperS.of(ExecutionVenueTypeEnum.SEF), MapperS.of(ExecutionVenueTypeEnum.DCM)), MapperS.of(reportableExecutionVenue).<ExecutionVenueTypeEnum>map("getExecutionVenueType", _reportableExecutionVenue -> _reportableExecutionVenue.getExecutionVenueType()), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(reportableExecutionVenue).<Boolean>map("getSefOrDcmAnonymousIndicator", _reportableExecutionVenue -> _reportableExecutionVenue.getSefOrDcmAnonymousIndicator()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportableExecutionVenueSEFOrDCMAnonymousIndicator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableExecutionVenue reportableExecutionVenue) {
			return Collections.emptyList();
		}
	}
}
