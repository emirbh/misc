package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.ApplicableRegulations;
import fpml.consolidated.reg.fpmlreporting.shared.validation.ApplicableRegulationsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.ApplicableRegulationsValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.ApplicableRegulationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApplicableRegulations.class)
public class ApplicableRegulationsMeta implements RosettaMetaData<ApplicableRegulations> {

	@Override
	public List<Validator<? super ApplicableRegulations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApplicableRegulations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableRegulations> validator(ValidatorFactory factory) {
		return factory.<ApplicableRegulations>create(ApplicableRegulationsValidator.class);
	}

	@Override
	public Validator<? super ApplicableRegulations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableRegulations>create(ApplicableRegulationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableRegulations> validator() {
		return new ApplicableRegulationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableRegulations> typeFormatValidator() {
		return new ApplicableRegulationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableRegulations, Set<String>> onlyExistsValidator() {
		return new ApplicableRegulationsOnlyExistsValidator();
	}
}
