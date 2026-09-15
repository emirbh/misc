package drr.regulation.common.trade.quantity.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.trade.quantity.QuantityFrequency;
import drr.regulation.common.trade.quantity.validation.QuantityFrequencyTypeFormatValidator;
import drr.regulation.common.trade.quantity.validation.QuantityFrequencyValidator;
import drr.regulation.common.trade.quantity.validation.exists.QuantityFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=QuantityFrequency.class)
public class QuantityFrequencyMeta implements RosettaMetaData<QuantityFrequency> {

	@Override
	public List<Validator<? super QuantityFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuantityFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuantityFrequency> validator(ValidatorFactory factory) {
		return factory.<QuantityFrequency>create(QuantityFrequencyValidator.class);
	}

	@Override
	public Validator<? super QuantityFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QuantityFrequency>create(QuantityFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QuantityFrequency> validator() {
		return new QuantityFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QuantityFrequency> typeFormatValidator() {
		return new QuantityFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantityFrequency, Set<String>> onlyExistsValidator() {
		return new QuantityFrequencyOnlyExistsValidator();
	}
}
