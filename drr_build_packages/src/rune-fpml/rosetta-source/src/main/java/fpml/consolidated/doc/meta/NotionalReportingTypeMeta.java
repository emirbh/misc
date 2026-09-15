package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.NotionalReportingType;
import fpml.consolidated.doc.validation.NotionalReportingTypeTypeFormatValidator;
import fpml.consolidated.doc.validation.NotionalReportingTypeValidator;
import fpml.consolidated.doc.validation.exists.NotionalReportingTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotionalReportingType.class)
public class NotionalReportingTypeMeta implements RosettaMetaData<NotionalReportingType> {

	@Override
	public List<Validator<? super NotionalReportingType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalReportingType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalReportingType> validator(ValidatorFactory factory) {
		return factory.<NotionalReportingType>create(NotionalReportingTypeValidator.class);
	}

	@Override
	public Validator<? super NotionalReportingType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalReportingType>create(NotionalReportingTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalReportingType> validator() {
		return new NotionalReportingTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalReportingType> typeFormatValidator() {
		return new NotionalReportingTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalReportingType, Set<String>> onlyExistsValidator() {
		return new NotionalReportingTypeOnlyExistsValidator();
	}
}
