package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AmountAndDirection109__1;
import iso20022.auth030.fca.validation.AmountAndDirection109__1TypeFormatValidator;
import iso20022.auth030.fca.validation.AmountAndDirection109__1Validator;
import iso20022.auth030.fca.validation.exists.AmountAndDirection109__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmountAndDirection109__1.class)
public class AmountAndDirection109__1Meta implements RosettaMetaData<AmountAndDirection109__1> {

	@Override
	public List<Validator<? super AmountAndDirection109__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountAndDirection109__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountAndDirection109__1> validator(ValidatorFactory factory) {
		return factory.<AmountAndDirection109__1>create(AmountAndDirection109__1Validator.class);
	}

	@Override
	public Validator<? super AmountAndDirection109__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountAndDirection109__1>create(AmountAndDirection109__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection109__1> validator() {
		return new AmountAndDirection109__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection109__1> typeFormatValidator() {
		return new AmountAndDirection109__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountAndDirection109__1, Set<String>> onlyExistsValidator() {
		return new AmountAndDirection109__1OnlyExistsValidator();
	}
}
