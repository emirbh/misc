package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityDeliveryUnitFirm;
import fpml.consolidated.com.validation.ElectricityDeliveryUnitFirmTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityDeliveryUnitFirmValidator;
import fpml.consolidated.com.validation.exists.ElectricityDeliveryUnitFirmOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityDeliveryUnitFirm.class)
public class ElectricityDeliveryUnitFirmMeta implements RosettaMetaData<ElectricityDeliveryUnitFirm> {

	@Override
	public List<Validator<? super ElectricityDeliveryUnitFirm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliveryUnitFirm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityDeliveryUnitFirm> validator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryUnitFirm>create(ElectricityDeliveryUnitFirmValidator.class);
	}

	@Override
	public Validator<? super ElectricityDeliveryUnitFirm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryUnitFirm>create(ElectricityDeliveryUnitFirmTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryUnitFirm> validator() {
		return new ElectricityDeliveryUnitFirmValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryUnitFirm> typeFormatValidator() {
		return new ElectricityDeliveryUnitFirmTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliveryUnitFirm, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryUnitFirmOnlyExistsValidator();
	}
}
