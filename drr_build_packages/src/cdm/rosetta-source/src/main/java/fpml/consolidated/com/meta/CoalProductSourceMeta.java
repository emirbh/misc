package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalProductSource;
import fpml.consolidated.com.validation.CoalProductSourceTypeFormatValidator;
import fpml.consolidated.com.validation.CoalProductSourceValidator;
import fpml.consolidated.com.validation.exists.CoalProductSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalProductSource.class)
public class CoalProductSourceMeta implements RosettaMetaData<CoalProductSource> {

	@Override
	public List<Validator<? super CoalProductSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalProductSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalProductSource> validator(ValidatorFactory factory) {
		return factory.<CoalProductSource>create(CoalProductSourceValidator.class);
	}

	@Override
	public Validator<? super CoalProductSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalProductSource>create(CoalProductSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalProductSource> validator() {
		return new CoalProductSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalProductSource> typeFormatValidator() {
		return new CoalProductSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalProductSource, Set<String>> onlyExistsValidator() {
		return new CoalProductSourceOnlyExistsValidator();
	}
}
