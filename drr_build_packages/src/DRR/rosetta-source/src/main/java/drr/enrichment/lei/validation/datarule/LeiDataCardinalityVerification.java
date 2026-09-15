package drr.enrichment.lei.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.lei.LeiCategoryEnum;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.LeiStatusEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("LeiDataCardinalityVerification")
@ImplementedBy(LeiDataCardinalityVerification.Default.class)
public interface LeiDataCardinalityVerification extends Validator<LeiData> {
	
	String NAME = "LeiDataCardinalityVerification";
	String DEFINITION = "if leiValidation is absent or leiValidation = True then lei exists and entityCategory exists and entityStatus exists and registrationStatus exists and registrationDate exists and published exists";
	
	class Default implements LeiDataCardinalityVerification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LeiData leiData) {
			ComparisonResult result = executeDataRule(leiData);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LeiData", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LeiData", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LeiData leiData) {
			try {
				if (notExists(MapperS.of(leiData).<Boolean>map("getLeiValidation", _leiData -> _leiData.getLeiValidation())).orNullSafe(areEqual(MapperS.of(leiData).<Boolean>map("getLeiValidation", _leiData -> _leiData.getLeiValidation()), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(leiData).<String>map("getLei", _leiData -> _leiData.getLei())).andNullSafe(exists(MapperS.of(leiData).<LeiCategoryEnum>map("getEntityCategory", _leiData -> _leiData.getEntityCategory()))).andNullSafe(exists(MapperS.of(leiData).<LeiStatusEnum>map("getEntityStatus", _leiData -> _leiData.getEntityStatus()))).andNullSafe(exists(MapperS.of(leiData).<LeiRegistrationStatusEnum>map("getRegistrationStatus", _leiData -> _leiData.getRegistrationStatus()))).andNullSafe(exists(MapperS.of(leiData).<ZonedDateTime>map("getRegistrationDate", _leiData -> _leiData.getRegistrationDate()))).andNullSafe(exists(MapperS.of(leiData).<Boolean>map("getPublished", _leiData -> _leiData.getPublished())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LeiDataCardinalityVerification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LeiData leiData) {
			return Collections.emptyList();
		}
	}
}
