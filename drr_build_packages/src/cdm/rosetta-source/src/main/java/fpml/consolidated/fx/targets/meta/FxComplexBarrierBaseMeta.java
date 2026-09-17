package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxComplexBarrierBase;
import fpml.consolidated.fx.targets.validation.FxComplexBarrierBaseTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxComplexBarrierBaseValidator;
import fpml.consolidated.fx.targets.validation.exists.FxComplexBarrierBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxComplexBarrierBase.class)
public class FxComplexBarrierBaseMeta implements RosettaMetaData<FxComplexBarrierBase> {

	@Override
	public List<Validator<? super FxComplexBarrierBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxComplexBarrierBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxComplexBarrierBase> validator(ValidatorFactory factory) {
		return factory.<FxComplexBarrierBase>create(FxComplexBarrierBaseValidator.class);
	}

	@Override
	public Validator<? super FxComplexBarrierBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxComplexBarrierBase>create(FxComplexBarrierBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxComplexBarrierBase> validator() {
		return new FxComplexBarrierBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxComplexBarrierBase> typeFormatValidator() {
		return new FxComplexBarrierBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxComplexBarrierBase, Set<String>> onlyExistsValidator() {
		return new FxComplexBarrierBaseOnlyExistsValidator();
	}
}
