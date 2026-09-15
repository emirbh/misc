package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityDeliveryFirm;
import fpml.consolidated.com.validation.ElectricityDeliveryFirmTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityDeliveryFirmValidator;
import fpml.consolidated.com.validation.exists.ElectricityDeliveryFirmOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityDeliveryFirm.class)
public class ElectricityDeliveryFirmMeta implements RosettaMetaData<ElectricityDeliveryFirm> {

	@Override
	public List<Validator<? super ElectricityDeliveryFirm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliveryFirm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityDeliveryFirm> validator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryFirm>create(ElectricityDeliveryFirmValidator.class);
	}

	@Override
	public Validator<? super ElectricityDeliveryFirm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryFirm>create(ElectricityDeliveryFirmTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryFirm> validator() {
		return new ElectricityDeliveryFirmValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryFirm> typeFormatValidator() {
		return new ElectricityDeliveryFirmTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliveryFirm, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryFirmOnlyExistsValidator();
	}
}
