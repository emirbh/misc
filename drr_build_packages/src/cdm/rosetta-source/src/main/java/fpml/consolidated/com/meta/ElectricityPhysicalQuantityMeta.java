package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityPhysicalQuantity;
import fpml.consolidated.com.validation.ElectricityPhysicalQuantityTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityPhysicalQuantityValidator;
import fpml.consolidated.com.validation.datarule.ElectricityPhysicalQuantityChoice;
import fpml.consolidated.com.validation.exists.ElectricityPhysicalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityPhysicalQuantity.class)
public class ElectricityPhysicalQuantityMeta implements RosettaMetaData<ElectricityPhysicalQuantity> {

	@Override
	public List<Validator<? super ElectricityPhysicalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ElectricityPhysicalQuantity>create(ElectricityPhysicalQuantityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ElectricityPhysicalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityPhysicalQuantity> validator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalQuantity>create(ElectricityPhysicalQuantityValidator.class);
	}

	@Override
	public Validator<? super ElectricityPhysicalQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalQuantity>create(ElectricityPhysicalQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalQuantity> validator() {
		return new ElectricityPhysicalQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalQuantity> typeFormatValidator() {
		return new ElectricityPhysicalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityPhysicalQuantity, Set<String>> onlyExistsValidator() {
		return new ElectricityPhysicalQuantityOnlyExistsValidator();
	}
}
