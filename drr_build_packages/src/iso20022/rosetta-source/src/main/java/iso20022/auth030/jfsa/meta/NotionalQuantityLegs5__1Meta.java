package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.NotionalQuantityLegs5__1;
import iso20022.auth030.jfsa.validation.NotionalQuantityLegs5__1TypeFormatValidator;
import iso20022.auth030.jfsa.validation.NotionalQuantityLegs5__1Validator;
import iso20022.auth030.jfsa.validation.exists.NotionalQuantityLegs5__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalQuantityLegs5__1.class)
public class NotionalQuantityLegs5__1Meta implements RosettaMetaData<NotionalQuantityLegs5__1> {

	@Override
	public List<Validator<? super NotionalQuantityLegs5__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalQuantityLegs5__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalQuantityLegs5__1> validator(ValidatorFactory factory) {
		return factory.<NotionalQuantityLegs5__1>create(NotionalQuantityLegs5__1Validator.class);
	}

	@Override
	public Validator<? super NotionalQuantityLegs5__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalQuantityLegs5__1>create(NotionalQuantityLegs5__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantityLegs5__1> validator() {
		return new NotionalQuantityLegs5__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantityLegs5__1> typeFormatValidator() {
		return new NotionalQuantityLegs5__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalQuantityLegs5__1, Set<String>> onlyExistsValidator() {
		return new NotionalQuantityLegs5__1OnlyExistsValidator();
	}
}
