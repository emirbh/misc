package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AmountAndDirection106;
import iso20022.auth030.esma.validation.AmountAndDirection106TypeFormatValidator;
import iso20022.auth030.esma.validation.AmountAndDirection106Validator;
import iso20022.auth030.esma.validation.exists.AmountAndDirection106OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmountAndDirection106.class)
public class AmountAndDirection106Meta implements RosettaMetaData<AmountAndDirection106> {

	@Override
	public List<Validator<? super AmountAndDirection106>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountAndDirection106, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountAndDirection106> validator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106>create(AmountAndDirection106Validator.class);
	}

	@Override
	public Validator<? super AmountAndDirection106> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106>create(AmountAndDirection106TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106> validator() {
		return new AmountAndDirection106Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106> typeFormatValidator() {
		return new AmountAndDirection106TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountAndDirection106, Set<String>> onlyExistsValidator() {
		return new AmountAndDirection106OnlyExistsValidator();
	}
}
