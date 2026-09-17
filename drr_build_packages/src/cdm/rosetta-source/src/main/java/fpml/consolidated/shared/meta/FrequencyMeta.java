package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.validation.FrequencyTypeFormatValidator;
import fpml.consolidated.shared.validation.FrequencyValidator;
import fpml.consolidated.shared.validation.exists.FrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Frequency.class)
public class FrequencyMeta implements RosettaMetaData<Frequency> {

	@Override
	public List<Validator<? super Frequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Frequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Frequency> validator(ValidatorFactory factory) {
		return factory.<Frequency>create(FrequencyValidator.class);
	}

	@Override
	public Validator<? super Frequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Frequency>create(FrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Frequency> validator() {
		return new FrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Frequency> typeFormatValidator() {
		return new FrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Frequency, Set<String>> onlyExistsValidator() {
		return new FrequencyOnlyExistsValidator();
	}
}
