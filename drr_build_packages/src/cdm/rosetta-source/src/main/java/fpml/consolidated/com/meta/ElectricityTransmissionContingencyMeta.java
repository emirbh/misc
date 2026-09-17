package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityTransmissionContingency;
import fpml.consolidated.com.validation.ElectricityTransmissionContingencyTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityTransmissionContingencyValidator;
import fpml.consolidated.com.validation.exists.ElectricityTransmissionContingencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityTransmissionContingency.class)
public class ElectricityTransmissionContingencyMeta implements RosettaMetaData<ElectricityTransmissionContingency> {

	@Override
	public List<Validator<? super ElectricityTransmissionContingency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityTransmissionContingency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityTransmissionContingency> validator(ValidatorFactory factory) {
		return factory.<ElectricityTransmissionContingency>create(ElectricityTransmissionContingencyValidator.class);
	}

	@Override
	public Validator<? super ElectricityTransmissionContingency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityTransmissionContingency>create(ElectricityTransmissionContingencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityTransmissionContingency> validator() {
		return new ElectricityTransmissionContingencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityTransmissionContingency> typeFormatValidator() {
		return new ElectricityTransmissionContingencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityTransmissionContingency, Set<String>> onlyExistsValidator() {
		return new ElectricityTransmissionContingencyOnlyExistsValidator();
	}
}
