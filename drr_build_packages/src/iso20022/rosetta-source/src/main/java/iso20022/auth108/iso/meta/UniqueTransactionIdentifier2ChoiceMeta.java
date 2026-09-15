package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.UniqueTransactionIdentifier2Choice;
import iso20022.auth108.iso.validation.UniqueTransactionIdentifier2ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.UniqueTransactionIdentifier2ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.UniqueTransactionIdentifier2ChoiceChoice;
import iso20022.auth108.iso.validation.exists.UniqueTransactionIdentifier2ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UniqueTransactionIdentifier2Choice.class)
public class UniqueTransactionIdentifier2ChoiceMeta implements RosettaMetaData<UniqueTransactionIdentifier2Choice> {

	@Override
	public List<Validator<? super UniqueTransactionIdentifier2Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<UniqueTransactionIdentifier2Choice>create(UniqueTransactionIdentifier2ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super UniqueTransactionIdentifier2Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice> validator(ValidatorFactory factory) {
		return factory.<UniqueTransactionIdentifier2Choice>create(UniqueTransactionIdentifier2ChoiceValidator.class);
	}

	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UniqueTransactionIdentifier2Choice>create(UniqueTransactionIdentifier2ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice> validator() {
		return new UniqueTransactionIdentifier2ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice> typeFormatValidator() {
		return new UniqueTransactionIdentifier2ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UniqueTransactionIdentifier2Choice, Set<String>> onlyExistsValidator() {
		return new UniqueTransactionIdentifier2ChoiceOnlyExistsValidator();
	}
}
