package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.NetAndGross;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("NetAndGrossChoice")
@ImplementedBy(NetAndGrossChoice.Default.class)
public interface NetAndGrossChoice extends Validator<NetAndGross> {
	
	String NAME = "NetAndGrossChoice";
	String DEFINITION = "gross exists or net exists";
	
	class Default implements NetAndGrossChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NetAndGross netAndGross) {
			ComparisonResult result = executeDataRule(netAndGross);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NetAndGross", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NetAndGross", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NetAndGross netAndGross) {
			try {
				return exists(MapperS.of(netAndGross).<BigDecimal>map("getGross", _netAndGross -> _netAndGross.getGross())).orNullSafe(exists(MapperS.of(netAndGross).<BigDecimal>map("getNet", _netAndGross -> _netAndGross.getNet())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NetAndGrossChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NetAndGross netAndGross) {
			return Collections.emptyList();
		}
	}
}
