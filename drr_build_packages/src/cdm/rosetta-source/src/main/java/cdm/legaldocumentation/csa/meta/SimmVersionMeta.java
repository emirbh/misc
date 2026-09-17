package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SimmVersion;
import cdm.legaldocumentation.csa.validation.SimmVersionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SimmVersionValidator;
import cdm.legaldocumentation.csa.validation.datarule.SimmVersionVersionNotSpecified;
import cdm.legaldocumentation.csa.validation.datarule.SimmVersionVersionSpecified;
import cdm.legaldocumentation.csa.validation.exists.SimmVersionOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=SimmVersion.class)
public class SimmVersionMeta implements RosettaMetaData<SimmVersion> {

	@Override
	public List<Validator<? super SimmVersion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SimmVersion>create(SimmVersionVersionNotSpecified.class),
			factory.<SimmVersion>create(SimmVersionVersionSpecified.class)
		);
	}
	
	@Override
	public List<Function<? super SimmVersion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimmVersion> validator(ValidatorFactory factory) {
		return factory.<SimmVersion>create(SimmVersionValidator.class);
	}

	@Override
	public Validator<? super SimmVersion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SimmVersion>create(SimmVersionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SimmVersion> validator() {
		return new SimmVersionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SimmVersion> typeFormatValidator() {
		return new SimmVersionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimmVersion, Set<String>> onlyExistsValidator() {
		return new SimmVersionOnlyExistsValidator();
	}
}
