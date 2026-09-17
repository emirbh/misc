package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityDelivery;
import fpml.consolidated.com.validation.ElectricityDeliveryTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityDeliveryValidator;
import fpml.consolidated.com.validation.datarule.ElectricityDeliveryChoice;
import fpml.consolidated.com.validation.exists.ElectricityDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityDelivery.class)
public class ElectricityDeliveryMeta implements RosettaMetaData<ElectricityDelivery> {

	@Override
	public List<Validator<? super ElectricityDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ElectricityDelivery>create(ElectricityDeliveryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ElectricityDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityDelivery> validator(ValidatorFactory factory) {
		return factory.<ElectricityDelivery>create(ElectricityDeliveryValidator.class);
	}

	@Override
	public Validator<? super ElectricityDelivery> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityDelivery>create(ElectricityDeliveryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDelivery> validator() {
		return new ElectricityDeliveryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDelivery> typeFormatValidator() {
		return new ElectricityDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDelivery, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryOnlyExistsValidator();
	}
}
