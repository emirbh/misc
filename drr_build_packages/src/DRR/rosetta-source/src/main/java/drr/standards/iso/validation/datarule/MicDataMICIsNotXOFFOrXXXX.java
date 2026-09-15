package drr.standards.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iso.MicData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MicDataMICIsNotXOFFOrXXXX")
@ImplementedBy(MicDataMICIsNotXOFFOrXXXX.Default.class)
public interface MicDataMICIsNotXOFFOrXXXX extends Validator<MicData> {
	
	String NAME = "MicDataMICIsNotXOFFOrXXXX";
	String DEFINITION = "if mic exists and mic <> \"XXXX\" and mic <> \"XOFF\" then nameInstitutionDescription exists and countryCode exists and city exists and status exists and creationDate exists";
	
	class Default implements MicDataMICIsNotXOFFOrXXXX {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MicData micData) {
			ComparisonResult result = executeDataRule(micData);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MicData", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MicData", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MicData micData) {
			try {
				if (exists(MapperS.of(micData).<String>map("getMic", _micData -> _micData.getMic())).andNullSafe(notEqual(MapperS.of(micData).<String>map("getMic", _micData -> _micData.getMic()), MapperS.of("XXXX"), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(micData).<String>map("getMic", _micData -> _micData.getMic()), MapperS.of("XOFF"), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(micData).<String>map("getNameInstitutionDescription", _micData -> _micData.getNameInstitutionDescription())).andNullSafe(exists(MapperS.of(micData).<String>map("getCountryCode", _micData -> _micData.getCountryCode()))).andNullSafe(exists(MapperS.of(micData).<String>map("getCity", _micData -> _micData.getCity()))).andNullSafe(exists(MapperS.of(micData).<String>map("getStatus", _micData -> _micData.getStatus()))).andNullSafe(exists(MapperS.of(micData).<Date>map("getCreationDate", _micData -> _micData.getCreationDate())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MicDataMICIsNotXOFFOrXXXX {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MicData micData) {
			return Collections.emptyList();
		}
	}
}
