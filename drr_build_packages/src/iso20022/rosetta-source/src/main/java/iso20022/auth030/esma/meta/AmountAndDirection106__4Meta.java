package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AmountAndDirection106__4;
import iso20022.auth030.esma.validation.AmountAndDirection106__4TypeFormatValidator;
import iso20022.auth030.esma.validation.AmountAndDirection106__4Validator;
import iso20022.auth030.esma.validation.exists.AmountAndDirection106__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmountAndDirection106__4.class)
public class AmountAndDirection106__4Meta implements RosettaMetaData<AmountAndDirection106__4> {

	@Override
	public List<Validator<? super AmountAndDirection106__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountAndDirection106__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountAndDirection106__4> validator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__4>create(AmountAndDirection106__4Validator.class);
	}

	@Override
	public Validator<? super AmountAndDirection106__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__4>create(AmountAndDirection106__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__4> validator() {
		return new AmountAndDirection106__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__4> typeFormatValidator() {
		return new AmountAndDirection106__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountAndDirection106__4, Set<String>> onlyExistsValidator() {
		return new AmountAndDirection106__4OnlyExistsValidator();
	}
}
