package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier3Choice__1;
import iso20022.auth030.jfsa.validation.UniqueTransactionIdentifier3Choice__1TypeFormatValidator;
import iso20022.auth030.jfsa.validation.UniqueTransactionIdentifier3Choice__1Validator;
import iso20022.auth030.jfsa.validation.datarule.UniqueTransactionIdentifier3Choice__1Choice;
import iso20022.auth030.jfsa.validation.exists.UniqueTransactionIdentifier3Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UniqueTransactionIdentifier3Choice__1.class)
public class UniqueTransactionIdentifier3Choice__1Meta implements RosettaMetaData<UniqueTransactionIdentifier3Choice__1> {

	@Override
	public List<Validator<? super UniqueTransactionIdentifier3Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<UniqueTransactionIdentifier3Choice__1>create(UniqueTransactionIdentifier3Choice__1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super UniqueTransactionIdentifier3Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UniqueTransactionIdentifier3Choice__1> validator(ValidatorFactory factory) {
		return factory.<UniqueTransactionIdentifier3Choice__1>create(UniqueTransactionIdentifier3Choice__1Validator.class);
	}

	@Override
	public Validator<? super UniqueTransactionIdentifier3Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UniqueTransactionIdentifier3Choice__1>create(UniqueTransactionIdentifier3Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UniqueTransactionIdentifier3Choice__1> validator() {
		return new UniqueTransactionIdentifier3Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super UniqueTransactionIdentifier3Choice__1> typeFormatValidator() {
		return new UniqueTransactionIdentifier3Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UniqueTransactionIdentifier3Choice__1, Set<String>> onlyExistsValidator() {
		return new UniqueTransactionIdentifier3Choice__1OnlyExistsValidator();
	}
}
