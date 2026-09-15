package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AmountAndDirection106__1;
import iso20022.auth030.esma.validation.AmountAndDirection106__1TypeFormatValidator;
import iso20022.auth030.esma.validation.AmountAndDirection106__1Validator;
import iso20022.auth030.esma.validation.exists.AmountAndDirection106__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmountAndDirection106__1.class)
public class AmountAndDirection106__1Meta implements RosettaMetaData<AmountAndDirection106__1> {

	@Override
	public List<Validator<? super AmountAndDirection106__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountAndDirection106__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountAndDirection106__1> validator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__1>create(AmountAndDirection106__1Validator.class);
	}

	@Override
	public Validator<? super AmountAndDirection106__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__1>create(AmountAndDirection106__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__1> validator() {
		return new AmountAndDirection106__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__1> typeFormatValidator() {
		return new AmountAndDirection106__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountAndDirection106__1, Set<String>> onlyExistsValidator() {
		return new AmountAndDirection106__1OnlyExistsValidator();
	}
}
