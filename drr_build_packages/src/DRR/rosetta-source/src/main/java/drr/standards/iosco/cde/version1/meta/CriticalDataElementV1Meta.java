package drr.standards.iosco.cde.version1.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.cde.version1.CriticalDataElementV1;
import drr.standards.iosco.cde.version1.validation.CriticalDataElementV1TypeFormatValidator;
import drr.standards.iosco.cde.version1.validation.CriticalDataElementV1Validator;
import drr.standards.iosco.cde.version1.validation.exists.CriticalDataElementV1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CriticalDataElementV1.class)
public class CriticalDataElementV1Meta implements RosettaMetaData<CriticalDataElementV1> {

	@Override
	public List<Validator<? super CriticalDataElementV1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CriticalDataElementV1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CriticalDataElementV1> validator(ValidatorFactory factory) {
		return factory.<CriticalDataElementV1>create(CriticalDataElementV1Validator.class);
	}

	@Override
	public Validator<? super CriticalDataElementV1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CriticalDataElementV1>create(CriticalDataElementV1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CriticalDataElementV1> validator() {
		return new CriticalDataElementV1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CriticalDataElementV1> typeFormatValidator() {
		return new CriticalDataElementV1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CriticalDataElementV1, Set<String>> onlyExistsValidator() {
		return new CriticalDataElementV1OnlyExistsValidator();
	}
}
