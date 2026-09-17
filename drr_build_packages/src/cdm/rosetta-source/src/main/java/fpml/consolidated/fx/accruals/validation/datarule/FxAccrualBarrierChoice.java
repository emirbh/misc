package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualBarrier;
import fpml.consolidated.fx.accruals.FxRateObservableReference;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxAccrualBarrierChoice")
@ImplementedBy(FxAccrualBarrierChoice.Default.class)
public interface FxAccrualBarrierChoice extends Validator<FxAccrualBarrier> {
	
	String NAME = "FxAccrualBarrierChoice";
	String DEFINITION = "if quotedCurrencyPair exists then observableReference is absent else quotedCurrencyPair is absent and informationSource is absent";
	
	class Default implements FxAccrualBarrierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualBarrier fxAccrualBarrier) {
			ComparisonResult result = executeDataRule(fxAccrualBarrier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualBarrier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualBarrier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualBarrier fxAccrualBarrier) {
			try {
				if (exists(MapperS.of(fxAccrualBarrier).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _fxAccrualBarrier -> _fxAccrualBarrier.getQuotedCurrencyPair())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualBarrier).<FxRateObservableReference>map("getObservableReference", _fxAccrualBarrier -> _fxAccrualBarrier.getObservableReference()));
				}
				return notExists(MapperS.of(fxAccrualBarrier).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _fxAccrualBarrier -> _fxAccrualBarrier.getQuotedCurrencyPair())).andNullSafe(notExists(MapperS.of(fxAccrualBarrier).<InformationSource>mapC("getInformationSource", _fxAccrualBarrier -> _fxAccrualBarrier.getInformationSource())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualBarrierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualBarrier fxAccrualBarrier) {
			return Collections.emptyList();
		}
	}
}
