package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.StubValue;
import fpml.consolidated.shared.validation.StubValueTypeFormatValidator;
import fpml.consolidated.shared.validation.StubValueValidator;
import fpml.consolidated.shared.validation.datarule.StubValueChoice;
import fpml.consolidated.shared.validation.exists.StubValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StubValue.class)
public class StubValueMeta implements RosettaMetaData<StubValue> {

	@Override
	public List<Validator<? super StubValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<StubValue>create(StubValueChoice.class)
		);
	}
	
	@Override
	public List<Function<? super StubValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StubValue> validator(ValidatorFactory factory) {
		return factory.<StubValue>create(StubValueValidator.class);
	}

	@Override
	public Validator<? super StubValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StubValue>create(StubValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StubValue> validator() {
		return new StubValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StubValue> typeFormatValidator() {
		return new StubValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubValue, Set<String>> onlyExistsValidator() {
		return new StubValueOnlyExistsValidator();
	}
}
