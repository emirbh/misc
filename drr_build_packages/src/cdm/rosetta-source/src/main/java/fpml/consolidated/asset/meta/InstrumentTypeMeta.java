package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.asset.validation.InstrumentTypeTypeFormatValidator;
import fpml.consolidated.asset.validation.InstrumentTypeValidator;
import fpml.consolidated.asset.validation.exists.InstrumentTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InstrumentType.class)
public class InstrumentTypeMeta implements RosettaMetaData<InstrumentType> {

	@Override
	public List<Validator<? super InstrumentType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InstrumentType> validator(ValidatorFactory factory) {
		return factory.<InstrumentType>create(InstrumentTypeValidator.class);
	}

	@Override
	public Validator<? super InstrumentType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InstrumentType>create(InstrumentTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentType> validator() {
		return new InstrumentTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentType> typeFormatValidator() {
		return new InstrumentTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentType, Set<String>> onlyExistsValidator() {
		return new InstrumentTypeOnlyExistsValidator();
	}
}
