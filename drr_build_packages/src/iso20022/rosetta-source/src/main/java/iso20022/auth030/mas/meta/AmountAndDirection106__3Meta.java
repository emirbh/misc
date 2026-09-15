package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.AmountAndDirection106__3;
import iso20022.auth030.mas.validation.AmountAndDirection106__3TypeFormatValidator;
import iso20022.auth030.mas.validation.AmountAndDirection106__3Validator;
import iso20022.auth030.mas.validation.exists.AmountAndDirection106__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmountAndDirection106__3.class)
public class AmountAndDirection106__3Meta implements RosettaMetaData<AmountAndDirection106__3> {

	@Override
	public List<Validator<? super AmountAndDirection106__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountAndDirection106__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmountAndDirection106__3> validator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__3>create(AmountAndDirection106__3Validator.class);
	}

	@Override
	public Validator<? super AmountAndDirection106__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmountAndDirection106__3>create(AmountAndDirection106__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__3> validator() {
		return new AmountAndDirection106__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AmountAndDirection106__3> typeFormatValidator() {
		return new AmountAndDirection106__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountAndDirection106__3, Set<String>> onlyExistsValidator() {
		return new AmountAndDirection106__3OnlyExistsValidator();
	}
}
