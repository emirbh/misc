package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityPhysicalLeg;
import fpml.consolidated.com.validation.ElectricityPhysicalLegTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityPhysicalLegValidator;
import fpml.consolidated.com.validation.exists.ElectricityPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityPhysicalLeg.class)
public class ElectricityPhysicalLegMeta implements RosettaMetaData<ElectricityPhysicalLeg> {

	@Override
	public List<Validator<? super ElectricityPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityPhysicalLeg> validator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalLeg>create(ElectricityPhysicalLegValidator.class);
	}

	@Override
	public Validator<? super ElectricityPhysicalLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityPhysicalLeg>create(ElectricityPhysicalLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalLeg> validator() {
		return new ElectricityPhysicalLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityPhysicalLeg> typeFormatValidator() {
		return new ElectricityPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new ElectricityPhysicalLegOnlyExistsValidator();
	}
}
