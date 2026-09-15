package drr.enrichment.upi.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.upi.UpiData;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("UpiDataCardinalityVerification")
@ImplementedBy(UpiDataCardinalityVerification.Default.class)
public interface UpiDataCardinalityVerification extends Validator<UpiData> {
	
	String NAME = "UpiDataCardinalityVerification";
	String DEFINITION = "if upiValidation is absent or upiValidation = True then upiOfUnderlying exists and upiRecord exists";
	
	class Default implements UpiDataCardinalityVerification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UpiData upiData) {
			ComparisonResult result = executeDataRule(upiData);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UpiData", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "UpiData", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(UpiData upiData) {
			try {
				if (notExists(MapperS.of(upiData).<Boolean>map("getUpiValidation", _upiData -> _upiData.getUpiValidation())).orNullSafe(areEqual(MapperS.of(upiData).<Boolean>map("getUpiValidation", _upiData -> _upiData.getUpiValidation()), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(upiData).<Boolean>map("getUpiOfUnderlying", _upiData -> _upiData.getUpiOfUnderlying())).andNullSafe(exists(MapperS.of(upiData).<AnnaDsbUpiRecord>map("getUpiRecord", _upiData -> _upiData.getUpiRecord())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UpiDataCardinalityVerification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UpiData upiData) {
			return Collections.emptyList();
		}
	}
}
