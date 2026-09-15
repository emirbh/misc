package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.FloatingRate13__1;
import iso20022.auth030.jfsa.validation.FloatingRate13__1TypeFormatValidator;
import iso20022.auth030.jfsa.validation.FloatingRate13__1Validator;
import iso20022.auth030.jfsa.validation.exists.FloatingRate13__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FloatingRate13__1.class)
public class FloatingRate13__1Meta implements RosettaMetaData<FloatingRate13__1> {

	@Override
	public List<Validator<? super FloatingRate13__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRate13__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRate13__1> validator(ValidatorFactory factory) {
		return factory.<FloatingRate13__1>create(FloatingRate13__1Validator.class);
	}

	@Override
	public Validator<? super FloatingRate13__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRate13__1>create(FloatingRate13__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRate13__1> validator() {
		return new FloatingRate13__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRate13__1> typeFormatValidator() {
		return new FloatingRate13__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRate13__1, Set<String>> onlyExistsValidator() {
		return new FloatingRate13__1OnlyExistsValidator();
	}
}
