package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxDateOffset;
import fpml.consolidated.fx.targets.validation.FxDateOffsetTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxDateOffsetValidator;
import fpml.consolidated.fx.targets.validation.exists.FxDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDateOffset.class)
public class FxDateOffsetMeta implements RosettaMetaData<FxDateOffset> {

	@Override
	public List<Validator<? super FxDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDateOffset> validator(ValidatorFactory factory) {
		return factory.<FxDateOffset>create(FxDateOffsetValidator.class);
	}

	@Override
	public Validator<? super FxDateOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDateOffset>create(FxDateOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDateOffset> validator() {
		return new FxDateOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDateOffset> typeFormatValidator() {
		return new FxDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDateOffset, Set<String>> onlyExistsValidator() {
		return new FxDateOffsetOnlyExistsValidator();
	}
}
