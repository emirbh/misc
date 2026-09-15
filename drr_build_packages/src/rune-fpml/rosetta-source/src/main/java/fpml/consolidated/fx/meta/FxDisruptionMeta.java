package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDisruption;
import fpml.consolidated.fx.validation.FxDisruptionTypeFormatValidator;
import fpml.consolidated.fx.validation.FxDisruptionValidator;
import fpml.consolidated.fx.validation.exists.FxDisruptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDisruption.class)
public class FxDisruptionMeta implements RosettaMetaData<FxDisruption> {

	@Override
	public List<Validator<? super FxDisruption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDisruption> validator(ValidatorFactory factory) {
		return factory.<FxDisruption>create(FxDisruptionValidator.class);
	}

	@Override
	public Validator<? super FxDisruption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDisruption>create(FxDisruptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruption> validator() {
		return new FxDisruptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruption> typeFormatValidator() {
		return new FxDisruptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruption, Set<String>> onlyExistsValidator() {
		return new FxDisruptionOnlyExistsValidator();
	}
}
