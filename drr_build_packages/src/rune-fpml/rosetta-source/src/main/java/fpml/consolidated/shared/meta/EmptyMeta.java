package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Empty;
import fpml.consolidated.shared.validation.EmptyTypeFormatValidator;
import fpml.consolidated.shared.validation.EmptyValidator;
import fpml.consolidated.shared.validation.exists.EmptyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Empty.class)
public class EmptyMeta implements RosettaMetaData<Empty> {

	@Override
	public List<Validator<? super Empty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Empty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Empty> validator(ValidatorFactory factory) {
		return factory.<Empty>create(EmptyValidator.class);
	}

	@Override
	public Validator<? super Empty> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Empty>create(EmptyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Empty> validator() {
		return new EmptyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Empty> typeFormatValidator() {
		return new EmptyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Empty, Set<String>> onlyExistsValidator() {
		return new EmptyOnlyExistsValidator();
	}
}
