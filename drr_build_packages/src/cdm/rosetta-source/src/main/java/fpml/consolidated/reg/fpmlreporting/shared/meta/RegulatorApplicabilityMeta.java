package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatorApplicability;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatorApplicabilityTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatorApplicabilityValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RegulatorApplicabilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatorApplicability.class)
public class RegulatorApplicabilityMeta implements RosettaMetaData<RegulatorApplicability> {

	@Override
	public List<Validator<? super RegulatorApplicability>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatorApplicability, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatorApplicability> validator(ValidatorFactory factory) {
		return factory.<RegulatorApplicability>create(RegulatorApplicabilityValidator.class);
	}

	@Override
	public Validator<? super RegulatorApplicability> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatorApplicability>create(RegulatorApplicabilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatorApplicability> validator() {
		return new RegulatorApplicabilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatorApplicability> typeFormatValidator() {
		return new RegulatorApplicabilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatorApplicability, Set<String>> onlyExistsValidator() {
		return new RegulatorApplicabilityOnlyExistsValidator();
	}
}
