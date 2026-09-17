package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CompressionActivity;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.shared.TradeId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CompressionActivityChoice")
@ImplementedBy(CompressionActivityChoice.Default.class)
public interface CompressionActivityChoice extends Validator<CompressionActivity> {
	
	String NAME = "CompressionActivityChoice";
	String DEFINITION = "replacementTradeId is absent and originatingTradeId is absent or replacementTradeIdentifier is absent and originatingTradeIdentifier is absent";
	
	class Default implements CompressionActivityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompressionActivity compressionActivity) {
			ComparisonResult result = executeDataRule(compressionActivity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CompressionActivity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CompressionActivity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CompressionActivity compressionActivity) {
			try {
				return notExists(MapperS.of(compressionActivity).<TradeId>map("getReplacementTradeId", _compressionActivity -> _compressionActivity.getReplacementTradeId())).andNullSafe(notExists(MapperS.of(compressionActivity).<TradeId>mapC("getOriginatingTradeId", _compressionActivity -> _compressionActivity.getOriginatingTradeId()))).orNullSafe(notExists(MapperS.of(compressionActivity).<TradeIdentifier>map("getReplacementTradeIdentifier", _compressionActivity -> _compressionActivity.getReplacementTradeIdentifier())).andNullSafe(notExists(MapperS.of(compressionActivity).<TradeIdentifier>mapC("getOriginatingTradeIdentifier", _compressionActivity -> _compressionActivity.getOriginatingTradeIdentifier()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CompressionActivityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompressionActivity compressionActivity) {
			return Collections.emptyList();
		}
	}
}
