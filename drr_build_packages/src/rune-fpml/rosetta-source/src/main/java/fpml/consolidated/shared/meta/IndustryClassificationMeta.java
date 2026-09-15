package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.IndustryClassification;
import fpml.consolidated.shared.validation.IndustryClassificationTypeFormatValidator;
import fpml.consolidated.shared.validation.IndustryClassificationValidator;
import fpml.consolidated.shared.validation.exists.IndustryClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IndustryClassification.class)
public class IndustryClassificationMeta implements RosettaMetaData<IndustryClassification> {

	@Override
	public List<Validator<? super IndustryClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndustryClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndustryClassification> validator(ValidatorFactory factory) {
		return factory.<IndustryClassification>create(IndustryClassificationValidator.class);
	}

	@Override
	public Validator<? super IndustryClassification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndustryClassification>create(IndustryClassificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndustryClassification> validator() {
		return new IndustryClassificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IndustryClassification> typeFormatValidator() {
		return new IndustryClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndustryClassification, Set<String>> onlyExistsValidator() {
		return new IndustryClassificationOnlyExistsValidator();
	}
}
