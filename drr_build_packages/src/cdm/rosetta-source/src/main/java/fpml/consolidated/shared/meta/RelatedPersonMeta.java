package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RelatedPerson;
import fpml.consolidated.shared.validation.RelatedPersonTypeFormatValidator;
import fpml.consolidated.shared.validation.RelatedPersonValidator;
import fpml.consolidated.shared.validation.exists.RelatedPersonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RelatedPerson.class)
public class RelatedPersonMeta implements RosettaMetaData<RelatedPerson> {

	@Override
	public List<Validator<? super RelatedPerson>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelatedPerson, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelatedPerson> validator(ValidatorFactory factory) {
		return factory.<RelatedPerson>create(RelatedPersonValidator.class);
	}

	@Override
	public Validator<? super RelatedPerson> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelatedPerson>create(RelatedPersonTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelatedPerson> validator() {
		return new RelatedPersonValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelatedPerson> typeFormatValidator() {
		return new RelatedPersonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelatedPerson, Set<String>> onlyExistsValidator() {
		return new RelatedPersonOnlyExistsValidator();
	}
}
