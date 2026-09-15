package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityTransmissionContingencyType;
import fpml.consolidated.com.validation.ElectricityTransmissionContingencyTypeTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityTransmissionContingencyTypeValidator;
import fpml.consolidated.com.validation.exists.ElectricityTransmissionContingencyTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityTransmissionContingencyType.class)
public class ElectricityTransmissionContingencyTypeMeta implements RosettaMetaData<ElectricityTransmissionContingencyType> {

	@Override
	public List<Validator<? super ElectricityTransmissionContingencyType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityTransmissionContingencyType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityTransmissionContingencyType> validator(ValidatorFactory factory) {
		return factory.<ElectricityTransmissionContingencyType>create(ElectricityTransmissionContingencyTypeValidator.class);
	}

	@Override
	public Validator<? super ElectricityTransmissionContingencyType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityTransmissionContingencyType>create(ElectricityTransmissionContingencyTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityTransmissionContingencyType> validator() {
		return new ElectricityTransmissionContingencyTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityTransmissionContingencyType> typeFormatValidator() {
		return new ElectricityTransmissionContingencyTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityTransmissionContingencyType, Set<String>> onlyExistsValidator() {
		return new ElectricityTransmissionContingencyTypeOnlyExistsValidator();
	}
}
