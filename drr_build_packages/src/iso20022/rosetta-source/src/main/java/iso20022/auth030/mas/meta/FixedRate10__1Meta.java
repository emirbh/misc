package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.FixedRate10__1;
import iso20022.auth030.mas.validation.FixedRate10__1TypeFormatValidator;
import iso20022.auth030.mas.validation.FixedRate10__1Validator;
import iso20022.auth030.mas.validation.exists.FixedRate10__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedRate10__1.class)
public class FixedRate10__1Meta implements RosettaMetaData<FixedRate10__1> {

	@Override
	public List<Validator<? super FixedRate10__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRate10__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedRate10__1> validator(ValidatorFactory factory) {
		return factory.<FixedRate10__1>create(FixedRate10__1Validator.class);
	}

	@Override
	public Validator<? super FixedRate10__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FixedRate10__1>create(FixedRate10__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FixedRate10__1> validator() {
		return new FixedRate10__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FixedRate10__1> typeFormatValidator() {
		return new FixedRate10__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRate10__1, Set<String>> onlyExistsValidator() {
		return new FixedRate10__1OnlyExistsValidator();
	}
}
