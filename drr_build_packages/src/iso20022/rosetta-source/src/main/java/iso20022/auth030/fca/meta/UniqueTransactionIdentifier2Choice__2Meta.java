package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.UniqueTransactionIdentifier2Choice__2;
import iso20022.auth030.fca.validation.UniqueTransactionIdentifier2Choice__2TypeFormatValidator;
import iso20022.auth030.fca.validation.UniqueTransactionIdentifier2Choice__2Validator;
import iso20022.auth030.fca.validation.datarule.UniqueTransactionIdentifier2Choice__2Choice;
import iso20022.auth030.fca.validation.exists.UniqueTransactionIdentifier2Choice__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UniqueTransactionIdentifier2Choice__2.class)
public class UniqueTransactionIdentifier2Choice__2Meta implements RosettaMetaData<UniqueTransactionIdentifier2Choice__2> {

	@Override
	public List<Validator<? super UniqueTransactionIdentifier2Choice__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<UniqueTransactionIdentifier2Choice__2>create(UniqueTransactionIdentifier2Choice__2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super UniqueTransactionIdentifier2Choice__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice__2> validator(ValidatorFactory factory) {
		return factory.<UniqueTransactionIdentifier2Choice__2>create(UniqueTransactionIdentifier2Choice__2Validator.class);
	}

	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UniqueTransactionIdentifier2Choice__2>create(UniqueTransactionIdentifier2Choice__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice__2> validator() {
		return new UniqueTransactionIdentifier2Choice__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super UniqueTransactionIdentifier2Choice__2> typeFormatValidator() {
		return new UniqueTransactionIdentifier2Choice__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UniqueTransactionIdentifier2Choice__2, Set<String>> onlyExistsValidator() {
		return new UniqueTransactionIdentifier2Choice__2OnlyExistsValidator();
	}
}
