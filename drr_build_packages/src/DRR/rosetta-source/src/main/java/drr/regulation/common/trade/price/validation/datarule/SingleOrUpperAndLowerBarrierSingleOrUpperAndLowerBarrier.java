package drr.regulation.common.trade.price.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier")
@ImplementedBy(SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier.Default.class)
public interface SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier extends Validator<SingleOrUpperAndLowerBarrier> {
	
	String NAME = "SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier";
	String DEFINITION = "if _single exists then upper is absent and lower is absent else upper exists and lower exists";
	
	class Default implements SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleOrUpperAndLowerBarrier singleOrUpperAndLowerBarrier) {
			ComparisonResult result = executeDataRule(singleOrUpperAndLowerBarrier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SingleOrUpperAndLowerBarrier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SingleOrUpperAndLowerBarrier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SingleOrUpperAndLowerBarrier singleOrUpperAndLowerBarrier) {
			try {
				if (exists(MapperS.of(singleOrUpperAndLowerBarrier).<BarrierPrice>map("get_single", _singleOrUpperAndLowerBarrier -> _singleOrUpperAndLowerBarrier.get_single())).getOrDefault(false)) {
					return notExists(MapperS.of(singleOrUpperAndLowerBarrier).<BarrierPrice>map("getUpper", _singleOrUpperAndLowerBarrier -> _singleOrUpperAndLowerBarrier.getUpper())).andNullSafe(notExists(MapperS.of(singleOrUpperAndLowerBarrier).<BarrierPrice>map("getLower", _singleOrUpperAndLowerBarrier -> _singleOrUpperAndLowerBarrier.getLower())));
				}
				return exists(MapperS.of(singleOrUpperAndLowerBarrier).<BarrierPrice>map("getUpper", _singleOrUpperAndLowerBarrier -> _singleOrUpperAndLowerBarrier.getUpper())).andNullSafe(exists(MapperS.of(singleOrUpperAndLowerBarrier).<BarrierPrice>map("getLower", _singleOrUpperAndLowerBarrier -> _singleOrUpperAndLowerBarrier.getLower())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleOrUpperAndLowerBarrier singleOrUpperAndLowerBarrier) {
			return Collections.emptyList();
		}
	}
}
