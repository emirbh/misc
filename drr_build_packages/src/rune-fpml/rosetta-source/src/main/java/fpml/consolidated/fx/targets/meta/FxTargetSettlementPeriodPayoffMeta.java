package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriodPayoff;
import fpml.consolidated.fx.targets.validation.FxTargetSettlementPeriodPayoffTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetSettlementPeriodPayoffValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetSettlementPeriodPayoffOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetSettlementPeriodPayoff.class)
public class FxTargetSettlementPeriodPayoffMeta implements RosettaMetaData<FxTargetSettlementPeriodPayoff> {

	@Override
	public List<Validator<? super FxTargetSettlementPeriodPayoff>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetSettlementPeriodPayoff, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetSettlementPeriodPayoff> validator(ValidatorFactory factory) {
		return factory.<FxTargetSettlementPeriodPayoff>create(FxTargetSettlementPeriodPayoffValidator.class);
	}

	@Override
	public Validator<? super FxTargetSettlementPeriodPayoff> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetSettlementPeriodPayoff>create(FxTargetSettlementPeriodPayoffTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetSettlementPeriodPayoff> validator() {
		return new FxTargetSettlementPeriodPayoffValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetSettlementPeriodPayoff> typeFormatValidator() {
		return new FxTargetSettlementPeriodPayoffTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetSettlementPeriodPayoff, Set<String>> onlyExistsValidator() {
		return new FxTargetSettlementPeriodPayoffOnlyExistsValidator();
	}
}
