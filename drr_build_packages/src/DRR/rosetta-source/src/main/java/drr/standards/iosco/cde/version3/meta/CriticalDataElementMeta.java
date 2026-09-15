package drr.standards.iosco.cde.version3.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.cde.version3.CriticalDataElement;
import drr.standards.iosco.cde.version3.validation.CriticalDataElementTypeFormatValidator;
import drr.standards.iosco.cde.version3.validation.CriticalDataElementValidator;
import drr.standards.iosco.cde.version3.validation.exists.CriticalDataElementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CriticalDataElement.class)
public class CriticalDataElementMeta implements RosettaMetaData<CriticalDataElement> {

	@Override
	public List<Validator<? super CriticalDataElement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CriticalDataElement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CriticalDataElement> validator(ValidatorFactory factory) {
		return factory.<CriticalDataElement>create(CriticalDataElementValidator.class);
	}

	@Override
	public Validator<? super CriticalDataElement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CriticalDataElement>create(CriticalDataElementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CriticalDataElement> validator() {
		return new CriticalDataElementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CriticalDataElement> typeFormatValidator() {
		return new CriticalDataElementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CriticalDataElement, Set<String>> onlyExistsValidator() {
		return new CriticalDataElementOnlyExistsValidator();
	}
}
