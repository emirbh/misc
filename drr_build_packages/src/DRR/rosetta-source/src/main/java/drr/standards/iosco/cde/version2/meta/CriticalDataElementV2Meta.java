package drr.standards.iosco.cde.version2.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.cde.version2.CriticalDataElementV2;
import drr.standards.iosco.cde.version2.validation.CriticalDataElementV2TypeFormatValidator;
import drr.standards.iosco.cde.version2.validation.CriticalDataElementV2Validator;
import drr.standards.iosco.cde.version2.validation.exists.CriticalDataElementV2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CriticalDataElementV2.class)
public class CriticalDataElementV2Meta implements RosettaMetaData<CriticalDataElementV2> {

	@Override
	public List<Validator<? super CriticalDataElementV2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CriticalDataElementV2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CriticalDataElementV2> validator(ValidatorFactory factory) {
		return factory.<CriticalDataElementV2>create(CriticalDataElementV2Validator.class);
	}

	@Override
	public Validator<? super CriticalDataElementV2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CriticalDataElementV2>create(CriticalDataElementV2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CriticalDataElementV2> validator() {
		return new CriticalDataElementV2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CriticalDataElementV2> typeFormatValidator() {
		return new CriticalDataElementV2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CriticalDataElementV2, Set<String>> onlyExistsValidator() {
		return new CriticalDataElementV2OnlyExistsValidator();
	}
}
