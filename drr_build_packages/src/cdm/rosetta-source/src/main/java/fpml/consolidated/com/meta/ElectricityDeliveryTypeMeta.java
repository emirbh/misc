package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityDeliveryType;
import fpml.consolidated.com.validation.ElectricityDeliveryTypeTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityDeliveryTypeValidator;
import fpml.consolidated.com.validation.datarule.ElectricityDeliveryTypeChoice;
import fpml.consolidated.com.validation.exists.ElectricityDeliveryTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityDeliveryType.class)
public class ElectricityDeliveryTypeMeta implements RosettaMetaData<ElectricityDeliveryType> {

	@Override
	public List<Validator<? super ElectricityDeliveryType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ElectricityDeliveryType>create(ElectricityDeliveryTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliveryType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityDeliveryType> validator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryType>create(ElectricityDeliveryTypeValidator.class);
	}

	@Override
	public Validator<? super ElectricityDeliveryType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryType>create(ElectricityDeliveryTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryType> validator() {
		return new ElectricityDeliveryTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryType> typeFormatValidator() {
		return new ElectricityDeliveryTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliveryType, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryTypeOnlyExistsValidator();
	}
}
