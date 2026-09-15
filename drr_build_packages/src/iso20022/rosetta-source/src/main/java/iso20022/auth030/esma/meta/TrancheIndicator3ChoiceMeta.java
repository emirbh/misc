package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.TrancheIndicator3Choice;
import iso20022.auth030.esma.validation.TrancheIndicator3ChoiceTypeFormatValidator;
import iso20022.auth030.esma.validation.TrancheIndicator3ChoiceValidator;
import iso20022.auth030.esma.validation.datarule.TrancheIndicator3ChoiceChoice;
import iso20022.auth030.esma.validation.exists.TrancheIndicator3ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TrancheIndicator3Choice.class)
public class TrancheIndicator3ChoiceMeta implements RosettaMetaData<TrancheIndicator3Choice> {

	@Override
	public List<Validator<? super TrancheIndicator3Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TrancheIndicator3Choice>create(TrancheIndicator3ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TrancheIndicator3Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TrancheIndicator3Choice> validator(ValidatorFactory factory) {
		return factory.<TrancheIndicator3Choice>create(TrancheIndicator3ChoiceValidator.class);
	}

	@Override
	public Validator<? super TrancheIndicator3Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TrancheIndicator3Choice>create(TrancheIndicator3ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TrancheIndicator3Choice> validator() {
		return new TrancheIndicator3ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TrancheIndicator3Choice> typeFormatValidator() {
		return new TrancheIndicator3ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TrancheIndicator3Choice, Set<String>> onlyExistsValidator() {
		return new TrancheIndicator3ChoiceOnlyExistsValidator();
	}
}
