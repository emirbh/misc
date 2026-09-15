package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalDelivery;
import fpml.consolidated.com.validation.CoalDeliveryTypeFormatValidator;
import fpml.consolidated.com.validation.CoalDeliveryValidator;
import fpml.consolidated.com.validation.datarule.CoalDeliveryChoice;
import fpml.consolidated.com.validation.exists.CoalDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalDelivery.class)
public class CoalDeliveryMeta implements RosettaMetaData<CoalDelivery> {

	@Override
	public List<Validator<? super CoalDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CoalDelivery>create(CoalDeliveryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalDelivery> validator(ValidatorFactory factory) {
		return factory.<CoalDelivery>create(CoalDeliveryValidator.class);
	}

	@Override
	public Validator<? super CoalDelivery> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalDelivery>create(CoalDeliveryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalDelivery> validator() {
		return new CoalDeliveryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalDelivery> typeFormatValidator() {
		return new CoalDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalDelivery, Set<String>> onlyExistsValidator() {
		return new CoalDeliveryOnlyExistsValidator();
	}
}
