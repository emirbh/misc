package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.validation.InstrumentIdTypeFormatValidator;
import fpml.consolidated.shared.validation.InstrumentIdValidator;
import fpml.consolidated.shared.validation.exists.InstrumentIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InstrumentId.class)
public class InstrumentIdMeta implements RosettaMetaData<InstrumentId> {

	@Override
	public List<Validator<? super InstrumentId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InstrumentId> validator(ValidatorFactory factory) {
		return factory.<InstrumentId>create(InstrumentIdValidator.class);
	}

	@Override
	public Validator<? super InstrumentId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InstrumentId>create(InstrumentIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentId> validator() {
		return new InstrumentIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentId> typeFormatValidator() {
		return new InstrumentIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentId, Set<String>> onlyExistsValidator() {
		return new InstrumentIdOnlyExistsValidator();
	}
}
