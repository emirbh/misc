package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AmountAndDirection106__2;
import iso20022.auth030.fca.validation.AmountAndDirection106__2TypeFormatValidator;
import iso20022.auth030.fca.validation.AmountAndDirection106__2Validator;
import iso20022.auth030.fca.validation.exists.AmountAndDirection106__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmountAndDirection106__2.class)
public class AmountAndDirection106__2Meta implements RosettaMetaData<AmountAndDirection106__2> {

	@Override
	public List<Validator<? super AmountAndDirection106__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountAndDirection106__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountAndDirection106__2> validator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__2>create(AmountAndDirection106__2Validator.class);
	}

	@Override
	public Validator<? super AmountAndDirection106__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__2>create(AmountAndDirection106__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__2> validator() {
		return new AmountAndDirection106__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__2> typeFormatValidator() {
		return new AmountAndDirection106__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountAndDirection106__2, Set<String>> onlyExistsValidator() {
		return new AmountAndDirection106__2OnlyExistsValidator();
	}
}
