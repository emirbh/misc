package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.CompoundingFrequency;
import fpml.consolidated.mktenv.validation.CompoundingFrequencyTypeFormatValidator;
import fpml.consolidated.mktenv.validation.CompoundingFrequencyValidator;
import fpml.consolidated.mktenv.validation.exists.CompoundingFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CompoundingFrequency.class)
public class CompoundingFrequencyMeta implements RosettaMetaData<CompoundingFrequency> {

	@Override
	public List<Validator<? super CompoundingFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CompoundingFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CompoundingFrequency> validator(ValidatorFactory factory) {
		return factory.<CompoundingFrequency>create(CompoundingFrequencyValidator.class);
	}

	@Override
	public Validator<? super CompoundingFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CompoundingFrequency>create(CompoundingFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CompoundingFrequency> validator() {
		return new CompoundingFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CompoundingFrequency> typeFormatValidator() {
		return new CompoundingFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompoundingFrequency, Set<String>> onlyExistsValidator() {
		return new CompoundingFrequencyOnlyExistsValidator();
	}
}
