package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RegulationName;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulationNameTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulationNameValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RegulationNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulationName.class)
public class RegulationNameMeta implements RosettaMetaData<RegulationName> {

	@Override
	public List<Validator<? super RegulationName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulationName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulationName> validator(ValidatorFactory factory) {
		return factory.<RegulationName>create(RegulationNameValidator.class);
	}

	@Override
	public Validator<? super RegulationName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulationName>create(RegulationNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulationName> validator() {
		return new RegulationNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulationName> typeFormatValidator() {
		return new RegulationNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulationName, Set<String>> onlyExistsValidator() {
		return new RegulationNameOnlyExistsValidator();
	}
}
