package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityDeliverySystemFirm;
import fpml.consolidated.com.validation.ElectricityDeliverySystemFirmTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityDeliverySystemFirmValidator;
import fpml.consolidated.com.validation.exists.ElectricityDeliverySystemFirmOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityDeliverySystemFirm.class)
public class ElectricityDeliverySystemFirmMeta implements RosettaMetaData<ElectricityDeliverySystemFirm> {

	@Override
	public List<Validator<? super ElectricityDeliverySystemFirm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliverySystemFirm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityDeliverySystemFirm> validator(ValidatorFactory factory) {
		return factory.<ElectricityDeliverySystemFirm>create(ElectricityDeliverySystemFirmValidator.class);
	}

	@Override
	public Validator<? super ElectricityDeliverySystemFirm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityDeliverySystemFirm>create(ElectricityDeliverySystemFirmTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliverySystemFirm> validator() {
		return new ElectricityDeliverySystemFirmValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliverySystemFirm> typeFormatValidator() {
		return new ElectricityDeliverySystemFirmTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliverySystemFirm, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliverySystemFirmOnlyExistsValidator();
	}
}
