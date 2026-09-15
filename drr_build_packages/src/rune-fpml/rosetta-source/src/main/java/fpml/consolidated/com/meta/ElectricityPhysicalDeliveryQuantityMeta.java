package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityPhysicalDeliveryQuantity;
import fpml.consolidated.com.validation.ElectricityPhysicalDeliveryQuantityTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityPhysicalDeliveryQuantityValidator;
import fpml.consolidated.com.validation.exists.ElectricityPhysicalDeliveryQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityPhysicalDeliveryQuantity.class)
public class ElectricityPhysicalDeliveryQuantityMeta implements RosettaMetaData<ElectricityPhysicalDeliveryQuantity> {

	@Override
	public List<Validator<? super ElectricityPhysicalDeliveryQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityPhysicalDeliveryQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantity> validator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalDeliveryQuantity>create(ElectricityPhysicalDeliveryQuantityValidator.class);
	}

	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalDeliveryQuantity>create(ElectricityPhysicalDeliveryQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantity> validator() {
		return new ElectricityPhysicalDeliveryQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantity> typeFormatValidator() {
		return new ElectricityPhysicalDeliveryQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityPhysicalDeliveryQuantity, Set<String>> onlyExistsValidator() {
		return new ElectricityPhysicalDeliveryQuantityOnlyExistsValidator();
	}
}
