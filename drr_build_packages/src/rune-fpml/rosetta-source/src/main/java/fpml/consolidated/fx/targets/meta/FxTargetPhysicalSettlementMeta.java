package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetPhysicalSettlement;
import fpml.consolidated.fx.targets.validation.FxTargetPhysicalSettlementTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetPhysicalSettlementValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetPhysicalSettlementChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetPhysicalSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetPhysicalSettlement.class)
public class FxTargetPhysicalSettlementMeta implements RosettaMetaData<FxTargetPhysicalSettlement> {

	@Override
	public List<Validator<? super FxTargetPhysicalSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetPhysicalSettlement>create(FxTargetPhysicalSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetPhysicalSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetPhysicalSettlement> validator(ValidatorFactory factory) {
		return factory.<FxTargetPhysicalSettlement>create(FxTargetPhysicalSettlementValidator.class);
	}

	@Override
	public Validator<? super FxTargetPhysicalSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetPhysicalSettlement>create(FxTargetPhysicalSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetPhysicalSettlement> validator() {
		return new FxTargetPhysicalSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetPhysicalSettlement> typeFormatValidator() {
		return new FxTargetPhysicalSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetPhysicalSettlement, Set<String>> onlyExistsValidator() {
		return new FxTargetPhysicalSettlementOnlyExistsValidator();
	}
}
