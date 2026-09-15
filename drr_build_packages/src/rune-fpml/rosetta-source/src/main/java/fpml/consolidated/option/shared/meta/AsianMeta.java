package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.Asian;
import fpml.consolidated.option.shared.validation.AsianTypeFormatValidator;
import fpml.consolidated.option.shared.validation.AsianValidator;
import fpml.consolidated.option.shared.validation.exists.AsianOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Asian.class)
public class AsianMeta implements RosettaMetaData<Asian> {

	@Override
	public List<Validator<? super Asian>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Asian, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Asian> validator(ValidatorFactory factory) {
		return factory.<Asian>create(AsianValidator.class);
	}

	@Override
	public Validator<? super Asian> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Asian>create(AsianTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Asian> validator() {
		return new AsianValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Asian> typeFormatValidator() {
		return new AsianTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Asian, Set<String>> onlyExistsValidator() {
		return new AsianOnlyExistsValidator();
	}
}
