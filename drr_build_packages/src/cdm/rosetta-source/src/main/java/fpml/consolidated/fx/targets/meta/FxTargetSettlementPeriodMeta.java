package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriod;
import fpml.consolidated.fx.targets.validation.FxTargetSettlementPeriodTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetSettlementPeriodValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetSettlementPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetSettlementPeriod.class)
public class FxTargetSettlementPeriodMeta implements RosettaMetaData<FxTargetSettlementPeriod> {

	@Override
	public List<Validator<? super FxTargetSettlementPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetSettlementPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetSettlementPeriod> validator(ValidatorFactory factory) {
		return factory.<FxTargetSettlementPeriod>create(FxTargetSettlementPeriodValidator.class);
	}

	@Override
	public Validator<? super FxTargetSettlementPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetSettlementPeriod>create(FxTargetSettlementPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetSettlementPeriod> validator() {
		return new FxTargetSettlementPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetSettlementPeriod> typeFormatValidator() {
		return new FxTargetSettlementPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetSettlementPeriod, Set<String>> onlyExistsValidator() {
		return new FxTargetSettlementPeriodOnlyExistsValidator();
	}
}
