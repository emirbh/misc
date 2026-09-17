package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxPayoffCap;
import fpml.consolidated.fx.targets.validation.FxPayoffCapTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxPayoffCapValidator;
import fpml.consolidated.fx.targets.validation.exists.FxPayoffCapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxPayoffCap.class)
public class FxPayoffCapMeta implements RosettaMetaData<FxPayoffCap> {

	@Override
	public List<Validator<? super FxPayoffCap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPayoffCap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxPayoffCap> validator(ValidatorFactory factory) {
		return factory.<FxPayoffCap>create(FxPayoffCapValidator.class);
	}

	@Override
	public Validator<? super FxPayoffCap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxPayoffCap>create(FxPayoffCapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxPayoffCap> validator() {
		return new FxPayoffCapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxPayoffCap> typeFormatValidator() {
		return new FxPayoffCapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPayoffCap, Set<String>> onlyExistsValidator() {
		return new FxPayoffCapOnlyExistsValidator();
	}
}
